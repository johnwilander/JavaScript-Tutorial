/**
 * @johnwilander
 */


(function () {
    "use strict";
    var localCache = {};

    define(["JW/util/util"], function(util) {
        var max_in_ms = 1000 * 30,  // 30 seconds cache
            _isValid = function(timestamp) {
                return (Date.now() - timestamp) <= max_in_ms;
            },
            _getPatient = function(personnummer) {
                var cacheEntry = localCache[personnummer.str], result;
                if(util.isDefined(cacheEntry) && _isValid(cacheEntry.timestamp)) {
                    console.log("Cache hit");
                    result = cacheEntry.patient;
                } else {
                    console.log("Cache miss");
                    result = "Cache miss";
                }
                return result;
            },
            _putPatient = function(patient) {
                // Will overwrite any previous record
                localCache[patient.personnummer.str] = {patient: patient, timestamp: Date.now()};
            };
        return {
            getPatient: function(personnummer) {
                return _getPatient(personnummer);
            },
            putPatient: function(patient) {
                _putPatient(patient);
            }
        };
    });
}());

