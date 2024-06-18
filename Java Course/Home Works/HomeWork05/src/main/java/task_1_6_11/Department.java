package task_1_6_11;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Department {

    @Setter
    private String name;
    private Employee manager;

    public Department(String name, Employee manager) {
        this.name = name;
        manager.setDepartment(this);
        setManager(manager);
    }

    public boolean setManager(Employee newManager) {
        if (newManager.getDepartment() != null && !newManager.getDepartment().getName().equals(this.getName()))
            return false;

        this.manager = newManager;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
