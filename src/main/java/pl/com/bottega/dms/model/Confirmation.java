package pl.com.bottega.dms.model;

import java.time.LocalDateTime;

/**
 * Created by anna on 18.02.2017.
 */
public class Confirmation {

    private EmployeeId owner;
    private LocalDateTime confirmationDate;
    private EmployeeId proxy;//przedstawiciel

    public Confirmation(EmployeeId owner) {
        this.owner = owner;
    }

    public boolean isOwnedBy(EmployeeId employeeId) {
        return employeeId.equals(owner);
    }

    public boolean isConfirmed() {
        return confirmationDate != null;
    }

    public void confirm() {
        confirmationDate = LocalDateTime.now();
    }

    public void confirmFor(EmployeeId proxy) {
        confirm();
        this.proxy = proxy;
    }
}
