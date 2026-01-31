package org.wuerthner.rehearsalmodel.attribute;

import org.wuerthner.rehearsalmodel.type.ExtendedDate;
import org.wuerthner.rehearsalmodel.type.SimpleDate;
import org.wuerthner.sport.api.attributetype.Text;
import org.wuerthner.sport.attribute.AbstractAttribute;

public class ExtendedDateAttribute extends AbstractAttribute<ExtendedDate, ExtendedDateAttribute, Text> implements Text {

    public ExtendedDateAttribute(String name) {
        super(name, ExtendedDate.class, Text.class);
    }

    @Override
    public ExtendedDate getValue(String s) {
        return new ExtendedDate(s);
    }
}
