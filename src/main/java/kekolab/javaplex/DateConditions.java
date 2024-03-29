package kekolab.javaplex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import kekolab.javaplex.model.PlexCondition;

class DateConditions extends Conditions {
    protected DateConditions(String field) {
        super(field);
    }

    public PlexCondition isAfter(Date value) {
        return super.withOperator(">>=").withValue(dateFormat().format(value)).build();
    }

    public PlexCondition isBefore(Date value) {
        return super.withOperator("<<=").withValue(dateFormat().format(value)).build();
    }

    private DateFormat dateFormat() {
        return new SimpleDateFormat("dd-MM-yy");
    }
}
    
   