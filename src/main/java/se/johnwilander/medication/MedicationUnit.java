package se.johnwilander.medication;

/**
 * @johnwilander
 */
public enum MedicationUnit {
    GRAM("g"), MILLIGRAM("mg"), MILLILITER("ml");
    
    private final String abbreviation;
    private MedicationUnit(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
