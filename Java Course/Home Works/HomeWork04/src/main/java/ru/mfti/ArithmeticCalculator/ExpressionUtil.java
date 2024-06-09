package ru.mfti.ArithmeticCalculator;

class ExpressionUtil {
    static final char OPEN_BRACKET = '(';
    static final char CLOSE_BRACKET = ')';
    static final char PLUS = '+';
    static final char MINUS = '-';
    static final char MULTIPLY = '*';
    static final char DIVISION = '/';
    static final char POW = '^';
    static final char UNARY_MINUS = '~';

    /**
     * Функция для получения подстраки в виде дробного числа
     * @param expression строка в которой производится поиск
     * @param strNumber итоговое найденное число в строков представлении
     * @param fromIndex индекс от которого в строке начинается поиск
     * @return индекс окончания числового представления
     */
    static int getNumberPartFromString(String expression, StringBuilder strNumber, int fromIndex) {
        strNumber.setLength(0);
        if (!Character.isDigit(expression.charAt(fromIndex)))
            return fromIndex;
        int toIndex = fromIndex;
        while(toIndex < expression.length()) {
            char symbol = expression.charAt(toIndex);
            if (Character.isDigit(symbol) || symbol == '.') {
                strNumber.append(symbol);
            } else {
                toIndex--;
                return toIndex;
            }
            toIndex++;
        }
        return toIndex;
    }
}
