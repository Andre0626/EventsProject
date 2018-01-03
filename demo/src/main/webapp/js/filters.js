'use strict';
eventsApp.filter("durations",function () {
    return function (duratino) {
        if(duratino == 1){
            return "1 hour byMe"
        }
        else if (duratino == 2){
            return "Half day byMe"
        }
        else if (duratino == 4){
            return "Full day byMe"
        }
    }
})
