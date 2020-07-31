package mozes;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mozEvil on 28.10.2016.
 */
public class PlansTonight {

    private ArrayList<String> list_str;
    private ArrayList<Plan> list_plan;
    private String filePath;

    public PlansTonight(String filePath) {
        this.filePath = filePath;
        list_plan = new ArrayList<>(parse(readFile(filePath)));
        checkChance();
        list_str = new ArrayList<>();
        for (Plan plan : list_plan) {
            for (int i = 0; i < plan.chance_now; i++) {
                list_str.add(plan.name);
            }
        }
    }

    //получаем Список строк из фаила планы
    private ArrayList<String> readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) return null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> list = new ArrayList<>();
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
            return list;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private ArrayList<Plan> parse(ArrayList<String> list_str) {
        if (list_str == null) return null;
        ArrayList<Plan> list_plan = new ArrayList<>();
        for (String str : list_str) {
            String[] tmp = str.split(";");
            Plan plan = new Plan();
            plan.name = tmp[0].trim();
            plan.chance_base = Integer.parseInt(tmp[1].trim());
            plan.chance_now = Integer.parseInt(tmp[2].trim());
            list_plan.add(plan);
        }
        return list_plan;
    }


    public String getChoice() {
        Random random = new Random();
        String choice = list_str.get(random.nextInt(list_str.size()));
        setChance(choice);
        return choice;
    }

    private void setChance(String choice) {
        ArrayList<Plan> new_list_plan = new ArrayList<>();
        for (Plan plan : list_plan) {
            if (choice.equals(plan.name)) {
                plan.chance_now -= 50;
            }
            new_list_plan.add(plan);
        }
        writeFile(new_list_plan);
    }

    private void checkChance() {
        int chance = 0;
        for (Plan plan : list_plan) {
           chance += plan.chance_now;
        }
        if (chance == 0) {
            for (Plan plan : list_plan) {
                plan.chance_now = plan.chance_base;
            }
        }
    }

    public void writeFile(ArrayList<Plan> list) {
        try {
            FileWriter writer = new FileWriter(new File(filePath), false);

            for (Plan plan : list) {
                writer.write(plan.name + "; ");
                writer.write(plan.chance_base + "; ");
                writer.write(plan.chance_now + ";\n");
            }
            writer.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

class Plan {

    String name;
    int chance_base;
    int chance_now;
}