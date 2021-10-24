package View;
import javafx.scene.control.DatePicker;

import java.sql.Date;


public class MyDatePicker extends DatePicker{
    static  Date defaultDate = new Date(0,0,0);

    public Date getDateValue(){
        if (getValue() != null) {
            return new Date(getValue().getYear()-1900, getValue().getMonth().ordinal(), getValue().getDayOfMonth());
        } else{
            return defaultDate;
        }
    }

    static public Date getDefaultDate(){
        return defaultDate;
    }
}
