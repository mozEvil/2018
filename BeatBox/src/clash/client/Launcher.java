package clash.client;

import clash.games.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 21.07.2017.
 */
public class Launcher {

    public Launcher() {
        initGUI();
    }

    private void initGUI() {
        JFrame frame = new JFrame("mozEvil CR");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Start game");
        button.addActionListener(e -> event_button());

        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    private void event_button() {
       new Game();
    }
}
