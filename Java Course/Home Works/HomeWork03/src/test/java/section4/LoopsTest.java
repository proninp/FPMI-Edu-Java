package section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopsTest {

    @Test
    void listNums() {
        Assertions.assertEquals("0 1 2 3 4 5", Loops.listNums(5));
    }
}