package paint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 30.06.2017.
 */
public class GradientOval extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

//        Graphics2D g2d = (Graphics2D) g;
//
//        int red = (int) (Math.random() * 255);
//        int green = (int) (Math.random() * 255);
//        int blue = (int) (Math.random() * 255);
//        Color startColor = new Color(red, green, blue);
//
//        red = (int) (Math.random() * 255);
//        green = (int) (Math.random() * 255);
//        blue = (int) (Math.random() * 255);
//        Color endColor = new Color(red, green, blue);
//
//        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
//        g2d.setPaint(gradient);
//
//        g2d.fillOval(70, 70, 100, 100);
//
        /////

                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);

                g.setColor(new Color(red, green, blue));

                int height = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x, y, width, height);


    }
}
