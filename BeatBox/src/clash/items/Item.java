package clash.items;

import javax.swing.*;

/**
 * Created by Женя on 21.07.2017.
 */
public abstract class Item extends JPanel {

    private String name;
    private String description;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
