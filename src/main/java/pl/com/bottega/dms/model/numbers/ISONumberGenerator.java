package pl.com.bottega.dms.model.numbers;

import org.springframework.stereotype.Component;
import pl.com.bottega.dms.model.DocumentNumber;

import java.util.UUID;

/**
 * Created by anna on 12.02.2017.
 */
@Component
public class ISONumberGenerator implements NumberGenerator {
    public DocumentNumber generate() {
        return new DocumentNumber("ISO-" + UUID.randomUUID().toString());
    }
}
