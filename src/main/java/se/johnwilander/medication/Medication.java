package se.johnwilander.medication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @johnwilander
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Medication {
    private String name;
    private MedicationUnit unit;
    private float amount;

    Medication(String name, MedicationUnit unit, float amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public Medication() {
        // Here for JAXB's sake
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", amount=" + amount +
                '}';
    }
    
}
