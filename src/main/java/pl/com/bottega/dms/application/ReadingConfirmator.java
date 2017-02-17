package pl.com.bottega.dms.application;

import pl.com.bottega.dms.model.commands.ConfirmDocumentCommand;
import pl.com.bottega.dms.model.commands.ConfirmForDocumentCommand;

/**
 * Created by anna on 12.02.2017.
 */
public interface ReadingConfirmator {

    void confirm(ConfirmDocumentCommand confirmDocumentCommand);

    void confirmFor(ConfirmForDocumentCommand confirmForDocumentCommand);
}
