package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.rehearsalmodel.attribute.DateAttribute;
import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.SelectableStringAttribute;
import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;
import java.util.Date;

public class Appointment extends AbstractModelElement {
    public final static String TYPE = "Appointment";

    public static final DateAttribute date = new DateAttribute("date")
            .label("Datum")
            .required();

    public static final StringAttribute message = new StringAttribute("message")
            .label("Info");

    public static final SelectableStringAttribute type = new SelectableStringAttribute("type")
            .label("Typ")
            .addValue("Probe", "PROBE")
            .addValue("Generalprobe", "GENERAL")
            .addValue("Konzert", "KONZERT")
            .defaultValue("PROBE");

    public Appointment() {
        super(TYPE, Arrays.asList(Cancellation.TYPE), Arrays.asList(date, message, type));
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
