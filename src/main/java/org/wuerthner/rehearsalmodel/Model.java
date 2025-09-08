package org.wuerthner.rehearsalmodel;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Model extends AbstractModelElement {
    public final static String TYPE = "Model";

    public static final IdAttribute id = new IdAttribute()
            .label("Name")
            .defaultValue("Model")
            .strictPattern(false);

    public Model() {
        super(TYPE, Arrays.asList(Project.TYPE), Arrays.asList(id));
    }
}
