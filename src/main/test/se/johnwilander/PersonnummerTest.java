package se.johnwilander;

import org.junit.Test;
import se.johnwilander.personnummer.BadPersonnummerException;
import se.johnwilander.personnummer.Personnummer;

import static org.junit.Assert.fail;

/**
 * @johnwilander
 */
public class PersonnummerTest {
    private String personnummerValid =           "191212121212";
    private String personnummerInvalidChecksum = "191111111111";
    private String personnummerImpossibleDate =  "201202302248";
    private String personnummerFutureDate =      "251212121212";
    private String personnummerTooOldDate =      "181212121212";
    private String personnummerTooShort =        "19121212121";
    private String personnummerTooLong =         "1912121212129";
    private String personnummerInvalidChar =     "191212a21212";
    private String personnummerEmpty =           "";
    private String personnummerNull =            null;

    // Positive tests

    @Test
    public void valid () {
        try {
            new Personnummer(personnummerValid);
        } catch (BadPersonnummerException e) {
            fail();
        }
    }

    // Negative tests

    @Test
    public void invalidChecksum() {
        try {
            new Personnummer(personnummerInvalidChecksum);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void impossibleDate() {
        try {
            new Personnummer(personnummerImpossibleDate);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void futureDate() {
        try {
            new Personnummer(personnummerFutureDate);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void tooOldDate() {
        try {
            new Personnummer(personnummerTooOldDate);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void tooShort() {
        try {
            new Personnummer(personnummerTooShort);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void tooLong() {
        try {
            new Personnummer(personnummerTooLong);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void invalidChar() {
        try {
            new Personnummer(personnummerInvalidChar);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void empty() {
        try {
            new Personnummer(personnummerEmpty);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }

    @Test
    public void nullObj() {
        try {
            new Personnummer(personnummerNull);
            fail();
        } catch (BadPersonnummerException e) {
            // Pass
        }
    }
}
