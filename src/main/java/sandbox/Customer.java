package sandbox;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by anna on 19.02.2017.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    //@JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Collection<Reservation> reservations;

    private String firstName;

    private String lastName;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }
}
