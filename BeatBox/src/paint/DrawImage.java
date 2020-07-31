package paint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Женя on 30.06.2017.
 */
public class DrawImage extends JPanel {

    public void paintComponent(Graphics g) {
//        g.setColor(Color.orange);
//        g.fillRect(20, 50, 100, 100);
        Image image = new ImageIcon("tattoo.jpg").getImage();
        g.drawImage(image, 3, 4, this);

    }


}
