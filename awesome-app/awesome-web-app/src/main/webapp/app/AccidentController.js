'use strict';

angular.module('awesomeApp').controller('AccidentController', [
		'$log',
		'AccidentFactory',
		function($log, accidentFactory) {
			var vm = this;
			
			vm.person = {};
			vm.person.firstName = "Sal";
			vm.person.lastName = "Elrahal";
			vm.person.age = 87;
			
			vm.other = {};
			vm.other.firstName = "Rosie";
			vm.other.lastName = "Elrahal";
			vm.other.age = 54;
			
			vm.processId = 0;
			
			
			vm.feedback = '';
			
			vm.submit = function() {
				$log.info("Submitting request");
				$log.info(vm.person);
				$log.info(vm.other);
				var myCar = {"driver" : vm.person};
				var otherCar = {"driver" : vm.other};
				var accident = { "cars" : [myCar, otherCar]};
				accidentFactory.create(accident).then(function(response) {
					vm.feedback = response.data;
					$log.info(vm.feedback);
				});
			}
			
			
			
			vm.getInfo = function() {
				$log.info("requesting info for:" + vm.processId);
				accidentFactory.getInfo(vm.processId).then(function(response) {
					vm.feedback = response.data;
					$log.info(vm.feedback);
				});
			}
		} ]);