/**
 * @johnwilander
 */
(function () {
    "use strict";

    define(["base", "JW/util/util"], function(base, util) {
        return function (personnummerStr) {
            var regexp =  /[0-9]+/,
                oldestAcceptableDate = new Date(1880, 0, 1),  // January == 0
                _isValid = function (personnummerStr) {
                    if((util.isDefined(personnummerStr)) &&
                        (typeof personnummerStr === "string") &&
                        (personnummerStr.length === 12) &&
                        (regexp.test(personnummerStr))) {
                        // TODO Check date and checksum
                        return true;
                    } else {
                        return false;
                    }
                };

            if (_isValid(personnummerStr)) {
                this.str = personnummerStr;
            } else {
                throw new Error("Incorrect personnummer " + personnummerStr);
            }
        };
    });
}());