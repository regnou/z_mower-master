module.exports = function(config) {
  config.set({
    basePath: '',
    frameworks: ['jasmine'],
    files: [ '../dist/js/tondeuse.js', 'angular-mocks.js', 'unit/*.js','unit/**/*.js' ],
    reporters: ['progress'],
    browsers: ['PhantomJS']
  });
};