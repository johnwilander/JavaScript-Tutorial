/**
 * @johnwilander
 */
(function () {
    "use strict";
    require(["JW/util/util", "JW/proxy/proxy", "JW/personnummer/Personnummer", "JW/patient/Patient", "jquery", "jquery-encoder"],
        function(util, proxy, Personnummer, Patient) {

            var _formatPersonnummer = function(personnummer) {
                var firstPart = personnummer.str.substring(0,8), lastPart = personnummer.str.substring(8);
                return $.encoder.encodeForHTML(firstPart + "-" + lastPart);
            },
                _formatMedicationList = function(medications) {
                    var i, resultingHtml = "",
                        _convertUnit = function(unit) {
                            switch(unit) {
                                case "GRAM":
                                    return "g";
                                case "MILLIGRAM":
                                    return "mg";
                                case "MILLILITER":
                                    return "ml";
                                default:
                                    throw new Error("Unknown unit " + unit);
                            }
                        };
                    for(i = 0; i < medications.length; i++) {
                        resultingHtml += $.encoder.encodeForHTML(medications[i].name) +
                            (medications[i].name.length > 8 ? "\t" : "\t\t\t");
                        resultingHtml += $.encoder.encodeForHTML(medications[i].amount) +
                            ((medications[i].amount+"").length > 4 ? "\t" : "\t\t");
                        resultingHtml += $.encoder.encodeForHTML(_convertUnit(medications[i].unit)) + "\t";
                        resultingHtml += "\r"
                    }
                    return resultingHtml;
                },
                _populateGuiWithPatientInfo = function(patient) {
                    $("#patientInfo").html(_formatPersonnummer(patient.personnummer));
                    $("#medicationList").html(_formatMedicationList(patient.medications));
                },
                _showErrorMessage = function(errorMessage) {
                    alert(errorMessage);
                },
                _submitSearch = function(event) {
                    var personnummerStr = $("#searchField").val(), personnummer;

                    console.log("Search for: " + personnummerStr);

                    if(!util.isDefined(personnummerStr) || personnummerStr === "") {
                        _showErrorMessage("You have to enter a Swedish personnummer");
                    } else {
                        try {
                            personnummer = new Personnummer(personnummerStr);
                            proxy.getPatient(personnummer, function(result) {
                                if(util.isDefined(result.errorMessage)) {
                                    _showErrorMessage(result.errorMessage);
                                } else if(util.isDefined(result.patient) && result.patient instanceof Patient) {
                                    _populateGuiWithPatientInfo(result.patient);
                                }
                            });
                        } catch (error) {
                            _showErrorMessage(error);
                        }

                    }
                };

            $(document).ready(function() {
                // Event handler for search button
                $("#searchButton").click(function(event) {
                    _submitSearch(event);
                });

                $("#searchField").keypress(function(event) {
                    if(event.which === 13) {
                        _submitSearch(event);
                    }
                });
            });

        });
}());

