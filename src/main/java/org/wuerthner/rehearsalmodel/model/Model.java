package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.StaticListAttribute;
import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Model extends AbstractModelElement {
    public final static String TYPE = "Model";

    public static final IdAttribute id = new IdAttribute()
            .label("Name")
            .defaultValue("Model")
            .strictPattern(false);

    public final static StringAttribute director = new StringAttribute("director")
            .label("Chorleitung")
            .required();

    public Model() {
        super(TYPE, Arrays.asList(Project.TYPE, Location.TYPE, Work.TYPE), Arrays.asList(id, director));
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
