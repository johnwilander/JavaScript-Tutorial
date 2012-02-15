package se.johnwilander.personnummer;

/**
 * @johnwilander
 */
public class PersonnummerFactory {

    public Personnummer createPersonnummer(String personnummerStr) {
        Personnummer personnummer;
        try {
            personnummer = new Personnummer(personnummerStr);
        } catch (BadPersonnummerException e) {
            System.err.println("Erroneous personnummer " + personnummerStr);
            personnummer = null;
        }
        return personnummer;
    }
}
