package sandbox;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by anna on 19.02.2017.
 */
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDeath;

    @ManyToMany
    private Set<Book> books;
}
