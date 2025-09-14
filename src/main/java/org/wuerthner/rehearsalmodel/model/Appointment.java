package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.rehearsalmodel.attribute.DateAttribute;
import org.wuerthner.sport.attribute.*;
import org.wuerthner.sport.check.True;
import org.wuerthner.sport.core.AbstractModelElement;
import org.wuerthner.sport.core.ElementFilter;

import java.util.Arrays;
import java.util.Date;

public class Appointment extends AbstractModelElement {
    public final static String TYPE = "Appointment";

    public static final DateAttribute date = new DateAttribute("date")
            .label("Datum")
            .required();

    public static final StringAttribute time = new StringAttribute("time")
            .label("Zeit")
            .required();

    public static final DynamicSelectableStringAttribute location = new DynamicSelectableStringAttribute("location")
            .label("Ort")
            .addFilter(new ElementFilter(Location.TYPE, new True()))
            ;

    public static final StringAttribute message = new StringAttribute("message")
            .label("Info");

    public static final SelectableStringAttribute type = new SelectableStringAttribute("type")
            .label("Typ")
            .addValue("Probe", "PROBE")
            .addValue("Generalprobe", "GENERAL")
            .addValue("Konzert", "KONZERT")
            .defaultValue("PROBE");

    public static final BooleanAttribute suppressCancellation = new BooleanAttribute("suppressCancellation")
            .label("Absage verbieten");


    public Appointment() {
        super(TYPE, Arrays.asList(Cancellation.TYPE), Arrays.asList(date, time, location, message, type, suppressCancellation));
    }

    @Override
    public String getId() {
        return ""+this.getAttributeValue(date);
    }

    @Override
    public String toString() {
        return getId();
    }
}
