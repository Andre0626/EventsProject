/**
 * Created by Andrei on 06.02.2017.
 */
eventsApp.controller("EventListController", function EventListController($routeParams, $http, $scope, $location,EventModel, eventData, serviceGlobal, $parse, $locale, $timeout, $filter, $interval, $route) {

    $scope.sortOrder = "name";
    $scope.buttonDisabled = true;

     EventModel.getEvents().then(function (response) {
        // console.log("ce vine de back",response);
         $scope.events = response.data;
     });



    //*********************************** Vote count *****************************\\
    $scope.upVoteSession = function (session) {
        session.upVoteCount += 2;
    };
    $scope.downVoteSession = function (session) {
        session.upVoteCount--;
    };


    //*********************************$route*******************
    $scope.reload = function () {
        $route.reload();
    } ;
      $scope.goToPage = function(event){
          eventData.setEvents(event);
          localStorage.setItem('eventObject', JSON.stringify(event));
          $location.path('/eventDetails');
    }
});





