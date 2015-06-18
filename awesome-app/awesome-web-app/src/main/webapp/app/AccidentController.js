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
			
			
			vm.feedback = '';
			
			vm.submitv1 = function() {
				$log.info("Submitting request");
				$log.info(vm.person);
				$log.info(vm.other);
				var myCar = {"driver" : vm.person};
				var otherCar = {"driver" : vm.person};
				var accident = { "cars" : [myCar, otherCar]};
				accidentFactory.createv1(accident).then(function(response) {
					vm.feedback = response.data;
				});
			}
			
			vm.submitv2 = function() {
				$log.info("Submitting request");
				$log.info(vm.person);
				$log.info(vm.other);
				var myCar = {"driver" : vm.person};
				var otherCar = {"driver" : vm.person};
				var accident = { "cars" : [myCar, otherCar]};
				accidentFactory.createv2(accident).then(function(response) {
					vm.feedback = response.data;
				});
			}
		} ]);