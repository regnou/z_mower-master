angular.module('tondeuse', ['ngRoute','partials.app', 'appFilereader','calculate','broadcast','tv']);

// Navigation configuration
angular.module('tondeuse').config(['$routeProvider', function ($routeProvider) {
	$routeProvider.
    	when('/calculate', {templateUrl: 'app/calculate/calculate.partial.html', controller: 'CalculateCtrl'}).
      	when('/broadcast', {templateUrl: 'app/broadcast/broadcast.partial.html', controller: 'BroadcastCtrl'}).
      	when('/tv', {templateUrl: 'app/tv/tv.partial.html', controller: 'TvCtrl'}).
      	otherwise({redirectTo: '/calculate'});
}]);

// Navigation bar controller.
angular.module('tondeuse').controller('HeaderCtrl', ['$scope','$location', function($scope,$location) {

	// Return true if path is current page
	$scope.currentPage = function(path) {
		return $location.path() == path;
	}

}]);