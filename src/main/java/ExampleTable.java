import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleTable extends Application {

    private static final int NUM_ELEMENTS = 5000;

    private final TableView<ExampleBean> table = new TableView<>();

    private final ObservableList<ExampleBean> data = FXCollections.observableArrayList();

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        final Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);

        final TableColumn<ExampleBean, Boolean> c1 = new TableColumn<>("A");
        c1.setCellValueFactory(new PropertyValueFactory<ExampleBean, Boolean>("p1"));
        c1.setCellFactory(CheckBoxTableCell.forTableColumn(c1));
        c1.setEditable(true);
        c1.setPrefWidth(100);

        final TableColumn<ExampleBean, String> c2 = new TableColumn<>("B");
        c2.setCellValueFactory(new PropertyValueFactory<ExampleBean, String>("p2"));
        c2.setCellFactory(TextFieldTableCell.forTableColumn());
        c2.setEditable(true);
        c2.setPrefWidth(100);


        for (int i = 0; i < NUM_ELEMENTS; i++) {
            data.add(new ExampleBean());
        }

        final ScrollPane sp = new ScrollPane();
        sp.setContent(table);
        sp.setMaxHeight(Double.POSITIVE_INFINITY);
        sp.setMaxWidth(Double.POSITIVE_INFINITY);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);

        table.setEditable(true);
        table.setItems(data);
        // table.setMaxHeight(Double.POSITIVE_INFINITY);
        // table.setMaxWidth(Double.POSITIVE_INFINITY);
        table.getColumns().addAll(c1, c2);

        final ContextMenu cm = new ContextMenu();
        cm.getItems().add(new MenuItem("bu"));
        table.setContextMenu(cm);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        VBox.setVgrow(sp, Priority.ALWAYS);
        vbox.getChildren().addAll(sp);

        scene.setRoot(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
