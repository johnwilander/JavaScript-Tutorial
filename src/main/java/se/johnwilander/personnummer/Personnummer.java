package se.johnwilander.personnummer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @johnwilander
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Personnummer {
    private String personnummerStr;

    private static final Pattern PERSONNUMMER_PATTERN = Pattern.compile("[0-9]*");
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

    private static Date OLDEST_ACCEPTABLE_DATE;
    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1880, 1, 1);
        OLDEST_ACCEPTABLE_DATE = calendar.getTime();
    }

    public Personnummer(String personnummerStr) throws BadPersonnummerException {
        if (isValid(personnummerStr)) {
            this.personnummerStr = personnummerStr;
        } else {
            throw new BadPersonnummerException();
        }
    }

    private boolean isValid(String personnummerStr) throws BadPersonnummerException {
        if(personnummerStr == null || personnummerStr.length() != 12 || !PERSONNUMMER_PATTERN.matcher(personnummerStr).matches()) {
            return false;
        }

        Date date = extractDate(personnummerStr);

        if(date.before(OLDEST_ACCEPTABLE_DATE) || date.after(new Date())) {
            return false;
        }

        return true;
    }

    private Date extractDate(String personnummerStr) throws BadPersonnummerException {
        try {
            synchronized (formatter) {  // SimpleDateFormat not thread-safe
                return formatter.parse(personnummerStr.substring(0, 8));
            }
        } catch (ParseException e) {
            System.err.println(personnummerStr + " produced a ParseException");
            throw new BadPersonnummerException();
        }
    }

    @Override
    public String toString() {
        return personnummerStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personnummer that = (Personnummer) o;

        if (!personnummerStr.equals(that.personnummerStr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return personnummerStr.hashCode();
    }

    public Personnummer() {
        // Here for JAXB's sake
    }
}
