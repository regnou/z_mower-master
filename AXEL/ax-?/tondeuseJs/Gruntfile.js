module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-karma');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-compress');
  grunt.loadNpmTasks('grunt-html2js');
  grunt.loadNpmTasks('grunt-contrib-connect');

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    
    // Clean dist/ directory
    clean: {
      dist: {src: ['dist/']},
    },

    // Concat html template in a js file
	html2js: {
	    dist: {
	      src: ['src/app/*.partial.html','src/app/**/*.partial.html'],
	      dest: 'src/tmp/partial.js',
	      module: 'partials.app'
	    },
	},

    // Build js app
    concat: {
      dist: {
        src: ['lib/jquery/jquery-1.11.0.min.js',
              'lib/bootstrap/js/bootstrap.min.js',
              'lib/angular/angular.min.js',
              'lib/angular/angular-route.min.js',
              'lib/filereader/filereader.js',
              'src/app/*.js',
              'src/app/**/*.js',
              'src/tmp/partial.js'],
        dest: 'dist/js/tondeuse.js'
      },
    },

    // copy file and assets
    copy: {
      dist: {
        files: [
          {expand: true, cwd: 'src/', src: ['index.html'], dest: 'dist/'},
          {expand: true, cwd: 'src/css', src: ['*.css'], dest: 'dist/css/'},
          {expand: true, cwd: 'lib/bootstrap/css/', src:'bootstrap.min.css', dest: 'dist/css/'},
        ]
      },
    },

    // Test with karma
    karma: {
      unit: {
        force:true,
        configFile: 'test/karma.conf.js',
        background: false,
        singleRun: true
      }
    },

    // Continuous build and test
    watch: {
      dist: {
        files: ['src/app/*.js', 
                'src/app/**/*.js', 
                'src/*.html', 
                'src/**/*.html',
                'test/**/*.js'],
        tasks: ['clean:dist', 'html2js:dist' ,'concat:dist', 'copy:dist', 'karma:unit']
      },
    },
  
    // Minify files with uglify
    uglify: {
      options: {mangle: false},
      dist: {
        files: {
          'dist/js/tondeuse.js': ['dist/js/tondeuse.js']
        }
      }
    },

    // Zip distribution in a file
    compress: {
      dist: {
        options: {
          archive: 'tondeuse.<%= pkg.version %>.zip'
        },
        files: [{src: 'dist/**/*'}]
      }
    },

    // Local server for testing
	connect: {
    	server: {
      		options: {
       			port: 8888,
        		base: 'dist'
      		}
    	}
  	}

  });

  // Package apps for production in tondeuse.<version>.zip
  grunt.registerTask('package', ['clean:dist', 'html2js:dist','concat:dist','copy:dist', 'uglify:dist', 'karma:unit', 'compress:dist']);

  // Task for developpement : watch if file change and continuous test and deploy
  grunt.registerTask('dev', ['clean:dist', 'html2js:dist', 'concat:dist', 'copy:dist', 'karma:unit', 'connect:server', 'watch:dist']);

}