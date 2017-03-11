package pl.com.bottega.dms.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.bottega.dms.application.DocumentStatusException;
import pl.com.bottega.dms.application.user.AuthRequiredException;

/**
 * Created by anna on 11.03.2017.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(AuthRequiredException.class)
    public ResponseEntity<String> handleAuthRequiredException() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<String>(
                "{\"error\": \"authentication_required\"}",
                headers,
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(DocumentStatusException.class)
    public ResponseEntity<String> handleDocumentStatusException(DocumentStatusException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<String>(
                String.format("{\"error\": \"document_status_error\", \"details\": \"%s\"authentication managenent}", ex.getMessage()),
                headers,
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }
}
