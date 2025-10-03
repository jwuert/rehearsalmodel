package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Work  extends AbstractModelElement {
    public final static String TYPE = "Work";

    public static final IdAttribute id = new IdAttribute()
            .label("Werk")
            .defaultValue("Untitled")
            .strictPattern(false);

    public static final StringAttribute composer = new StringAttribute("composer")
            .label("Komponist");

    public Work() {
        super(TYPE, Arrays.asList(Voice.TYPE), Arrays.asList(id, composer));
    }
}
