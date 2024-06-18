package task_1_6_11;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Employee {

    @Setter
    private String name;
    private Department department;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Department department) {
        this(name);
        setDepartment(department);
    }

    /**
     * Установка отдела для сотрудника
     * Если сотрудник являеся руководиетелем в другом отделе, то перед изменением отдела у сотрудника, нужно
     * изменить руководитея отдела, иначе будет выбрашено исключение
     * @param newDepartment новый отдел
     */
    public boolean setDepartment(Department newDepartment) {
        if (this.department != null) {
            if (department.equals(newDepartment))
                return false;

            // Если сотрудник является руководителем в своём отделе
            if (this.department.getManager().equals(this)) {
                return false;
            }
        }
        this.department = newDepartment;
        return true;
    }

    public boolean isManager() {
        if (this.department == null || this.department.getManager() == null)
            return false;
        return this.department.getManager().equals(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department);
    }

    @Override
    public String toString() {
        if (isManager()) {
            return String.format("%s начальник отдела %s", this.name, this.department);
        }
        return String.format("%s работает в отделе %s, начальник которого %s",
                this.name, this.department, this.department.getManager().getName());
    }
}
