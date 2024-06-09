package ru.mfti.ArithmeticCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void testAddition() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("4", calculator.calculate("2 + 2"));
    }

    @Test
    public void testSubtraction() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("-1", calculator.calculate("3 - 4"));
    }

    @Test
    public void testMultiplication() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("12", calculator.calculate("3 * 4"));
    }

    @Test
    public void testDivision() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("2", calculator.calculate("8 / 4"));
    }

    @Test
    public void testComplexExpression() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("13", calculator.calculate("2 + 3 * 4 - 1"));
    }

    @Test
    public void testParentheses() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("15", calculator.calculate("(2 + 3) * (4 - 1)"));
    }

    @Test
    public void testComplicatedParentheses() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("34", calculator.calculate("(2 - 3 + (-55 + 10 * 7)) + ((-4 + 6) * (24 - (2 + 5) * 2))"));
    }

    @Test
    public void testDecimalNumbers() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("3.24", calculator.calculate("3.1 + 0.14"));
    }

    @Test
    public void testNegativeNumbers() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("-2", calculator.calculate("-2"));
    }

    @Test
    public void testZero() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertEquals("0", calculator.calculate("0"));
    }

    @Test
    public void testInvalidExpression() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("2 + a");
        });
    }

    @Test
    public void testDivisionByZero() {
        ICalculate calculator = new Calculator(new ExpressionConverter());
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate("2 / 0");
        });
    }
}