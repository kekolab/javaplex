package kekolab.javaplex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import kekolab.javaplex.model.PlexFilter;

public class DateFilterBuilder extends PlexFilterBuilder {
    protected DateFilterBuilder(String field) {
        super(field);
    }

    public PlexFilter isAfter(Date value) {
        return super.withOperator(">>=").withValue(dateFormat().format(value)).build();
    }

    public PlexFilter isBefore(Date value) {
        return super.withOperator("<<=").withValue(dateFormat().format(value)).build();
    }

    private DateFormat dateFormat() {
        return new SimpleDateFormat("dd-MM-yy");
    }
}
    
   