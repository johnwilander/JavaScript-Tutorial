/**
 * @johnwilander
 */
(function () {
    "use strict";

    require(["JW/personnummer/Personnummer", "JW/patient/Patient"], function(Personnummer, Patient) {
        describe("Patient", function() {
            var patientValid,
                personnummerValid = new Personnummer("191212121212"),
                medicationsValid =  [{name: "Alvedon", unit: "mg", amount: "200"}];

            beforeEach(function() {
                patientValid = new Patient(personnummerValid, medicationsValid);
            });

            it("should be type Patient", function() {
                expect(patientValid instanceof Patient).toBeTruthy();
            });

            it("should be able to access personnummer in a new patient object", function() {
                expect(patientValid.personnummer).toEqual(personnummerValid);
            });

            it("should be able to access medication list in a new patient object", function() {
                expect(patientValid.medications).toEqual(medicationsValid);
            });
        });
    });
}());