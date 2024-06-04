package section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopsTest {

    @Test
    void listNums() {
        Assertions.assertEquals("0 1 2 3 4 5", Loops.listNums(5));
        Assertions.assertEquals("0", Loops.listNums(0));
        Assertions.assertEquals("", Loops.listNums(-1));
    }

    @Test
    void reverseListNums() {
        Assertions.assertEquals("5 4 3 2 1 0", Loops.reverseListNums(5));
        Assertions.assertEquals("0", Loops.reverseListNums(0));
        Assertions.assertEquals("", Loops.reverseListNums(-1));
    }

    @Test
    void chet() {
        Assertions.assertEquals("0 2 4 6 8", Loops.chet(9));
        Assertions.assertEquals("0", Loops.chet(0));
        Assertions.assertEquals("", Loops.chet(-1));
    }

    @Test
    void pow() {
        Assertions.assertEquals(32, Loops.pow(2, 5));
        Assertions.assertEquals(1, Loops.pow(10, 0));
        Assertions.assertEquals(5, Loops.pow(5, 1));
    }

    @Test
    void numLen() {
        Assertions.assertEquals(5, Loops.numLen(12345));
        Assertions.assertEquals(1, Loops.numLen(0));
        Assertions.assertEquals(2, Loops.numLen(-12));
    }

    @Test
    void equalNum() {
        Assertions.assertTrue(Loops.equalNum(1111));
        Assertions.assertFalse(Loops.equalNum(1211));
        Assertions.assertTrue(Loops.equalNum(0));
    }

    @Test
    void getSquare() {
        StringBuilder sb = new StringBuilder();
        sb.append("****").append(System.lineSeparator());
        sb.append("****").append(System.lineSeparator());
        sb.append("****").append(System.lineSeparator());
        sb.append("****").append(System.lineSeparator());
        Assertions.assertEquals(sb.toString(), Loops.getSquare(4));
    }

    @Test
    void getLeftTriangle() {
        StringBuilder sb = new StringBuilder();
        sb.append("*").append(System.lineSeparator());
        sb.append("**").append(System.lineSeparator());
        sb.append("***").append(System.lineSeparator());
        sb.append("****").append(System.lineSeparator());
        sb.append("*****").append(System.lineSeparator());
        Assertions.assertEquals(sb.toString(), Loops.getLeftTriangle(5));
    }

    @Test
    void getRightTriangle() {
        StringBuilder sb = new StringBuilder();
        sb.append("    *").append(System.lineSeparator());
        sb.append("   **").append(System.lineSeparator());
        sb.append("  ***").append(System.lineSeparator());
        sb.append(" ****").append(System.lineSeparator());
        sb.append("*****").append(System.lineSeparator());
        Assertions.assertEquals(sb.toString(), Loops.getRightTriangle(5));
    }
}