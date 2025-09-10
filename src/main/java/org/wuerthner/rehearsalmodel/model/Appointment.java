package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.rehearsalmodel.attribute.DateAttribute;
import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.SelectableStringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;
import java.util.Date;

public class Appointment extends AbstractModelElement {
    public final static String TYPE = "Appointment";

    public static final IdAttribute id = new IdAttribute()
            .label("Name")
            .defaultValue("Untitled")
            .strictPattern(false);

    public static final DateAttribute date = new DateAttribute("date")
            .label("Datum")
            .required();

    public static final SelectableStringAttribute type = new SelectableStringAttribute("type")
            .label("Typ")
            .addValue("Probe", "PROBE")
            .addValue("Generalprobe", "GENERAL")
            .addValue("Konzert", "KONZERT")
            .defaultValue("PROBE");

    public Appointment() {
        super(TYPE, Arrays.asList(), Arrays.asList(id, date, type));
    }

    @Override
    public String getId() {
        return this.getAttributeValue(id);
    }

    @Override
    public String toString() {
        return getId();
    }
}
