/**
 * @johnwilander
 */
(function () {
    "use strict";

    define(["JW/personnummer/Personnummer"], function(Personnummer) {
        return function (personnummer, medications) {
            if (personnummer instanceof Personnummer) {
                this.personnummer = personnummer;
                this.medications = medications;
            } else {
                throw new Error("Not a correct personnummer");
            }
        };
    });
}());