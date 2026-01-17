package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;

public class Location extends AbstractModelElement {
    public final static String TYPE = "Location";

    public static final IdAttribute id = new IdAttribute()
            .label("ID")
            .strictPattern(false)
            .required();

    public static final StringAttribute name = new StringAttribute("name")
            .label("Name")
            .required();

    public static final StringAttribute address = new StringAttribute("address")
            .label("Adresse")
            .required();

    public static final StringAttribute plz = new StringAttribute("plz")
            .label("PLZ")
            .required();

    public static final StringAttribute city = new StringAttribute("city")
            .label("Stadt")
            .required();

    public Location() {
        super(TYPE, Arrays.asList(), Arrays.asList(id, name, address, plz, city));
    }

    public String getId() { return this.getAttributeValue(id); }
}
