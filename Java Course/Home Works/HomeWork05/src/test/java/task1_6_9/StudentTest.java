package task1_6_9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void studentCreationTest() {
        Student neo = new Student("Thomas Anderson");
        System.out.println(neo);
        Student keeper = new Student("Bilbo Baggins", 5, 4, 5, 4, 3, 5, 3, 5, 5, 5, 4);
        System.out.println(keeper);
        assertEquals("Thomas Anderson", neo.toString());
        assertEquals("Bilbo Baggins: [5, 4, 5, 4, 3, 5, 3, 5, 5, 5, 4]", keeper.toString());
    }

    @Test
    void illegalGradeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Student luke = new Student("Luke Stackwalker", 5, 4, 15);
        });
    }
}