package sandbox;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by anna on 19.02.2017.
 */
@Component
public class JPATester {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        Address address = new Address();
        address.setLine1("Elm St");
        address.setCity("Los Angeles");
        address.setZip("90210");
        address.setCountry("US");
        customer.setAddress(address);
        entityManager.persist(customer);
    }

    @Transactional
    public Customer getCustomer() {
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        System.out.println(customer.getAddress().getCity());
        return customer;
    }

    @Transactional
    public void printAllCustomers() {
        Query query = entityManager.createQuery("FROM Customer c JOIN FETCH c.address");
        Collection<Customer> customers = query.getResultList();
        for (Customer customer : customers) {
            System.out.println(customer.getFirstName());
            System.out.println(customer.getLastName());
            System.out.println(customer.getAddress().getCity());
        }
    }
}
