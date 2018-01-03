/**
 * Created by Andrei on 14.02.2017.
 */
/**
 * Created by Andrei on 06.02.2017.
 */
eventsApp.controller("ClickController", function ClickController($routeParams, $http, $scope, $location, eventData, serviceGlobal,$parse,$locale,$timeout,$filter,$interval) {

    //**************************varianta cu Service ***************************\\

    $scope.sortOrder = "name";
    $scope.myStyle = {color: "red"};
    $scope.buttonDisabled = true;

    serviceGlobal.objSelect()
        .then(function (response) {
            // var events = response
            $scope.events = response.data;
            console.log("nume obiecte", response);


            var pageNumber = $routeParams.pageNumber;

            $scope.events.forEach(function (item) {
                if (item.id == pageNumber) {
                    $scope.event = item;
                }
            });
            console.log("event cu id 1", $scope.event);
        });
    //alert("pagina din Routing" + pageNumber);

    //*********************************** Vote count *****************************\\
    $scope.upVoteSession = function (session) {
        session.upVoteCount+=2;
    };
    $scope.downVoteSession = function (session) {
        session.upVoteCount--;
    };
    //***********************************utilizare $parse**************************\\
    var fn = $parse('1+2');
    console.log(fn());

    var test = $parse('event.name');

    var con1 = {event:{name:"angular"}};
    var con2 = {event:{name:"angular2"}};

    console.log(test(con1));

    var se = test.assign;
    se(con2, "s-a facut assign");
    console.log(con2.event.name);

    //***********************************utilizare $locale********************************\\
    $scope.myDate = Date.now();
    $scope.myFormat = $locale.DATETIME_FORMATS.fullDate;
    //console.log($locale);

    //********************************utilizare$timeout**************************************\\
    var promis = $timeout(function () {
        $scope.name = "Andrei";
    },5000);
    $scope.stop = function () {
        $timeout.cancel(promis)
        if (stocare){
            $interval.cancel(stocare);
        }
    };

    //********************************countdown************************************************\\
    $scope.countdown = 5;
    var decrementalCountdown = function () {
        $scope.countdown -= 1;
    };
    var startCountdown = function () {
        stocare = $interval(decrementalCountdown , 1000 , $scope.countdown)
    };
    startCountdown();



});





