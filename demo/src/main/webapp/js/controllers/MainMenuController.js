/**
 * Created by Andrei on 14.02.2017.
 */
eventsApp.controller("MainMenuController", function MainMenuController($scope,$location) {
     $scope.createEvent = function () {
         $location.url('/newEvent');
     };
     $scope.mainPage = function () {
            $location.url('/eventList')
     }
});