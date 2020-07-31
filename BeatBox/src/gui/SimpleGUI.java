package gui;

import paint.GradientOval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Женя on 30.06.2017.
 */
public class SimpleGUI implements ActionListener {

    private JFrame frame;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("change colors");
        button.addActionListener(this);

        GradientOval oval = new GradientOval();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, oval);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
