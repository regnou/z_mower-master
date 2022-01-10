##TondeuseJS
User interface with AngularJS

 - Calculate : calculate mower final position 
 - Broadcast : calculate and broadcast mower positions 
 - Tv : see a broadcast

### Requirements

**nodejs and npm** : see http://nodejs.org/

**grunt** : $npm install grunt

**grunt-cli** : $npm install grunt-cli

### Grunt tasks

Package for production : **grunt package**
Continuous build & test for developpement : **grunt dev**

### Project organisation

    dist/ : packaged application
    lib/ : thirds party librairy: AngularJs, Bootstrap etc...
    src/ : sources of the application
       app/ : controllers, directives, services, partials organized by functions
       asset/ : img, icon, etc...
       css/ : css of the application
       index.html : application main page
    test/ : source for the tests
    unit/ : unit tests
    htmlRunner/ : jasmine html test runner
    karma.conf.js : karma configuration
    package.json : application description
    Gruntfile.js : grunt configuration