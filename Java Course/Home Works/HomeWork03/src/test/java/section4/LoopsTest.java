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
}