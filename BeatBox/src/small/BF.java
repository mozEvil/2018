package small;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 24.07.2017.
 */
public class BF {

    public static void main(String[] args) {
        new BF().initGUI();
    }

    private void initGUI() {
        JFrame frame = new JFrame("Start game");
        frame.setBackground(Color.GREEN);
        JPanel panel = new JPanel();
        Unit circle = new Unit(0, 0);
        panel.add(circle);
        //frame.setContentPane(panel);

        frame.getContentPane().add(BorderLayout.CENTER, circle);
        //frame.getContentPane().add(BorderLayout.SOUTH, new Unit(100, 100));


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);
    }
}
