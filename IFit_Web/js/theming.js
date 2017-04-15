angular.module('IFit', ['ngMaterial'])
.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('warn')
    .primaryPalette('pink')
    .accentPalette('orange');
});