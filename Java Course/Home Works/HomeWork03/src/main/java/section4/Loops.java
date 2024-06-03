package section4;

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
}
