package ru.mfti.ArithmeticCalculator;

import java.util.Map;
import java.util.Stack;

import static ru.mfti.ArithmeticCalculator.ExpressionUtil.*;

public class ExpressionConverter implements IReversePolishNotationConverter {
    static final Map<Character, Integer> operatorsPriority = Map.of(
            OPEN_BRACKET, 0,
            CLOSE_BRACKET, 0,
            PLUS, 1,
            MINUS, 1,
            MULTIPLY, 2,
            DIVISION, 2,
            POW, 3,
            UNARY_MINUS, 4
    );
    private final StringBuilder postfixExpression;
    private final Stack<Character> operatorsStack;

    public ExpressionConverter() {
        operatorsStack = new Stack<>();
        postfixExpression = new StringBuilder();
    }

    /**
     * Метод преобразования строки арифметического выражения в постфиксную строку формата ОПЗ
     * @param infixExpression инфиксная строка выражения
     * @return выражение в формате обратной Польской записи
     */
    @Override
    // Формируем обратную польскую запись
    public String convert(String infixExpression) {
        if (infixExpression.isEmpty())
            return "";

        infixExpression = infixExpression
                .replace(" ", "")
                .replace(",", ".");

        if (!checkPairedBrackets(infixExpression)) {
            String PAIRED_BRACKETS_ERR = "В переданном выражении найдены непарные скобки";
            throw new ArithmeticException(PAIRED_BRACKETS_ERR);
        }

        postfixExpression.setLength(0);

        convertInfixExpressionToPostfixExpression(infixExpression);

        while(!operatorsStack.isEmpty()) {
            postfixExpression.append(operatorsStack.pop());
        }

        return postfixExpression.toString();
    }

    private void convertInfixExpressionToPostfixExpression(String infixExpression) {
        StringBuilder sbNumber = new StringBuilder();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);
            if (Character.isDigit(c)) {
                i = ExpressionUtil.getNumberPartFromString(infixExpression, sbNumber, i);
                postfixExpression.append(sbNumber).append(" ");
            } else if (c == OPEN_BRACKET) {
                operatorsStack.push(c);
            } else if (c == CLOSE_BRACKET) {
                // добавляем к выражению предшествующие операторы
                while(!operatorsStack.isEmpty() && operatorsStack.peek() != OPEN_BRACKET) {
                    postfixExpression.append(operatorsStack.pop());
                }
                operatorsStack.pop(); // удаляем из стэка открывающую (
            } else if (operatorsPriority.containsKey(c)) {
                // определяем, я вляется ли встреченный минус унарным
                if (isUnaryOperator(infixExpression, c, i)) {
                    c = UNARY_MINUS;
                }
                // в выходную строку добавляем все встреченные операторы из стэка, которые имеют более высокий приоритет
                appendLowerPriorityOperators(c);
                operatorsStack.push(c);
            } else {
                throw new IllegalArgumentException("Некорректный символ в арифметической операции: " + c);
            }
        }
    }

    private void appendLowerPriorityOperators(char c) {
        int currPriority = operatorsPriority.get(c);
        while (!operatorsStack.isEmpty() && (operatorsPriority.get(operatorsStack.peek()) >= currPriority)) {
            postfixExpression.append(operatorsStack.pop());
        }
    }
    private boolean isUnaryOperator(String infixExpression, char c, int index) {
        if (c != MINUS) {
            return false;
        }
        if (index == 0) {
            return true;
        }
        return index > 1 && operatorsPriority.containsKey(infixExpression.charAt(index - 1));
    }

    private boolean checkPairedBrackets(String infixExpression) {
        var bracketsStack = new Stack<Character>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);
            if (c == '(') {
                bracketsStack.push(c);
            } else if (c == ')') {
                bracketsStack.pop();
            }
        }
        return bracketsStack.isEmpty();
    }
}
