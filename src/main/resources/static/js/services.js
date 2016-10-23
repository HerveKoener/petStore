(function(angular) {
    var PetFactory = function($resource) {
        return $resource('/pet/:id', {
            id: '@id'
        }, {
            remove: {
                method: "DELETE"
            },
            show: {
                method: "GET"
            }
        });
    };

    PetFactory.$inject = ['$resource'];
    angular.module("petStore.services").factory("Pet", PetFactory);
}(angular));