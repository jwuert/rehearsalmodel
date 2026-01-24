package org.wuerthner.rehearsalmodel.model;

import org.wuerthner.rehearsalmodel.attribute.DateAttribute;
import org.wuerthner.sport.attribute.*;
import org.wuerthner.sport.check.IdAvailableCheck;
import org.wuerthner.sport.check.True;
import org.wuerthner.sport.core.AbstractModelElement;
import org.wuerthner.sport.core.ElementFilter;

import java.util.Arrays;
import java.util.Date;

public class Appointment extends AbstractModelElement {
    public final static String TYPE = "Appointment";

    public static final DateAttribute date = new DateAttribute("date")
            .label("Datum")
            .required();

    public static final StringAttribute time = new StringAttribute("time")
            .label("Zeit")
            .required();

    public static final DynamicSelectableStringAttribute location = new DynamicSelectableStringAttribute("location")
            .label("Ort")
            .required()
            .addValidation(new IdAvailableCheck(Location.TYPE))
            .addFilter(new ElementFilter(Location.TYPE, new True()))
            ;

    public static final StringAttribute message = new StringAttribute("message")
            .label("Info");

    public static final SelectableStringAttribute type = new SelectableStringAttribute("type")
            .label("Typ")
            .addValue("Probe", "PROBE")
            .addValue("Probenwochenende", "PWE")
            .addValue("Generalprobe", "GENERAL")
            .addValue("Konzert", "KONZERT")
            .addValue("Feier", "FEIER")
            .defaultValue("PROBE");

    public static final BooleanAttribute suppressCancellation = new BooleanAttribute("suppressCancellation")
            .label("Absage verbieten");

    public static final BooleanAttribute allowAcceptance = new BooleanAttribute("allowAcceptance")
            .label("Zusage anbieten");

    public Appointment() {
        super(TYPE, Arrays.asList(Cancellation.TYPE), Arrays.asList(date, time, location, message, type, suppressCancellation, allowAcceptance));
    }

    @Override
    public String getId() {
        return ""+this.getAttributeValue(date);
    }

    @Override
    public String toString() {
        return getId();
    }
}
