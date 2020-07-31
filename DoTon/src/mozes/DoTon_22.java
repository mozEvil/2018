package mozes;

/**
 * Created by mozEvil on 28.10.2016.
 */
public class DoTon_22 {
    public static void main(String[] args) throws Exception {

        showChoice("E:\\! java\\IdeaProjects\\DoTon\\src\\mozes\\plans.txt");

    }

    private static void showChoice(String filePath) throws Exception {
        PlansTonight pt = new PlansTonight(filePath);
        System.out.print("Сегодня вечером у нас будет -");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.print("-");
        }
        System.out.println("-> " + pt.getChoice().toUpperCase());
    }
}