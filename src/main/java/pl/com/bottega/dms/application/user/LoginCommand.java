package pl.com.bottega.dms.application.user;

/**
 * Created by anna on 11.03.2017.
 */
public class LoginCommand {

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
}
