package pl.com.bottega.dms.model;

import pl.com.bottega.dms.application.DocumentStatusException;
import pl.com.bottega.dms.model.commands.*;
import pl.com.bottega.dms.model.numbers.NumberGenerator;
import pl.com.bottega.dms.model.printing.PrintCostCalculator;

import java.time.LocalDateTime;
import java.util.Date;

import static pl.com.bottega.dms.model.DocumentStatus.*;

/**
 * Created by anna on 12.02.2017.
 */
public class Document {

    private DocumentNumber number;
    private DocumentStatus status;
    private String title;
    private String content;
    private LocalDateTime verifiedAt, createdAt, publishedAt, changedAt;
    private EmployeeId verifier, creator, publisher, editor;

    public Document(CreateDocumentCommand createDocumentCommand, NumberGenerator numberGenerator) {
        this.number = numberGenerator.generate();
        this.status = DRAFT;
        this.title = createDocumentCommand.getTitle();

        this.createdAt = new LocalDateTime();
        this.verifiedAt = getVerifiedAt();
        this.publishedAt = getPublishedAt();
        this.changedAt = getChangedAt();

        this.creator = getCreator();
        this.verifier = getVerifier();
        this.publisher = getPublisher();
        this.editor = getEditor();

        //if (this.status == ARCHIVED)
    }

    public void change(ChangeDocumentCommand changeDocumentCommand, EmployeeId employeeId) {
        if (this.status == DRAFT || this.status == VERIFIED) {
            this.title = changeDocumentCommand.getTitle();
            this.content = changeDocumentCommand.getContent();
            this.status = DRAFT;
            this.changedAt = new LocalDateTime();
            this.editor = employeeId;
        } else {
            throw new DocumentStatusException();
        }
    }

    public void verify(EmployeeId employeeId) {
        if (this.status == DRAFT) {
            this.verifier = employeeId;
            this.status = VERIFIED;
            this.verifiedAt = new LocalDateTime();
        } else {
            throw new DocumentStatusException();
        }
    }

    public void archive() {
        this.status = ARCHIVED;
    }

    public void publish(PublishDocumentCommand publishDocumentCommand, PrintCostCalculator printCostCalculator, EmployeeId employeeId) {
        if (this.status == VERIFIED) {
            this.status = PUBLISHED;
            this.publishedAt = new LocalDateTime();
            this.publisher = employeeId;
        } else {
            throw new DocumentStatusException();
        }
    }
    public void confirm(ConfirmDocumentCommand confirmDocumentCommand) {

    }

    public void confirm(ConfirmForDocumentCommand confirmForDocumentCommand) {

    }

    public DocumentStatus getStatus() {
        return status;
    }

    public DocumentNumber getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public EmployeeId getVerifier() {
        return verifier;
    }

    public EmployeeId getCreator() {
        return creator;
    }

    public EmployeeId getPublisher() {
        return publisher;
    }

    public EmployeeId getEditor() {
        return editor;
    }
}
