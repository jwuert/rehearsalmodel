package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Voice  extends AbstractModelElement {
    public final static String TYPE = "Voice";

    public static final IdAttribute id = new IdAttribute()
            .label("Stimme")
            .required()
            .strictPattern(false);

    public static final StringAttribute shortid = new StringAttribute("shortid")
            .label("Kürzel")
            .required();

    public final static StringAttribute singers = new StringAttribute("singers")
            .label("Liste")
            .required();

    public Voice() {
        super(TYPE, Arrays.asList(), Arrays.asList(id, shortid, singers));
    }
}
