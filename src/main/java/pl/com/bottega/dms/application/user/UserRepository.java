package pl.com.bottega.dms.application.user;

import pl.com.bottega.dms.application.user.User;
import pl.com.bottega.dms.model.EmployeeId;

/**
 * Created by anna on 11.03.2017.
 */
public interface UserRepository {

    void put(User user);
    User findByEmployeeId(EmployeeId employeeId);
    User findByUserName(String name);
    User findByLoginAndHashedPassword(String login, String hashedPassword);
}
