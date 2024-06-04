package section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class ConditionsTest {

    @Test
    public void abs() {
        Assertions.assertEquals(3, Conditions.abs(-3));
        Assertions.assertEquals(0, Conditions.abs(0));
        Assertions.assertEquals(3, Conditions.abs(3));
    }

    @Test
    public void safeDiv() {
        Assertions.assertEquals(3, Conditions.safeDiv(6, 2));
        Assertions.assertEquals(0, Conditions.safeDiv(6, 0));
        Assertions.assertEquals(3, Conditions.safeDiv(3, 1));
    }

    @Test
    public void max() {
        Assertions.assertEquals(-1, Conditions.max(-1, -2));
        Assertions.assertEquals(3, Conditions.max(1, 3));
        Assertions.assertEquals(3, Conditions.max(2, 3));
    }

    @Test
    public void makeDecision() {
        Assertions.assertEquals("1 < 2", Conditions.makeDecision(1, 2));
        Assertions.assertEquals("4 > 2", Conditions.makeDecision(4, 2));
        Assertions.assertEquals("3 == 3", Conditions.makeDecision(3, 3));
    }

    @Test
    public void max3() {
        Assertions.assertEquals(3, Conditions.max3(1, 3, 2));
        Assertions.assertEquals(3, Conditions.max3(2, 3, 1));
    }

    @Test
    public void sum3() {
        Assertions.assertEquals(true, Conditions.sum3(1, 2, 3));
        Assertions.assertEquals(false, Conditions.sum3(1, 2, 4));
    }

    @Test
    public void sum2() {
        Assertions.assertEquals(3, Conditions.sum2(1, 2));
        Assertions.assertEquals(20, Conditions.sum2(10, 2));
        Assertions.assertEquals(20, Conditions.sum2(10, 9));
        Assertions.assertEquals(25, Conditions.sum2(15, 10));
    }

    @Test
    public void is35() {
        Assertions.assertEquals(true, Conditions.is35(3));
        Assertions.assertEquals(true, Conditions.is35(5));
        Assertions.assertEquals(false, Conditions.is35(4));
        Assertions.assertEquals(false, Conditions.is35(15));
        Assertions.assertEquals(false, Conditions.is35(22));
    }

    @Test
    public void magic6() {
        Assertions.assertEquals(true, Conditions.magic6(6, 2));
        Assertions.assertEquals(true, Conditions.magic6(7, 6));
        Assertions.assertEquals(true, Conditions.magic6(3, 3));
        Assertions.assertEquals(true, Conditions.magic6(14, 8));
        Assertions.assertEquals(true, Conditions.magic6(2, 8));
        Assertions.assertEquals(false, Conditions.magic6(25, 1));
        Assertions.assertEquals(false, Conditions.magic6(5, 2));
    }

    @Test
    public void age() {
        assertEquals("3 года", Conditions.age(3));
        assertEquals("5 лет", Conditions.age(5));
        assertEquals("12 лет", Conditions.age(12));
        assertEquals("44 года", Conditions.age(44));
        assertEquals("51 год", Conditions.age(51));
        assertEquals("112 лет", Conditions.age(112));
        assertEquals("1152 года", Conditions.age(1152));
        assertEquals("2512 лет", Conditions.age(2512));
    }

    @Test
    public void day() {
        assertEquals("понедельник", Conditions.day(1));
        assertEquals("вторник", Conditions.day(2));
        assertEquals("среда", Conditions.day(3));
        assertEquals("четверг", Conditions.day(4));
        assertEquals("пятница", Conditions.day(5));
        assertEquals("суббота", Conditions.day(6));
        assertEquals("воскресенье", Conditions.day(7));
        assertEquals("это не день недели", Conditions.day(8));
    }

    @Test
    public void printDays() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream console = System.out;
        PrintStream err = System.err;
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

        Conditions.printDays("понедельник");
        assertEquals(String.join("", days), outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("вторник");
        assertEquals(String.join("", Arrays.copyOfRange(days, 1, days.length)), outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("среда");
        assertEquals(String.join("", Arrays.copyOfRange(days, 2, days.length)), outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("четверг");
        assertEquals(String.join("", Arrays.copyOfRange(days, 3, days.length)), outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("пятница");
        assertEquals(String.join("", Arrays.copyOfRange(days, 4, days.length)), outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("суббота");
        assertEquals(String.join("", Arrays.copyOfRange(days, 5, days.length)), outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("воскресенье");
        assertEquals("воскресенье", outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        Conditions.printDays("1");
        assertEquals("это не день недели", outputStream.toString().replace("\r\n", ""));
        outputStream.reset();

        System.setOut(console);
        System.setErr(err);
    }
}