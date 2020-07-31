import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mozEvil on 27.10.2016.
 */
public class DoTon {

    public static void main(String[] args) throws Exception {


        ArrayList list = new ArrayList();
        list.add("Прогулка 30 минут");
        list.add("Прогулка 60 минут");
        list.add("Массаж Женя Максиму");
        list.add("Массаж Максим Жене");
        list.add("Кино");
        list.add("Душ");
        list.add("Танки");
        list.add("Дота");
        list.add("Бильярд");
        list.add("Шахматы");
        list.add("Английский");
        list.add("Ленивые тюлени");
        list.add("Аниме");
        list.add("Книга");
        list.add("JavaRush");

        Plans plans = new Plans(list);
        System.out.print("Выбираем занятие из списка.");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println("\nВаше занятие на сегодня: " + plans.choise().toUpperCase());
        System.out.println("Удачного вечера!");
    }

    public static class Plans {

        public Plans(ArrayList list) {
            this.list = new ArrayList(list);
        }

        public void addPlan(String s) {
            list.add(s);
        }

        public int getCount() {
            return list.size();
        }

        public String choise() {
            Random random = new Random();
            return list.get(random.nextInt(list.size())).toString();
        }


        private ArrayList list;
    }
}
