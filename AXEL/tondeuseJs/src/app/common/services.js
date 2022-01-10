angular.module('tondeuseJsServices', []);

angular.module('tondeuseJsServices').service('mowerService', [function () {

	// Return the new posistion after a move.
	this.move = function(orientation,x,y, maxX, maxY) {
		if(orientation == 'N') {
			var newY = Math.min(y+1,maxY);
			return {'x':x,'y':newY};
		}

		if(orientation == 'S') {
			var newY = Math.max(y-1,0);
			return {'x':x,'y':newY};
		}

		if(orientation == 'E') {
			var newX = Math.min(x+1,maxX);
			return {'x':newX,'y':y};
		}

		if(orientation == 'W') {
			var newX = Math.max(x-1,0);
			return {'x':newX,'y':y};
		}
	};

	// Return new posistion after a left rotation
	this.rotateLeft = function(orientation) {
		if(orientation == 'N') return 'W';
		if(orientation == 'E') return 'N';
		if(orientation == 'S') return 'E';
		if(orientation == 'W') return 'S';
	};

	// Return new posistion after a right rotation
	this.rotateRight = function(orientation) {
		if(orientation == 'N') return 'E';
		if(orientation == 'E') return 'S';
		if(orientation == 'S') return 'W';
		if(orientation == 'W') return 'N';
	};

	// Mower constructor
	this.mowerFactory = function(xPosition, yPosition, orientation, orders) {
		return {'position':{'x':xPosition,'y':yPosition},
			    'orientation':orientation,
				'orders':orders};
	}
	
	// Read rawn entry data and return an object like:
	//  {lawn:{x,y},
	//   mowers:[{position:{x:<x position>,y:<y position>}, orientation:<orientation>, orders:<orders>},
	//  		 {position:{x:<x position>,y:<y position>}, orientation:<orientation>, orders:<orders>},
	//  		 ...]}
	// If invalid data return 'ERROR'
	this.readEntry = function(entry) {
		if(!angular.isString(entry)) return "ERROR";
		
		var lines = entry.split("\n");
		if(!angular.isArray(lines) || lines.length % 2 == 0 || lines.length < 3) return "ERROR";

		// Lawn
		var lawnData = lines[0].split(" ");
		if(lawnData.length != 2) return "ERROR";

		var lawnX = parseInt(lawnData[0]);
		var lawnY = parseInt(lawnData[1]);
		if(!angular.isNumber(lawnX) || isNaN(lawnX) || !angular.isNumber(lawnY) || isNaN(lawnY)) return "ERROR";

		var lawn = {'x':lawnX, 'y': lawnY};

		// Mowers
		var mowers = new Array();
		var mowersLines = lines.slice(1);
		var i=0
		while(i < mowersLines.length){
			var mowerInfo = mowersLines[i].split(" ");
			if(mowerInfo.length != 3) return "ERROR";

			var x = parseInt(mowerInfo[0]);
			var y = parseInt(mowerInfo[1]);
			var position = mowerInfo[2];
			if(!angular.isNumber(x) || isNaN(x) || !angular.isNumber(y) ||  isNaN(y)) return "ERROR";
			if(x>lawn.x || y>lawn.y) return "ERROR";
			if(!(position == 'N' || position == 'E' || position == 'W' || position == 'S')) return "ERROR";

			mowers.push(this.mowerFactory(x,y,position,mowersLines[i+1]));
			i += 2;
		}
		return {'lawn':lawn,'mowers':mowers};
	}

	// Print mowers posistions for humans
	this.mowersPositions = function(mowers) {
		var result = "";
		angular.forEach(mowers, function(mower){
			result += mower.position.x + " " + mower.position.y + " " + mower.orientation + "\n";
		})
		return result.slice(0, -1);
	};

	// Execute the next order of the mower
	this.executeOrder = function(mower,lawn) {
		var order = mower.orders[0];
		mower.orders = mower.orders.slice(1);
		if(order == 'A') {
			mower.position = this.move(mower.orientation,mower.position.x, mower.position.y, lawn.x, lawn.y);
		} else if(order == 'G') {
			mower.orientation = this.rotateLeft(mower.orientation);
		} else if(order == 'D') {
			mower.orientation = this.rotateRight(mower.orientation);
		}
	};
	
}]);