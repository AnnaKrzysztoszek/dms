package pl.com.bottega.dms.application.user;

/**
 * Created by anna on 11.03.2017.
 */
public interface AuthProcess {

    AuthResult createAccount(CreateAccountCommand cmd);

    AuthResult login(LoginCommand cmd);
}
