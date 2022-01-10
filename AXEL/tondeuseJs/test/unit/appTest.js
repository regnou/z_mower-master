describe("Unit: Testing HeaderCtrl", function() {

	var scope;
	
	// Mock $location
	var locationMock = {
		currentPath: '/',
		path : function() {return this.currentPath}
	}

	// Header controller
	var headerCtrl;

	// Chargement du module
	beforeEach(module('tondeuse'));

	// Init du controleur ThemeCtrl avec un scope vierge
	beforeEach(inject(function($controller, $rootScope) {
        scope = $rootScope.$new();
        headerCtrl = $controller("HeaderCtrl", {$scope: scope, $location: locationMock});
    }));

    // Test de l'existance du controleur
	it('HeaderCtrl exist', function () {
   	 	expect(headerCtrl).not.toBe(null); 
  	});

	it('HeaderCtrl currentPage("/") on / => true', function() {
		locationMock.currentPath = '/';
		expect(scope.currentPage('/')).toBe(true);
	});

	it('HeaderCtrl currentPage("/#/calculate") on / => false', function() {
		locationMock.currentPath = '/';
		expect(scope.currentPage('/#/calculate')).toBe(false);
	});
});