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
        return sb.substring(0, sb.length() - 1);
    }
}
