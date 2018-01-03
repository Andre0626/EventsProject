/**
 * Created by Andrei on 05.12.2017.
 */

eventsApp.factory("EventModel", function ($http) {
    var service = {};

    service.getEvents = function () {
        var Url = "/home/get-events";
        return $http.get(Url).then(function (response) {
            return response;
        })
    };
    return service;
});