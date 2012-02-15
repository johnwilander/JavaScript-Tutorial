## JavaScript Tutorial (for Java Developers) by [@johnwilander](https://twitter.com/johnwilander)

A tutorial covering JavaScript design patterns, dependency handling and builds with [require.js](http://requirejs.org/), unit testing with [Jasmine](http://pivotal.github.com/jasmine/), simple DOM manipulation and Ajax calls with [jQuery](http://jquery.com/), and client-side encoding with [jQuery Encoder](https://github.com/chrisisbeef/jquery-encoder).

### Brendan Eich's Kind Intro
Brendan Eich, the creator of JavaScript and the CTO of Mozilla, was kind enough to record a short intro for this tutorial. [Check it out](http://videos-cdn.mozilla.net/serv/drafts/Brendan-60fps-720p-MPEG-4.webm).

### The Slides
The slides for this tutorial are [available on Slideshare](http://www.slideshare.net/johnwilander/javascript-fr-javautvecklare), currently only in Swedish.

### The Backend
The whole project is setup with Maven and is run on Jetty via the Jetty Maven plugin. The Java backend is built with Jersey JAX-RS and Spring DI.

### Setup and Run

- Make sure you have Maven installed. Try running 'mvn -version' in your shell to see if you've got it.
- Download or fork the code, go to the source folder (where pom.xml can be found) and run 'mvn install'. Maven will now download the the interwebz for you :).
- In the same folder, run 'mvn jetty:run'.
- Surf to [http://localhost:8080/JavaScriptTutorial/](http://localhost:8080/JavaScriptTutorial/).
- When you want to stop the server you run 'mvn jetty:stop'.

### Try Out a JavaScript Build

If you want to try running the require.js build including concatenation and minification of JavaScript, do this:

- Make sure you have Rhino (js.jar) downloaded. In my example I have it in /Applications/Utilities/rhino/ on my Mac.
- Make sure you have Google's Closure Compiler (compiler.jar) downloaded. In my example I have it in /Applications/Utilities/Closure_Compiler/ on my Mac.
- In your shell, go to path_to_the_tutorial_code_on_your_machine/src/main/webapp/js/
- run java -classpath /Applications/Utilities/rhino/js.jar:/Applications/Utilities/Closure_Compiler/compiler.jar org.mozilla.javascript.tools.shell.Main ../../r.js -o name=base out=min.js baseUrl=. paths.jquery=empty: paths.jquery-encoder=empty:

### Try Out JavaScript Unit Testing

If you want to look into JavaScript unit testing with Jasmine: 

- surf to [http://localhost:8080/JavaScriptTutorial/test/JW/jasmineTestSpec.html](http://localhost:8080/JavaScriptTutorial/test/JW/jasmineTestSpec.html) (the live.js auto-refresh doesn't work in Chrome at them moment)
- Check the corresponing source in path_to_the_tutorial_code_on_your_machine/src/main/webapp/test/JW/

### Contact

Ping me on Twitter –  [@johnwilander](https://twitter.com/johnwilander) – if you have questions or problems setting it up.
