package pl.com.bottega.dms.application.user;

/**
 * Created by anna on 11.03.2017.
 */
public class AuthResult {

    private boolean success;
    private String errorMessage;

    public AuthResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public static AuthResult success() {
        return new AuthResult(true, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
