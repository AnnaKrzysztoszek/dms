package pl.com.bottega.dms.model.commands;

import pl.com.bottega.dms.model.EmployeeId;

/**
 * Created by anna on 12.02.2017.
 */
public class ConfirmDocumentCommand {
    private EmployeeId employeeId;

    public void setEmployeeId(EmployeeId employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }
}
