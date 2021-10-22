package View.Alert.AddAlert;

import View.OptionInputBox.FrequencyInputBox;
import View.MyDatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddPlantAlert extends Alert {

    private final TextField parkIdField = new TextField();
    private final TextField zoneIdField = new TextField();
    private final TextField plantIdField = new TextField();
    private final MyDatePicker myDatePicker = new MyDatePicker();
    private final TextField ageField = new TextField();
    private final TextField typeField = new TextField();
    private final TextField wateringIdField = new TextField();
    private final FrequencyInputBox wateringFrequencyBox = new FrequencyInputBox();
    private final TextField wateringTimeField = new TextField();
    private final TextField wateringAmountField = new TextField();

    public AddPlantAlert() {
        super(Alert.AlertType.NONE);
        setTitle("Добавление растения");
        getButtonTypes().add(new ButtonType("OK"));
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("ID парка:   "), parkIdField);
        gridPane.addRow(1, new Label("ID зоны:   "), zoneIdField);
        gridPane.addRow(2, new Label("ID растения:   "), plantIdField);
        gridPane.addRow(3, new Label("Дата высадки"), myDatePicker);
        gridPane.addRow(4, new Label("Возраст"), ageField);
        gridPane.addRow(5, new Label("Тип"), typeField);
        gridPane.addRow(6, new Label("ID режима полива"), wateringIdField);
        gridPane.addRow(7, new Label("Частота полива"), wateringFrequencyBox);
        gridPane.addRow(8, new Label("Время полива"), wateringTimeField);
        gridPane.addRow(9, new Label("Количество воды в литрах"), wateringAmountField);
        getDialogPane().setContent(gridPane);

    }

    private String getFieldValue(TextField field){
        if (field.getText().isEmpty()) return "не указано";
        return field.getText();
    }

    public String getPlantId(){
        return getFieldValue(plantIdField);
    }

    public String getParkId(){
        return getFieldValue(parkIdField);
    }

    public String getZoneId(){
        return getFieldValue(zoneIdField);
    }

    public String getDateValue(){
        return myDatePicker.getDateValue().toString();
    }

    public String getAge(){
        return getFieldValue(ageField);
    }

    public String getType(){
        return getFieldValue(typeField);
    }

    public String getWateringId(){
        return getFieldValue(wateringIdField);
    }

    public String getWateringFrequency(){
        return wateringFrequencyBox.toString();
    }

    public String getWateringTime(){
        return getFieldValue(wateringTimeField);
    }

    public String getWateringAmount(){
        return getFieldValue(wateringAmountField);
    }



}
