var eventsApp = angular.module('eventsApp', ['ngRoute', 'ngResource']);

eventsApp.config(function ($routeProvider, $locationProvider, $httpProvider, $logProvider) {
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
    $routeProvider
        .when('/newEvent', {
            templateUrl: 'templates/NewEvent.html',
            controller: 'EditEventController'
        });
    $routeProvider
        .when('/eventDetails', {
            templateUrl: 'templates/EventDetails.html',
            controller: 'EventController'
        });
    $routeProvider
        .when('/eventList', {
            foo: 'bar',
            templateUrl: 'templates/EventList.html',
            controller: 'EventListController'
        });
//************************Test de routeParams*****************//
 /*   $routeProvider
        .when('/pageUrl/:pageNumber', {
            templateUrl: 'templates/EventDetails.html',
            controller: 'EventListController'
        });*/

//**************************Redirect to********************//

    $routeProvider
        .otherwise({redirectTo: '/eventList'})


});


