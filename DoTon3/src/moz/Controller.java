package moz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import moz.plans.Plan;
import moz.plans.PlansTonight;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public Label label;
    public ProgressIndicator pi;
    public Button btn;
    public Label label_date;
    public DialogPane dpane;
    private ObservableList<Plan> tableData = FXCollections.observableArrayList();
    public TableView<Plan> tablePlans;
    public TableColumn<Plan, String> colName;
    public TableColumn<Plan, Integer> colBase;
    public TableColumn<Plan, Integer> colNow;

    public void choicePlan(ActionEvent actionEvent) throws InterruptedException {
        btn.setDisable(true);
        PlansTonight pt = new PlansTonight(new File("src\\moz\\files\\plans.txt").getAbsolutePath());
        String result = pt.getChoice().toUpperCase();

        Task task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                for (int i = 0; i <= 100; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, 100);
                    Thread.sleep(100);
                }
                return null;
            }
        };
        pi.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
        task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                t -> {//выполняется после завершения потока
                    label.setText(result);
                    btn.setText("Еще");
                    btn.setDisable(false);
                    fillTable(pt);
                });
    }

    @Override //выполняется при запуске программы
    public void initialize(URL location, ResourceBundle resources) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        label_date.setText(sdf.format(new Date()));
        fillTable(new PlansTonight(new File("src\\moz\\files\\plans.txt").getAbsolutePath()));
    }

    private void fillTable(PlansTonight pt) {
        tableData.clear();
        tableData.addAll(pt.getList());
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBase.setCellValueFactory(new PropertyValueFactory<>("chance_base"));
        colNow.setCellValueFactory(new PropertyValueFactory<>("chance_now"));
        tablePlans.setItems(tableData);

    }


    public void showList(ActionEvent actionEvent) {
        dpane.setVisible(!dpane.isVisible());
    }
}
