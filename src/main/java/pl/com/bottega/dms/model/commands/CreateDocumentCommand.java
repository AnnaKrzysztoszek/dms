package pl.com.bottega.dms.model.commands;

import pl.com.bottega.dms.model.EmployeeId;

/**
 * Created by anna on 12.02.2017.
 */
public class CreateDocumentCommand {
    private String title;
    private EmployeeId employeeId;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setEmployeeId(EmployeeId employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }
}
