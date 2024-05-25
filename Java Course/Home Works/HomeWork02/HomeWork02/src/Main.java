public class Main {
    public static void main(String[] args) {
        // 2.1 Дробная часть.
        double a = 5.25;
        System.out.print("2.1 Дробная часть");
        System.out.printf(" [%f]: %n", a);
        System.out.println(fraction(a));
        System.out.println();

        // 2.2 Сумма знаков.
        int b = 4568;
        System.out.print("2.2 Сумма знаков");
        System.out.printf(" [%d]: %n", b);
        System.out.println(sumLastNums(b));
        System.out.println();

        // 2.3 Букву в число.
        char c = '5';
        System.out.print("2.3 Букву в число");
        System.out.printf(" [%c]: %n", c);
        System.out.println(charToNum(c));
        System.out.println();

        // 2.4 Есть ли позитив.
        int d = 3;
        System.out.print("2.4 Есть ли позитив");
        System.out.printf(" [%d]: %n", d);
        System.out.println(isPositive(d));
        System.out.println();

        // 2.5 Двузначное.
        int e = 27;
        System.out.print("2.5 Двузначное");
        System.out.printf(" [%d]: %n", e);
        System.out.println(is2Digits(e));
        System.out.println();

        // 2.6 Большая буква.
        char f = 'F';
        System.out.print("2.6 Большая буква");
        System.out.printf(" [%c]: %n", f);
        System.out.println(isUpperCase(f));
        System.out.println();

        // 2.7 Диапазон.
        int g = 3;
        int h = 5;
        int i = 10;
        System.out.print("2.7 Диапазон");
        System.out.printf(" [%d..%d], число [%d]: %n", g, h, i);
        System.out.println(isInRange(g, h, i));
        System.out.println();

        // 2.7 Диапазон.
        int j = 2;
        int k = 0;
        System.out.print("2.8 Делитель");
        System.out.printf(" [%d], [%d]: %n", j, k);
        System.out.println(isDivisor(j, k));
        System.out.println();

        // 2.9 равенство.
        int l = 2;
        int m = 2;
        int n = 2;
        System.out.print("2.9 равенство");
        System.out.printf(" [%d], [%d], [%d]: %n", l, m, n);
        System.out.println(isEqual(l, m, n));
        System.out.println();

        // 2.9 равенство.
        int o = 5;
        int p = 11;
        int q = 123;
        int r = 14;
        int s = 1;
        System.out.print("2.10 Многократный вызов");
        System.out.printf(" [%d], [%d], [%d], [%d], [%d]: %n", o, p, q, r, s);
        System.out.println(lastNumSum(lastNumSum(lastNumSum(lastNumSum(o, p), q), r), s));
        System.out.println();
    }

    /**
     * 2.1 Дробная часть.
     * @param x дробное число
     * @return дробная часть числа x
     */
    public static double fraction(double x) {
        return x - (int) x;
    }

    /**
     * 2.2 Сумма знаков.
     * @param x целое число
     * @return результат сложения двух последних знаков числа х
     */
    public static int sumLastNums(int x) {
        return x / 10 % 10 + x % 10;
    }

    /**
     * 2.3 Букву в число.
     * @param x символ, который представляет собой один из “0 1 2 3 4 5 6 7 8 9”
     * @return соответствующее число
     */
    public static int charToNum(char x) {
        return x - '0';
    }

    /**
     * 2.4 Есть ли позитив.
     * @param x число
     * @return true если число положительное, иначе false
     */
    public static boolean isPositive(int x) {
        return x > 0;
    }

    /**
     * 2.5 Двузначное.
     * @param x целое число
     * @return true если число двузначное, иначе false
     */
    public static boolean is2Digits(int x) {
        return x > 9 && x < 100;
    }

    /**
     * 2.6 Большая буква.
     * @param x символ
     * @return возвращал true если это большая буква в диапазоне от ‘A’ до ‘Z’, иначе false
     */
    public static boolean isUpperCase(char x) {
        /*
        return Character.isUpperCase(x);
        Изначально я бы сделал так, но в условии прописано "в диапазоне от ‘A’ до ‘Z’"
        */
        return x >= 'A' && x <= 'Z';
    }

    /**
     * 2.7 Диапазон.
     * @param a левая граница
     * @param b правая граница
     * @param num число для определения вхождения в диапазон
     * @return true, если num входит в указанный диапазон (включая границы), иначе false
     */
    public static boolean isInRange(int a, int b, int num) {
        return num <= Math.max(a, b) && num >= Math.min(a, b);
    }

    /**
     * 2.8 Делитель.
     * @param a первое число
     * @param b второе число
     * @return true если любое из принятых чисел делит другое нацело, иначе false
     */
    public static boolean isDivisor (int a, int b) {
        // Если присутствует 0, то всегда можно сделать 0/x = 0, т.е. нацело
        return a == 0 || b == 0 || a % b == 0 || b % a == 0;
    }

    /**
     * 2.9 равенство.
     * @param a первое число
     * @param b второе число
     * @param c третье число
     * @return возвращал true если все три полученных методом числа равны, иначе false
     */
    public static boolean isEqual (int a, int b, int c) {
        return a == b && a == c;
    }

    /**
     * 2.10 Многократный вызов.
     * @param a первое число
     * @param b второе число
     * @return сумма остатков от деления на 10 каждого слогаемого
     */
    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
}