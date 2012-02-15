package se.johnwilander.patient;

import se.johnwilander.personnummer.Personnummer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @johnwilander
 */
public class PatientDb {
    private Map<Personnummer, Patient> patients = Collections.synchronizedMap(new HashMap<Personnummer, Patient>());

    public Patient getPatient(Personnummer personnummer) {
        return patients.get(personnummer);
    }

    void putPatient(Patient patient) {
        patients.put(patient.getPersonnummer(), patient);
    }

    public PatientDb(List<Patient> initialPatients) {
        for(Patient patient : initialPatients) {
            putPatient(patient);
        }
    }
}
