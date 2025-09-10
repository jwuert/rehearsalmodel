package org.wuerthner.rehearsalmodel.attribute;

import org.wuerthner.rehearsalmodel.type.SimpleDate;
import org.wuerthner.sport.api.attributetype.Text;
import org.wuerthner.sport.attribute.AbstractAttribute;

public class DateAttribute extends AbstractAttribute<SimpleDate, DateAttribute, Text> implements Text {

    public DateAttribute(String name) {
        super(name, SimpleDate.class, Text.class);
    }

    @Override
    public SimpleDate getValue(String s) {
        return new SimpleDate(s);
    }
}
