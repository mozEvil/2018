package gui;

import paint.GradientOval;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 30.06.2017.
 */
public class TwoBtnGUI {

    private JFrame frame;
    private JLabel label;

    public void init() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label = new JLabel("Label");
        GradientOval oval = new GradientOval();

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(e -> labelButtonEvent());

        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(e -> colorButtonEvent());

        frame.getContentPane().add(BorderLayout.CENTER, oval);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.NORTH, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void go() {
        init();
    }

    private void labelButtonEvent() {
        label.setText("Ouch!");
    }

    private void colorButtonEvent() {
        frame.repaint();
    }
}
