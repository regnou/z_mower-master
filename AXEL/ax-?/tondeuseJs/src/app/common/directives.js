angular.module('tondeuseJsDirectives',[]);

angular.module('tondeuseJsDirectives').directive("mowercanvas", function(){
  return {
    restrict: "A",
    require: '?ngModel',
    link: function(scope, element, ngModel) {
      if(angular.isUndefined(ngModel.lawn)) return;


      var ctx = element[0].getContext('2d');
      ctx.clearRect (0, 0, 400, 400);

      // for (var i=0;i<10;i++) {
      //   for (var j=0;j<10;j++) {
      //         ctx.fillStyle="#349D27";
      //         ctx.fillRect(j*10,i*10,9,9);
      //   }
      // }

      for (var i=0;i<ngModel.lawn.x;i++) {
        for (var j=0;j<ngModel.lawn.y;j++) {
          ctx.fillStyle="#349D27";
          ctx.fillRect(j*10,i*10,9,9);
        }
      }

      angular.forEach(ngModel.mowers, function(mower) {
        ctx.fillStyle = '#120000';
        ctx.fillRect(mower.position.y*10,mower.position.x*10,9,9);
      });

    }
  }

});
