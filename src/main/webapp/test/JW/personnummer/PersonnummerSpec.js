/**
 * @johnwilander
 */
(function () {
    "use strict";

    require(["JW/personnummer/Personnummer"], function(Personnummer) {
        describe("Personnummer", function() {
            var personnummerValidStr =           "191212121212",
                personnummerInvalidChecksumStr = "191111111111",
                personnummerImpossibleDateStr =  "201202302248",
                personnummerFutureDateStr =      "251212121212",
                personnummerTooOldDateStr =      "181212121212",
                personnummerTooShortStr =        "19121212121",
                personnummerTooLongStr =         "1912121212129",
                personnummerInvalidCharStr =     "191212a21212",
                personnummerEmptyStr =           "",
                personnummerNullStr =            null,
                personnummerUndefinedStr =       undefined;

            it("should be possible to construct a valid personnummer", function() {
                var personnummerValid = new Personnummer(personnummerValidStr);
                expect(personnummerValid instanceof Personnummer).toBeTruthy();
            });

        });
    });
}());