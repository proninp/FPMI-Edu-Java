package section4;

import java.util.Scanner;

public class Loops {
    /**
     * 4.1 Числа подряд
     * @param x целое число
     * @return строка, в которой будут записаны все числа от 0 до x (включительно)
     */
    public static String listNums(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= x ; i++) {
            sb.append(i).append(" ");
        }
        return !sb.isEmpty() ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    /**
     * 4.2 Числа наоборот
     * @param x целое число
     * @return возвращает строку, в которой будут записаны все числа от x до 0 (включительно)
     */
    public static String reverseListNums(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = x; i >= 0 ; i--) {
            sb.append(i).append(" ");
        }
        return !sb.isEmpty() ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    /**
     * 4.3 Четные числа
     * @param x целое число
     * @return строка, в которой будут записаны все четные числа от 0 до x (включительно)
     */
    public static String chet(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= x ; i += 2) {
            sb.append(i).append(" ");
        }
        return !sb.isEmpty() ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    /**
     * 4.4 Степень числа
     * @param x целое число
     * @param y целое число
     * @return возвращает результат возведения x в степень y
     */
    public static int pow(int x, int y) {
        int result = 1;
        while (y > 0) {
            result *= x;
            y--;
        }
        return result;
    }

    /**
     * 4.5 Длина числа
     * @param x целое число
     * @return возвращает количество знаков в числе x
     */
    public static int numLen(long x) {
        int len = x != 0 ? 0 : 1;
        while (x != 0) {
            x /= 10;
            len++;
        }
        return len;
    }

    /**
     * 4.6 Одинаковость
     * @param x целое число
     * @return возвращает true, если все знаки числа одинаковы, и false в ином случае
     */
    public static boolean equalNum(int x) {
        int target = x % 10;
        x /= 10;
        while (x != 0) {
            if (x % 10 != target) {
                return false;
            }
            x /= 10;
        }
        return true;
    }

    /**
     * 4.7 Квадрат
     * @param x целое число
     */
    public static void square(int x) {
        System.out.println(getSquare(x));
    }
    /**
     * 4.7 Квадрат (вспомогательный метод)
     * @param x целое число
     * @return возвращает строку - квадрат из символов '*'
     */
    public static String getSquare(int x) {
        final String asterisk = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(asterisk.repeat(x));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * 4.8 Левый треугольник
     * @param x целое число
     */
    public static void leftTriangle(int x) {
        System.out.println(getLeftTriangle(x));
    }

    /**
     * 4.8 Левый треугольник (вспомогательный метод)
     * @param x целое число
     * @return возвращает строку - левый треугольник из символов '*'
     */
    public static String getLeftTriangle(int x) {
        final String asterisk = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= x; i++) {
            sb.append(asterisk.repeat(i));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * 4.9 Правый треугольник
     * @param x целое число
     */
    public static void rightTriangle(int x) {
        System.out.println(getRightTriangle(x));
    }

    /**
     * 4.9 Правый треугольник (вспомогательный метод)
     * @param x целое число
     * @return возвращает строку - правый треугольник из символов '*'
     */
    public static String getRightTriangle(int x) {
        final String asterisk = "*";
        final String space = " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= x; i++) {
            sb.append(space.repeat(x - i));
            sb.append(asterisk.repeat(i));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * 4.10 Угадайка
     */
    public static void guessGame() {
        int randomNum = (int) (Math.random() * 9 + 1);
        //System.out.println("Загадано число: " + randomNum);
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("What number am I thinking (0 to 9)? :");
            while (sc.nextInt() != randomNum) {
                System.out.println("No, try again");
            }
            System.out.println("Yes, it`s " + randomNum);
        }
    }
}
