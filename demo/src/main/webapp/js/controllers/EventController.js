/**
 * Created by Andrei on 30.01.2017.
 */

eventsApp.controller('EventController', function EventController($scope, eventData, $log, $parse, $locale, $timeout,$http, $filter,$route) {


    $scope.event = JSON.parse(localStorage.getItem('eventObject'));
    console.log('local storage',$scope.event);
    $scope.VoteSession = function (vote,id,countUp) {
          if(countUp){
              vote ++;
          } else {
              vote --;
          }

        var url ="/home/get-vote";
        var vData = $.param({
            vote:vote,
            id_event:id
        });
            $http.post(url,vData)
                .then(function (response) {
                $scope.event.vote = response.data.vote;
                });

    };


/*
    $scope.buttonDisabled = function () {
        html2canvas($('.container'), {
            onrendered: function (canvas) {
                var img = canvas.toDataURL("image/png")
                var doc = new jsPDF();
                doc.addImage(img, 'JPEG',0, 20);
                doc.save('test.pdf')
            }
        });
    };*/
    /*
     doc.fromHTML($('#content').html(), 15, 15, {
     'width': 170,
     'elementHandlers': specialElementHandlers
     });
     doc.save('sample-file.pdf');*/
    $scope.reload = function () {
        $route.reload();
    } ;

    $scope.stop = function () {

    }

});