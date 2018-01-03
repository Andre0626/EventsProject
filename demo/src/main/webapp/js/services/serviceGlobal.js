/**
 * Created by Andrei on 10.02.2017.
 */

eventsApp.factory("serviceGlobal", function serviceGlobal($resource, $http) {
    return {
        objSelect: function () {
            return $http({
                url: '/data/event/events.json',
                method: "get"
            })

        }

    }
});
