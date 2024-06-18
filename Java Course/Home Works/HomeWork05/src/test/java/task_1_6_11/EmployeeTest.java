package task_1_6_11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void testEmployees() {
        Employee director = new Employee("Peter Jackson");
        Department actors = new Department("Actors", director);

        Employee aragorn = new Employee("Viggo Mortensen", actors);
        Employee frodo = new Employee("Elijah Wood", actors);
        Employee gendalf = new Employee("Ian McKellen", actors);
        Employee gollum = new Employee("Andy Serkisyan", actors);

        List<Employee> staff = new ArrayList<>(List.of(
                director, aragorn, frodo, gendalf, gollum
        ));

        staff.forEach(System.out::println);

        System.out.println("\nGollum now is a director, my precious!\n");


        actors.setManager(gollum);
        staff.forEach(System.out::println);
    }
}