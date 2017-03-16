package pl.com.bottega.dms.application;

import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import pl.com.bottega.dms.model.events.DocumentPublishedEvent;

/**
 * Created by anna on 12.03.2017.
 */
@Component
public class DocumentPublishedEmailNotifier {

    @TransactionalEventListener
    public void documentPublished(DocumentPublishedEvent documentPublishedEvent) {
        Logger.getLogger(PrintDocumentScheduler.class).info("Mailing to recipients");
    }
}
