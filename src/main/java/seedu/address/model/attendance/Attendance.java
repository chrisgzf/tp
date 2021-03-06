package seedu.address.model.attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Represents a Person's attendance in classes.
 * Guarantees: immutable
 */
public class Attendance implements Comparable<Attendance> {

    public static final String MESSAGE_CONSTRAINTS = "Accepted date format: dd/MM/yyyy (e.g. 27/03/1998)";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public final Date date;

    public Attendance(Date date) {
        this.date = date;
    }

    /**
     * Creates a new {@code Attendance} using a date string that will be parsed.
     *
     * @param input date string in dd/MM/yyyy
     * @return {@code Attendance} that corresponds to the input date
     */
    public static final Attendance fromDateString(String input) {
        Date date;
        try {
            date = DATE_FORMAT.parse(input);
        } catch (ParseException e) {
            return null;
        }
        return new Attendance(date);
    }

    @Override
    public String toString() {
        return DATE_FORMAT.format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attendance that = (Attendance) o;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public int compareTo(Attendance o) {
        return this.date.compareTo(o.date);
    }
}
