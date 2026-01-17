package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.sport.attribute.DynamicListAttribute;
import org.wuerthner.sport.attribute.IdAttribute;
import org.wuerthner.sport.attribute.StaticListAttribute;
import org.wuerthner.sport.attribute.StringAttribute;
import org.wuerthner.sport.core.AbstractModelElement;

import java.util.Arrays;
import java.util.Map;

public class Voice  extends AbstractModelElement {
    public final static String TYPE = "Voice";

    public static final IdAttribute id = new IdAttribute()
            .label("Stimme")
            .required()
            .strictPattern(false);

    public static final StringAttribute shortid = new StringAttribute("shortid")
            .label("Kürzel")
            .required();

//    public final static StringAttribute singers = new StringAttribute("singers")
//            .label("Liste")
//            .required();

    public final static StaticListAttribute<String> singerList = new StaticListAttribute<>("singerList", String.class)
            .label("Teinehmer");

    public Voice() {
        super(TYPE, Arrays.asList(), Arrays.asList(id, shortid, singerList));
    }

    public String getId() { return this.getAttributeValue(id); }

    public void setUserMap(Map<String, String> userMap) {
        if (singerList.getValueMap().isEmpty()) {
            for (Map.Entry<String,String> entry : userMap.entrySet()) {
                singerList.addValue(entry.getValue(), entry.getKey());
            }
        }
    }
}
