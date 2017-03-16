package pl.com.bottega.dms.model.commands;

/**
 * Created by anna on 12.03.2017.
 */
public class CommandInvalidException extends RuntimeException {

    private Validatable.ValidationErrors errors;

    public CommandInvalidException(Validatable.ValidationErrors errors) {
        this.errors = errors;
    }

    public Validatable.ValidationErrors getErrors() {
        return errors;
    }
}