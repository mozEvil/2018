package paint;

import javax.swing.*;

/**
 * Created by Женя on 30.06.2017.
 */
public class TestPaint {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setContentPane(new GradientOval());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
