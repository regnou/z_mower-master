describe("Unit: Testing TvCtrl", function() {

	var ctrl;

	// Load tv module
	beforeEach(module('tv'));

	// Init TvCtrl
	beforeEach(inject(function($controller, $rootScope) {
        scope = $rootScope.$new();
        ctrl = $controller("TvCtrl", {$scope: scope});
    }));

	it('TvCtrl exist', function () {
   	 	expect(ctrl).not.toBe(null); 
  	});

});