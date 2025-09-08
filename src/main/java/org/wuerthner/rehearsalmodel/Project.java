package org.wuerthner.rehearsalmodel;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Project extends AbstractModelElement {
    public final static String TYPE = "Project";

    public static final IdAttribute id = new IdAttribute()
            .label("Name")
            .defaultValue("Untitled")
            .strictPattern(false);

    public Project() {
        super(TYPE, Arrays.asList(Appointment.TYPE), Arrays.asList(id));
    }
}
