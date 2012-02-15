/**
 * Base for the frontend of @johnwilander's JavaScript tutorial
 *
 * Uses require.js for module loading and dependency optimizing
 * http://requirejs.org/
 *
 * Given that
 *
 * 1) Rhino (js.jar) is in /Applications/Utilities/rhino/
 * 2) Google's Closure Compiler is in /Applications/Utilities/Closure_Compiler/
 * 3) You're in src/main/webapp/js/
 *
 * run ...
 *
 * java -classpath /Applications/Utilities/rhino/js.jar:/Applications/Utilities/Closure_Compiler/compiler.jar org.mozilla.javascript.tools.shell.Main ../../r.js -o name=base out=min.js baseUrl=. paths.jquery=empty: paths.jquery-encoder=empty:
 */



(function () {
    "use strict";

    requirejs.config({
        paths: {
            'jquery': 'lib/jquery-1.7.1.min',
            'jquery-encoder': 'lib/jquery-encoder-0.1.0'
        }
    });
    require(["jquery", "JW/util/util", "JW/gui/gui"], function(util) {
        // Load jQuery and util. Then run GUI code.
        console.log("App initialized");
    });
}());