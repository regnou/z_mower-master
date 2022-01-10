describe("Unit: Testing BroadcastCtrl", function() {

	var controller;

	// Load broadcast module
	beforeEach(module('broadcast'));

	// Init BroadcastCtrl
	beforeEach(inject(function($controller, $rootScope) {
        scope = $rootScope.$new();
        controller = $controller("BroadcastCtrl", {$scope: scope});
    }));

	it('BroadcastCtrl exist', function () {
   	 	expect(controller).not.toBe(null); 
  	});

});