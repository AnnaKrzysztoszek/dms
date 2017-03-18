package pl.com.bottega.dms.application;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import pl.com.bottega.dms.model.events.DocumentPublishedEvent;

/**
 * Created by anna on 12.03.2017.
 */
@Component
public class PrintDocumentScheduler {

    @TransactionalEventListener
    @Async
    public void documentPublished(DocumentPublishedEvent event) {
        Logger.getLogger(PrintDocumentScheduler.class).info("Scheduling document printing");
    }
}
