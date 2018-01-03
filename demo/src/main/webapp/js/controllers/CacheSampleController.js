/**
 * Created by Andrei on 08.02.2017.
 */

eventsApp.controller('CacheSampleController',
        function CacheSampleController($scope , myCache) {
          $scope.addToCache = function (key , value) {
              myCache.put(key , value);
          };

          $scope.readFromCache = function (key) {
              return myCache.get(key)
          };

            $scope.getCacheStatus = function (key) {
                return myCache.info();
            };

        });