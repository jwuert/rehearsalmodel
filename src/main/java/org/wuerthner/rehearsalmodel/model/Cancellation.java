package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Cancellation extends AbstractModelElement {
    public final static String TYPE = "Cancellation";

    public static final StringAttribute userid = new StringAttribute("userid")
            .label("ID");

    public Cancellation() {
        super(TYPE, Arrays.asList(), Arrays.asList(userid));
    }
}
