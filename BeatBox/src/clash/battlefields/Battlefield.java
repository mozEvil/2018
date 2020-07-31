package clash.battlefields;

import clash.deck.Castle;
import clash.items.Item;
import clash.items.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Женя on 21.07.2017.
 */
public class Battlefield {

    private  JPanel panel = new JPanel();
    private List<Item> itemsOnBattlefield = new LinkedList<>();
    Unit castle = new Castle();


    public Battlefield() {
        panel.setBackground(Color.GREEN);
        panel.add(castle);
    }

    public JPanel getPane() {
        return panel;
    }


}
