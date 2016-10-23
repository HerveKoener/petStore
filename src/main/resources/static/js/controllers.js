(function(angular) {
    var AppController = function($scope, $http, Pet) {
        Pet.query(function(response) {
            $scope.pets = response ? response : [];
        });

        $scope.detailPet = function(pet) {
            //Show detail
            pet.$show(function() {
                $scope.errors = null;
                $scope.pet = $scope.pets[$scope.pets.indexOf(pet)];
            });
        };

        $scope.addPet = function(name) {
            //Add a new pet
            new Pet({
                name: name,
                checked: false
            }).$save(function(pet) {
                $scope.errors = null;
                $scope.pets.push(pet);
            },function(err){
                //Handle error
                $scope.errors = err.data.errors;
                });
            $scope.newPet = "";
        };

        $scope.deletePet = function(pet) {
            pet.$remove(function() {
                //Delete a pet and hide errors and detailed pet
                $scope.errors = null;
                $scope.pet = null;
                $scope.pets.splice($scope.pets.indexOf(pet), 1);
            });
        };

        var authenticate = function(credentials, callback) {

            var headers = credentials ? {authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('user', {headers : headers}).then(function(response) {
                if (response.data.name) {
                    //authentication successful
                    $scope.authenticated = true;
                    $scope.roles = response.data.authorities.map(function(o) {
                            return o.authority;
                        });
                } else {
                    //user has no name
                    $scope.authenticated = false;
                }
                callback && callback();
            }, function() {
                //authentication failed
                $scope.authenticated = false;
                callback && callback();
            });

        }

        $scope.credentials = {};
        $scope.role = 'public';
        $scope.login = function() {
            authenticate($scope.credentials, function() {
                if ($scope.authenticated) {
                    $scope.error = false;
                } else {
                    $scope.error = true;
                }
            });
        };

        $scope.logout = function() {
            $http.post('logout', {}).finally(function() {
                $scope.authenticated = false;
                $scope.pet = "";
                $scope.role = 'public';
            });
        }
    };

    AppController.$inject = ['$scope', '$http', 'Pet'];
    angular.module("petStore.controllers").controller("AppController", AppController);
}(angular));