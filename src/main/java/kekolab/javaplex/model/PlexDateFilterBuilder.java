package kekolab.javaplex.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import kekolab.javaplex.model.PlexBaseFilter.Operator;

public class PlexDateFilterBuilder {
    private static final DateFormat DATE_FORMAT;

    static {
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    }

    private final PlexFilterableDate field;

    public PlexDateFilterBuilder(PlexFilterableDate field) {
        this.field = field;
    }

    public PlexFilter isAfter(Date value) {
        return new PlexBaseFilter(field.getName(), Operator.IS_GREATER_THAN, DATE_FORMAT.format(value));
    }

    public PlexFilter isBefore(Date value) {
        return new PlexBaseFilter(field.getName(), Operator.IS_LESS_THAN, DATE_FORMAT.format(value));
    }
}