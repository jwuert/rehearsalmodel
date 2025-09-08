package org.wuerthner.rehearsalmodel;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Appointment extends AbstractModelElement {
    public final static String TYPE = "Appointment";

    public static final IdAttribute id = new IdAttribute()
            .label("Name")
            .defaultValue("Untitled")
            .strictPattern(false);

    public Appointment() {
        super(TYPE, Arrays.asList(), Arrays.asList(id));
    }
}
