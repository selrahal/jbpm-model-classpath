'use strict';

angular.module('awesomeApp', ['ngRoute', 'ui.bootstrap']).
  config(['$routeProvider','$httpProvider', function($routeProvider, $httpProvider) {
    $routeProvider.when('/home', {templateUrl: 'app/home.html'});
    $routeProvider.otherwise({redirectTo: '/home'});
  }]).constant('API_ENDPOINT','/awesome-web-app-v2/rest');
