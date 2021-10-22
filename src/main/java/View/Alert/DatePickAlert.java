package View.Alert;

import View.MyDatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.sql.Date;

public class DatePickAlert extends Alert {
    private final MyDatePicker datePicker = new MyDatePicker();

    public DatePickAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Выбор даты");
        getButtonTypes().add(new ButtonType("OK"));
        getDialogPane().setContent(new HBox(new Label("Введите дату:   "), datePicker));
    }

    public Date getDate(){
        return datePicker.getDateValue();
    }
}
