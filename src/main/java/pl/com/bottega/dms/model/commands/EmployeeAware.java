package pl.com.bottega.dms.model.commands;

import pl.com.bottega.dms.model.EmployeeId;

/**
 * Created by anna on 12.03.2017.
 */
public interface EmployeeAware {

    void setEmployeeId(EmployeeId employeeId);
}
