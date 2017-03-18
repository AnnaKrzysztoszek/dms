package pl.com.bottega.dms.application.user;

/**
 * Created by anna on 11.03.2017.
 */
public class AuthRequiredException extends RuntimeException {

    public AuthRequiredException(String msg) {
        super(msg);
    }
}
