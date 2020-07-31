package turist;

import java.io.Serializable;

/**
 * Created by Женя on 28.07.2017.
 */

public class Tour implements Serializable {

    private int id;
    private boolean status;
    private String name;
    private String description;

    public Tour() {
        status = true;
    }

    public Tour(String name, String description) {
        this.name = name;
        this.description = description;
        status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void delete() {
        status = false;
    }

    public boolean isActive() {
        return status;
    }

    public String getName() {
        return name;
    }

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