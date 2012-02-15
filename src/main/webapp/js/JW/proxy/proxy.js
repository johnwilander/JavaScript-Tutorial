/**
 * @johnwilander
 */
(function () {
    "use strict";
    define(["JW/util/util", "JW/cache/cache", "JW/personnummer/Personnummer", "JW/patient/Patient", "jquery"],
        function(util, cache, Personnummer, Patient) {

        return {
            getPatient : function(personnummer, callback, options) {
                var patient,
                    url = (util.isDefined(options) && util.isDefined(options.url)) ? options.url : "ws/patient/",
                    _parsePatient = function(patientObj) {
                        return new Patient(new Personnummer(patientObj.personnummer.personnummerStr), patientObj.medications);
                    };

                if(util.isDefined(personnummer) && personnummer instanceof Personnummer) {
                    patient = cache.getPatient(personnummer);

                    if(patient === "Cache miss") {
                        $.ajax({
                            url: url + personnummer.str,
                            success: function(data) {
                                var patient;
                                if(data.status === "false") {
                                    callback({errorMessage: "There's no patient with that personnummer"});
                                } else {
                                    patient = _parsePatient(data);
                                    cache.putPatient(patient);
                                    callback({patient: patient});
                                }
                            },
                            failure: function () {
                                callback({errorMessage: "Something went wrong in the communication with the server system."});
                            }
                        });
                    } else {
                        callback({patient: patient});
                    }
                } else {
                    callback({errorMessage: "Erroneous personnumer"});
                }
            }
        };
    });
}());

