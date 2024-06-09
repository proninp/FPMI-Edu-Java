package ru.mfti.ArithmeticCalculator;

import java.util.ArrayDeque;

import static ru.mfti.ArithmeticCalculator.ExpressionConverter.operatorsPriority;
import static ru.mfti.ArithmeticCalculator.ExpressionUtil.*;

public class Calculator implements ICalculate {
    private final IReversePolishNotationConverter converter;

    public Calculator(IReversePolishNotationConverter converter) {
        this.converter = converter;
    }

    /**
     * Метод вычисения значения выражения
     * @param expression строковое представления арифметического выражения
     * @return значение результата вычисления
     */
    @Override
    public String calculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            return "";
        }

        String reversedPolishNotation = converter.convert(expression);
        double result = calculateRpn(reversedPolishNotation);
        if (result % 1 == 0) {
            return String.valueOf((int)result);
        }
        return String.valueOf(result);
    }

    /**
     * Метод вычисления значения выражения
     * @param rpn запись в формете обратной Польской нотации
     * @return строка - результат вычисления
     */
    private double calculateRpn(String rpn) {
        StringBuilder sbNumber = new StringBuilder();

        var stack = new ArrayDeque<Double>();
        for (int i = 0; i < rpn.length(); i++) {
            char c = rpn.charAt(i);
            if (Character.isDigit(c)) {

                i = ExpressionUtil.getNumberPartFromString(rpn, sbNumber, i);
                double number = Double.parseDouble(sbNumber.toString());
                stack.push(number);
            } else if (operatorsPriority.containsKey(c)) {
                if (c == UNARY_MINUS) {
                    double number = stack.pop();
                    stack.push(-number);
                } else {
                    double right = stack.pop();
                    double left = stack.pop();
                    stack.push(calculateBinaryOperation(c, left, right));
                }
            }
        }
        if (stack.isEmpty())
            throw new IllegalArgumentException("Ошибка вычисления выражения. Недопустимое выражение.");
        return stack.pop();
    }


    /**
     * Вычисление значения бинорной операции
     * @param operation бинарная операция
     * @param left левый операнд
     * @param right правый операнд
     * @return значение выражения
     */
    private double calculateBinaryOperation(char operation, double left, double right) {
        if (operation == DIVISION && right == 0) {
            throw new ArithmeticException("Ошибка вычисления выражения. Деление на ноль запрещено.");
        }
        return switch (operation) {
            case PLUS -> left + right;
            case MINUS -> left - right;
            case MULTIPLY -> left * right;
            case DIVISION -> left / right;
            case POW -> Math.pow(left, right);
            default -> 0;
        };
    }
}
