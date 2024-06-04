package section5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysFpmiTest {

    @Test
    void findFirst() {
        Assertions.assertEquals(0, ArraysFpmi.findFirst(new int[]{0, 1, 2, 3, 4, 5}, 0));
        Assertions.assertEquals(3, ArraysFpmi.findFirst(new int[]{0, 1, 2, 3, 4, 5}, 3));
        Assertions.assertEquals(5, ArraysFpmi.findFirst(new int[]{0, 1, 2, 3, 4, 5}, 5));
        Assertions.assertEquals(-1, ArraysFpmi.findFirst(new int[]{0, 1, 2, 3, 4, 5}, 8));
    }


    @Test
    void findLast() {
        Assertions.assertEquals(5, ArraysFpmi.findLast(new int[]{0, 1, 2, 3, 4, 4}, 4));
        Assertions.assertEquals(4, ArraysFpmi.findLast(new int[]{0, 1, 2, 3, 3, 4}, 3));
        Assertions.assertEquals(2, ArraysFpmi.findLast(new int[]{0, 0, 0, 1, 1, 1}, 0));
        Assertions.assertEquals(-1, ArraysFpmi.findLast(new int[]{0, 1, 2, 3, 4, 5}, 8));
    }

    @Test
    void maxAbs() {
        Assertions.assertEquals(5, ArraysFpmi.maxAbs(new int[]{0, 1, 2, 3, 4, 5}));
        Assertions.assertEquals(-3, ArraysFpmi.maxAbs(new int[]{-3, -2, -1, 0, 1, 2}));
        Assertions.assertEquals(4, ArraysFpmi.maxAbs(new int[]{-1, 1, -2, 2, -3, 4}));
    }

    @Test
    void countPositive() {
        Assertions.assertEquals(5, ArraysFpmi.countPositive(new int[]{0, 1, 2, 3, 4, 5}));
        Assertions.assertEquals(2, ArraysFpmi.countPositive(new int[]{0, 0, 1, 0, 2, 0}));
        Assertions.assertEquals(0, ArraysFpmi.countPositive(new int[]{-1, -2, -3, -4, -5}));
    }

    @Test
    void palindrom() {
        Assertions.assertTrue(ArraysFpmi.palindrom(new int[]{1, 2, 3, 2, 1}));
        Assertions.assertTrue(ArraysFpmi.palindrom(new int[]{1, 2, 3, 3, 2, 1}));
        Assertions.assertTrue(ArraysFpmi.palindrom(new int[]{0}));
        Assertions.assertFalse(ArraysFpmi.palindrom(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void reverse() {
        int[] arr = new int[] {0, 1, 2, 3, 4, 5};
        ArraysFpmi.reverse(arr);
        Assertions.assertArrayEquals(new int[] {5, 4, 3, 2, 1, 0}, arr);
        arr = new int[] {0};
        ArraysFpmi.reverse(arr);
        Assertions.assertArrayEquals(new int[] {0}, arr);
        arr = new int[] {-5, -4, -3, -2, -1};
        ArraysFpmi.reverse(arr);
        Assertions.assertArrayEquals(new int[] {-1, -2, -3, -4, -5}, arr);
    }

    @Test
    void reverseBack() {
        Assertions.assertArrayEquals(new int[] {5, 4, 3, 2, 1, 0}, ArraysFpmi.reverseBack(new int[] {0, 1, 2, 3, 4, 5}));
        Assertions.assertArrayEquals(new int[] {0}, ArraysFpmi.reverseBack(new int[] {0}));
        Assertions.assertArrayEquals(new int[] {-1, -2, -3, -4, -5},
                ArraysFpmi.reverseBack(new int[] {-5, -4, -3, -2, -1}));
    }

    @Test
    void concat() {
        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5},
                ArraysFpmi.concat(new int[] {0, 1, 2, 3, 4, 5}, new int[] {0, 1, 2, 3, 4, 5}));

        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                ArraysFpmi.concat(new int[] {0, 1, 2, 3, 4, 5}, new int[] {6, 7, 8, 9, 10}));

        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3},
                ArraysFpmi.concat(new int[] {0, 1, 2, 3}, new int[] {}));
    }

    @Test
    void findAll() {
        int[] arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Assertions.assertArrayEquals(new int[] {0, 11, 22}, ArraysFpmi.findAll(arr, 0));
        Assertions.assertArrayEquals(new int[] { 33 }, ArraysFpmi.findAll(arr, 11));
        Assertions.assertArrayEquals(new int[] {}, ArraysFpmi.findAll(arr, 12));
    }

    @Test
    void deleteNegative() {
        int[] arr = new int[] {1, 2, -3, 4, -2, 2, -5};
        Assertions.assertArrayEquals(new int[] {1, 2, 4, 2}, ArraysFpmi.deleteNegative(arr));
    }

    @Test
    void add() {
        int[] arr = new int[] {0, 1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 6, 4, 5}, ArraysFpmi.add(arr, 6, 4));
        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6}, ArraysFpmi.add(arr, 6, 6));
    }

    @Test
    void addAll() {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int[] ins = new int[] {7, 8, 9};
        Assertions.assertArrayEquals(new int[] {1, 2, 3, 7, 8, 9, 4, 5}, ArraysFpmi.add(arr, ins, 3));
        Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 7, 8, 9}, ArraysFpmi.add(arr, ins, 5));
        Assertions.assertArrayEquals(new int[] {7, 8, 9, 1, 2, 3, 4, 5}, ArraysFpmi.add(arr, ins, 0));
    }
}