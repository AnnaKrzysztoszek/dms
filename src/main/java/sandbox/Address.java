package sandbox;

import javax.persistence.*;

/**
 * Created by anna on 19.02.2017.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String line1, line2, city, country, zip;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }
}
