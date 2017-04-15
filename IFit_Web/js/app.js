/*
    Módulos adicionados e dependências:
        - ui.router: angular-ui-router.minjs, 
        - ngMaterial: angular-material.min.js, angular-material.min.css, angular-animate.min.js, angular-aria.min.js, angular-sanitize.min.js
 */
var angulaAppModulo = angular.module('AngularApp', ['ngRoute', 'ui.router', 'ngMaterial'])
.config(function($mdThemingProvider) {
    $mdThemingProvider.theme('default')
      .primaryPalette('grey', {
        'default': '900',
        'hue-1': '100',
        'hue-2': '800',
        'hue-3': 'A100'
      })
      .accentPalette('orange')
      .warnPalette('yellow')
      .backgroundPalette('grey');
  });