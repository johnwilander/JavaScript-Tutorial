/**
 * @johnwilander
 */

(function () {
    "use strict";

    require(["JW/patient/Patient", "JW/personnummer/Personnummer", "JW/proxy/proxy"],
        function(Patient, Personnummer, proxy) {
        describe("Proxy", function() {
            var personnummerValidStr = "191212121212",
                personnummerValid = new Personnummer(personnummerValidStr),
                hasCompleted = false, patient;

            it("should be possible to retrieve a patient via the proxy", function() {
                proxy.getPatient(personnummerValid, function(result) {
                    patient = result.patient;
                    hasCompleted = true;
                }, {
                    url: "../../ws/patient/"
                });

                waitsFor(function() {
                    return hasCompleted &&
                        patient.personnummer.str === personnummerValidStr &&
                        patient instanceof Patient;
                }, "Proxy call never completed", 1000);
            });
        });
    });
}());

