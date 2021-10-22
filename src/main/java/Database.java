import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Database extends Application {

    public static final String DB_URL = "jdbc:h2:/home/katsiaryna/IdeaProjects/pbz1/db/Company";
    public static final String DB_USER = "leask";
    public static final String DB_Driver = "org.h2.Driver";
    public static final String DB_PASSWORD = "1111";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Company");
        primaryStage.setScene(new Scene(new View(DB_URL, DB_USER, DB_PASSWORD, DB_Driver)));
        primaryStage.sizeToScene();
        primaryStage.show();
    }


    /*
    ДОДЕЛАТЬ:
    - возможность добавлять/удалять/редачить зоны
    - редактирование инфы о фирме
    - при добавлении/редактирование служащего и TIMETABLE
    • Просмотр списка сотрудников, работающих на заданную дату – ФИО, дата рождения, телефон.
    • Просмотр перечня всех растений заданного вида на текущую дату и режимы их полива.

    */

    public static void main(String[] args) {
        launch(args);
    }
}