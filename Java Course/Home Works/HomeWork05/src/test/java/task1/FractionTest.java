package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;


class FractionTest {
    @Test
    void plusTest() {
        assertOperation(new int[] {-3, 5}, new int[] {1, 7}, new int[] {-16, 35}, Fraction::plus);
        assertOperation(new int[] {3, 8}, new int[] {5, 1}, new int[] {43, 8}, Fraction::plus);
        assertOperation(new int[] {4, 5}, new int[] {1, 10}, new int[] {9, 10}, Fraction::plus);
        assertOperation(new int[] {15, 28}, new int[] {1, 3}, new int[] {73, 84}, Fraction::plus);
        assertOperation(new int[] {5, 11}, new int[] {-4, 7}, new int[] {-9, 77}, Fraction::plus);
        assertOperation(new int[] {5, 11}, new int[] {-7, 4}, new int[] {-57, 44}, Fraction::plus);
    }

    @Test
    void minusTest() {
        assertOperation(new int[] {2, 3}, new int[] {4, 7}, new int[] {2, 21}, Fraction::minus);
        assertOperation(new int[] {15, 6}, new int[] {2, 1}, new int[] {1, 2}, Fraction::minus);
        assertOperation(new int[] {-4, 15}, new int[] {8, 25}, new int[] {-44, 75}, Fraction::minus);
        assertOperation(new int[] {7, 9}, new int[] {12, 17}, new int[] {11, 153}, Fraction::minus);
        assertOperation(new int[] {-11, 12}, new int[] {4, 7}, new int[] {-125, 84}, Fraction::minus);
    }

    @Test
    void multiplyTest() {
        assertOperation(new int[] {14, 25}, new int[] {-15, 21}, new int[] {-2, 5}, Fraction::multiply);
        assertOperation(new int[] {8, 9}, new int[] {4, 5}, new int[] {32, 45}, Fraction::multiply);
        assertOperation(new int[] {2, 3}, new int[] {4, 7}, new int[] {8, 21}, Fraction::multiply);
        assertOperation(new int[] {5, 11}, new int[] {-4, 7}, new int[] {-20, 77}, Fraction::multiply);
    }

    @Test
    void divisionTest() {
        assertOperation(new int[] {14, 25}, new int[] {-15, 21}, new int[] {-98, 125}, Fraction::division);
        assertOperation(new int[] {-18, 25}, new int[] {-15, 21}, new int[] {126, 125}, Fraction::division);
        assertOperation(new int[] {2, 3}, new int[] {4, 7}, new int[] {7, 6}, Fraction::division);
        assertOperation(new int[] {-4, 7}, new int[] {5, 11}, new int[] {-44, 35}, Fraction::division);
    }

    private void assertOperation(int[] leftParam, int[] rightParam, int[] expectedParam, BinaryOperator<Fraction> operation) {
        Fraction left = new Fraction(leftParam[0], leftParam[1]);
        Fraction right = new Fraction(rightParam[0], rightParam[1]);

        Fraction actual = operation.apply(left, right);
        System.out.println(actual);
        Fraction expected = new Fraction(expectedParam[0], expectedParam[1]);
        Assertions.assertEquals(expected, actual);
    }
}