(function(angular) {
    angular.module("petStore.controllers", []);
    angular.module("petStore.services", []);
    angular.module("petStore", ["ngResource", "petStore.controllers", "petStore.services"])
        .config(function($httpProvider) {

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    });
}(angular));