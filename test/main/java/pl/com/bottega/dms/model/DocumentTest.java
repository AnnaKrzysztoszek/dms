package pl.com.bottega.dms.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.dms.application.DocumentStatusException;
import pl.com.bottega.dms.model.commands.ChangeDocumentCommand;
import pl.com.bottega.dms.model.commands.CreateDocumentCommand;
import pl.com.bottega.dms.model.commands.PublishDocumentCommand;
import pl.com.bottega.dms.model.numbers.NumberGenerator;
import pl.com.bottega.dms.model.printing.PrintCostCalculator;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static pl.com.bottega.dms.model.DocumentStatus.DRAFT;
import static pl.com.bottega.dms.model.DocumentStatus.PUBLISHED;
import static pl.com.bottega.dms.model.DocumentStatus.VERIFIED;

/**
 * Created by anna on 12.02.2017.
 */
public class DocumentTest {

    private static final Long DATE_EPS = 500L;

    private CreateDocumentCommand createDocumentCommand;
    private NumberGenerator numberGenerator;
    private Document document;
    private ChangeDocumentCommand changeDocumentCommand;
    private EmployeeId someEmployeeId = new EmployeeId(123L);
    private EmployeeId otherEmployeeId = new EmployeeId(124L);
    private PublishDocumentCommand publishDocumentCommand;
    private PrintCostCalculator printCostCalculator;
    private LocalDateTime createdAt = new LocalDateTime();

    @Before
    public void setUp() {
        createDocumentCommand = new CreateDocumentCommand();
        numberGenerator = new StubNumberGenerator();
        createDocumentCommand.setTitle("test title");
        document = new Document(createDocumentCommand, numberGenerator);
        changeDocumentCommand = new ChangeDocumentCommand();
        changeDocumentCommand.setTitle("changed title");
        changeDocumentCommand.setContent("changed content");
    }

    @Test
    public void shouldBeDraftAfterCreate() {
        //given

        //when

        //then
        assertEquals(DRAFT, document.getStatus());
    }

    @Test
    public void shouldGenerateNumberOnCreate() {
        //given

        //when

        //then
        assertEquals(new DocumentNumber("1"), document.getNumber());
    }

    @Test
    public void shouldSetTitleOnCreate() {
        //given

        //when

        //then
        assertEquals("test title", document.getTitle());
    }

    @Test
    public void shouldChangeTitleAndContent() {
        /*//given
        ChangeDocumentCommand changeDocumentCommand = new ChangeDocumentCommand();
        changeDocumentCommand.setTitle("changed title");
        changeDocumentCommand.setContent("changed content");*/

        //when
        document.change(changeDocumentCommand, someEmployeeId);

        //then
        assertEquals("changed title", document.getTitle());
        assertEquals("changed content", document.getContent());
    }

    @Test
    public void shouldChangeStatusToVerifyAfterVerified() {
        //when
        document.verify(someEmployeeId);

        //then
        assertEquals(VERIFIED, document.getStatus());
    }

    @Test
    public void shouldChangeStatusToDraftAfterEdit() {
        //given
        document.verify(someEmployeeId);

        //when
        document.change(changeDocumentCommand, someEmployeeId);

        //then
        assertEquals(DRAFT, document.getStatus());
    }

    @Test
    public void shouldChangeStatusToPublishAfterPublished() {
        //given
        document.verify(someEmployeeId);

        //when
        document.publish(publishDocumentCommand, printCostCalculator, someEmployeeId);

        //then
        assertEquals(PUBLISHED, document.getStatus());
    }
    @Test
    public void shouldRememberCreateDate() {
        assertSameTime(document.getCreatedAt(), createdAt);
    }

    @Test(expected = DocumentStatusException.class)
    public void shouldNotAllowVerifyingAlreadyVerifiedDocument() {
        // given - document is already verified
        document.verify(someEmployeeId);

        // when - second verification attempt
        document.verify(otherEmployeeId);

        // then - nie ma tutaj żadych assercji bo testujemy czy kodzik produkcyjny wyrzuci wyjątek klasy DocumentStatusException
    }

    @Test(expected = DocumentStatusException.class)
    public void shouldNotAllowDoAnythingWithArchivedDocument() {
        //given
        document.archive();

        //when
        document.verify(someEmployeeId);
    }

    @Test(expected = DocumentStatusException.class)
    public void shouldNotAllowPublishWhenDocumentIsNotVerified() {
        //given
        document.change(changeDocumentCommand, someEmployeeId);

        //when
        document.publish(publishDocumentCommand, printCostCalculator, someEmployeeId);
    }

    class StubNumberGenerator implements NumberGenerator {

        public DocumentNumber generate() {
            return new DocumentNumber("1");
        }
    }

    private void assertSameTime(LocalDateTime expected, LocalDateTime actual) {
        assertTrue(ChronoUnit.MILLIS.between(expected, actual) < DATE_EPS);
    }
}
