package se.johnwilander.patient;

import se.johnwilander.medication.Medication;
import se.johnwilander.personnummer.Personnummer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @johnwilander
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Patient {
    private Personnummer personnummer;
    private List<Medication> medications;

    // Don't use this constructor, use PatientFactory instead
    Patient(Personnummer personnummer, List<Medication> medications) {
        this.personnummer = personnummer;
        this.medications = medications;
    }

    public Personnummer getPersonnummer() {
        return personnummer;
    }

    public Patient() {
        // Here for JAXB's sake
    }

    @Override
    public String toString() {
        return "Patient{" +
                "personnummer=" + personnummer +
                ", medications=" + medications +
                '}';
    }
}
