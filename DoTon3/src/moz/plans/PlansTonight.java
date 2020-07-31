package moz.plans;

import moz.io.FileWork;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mozEvil on 28.10.2016.
 */
public class PlansTonight {

    private ArrayList<Plan> list_plan;
    private String filePath;

    public PlansTonight(String filePath) {
        this.filePath = filePath;
        list_plan = new ArrayList<>(parseToPlan(readFile()));
        checkChance();
    }

    //получаем Список строк из фаила планы
    private ArrayList<String> readFile() {
        FileWork fw = new FileWork(filePath);
        return fw.read();
    }

    //переводим лист строк в лист планов
    private ArrayList<Plan> parseToPlan(ArrayList<String> list_str) {
        ArrayList<Plan> list_plan = new ArrayList<>();
        for (String str : list_str) {
            String[] tmp = str.split(";");
            Plan plan = new Plan();
            plan.setName(tmp[0].trim());
            plan.setChance_base(Integer.parseInt(tmp[1].trim()));
            plan.setChance_now(Integer.parseInt(tmp[2].trim()));
            list_plan.add(plan);
        }
        return list_plan;
    }

    //переводим лист планов в лист строк для записи
    private ArrayList<String> parseToString(ArrayList<Plan> list_plan) {
        ArrayList<String> list_str = new ArrayList<>();
        for (Plan p : list_plan) {
            list_str.add(p.getName() + "; " + p.getChance_base() + "; " + p.getChance_now() + ";");
        }
        return list_str;
    }

    //выбираем рандомом план
    public String getChoice() {
        ArrayList<String> list_str = new ArrayList<>();
        for (Plan plan : list_plan) {
            for (int i = 0; i < plan.getChance_now(); i++) {
                list_str.add(plan.getName());
            }
        }
        Random random = new Random();
        String choice = list_str.get(random.nextInt(list_str.size()));
        setChance(choice);
        writeFile();
        return choice;
    }

    //уменьшаем шансы у выбранного плана
    private void setChance(String choice) {
        for (Plan plan : list_plan) {
            if (choice.equals(plan.getName())) {
                plan.setChance_now(plan.getChance_now() - 50);
            }
        }
    }

    //проверяем, если у всех планов нулевые шансы, то восстанавливаем до базовых
    private void checkChance() {
        int chance = 0;
        for (Plan plan : list_plan) {
            chance += plan.getChance_now();
        }
        if (chance == 0) {
            for (Plan plan : list_plan) {
                plan.setChance_now(plan.getChance_base());
            }
        }
    }

    //перезаписываем фаил с планами
    private void writeFile() {
        FileWork fw = new FileWork(filePath);
        fw.write(parseToString(list_plan));
    }

    public ArrayList<Plan> getList() {
        return list_plan;
    }

}
