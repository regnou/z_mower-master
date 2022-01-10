angular.module('broadcast',['tondeuseJsServices']);

angular.module('broadcast').controller('BroadcastCtrl', ['$scope', 'mowerService', '$location', function($scope,mowerService,$location) {

	var currentMower = 0;
	$scope.tickSpeed = 500;
	$scope.valid = true;

	var loadDatas = function() {
		$scope.valid = true;
		$scope.datas = mowerService.readEntry($scope.entry);
		if($scope.datas == "ERROR") {
			$scope.valid = false;
			$scope.result = "Données invalides";
			return false;
		}
		return true;
	}

	$scope.calculate = function() {
		if(!loadDatas()) return;
		currentMower = 0;
		tick();
	}

	function drawn() {
		var frameSize = 15;
		var canvas = document.getElementById("mowerCanvas");
		canvas.width  = frameSize*($scope.datas.lawn.x+1);
		canvas.height = frameSize*($scope.datas.lawn.y+1); 
		var ctx=canvas.getContext("2d");
		ctx.clearRect (0, 0, 1000, 1000);
		for (var i=0;i<$scope.datas.lawn.x+1;i++) {
			for (var j=0;j<$scope.datas.lawn.y+1;j++) {
	            ctx.fillStyle="#349D27";
				ctx.fillRect(i*frameSize,j*frameSize,frameSize-1,frameSize-1);
	        }
		}

    	angular.forEach($scope.datas.mowers, function(mower) {
    		var xPosition = frameSize*(mower.position.x);
    		var yPosition = frameSize*($scope.datas.lawn.y - mower.position.y+1);
        	if(mower.orientation == 'N') ctx.fillStyle = 'blue';
        	if(mower.orientation == 'S') ctx.fillStyle = 'red';
        	if(mower.orientation == 'W') ctx.fillStyle = 'yellow';
        	if(mower.orientation == 'E') ctx.fillStyle = 'black';
        	ctx.fillRect(xPosition,yPosition,frameSize-1,frameSize-1);
      	});
	};

	tick = function() {
		mowerService.executeOrder($scope.datas.mowers[currentMower],$scope.datas.lawn);
		drawn();
		if($scope.wsConnected) $scope.ws.send(JSON.stringify($scope.datas));
		if($scope.datas.mowers[currentMower].orders.length == 0) currentMower++;
		if(currentMower < $scope.datas.mowers.length) window.setTimeout("tick()", $scope.tickSpeed);
	};


	$scope.connect = function() {
		$scope.ws = new WebSocket('ws://'+ $location.host() +':9000/create/'+$scope.tvName);

		$scope.ws.onopen = function() {
			$scope.$apply(function() {
				$scope.wsInfos = "Tv <"+ $scope.tvName +"> ready to cast";
				$scope.wsConnected = true;
			});
   		};
 
    	$scope.ws.onerror = function() {
			$scope.$apply(function() {
				$scope.wsInfos = "Websocket error";
				$scope.wsConnected = false;
				$scope.clear();
			});
    	}

    	$scope.ws.onclose = function() {
			$scope.$apply(function() {
				$scope.wsInfos = "Websocket close";
				$scope.wsConnected = false;
				$scope.clear();
			});
    	}
	};

	$scope.clear = function() {
		$scope.datas = '';
		$scope.entry = '';
		var canvas = document.getElementById("mowerCanvas");
		canvas.getContext("2d").clearRect (0, 0, 1000, 1000);
	}

}]);

