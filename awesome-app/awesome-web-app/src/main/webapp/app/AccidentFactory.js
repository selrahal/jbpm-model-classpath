'use strict';

angular.module('awesomeApp').factory('AccidentFactory', ['$http', 'API_ENDPOINT',function($http, API_ENDPOINT) {
	return {
		create : function(accident) {
			var api = API_ENDPOINT + '/accident/';
			var headers = {'Content-Type' : 'application/json'};
			return $http.post(api, accident, headers);
		},
		getInfo : function(processinstanceid) {
			var api = API_ENDPOINT + '/accident/' + processinstanceid;
			return $http.get(api);
		}
	}
}]);