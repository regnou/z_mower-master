angular.module('calculate',['tondeuseJsServices']);

angular.module('calculate').controller('CalculateCtrl', ['$scope', 'mowerService', function($scope,mowerService) {

	$scope.valid = true;

	var loadDatas = function() {
		$scope.valid = true;
		$scope.datas = mowerService.readEntry($scope.entry);
		if($scope.datas == "ERROR") {
			$scope.valid = false;
			$scope.result = "Invalid datas";
			return false;
		}
		return true;
	}

	//  Calculate mower's final position.
	$scope.calculate = function() {
		if(!loadDatas()) return;
		var currentMower = 0;
		while(currentMower < $scope.datas.mowers.length) {
			var mower = $scope.datas.mowers[currentMower];
			while(mower.orders.length > 0) {
				mowerService.executeOrder(mower,$scope.datas.lawn);
			}
			currentMower++;
		}
		$scope.result = mowerService.mowersPositions($scope.datas.mowers);
	};
}]);