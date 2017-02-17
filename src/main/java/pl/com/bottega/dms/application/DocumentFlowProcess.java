package pl.com.bottega.dms.application;

import pl.com.bottega.dms.model.DocumentNumber;
import pl.com.bottega.dms.model.commands.ChangeDocumentCommand;
import pl.com.bottega.dms.model.commands.CreateDocumentCommand;
import pl.com.bottega.dms.model.commands.PublishDocumentCommand;

/**
 * Created by anna on 12.02.2017.
 */
public interface DocumentFlowProcess {

    DocumentNumber create(CreateDocumentCommand createDocumentCommand);

    void change(ChangeDocumentCommand changeDocumentCommand);

    void verify(DocumentNumber documentNumber);

    void publish(PublishDocumentCommand publishDocumentCommand);

    void archive(DocumentNumber documentNumber);
}
