package pl.com.bottega.dms.application.user;

import pl.com.bottega.dms.model.EmployeeId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by anna on 11.03.2017.
 */
@Entity
public class User {

    @EmbeddedId
    private EmployeeId employeeId;
    private String hashedPassword;
    private String userName;

    public User() {
    }

    public User(EmployeeId employeeId, String userName, String hashedPassword) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.hashedPassword = hashedPassword;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getUserName() {
        return userName;
    }
}
