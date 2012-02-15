package se.johnwilander.patient;

import se.johnwilander.medication.Medication;
import se.johnwilander.personnummer.Personnummer;

import java.util.List;

/**
 * @johnwilander
 */
public class PatientFactory {
    public Patient createPatient(Personnummer personnummer, List<Medication> medications) {
        return new Patient(personnummer, medications);
    }
}
