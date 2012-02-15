package se.johnwilander.medication;

/**
 * @johnwilander
 */
public class MedicationFactory {
    public Medication createMedication(String name, MedicationUnit unit, float amount) {
        return new Medication(name, unit, amount);
    }
}
