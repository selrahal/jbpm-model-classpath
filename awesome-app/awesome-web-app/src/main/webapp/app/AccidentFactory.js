'use strict';

angular.module('awesomeApp').factory('AccidentFactory', ['$http', 'API_ENDPOINT',function($http, API_ENDPOINT) {
	return {
		createv1 : function(accident) {
			var api = API_ENDPOINT + '/accident/v1';
			var headers = {'Content-Type' : 'application/json'};
			return $http.post(api, accident, headers);
		},
		createv2 : function(accident) {
			var api = API_ENDPOINT + '/accident/v2';
			var headers = {'Content-Type' : 'application/json'};
			return $http.post(api, accident, headers);
		}
	}
}]);