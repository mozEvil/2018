package remote.server;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by Женя on 18.07.2017.
 */
public interface Service extends Serializable {

    public JPanel getGuiPanel();
}
