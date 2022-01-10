describe("Unit: Testing CalculateCtrl", function() {

	var calculateCtrl;

	// Load calculate module
	beforeEach(module('calculate'));

	// Init calculateCtrl
	beforeEach(inject(function($controller, $rootScope) {
        scope = $rootScope.$new();
        calculateCtrl = $controller("CalculateCtrl", {$scope: scope});
    }));

	it('CalculateCtrl exist', function () {
   	 	expect(calculateCtrl).not.toBe(null); 
  	});

  	it('CalculateCtrl calculate() - 5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA => 1 3 N\n5 1 E', function () {
  		scope.entry = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
  		scope.calculate();
  		expect(scope.result).toBe("1 3 N\n5 1 E");
  	});


  	it('CalculateCtrl calculate() - bad entry => Invalid datas', function () {
  		scope.entry = "bad entry";
  		scope.calculate();
  		expect(scope.result).toBe("Invalid datas");
  	});

});