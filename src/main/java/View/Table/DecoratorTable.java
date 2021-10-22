package View.Table;

import Model.Labourer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DecoratorTable extends TableView {

    final private TableColumn<Labourer, Short> idTableColumn;
    final private TableColumn<Labourer, String> lastNameTableColumn;
    final private TableColumn<Labourer, String> firstNameTableColumn;
    final private TableColumn<Labourer, String> patronymicTableColumn;
    final private TableColumn<Labourer, String> phoneTableColumn;
    final private TableColumn<Labourer, String> addressTableColumn;
    final private TableColumn<Labourer, String> educationTableColumn;
    final private TableColumn<Labourer, String> nameOfInstitutionTableColumn;
    final private TableColumn<Labourer, String> categoryTableColumn;

    public DecoratorTable() {
        setMinHeight(600);

        idTableColumn = new TableColumn<>("ID");
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        lastNameTableColumn = new TableColumn<>("Фамилия");
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameTableColumn.setPrefWidth(100);

        firstNameTableColumn = new TableColumn<>("Имя");
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameTableColumn.setPrefWidth(100);

        patronymicTableColumn = new TableColumn<>("Отчество");
        patronymicTableColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        patronymicTableColumn.setPrefWidth(100);

        phoneTableColumn = new TableColumn<>("Телефон");
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneTableColumn.setPrefWidth(150);

        addressTableColumn = new TableColumn<>("Адрес");
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressTableColumn.setPrefWidth(200);

        educationTableColumn = new TableColumn<>("Образование");
        educationTableColumn.setCellValueFactory(new PropertyValueFactory<>("education"));
        educationTableColumn.setPrefWidth(200);

        nameOfInstitutionTableColumn = new TableColumn<>("Название оконченного учебного заведения");
        nameOfInstitutionTableColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfInstitution"));
        nameOfInstitutionTableColumn.setPrefWidth(200);

        categoryTableColumn = new TableColumn<>("Категория");
        categoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        categoryTableColumn.setPrefWidth(200);

        getColumns().addAll(idTableColumn, lastNameTableColumn, firstNameTableColumn, patronymicTableColumn, phoneTableColumn, addressTableColumn, educationTableColumn, nameOfInstitutionTableColumn, categoryTableColumn);
    }

    public TableColumn<Labourer, Short> getIdTableColumn() {
        return idTableColumn;
    }

    public TableColumn<Labourer, String> getLastNameTableColumn() {
        return lastNameTableColumn;
    }

    public TableColumn<Labourer, String> getFirstNameTableColumn() {
        return firstNameTableColumn;
    }

    public TableColumn<Labourer, String> getPatronymicTableColumn() {
        return patronymicTableColumn;
    }

    public TableColumn<Labourer, String> getPhoneTableColumn() {
        return phoneTableColumn;
    }

    public TableColumn<Labourer, String> getAddressTableColumn() {
        return addressTableColumn;
    }

    public TableColumn<Labourer, String> getEducationTableColumn() {
        return educationTableColumn;
    }

    public TableColumn<Labourer, String> getNameOfInstitutionTableColumn() {
        return nameOfInstitutionTableColumn;
    }

    public TableColumn<Labourer, String> getCategoryTableColumn() {
        return categoryTableColumn;
    }
}
