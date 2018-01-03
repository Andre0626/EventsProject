/**
 * Created by Andrei on 03.02.2017.
 */
eventsApp.factory("eventData", function eventData() {


    service = {};
    service.setEvents = setEvents;
    service.getEvents = getEvents;
    service.setId = setId;
    service.getId = getId;
    service.rezult = rezult;
    var colectie = [];
    var nrId = 0;


    function setEvents(events) {
        colectie = events;
        console.log('care este colectia',colectie);
    }

    function getEvents() {
      return colectie;

    }

    function setId(idCrt) {
        nrId = idCrt;

    }

    function getId() {
        return nrId
    }
    
   function rezult() {

       var retrunRezult = null;
       var events = getEvents();
       var nrId = getId();

       events.forEach(function (item) {
           if (item.id == nrId) {
               retrunRezult = item;
           }
       });
       return retrunRezult;
   }

    return service;
});

