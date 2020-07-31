package turist;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Женя on 02.08.2017.
 */
public class User implements Serializable {

    private String login;
    private char[] password;

    public User(String login, char[] password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public boolean checkPassword(char[] password) {
        return Arrays.equals(this.password, password);
    }
}
