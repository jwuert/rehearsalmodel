package org.wuerthner.rehearsalmodel.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class ExtendedDate extends Date {
    private enum Shift {
        A("Vormittag"), B("Nachmittag"), C("Abend");
        public final String title;
        Shift(String title) {
            this.title = title;
        }
        public static Shift makeShift(String title) {
            switch (title) {
                case "Vormittag": return Shift.A;
                case "Vormittags": return Shift.A;
                case "A": return Shift.A;
                case "Nachmittag": return Shift.B;
                case "Nachmittags": return Shift.B;
                case "B": return Shift.B;
                case "Abend": return Shift.C;
                case "Abends": return Shift.C;
                case "C": return Shift.C;
                default: return null;
            }
        }
    }

    public final static String DATE_FORMAT = "yyyy-MM-dd";
    private static final long serialVersionUID = 1L;

    private final Shift shift;

    /**
     * Creates a SimpleDate from a given String with the format: dd MMM yyyy
     *
     * @param stringValue
     * @throws ParseException
     */
    public ExtendedDate(String stringValue) {
        String shift = "";
        if (stringValue!=null && stringValue.split("[: ,]").length>1) {
            shift = stringValue.split("[: ,]+")[1].trim();
            stringValue = stringValue.split("[: ,]+")[0].trim();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            if (stringValue==null || stringValue.equals("")) {
                this.setTime(0);
            } else {
                truncateTime(sdf.parse(stringValue).getTime());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (!shift.isEmpty()) {
            Shift myShift = null;
            try {
                myShift = Shift.makeShift(shift);
            } catch (Exception e) {
            }
            this.shift = myShift;
        } else {
            this.shift = null;
        }

    }

    private void truncateTime(long millis) {
        millis = millis - (millis % (24 * 3600000));
        this.setTime(millis);
    }

    @Override
    public String toString() {
        return new SimpleDateFormat(DATE_FORMAT).format(this) + (shift==null ? "" : " : " + shift.name());
    }

    @Override
    public String toLocaleString() {
        return new SimpleDateFormat(DATE_FORMAT).format(this) + (shift==null ? "" : " : " + shift.title);
    }
}