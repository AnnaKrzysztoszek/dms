package pl.com.bottega.dms.application;

/**
 * Created by anna on 14.02.2017.
 */
public class DocumentStatusException extends RuntimeException {

    public DocumentStatusException() {
        super("Not allowed do this");
    }
}
