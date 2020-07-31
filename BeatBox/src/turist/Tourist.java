package turist;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Женя on 28.07.2017.
 */
public class Tourist implements Serializable {

    private int id;
    private boolean status;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String passport;
    private String phone;
    private String email;

    public Tourist() {
        status = true;
    }

    public Tourist(String firstName, String lastName, String middleName, Date birthDate, String passport, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.passport = passport;
        this.phone = phone;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
