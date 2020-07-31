package ru.mozevil.address.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import ru.mozevil.address.model.Person;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Женя on 09.08.2017.
 */
public class BirthdayStatisticsController {

    @FXML
    private BarChart barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        //получаем массив с английскими именами месяцев.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        monthNames.addAll(months);

        //начначаем имена месяцев категориями для горизонтальной оси.
        xAxis.setCategories(monthNames);
    }

    /**
     * Задает адресатов, о которых будет показана статистика.
     *
     * @param persons
     */
    public void setPersonData(List<Person> persons) {
        //считаем адресатов, имеющих дни рождения в указанном месяце.
        int[] monthCounter = new int[12];
        for (Person p : persons) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }

        XYChart.Series series = new XYChart.Series<>();

        //создаем объект XYChart.Data для каждого месяа.
        //добавляем его в серии.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }

        barChart.getData().add(series);
    }
}
