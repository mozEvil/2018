package clash.games;

import clash.battlefields.Battlefield;
import clash.client.Player;
import clash.items.Item;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 20.07.2017.
 */
public class Game {

    private Player player;
    private Player enemy;
    private Battlefield battlefield;

    private final static int MAX_MANA = 100;
    private final static int BATTLE_TIME = 180;
    private final static int SPEED_TIME = 60;

    private int playerScore;
    private int enemyScore;

    public Game(Player player, Player enemy, Battlefield battlefield) {
        this.player = player;
        this.enemy = enemy;
        this.battlefield = battlefield;
        initGUI();
    }

    public Game() {
        this.player = new Player(new Item[]{});
        this.enemy = new Player(new Item[]{});
        this.battlefield = new Battlefield();
        initGUI();
    }


    private void initGUI() {
        JFrame frame = new JFrame("Start game");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.CENTER, battlefield.getPane());


        frame.setSize(400, 600);
        frame.setVisible(true);
    }

}
