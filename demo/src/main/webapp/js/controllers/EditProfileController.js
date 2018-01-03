/**
 * Created by Andrei on 03.02.2017.
 */

eventsApp.controller("EditProfileController",function ($scope , GravatarUrlBuilder) {
  $scope.user={};

    $scope.getGravatarUrl = function(email) {
       return GravatarUrlBuilder.service(email);
    }
});