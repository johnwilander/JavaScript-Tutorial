(function () {
    "use strict";

    define(["base"], function() {
        return {
            isDefined: function(obj) {
                return !(obj === undefined || obj === null);
            }
        };

        console.log("util initialized");
    });
}());