describe("Unit: Testing mowerService", function() {

	var mowerService;

	beforeEach(function() {
		var servicesModule = angular.injector(['tondeuseJsServices'])
 		mowerService = servicesModule.get('mowerService');
    });

	it('mowerService exist', function () {
   	 	expect(mowerService).not.toBe(null); 
  	});

	it('mowerService.move()', function () {
   	 	expect(mowerService.move('N',0,0,10,10).y).toBe(1);
   	 	expect(mowerService.move('N',0,0,10,10).x).toBe(0);

   	 	expect(mowerService.move('N',0,10,10,10).y).toBe(10);
   	 	expect(mowerService.move('N',0,10,10,10).x).toBe(0);

   	 	expect(mowerService.move('S',0,0,10,10).y).toBe(0);
   	 	expect(mowerService.move('S',0,0,10,10).x).toBe(0);

   	 	expect(mowerService.move('S',0,10,10,10).y).toBe(9);
   	 	expect(mowerService.move('S',0,10,10,10).x).toBe(0);

   	 	expect(mowerService.move('E',0,0,10,10).y).toBe(0);
   	 	expect(mowerService.move('E',0,0,10,10).x).toBe(1);

   	 	expect(mowerService.move('E',10,0,10,10).y).toBe(0);
   	 	expect(mowerService.move('E',10,0,10,10).x).toBe(10);

   	 	expect(mowerService.move('W',0,0,10,10).y).toBe(0);
   	 	expect(mowerService.move('W',0,0,10,10).x).toBe(0);

   	 	expect(mowerService.move('W',10,0,10,10).y).toBe(0);
   	 	expect(mowerService.move('W',10,0,10,10).x).toBe(9);
  	});

  	it('mowerService.rotateLeft()', function () {
   	 	expect(mowerService.rotateLeft('N')).toBe('W');
   	 	expect(mowerService.rotateLeft('W')).toBe('S');
   	 	expect(mowerService.rotateLeft('S')).toBe('E');
   	 	expect(mowerService.rotateLeft('E')).toBe('N');
  	});

  	it('mowerService.rotateRight()', function () {
   	 	expect(mowerService.rotateRight('N')).toBe('E');
   	 	expect(mowerService.rotateRight('W')).toBe('N');
   	 	expect(mowerService.rotateRight('S')).toBe('W');
   	 	expect(mowerService.rotateRight('E')).toBe('S');
  	});

  	it('mowerService.mowerFactory()', function (){
  		var x = 1;
  		var y = 3;
  		var orientation = 'N';
  		var orders = "AAADGGAAD";
  		var mower = mowerService.mowerFactory(x,y,orientation,orders);

  		expect(mower.position.x).toBe(x);
  		expect(mower.position.y).toBe(y);
  		expect(mower.orientation).toBe(orientation);
  		expect(mower.orders).toBe(orders);
  	});

  	it('mowerService.readEntry()', function() {
  		var result = mowerService.readEntry("10 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result.lawn.x).toBe(10);
  		expect(result.lawn.y).toBe(5);
  		expect(result.mowers.length).toBe(2);
  		expect(result.mowers[0].position.x).toBe(1);
  		expect(result.mowers[0].position.y).toBe(2);
  		expect(result.mowers[0].orientation).toBe('N');
  		expect(result.mowers[0].orders).toBe('GAGAGAGAA');
  		expect(result.mowers[1].position.x).toBe(3);
  		expect(result.mowers[1].position.y).toBe(3);
  		expect(result.mowers[1].orientation).toBe('E');
  		expect(result.mowers[1].orders).toBe('AADAADADDA');
  	});

  	it('mowerService.readEntry() errors check - no string entry', function() {
  		var result = mowerService.readEntry(1);
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - no mowers', function() {
  		var result = mowerService.readEntry("10 5");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad lawn infos', function() {
  		result = mowerService.readEntry("10 5 R\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad lawn infos bis', function() {
  		result = mowerService.readEntry("10\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad lawn infos ter', function() {
  		result = mowerService.readEntry("10 i\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - no orders for mower', function() {
		result = mowerService.readEntry("10 5\n1 2 N\nGAGAGAGAA\n3 3 E");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad mower position', function() {
  		result = mowerService.readEntry("10 2\n1 i N\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad mower orientation', function() {
  		result = mowerService.readEntry("10 2\n1 2 T\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad mower position (x outside lawn)', function() {
  		result = mowerService.readEntry("10 2\n11 2 S\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerService.readEntry() errors check - bad mower position (y outside lawn)', function() {
  		result = mowerService.readEntry("10 2\n1 9 S\nGAGAGAGAA\n3 3 E\nAADAADADDA");
  		expect(result).toBe("ERROR");
  	});

  	it('mowerSercice.mowersPositions()', function() {
  		var mower1 = mowerService.mowerFactory(1,2,'N','DDAADD');
  		var mower2 = mowerService.mowerFactory(3,3,'E','DDAADD');
  		var mowers = [mower1,mower2];
  		
  		expect(mowerService.mowersPositions(mowers)).toBe('1 2 N\n3 3 E');
  		expect(mowerService.mowersPositions([])).toBe('');
  	});

  	it('mowerService.executeOrder()', function() {
  		var lawn = {'x':5,'y':5};
  		
  		var mower = mowerService.mowerFactory(0,0,'N','G');
		  mowerService.executeOrder(mower,lawn);
  		expect(mower.position.x).toBe(0);
  		expect(mower.position.y).toBe(0);
  		expect(mower.orientation).toBe('W');
  		expect(mower.orders).toBe('');

		  mower = mowerService.mowerFactory(0,0,'N','D');
  		mowerService.executeOrder(mower,lawn);
  		expect(mower.position.x).toBe(0);
  		expect(mower.position.y).toBe(0);
  		expect(mower.orientation).toBe('E');
  		expect(mower.orders).toBe('');

		  mower = mowerService.mowerFactory(0,0,'N','A');
  		mowerService.executeOrder(mower,lawn);
  		expect(mower.position.x).toBe(0);
  		expect(mower.position.y).toBe(1);
  		expect(mower.orientation).toBe('N');
  		expect(mower.orders).toBe('');
  	
  	});
});