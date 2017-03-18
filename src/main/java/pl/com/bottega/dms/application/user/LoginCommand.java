package pl.com.bottega.dms.application.user;

import pl.com.bottega.dms.model.commands.Validatable;

/**
 * Created by anna on 11.03.2017.
 */
public class LoginCommand implements Validatable {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate(ValidationErrors errors) {
        if(isEmpty(login))
            errors.add("login", "can't be blank");
        if(isEmpty(password))
            errors.add("password", "can't be blank");
    }
}
