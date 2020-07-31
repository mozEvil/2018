package small;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 24.07.2017.
 */
public class Unit  extends JPanel {

    private int x;
    private int y;

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 20, 20);
    }
}
