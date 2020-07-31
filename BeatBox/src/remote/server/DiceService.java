package remote.server;

import javax.swing.*;

/**
 * Created by Женя on 18.07.2017.
 */
public class DiceService implements Service {

    JLabel label;
    JComboBox numOfDice;

    @Override
    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll 'em!");
        String[] choices = {"1", "2", "3", "4", "5"};
        numOfDice = new JComboBox(choices);
        label = new JLabel("dice values here");
        button.addActionListener(e -> event_button());
        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);
        return panel;
    }

    private void event_button() {
        StringBuilder diceOutput = new StringBuilder();
        String selection = (String) numOfDice.getSelectedItem();
        int numOfDiceToRoll = Integer.parseInt(selection);
        for (int i = 0; i < numOfDiceToRoll; i++) {
            int r = (int) ((Math.random() * 6 ) + 1);
            diceOutput.append(" ").append(r);
        }
        label.setText(diceOutput.toString());
    }
}
