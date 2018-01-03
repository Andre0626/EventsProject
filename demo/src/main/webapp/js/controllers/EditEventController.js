/**
 * Created by Andrei on 02.02.2017.
 */
eventsApp.controller('EditEventController', function EditEventController($scope, $route,$http) {
    $scope.saveEvent = function (event, newEventForm) {
        if (newEventForm.$valid) {
            var url ="/new-event/add-new-event";
            var vData = $.param({
                eventName: event.eventName,
                eventDate: event.eventDate,
                eventTime: event.eventTime,
                eventImg : event.eventImg,
                address : event.address,
                city : event.city,
                province : event.province
            });
        $http.post(url,vData)
              .success(function (response) {
                        console.log(response);
                });

        }
    };

    $scope.cancelEdit = function () {
        $route.reload();
    }

});