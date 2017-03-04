package sandbox;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by anna on 19.02.2017.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Embedded
    @AttributeOverride(name = "companyName", column = @Column(name = "publisher_companyName"))
    private Publisher publisher;

    @Embedded
    @AttributeOverride(name = "companyName", column = @Column(name = "otherPublisher_companyName"))
    private Publisher publisher2;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
}
