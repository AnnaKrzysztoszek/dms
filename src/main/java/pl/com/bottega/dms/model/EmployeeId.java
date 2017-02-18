package pl.com.bottega.dms.model;

/**
 * Created by anna on 14.02.2017.
 */
public class EmployeeId {

    private Long id;

    public EmployeeId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeId that = (EmployeeId) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
