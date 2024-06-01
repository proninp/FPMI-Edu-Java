package section3;

public class Conditions {
    /**
     * 3.1 Модуль числа
     * @param x целое число
     * @return Модуль числа x
     */
    public static int abs(int x) {
        //return Math.abs(x);
        return x >= 0 ? x : -x;
    }

    /**
     * 3.2 Безопасное деление
     * @param x целое число
     * @param y целое число
     * @return Возвращает резултат деления x на y, при делении на 0 возвращает 0
     */
    public static int safeDiv(int x, int y) {
        return y != 0 ? x / y : 0;
    }

    /**
     * 3.3 Максимум
     * @param x целое число
     * @param y целое число
     * @return максимальное значение
     */
    public static int max(int x, int y) {
        //return Math.max(x, y);
        return (x > y) ? x : y;
    }

    /**
     * 3.4 Строка сравнения
     * @param x целое число
     * @param y целое число
     * @return Строка сравнения
     */
    public static String makeDecision(int x, int y) {
        return x + (x > y ? " > " : x < y ? " < " : " == ") + y;
    }

    /**
     * 3.5 Тройной максимум
     * @param x целое число
     * @param y целое число
     * @param z целое число
     * @return максимальное значение
     */
    public static int max3(int x, int y, int z) {
        return max(z, max(x, y));
    }

    /**
     * 3.6 Тройная сумма
     * @param x целое число
     * @param y целое число
     * @param z целое число
     * @return true, если два любых числа (из трех принятых) можно сложить так, чтобы получить третье
     */
    public static boolean sum3(int x, int y, int z) {
        return x == y + z || y == x + z || z == x + y;
    }

    /**
     * 3.7 Двойная сумма
     * @param x целое число
     * @param y целое число
     * @return сумма чисел x и y. Однако, если сумма попадает в диапазон от 10 до 19, то возвращает 20
     */
    public static int sum2(int x, int y) {
        int z = x + y;
        if (z > 9 && z < 20) {
            return 20;
        }
        return z;
    }

    /**
     * 3.8 Тридцать пять
     * @param x целое число
     * @return true, если число x делится нацело на 3 или 5. При этом, если оно делится и на 3, и на 5, то false
     */
    public static boolean is35(int x) {
        if (x % 3 == 0 && x % 5 == 0)
            return false;
        return x % 3 == 0 || x % 5 == 0;
    }

    /**
     * 3.9 Волшебная шестерка
     * @param x целое число
     * @param y целое число
     * @return true, если одно из принятых методом чисел равно шести,
     * или их сумма равна шести, или разница между ними равна шести
     */
    public static boolean magic6(int x, int y) {
        return x == 6 ||
                y == 6 ||
                x + y == 6 ||
                x - y == 6 ||
                y - x == 6;
    }

    /**
     * 3.10 Возраст
     * @param x целое число
     * @return возвращает строку, в которой сначала будет число х, а затем одно из слов: год, года, лет
     */
    public static String age(int x) {
        int remainder = x % 10;
        if (remainder == 1 && x != 11)
            return x + " год";
        if (remainder > 1 && remainder < 5 && x != 12 && x != 13 && x != 14)
            return x + " года";
        return x + " лет";
    }

}
