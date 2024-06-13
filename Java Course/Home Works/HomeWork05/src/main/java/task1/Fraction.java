package task1;

import java.util.Objects;

public class Fraction {
    private int numerator; // числитель
    private int denominator; // знаменатель

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель должен быть положительным числом");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /**
     * Сложение дробей
     * @param right правое слогаемое - дробь
     * @return новая дробь - сумма двух дробей
     */
    public Fraction plus(Fraction right) {
        Fraction left = this;

        FractionHelper fractionHelper = new FractionHelper(left, right);

        int newNumerator = fractionHelper.leftNumerator + fractionHelper.rightNumerator;
        return new Fraction(newNumerator, fractionHelper.commonDenominator);
    }

    /**
     * Сложение дроби и целого числа
     * @param number правое слогаемое - целое число
     * @return новая дробь - сумма двух дробей
     */
    public Fraction plus(int number) {
        return plus(new Fraction(number, 1));
    }

    /**
     * Вычитание дробей
     * @param right правое вычитаемое - дробь
     * @return новая дробь - разница двух дробей
     */
    public Fraction minus(Fraction right) {
        Fraction left = this;

        FractionHelper fractionHelper = new FractionHelper(left, right);

        int newNumerator = fractionHelper.leftNumerator - fractionHelper.rightNumerator;
        return new Fraction(newNumerator, fractionHelper.commonDenominator);
    }

    /**
     * Вычитание дроби и целого числа
     * @param number правое вычитаемое - целое число
     * @return новая дробь - разница дроби и целого числа
     */
    public Fraction minus(int number) {
        return minus(new Fraction(number, 1));
    }

    /**
     * Умножение дробей
     * @param right множитель - дробь
     * @return новая дробь - произведение двух дробей
     */
    public Fraction multiply(Fraction right) {
        Fraction left = this;

        int newNumerator = left.numerator * right.numerator;
        int newDenominator = left.denominator * right.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Умножение дроби и целого числа
     * @param number множитель - целое число
     * @return новая дробь - произведение дроби и целого числа
     */
    public Fraction multiply(int number) {
        return multiply(new Fraction(number, 1));
    }

    /**
     * Функция деления дробей
     * @param right правая дробь
     * @return Результат деления дробей
     */
    public Fraction division(Fraction right) {
        Fraction left = this;
        // упрощаем дробь
        // левый числитель с правым числителем
        int gcd = gcd(Math.abs(left.numerator), Math.abs(right.numerator));
        int leftNumerator = left.numerator / gcd;
        int rightNumerator = right.numerator / gcd;

        // левый знаменатель с правым знаменателем
        gcd = gcd(left.denominator, right.denominator);
        int leftDenominator = left.denominator / gcd;
        int rightDenominator = right.denominator / gcd;

        // переносим знак правого числителя в знаменатель, т.к. правый знаменатель будет множителем числителя
        if (rightNumerator < 0) {
            rightNumerator = -rightNumerator;
            rightDenominator = -rightDenominator;
        }

        // перемножаем левый числитель с правым знаменателем и левый знаменатель с правым числителем
        int newNumerator = leftNumerator * rightDenominator;
        int newDenominator = leftDenominator * rightNumerator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Функция деления дроби на целое число
     * @param number целое число
     * @return Результат деления дроби и целого числа
     */
    public Fraction division(int number) {
        return division(new Fraction(number, 1));
    }

    /**
     * Функция для упрощения дроби, если числитель и знаменатель имеют общий делитель
     */
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), denominator); // нод для сокращения числителя и знаменателя
        numerator /= gcd;
        denominator /= gcd;
    }

    // Нахождение наибольшего общего делителя
    private int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return Math.max(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        Fraction left = new Fraction(this.numerator, this.denominator);
        Fraction right = new Fraction(fraction.numerator, fraction.denominator);
        left.simplify();
        right.simplify();
        return left.numerator == right.numerator && left.denominator == right.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        if (denominator == 1)
            return String.valueOf(numerator);
        if (Math.abs(numerator) > denominator) {
            return String.format("%d %d/%d", numerator / denominator, Math.abs(numerator) % denominator, denominator);
        }
        return numerator + "/" + denominator;
    }

    /**
     * Вспомогательный класс для вычисления суммы и разности,
     * т.к. для вычисления суммы и разности используется одинаковый принцип приведения к общему знаменателю
     * Позволяет получить общий знаменатель и привести числители к виду [числитель * множитель]
     */
    private class FractionHelper {
        private int leftNumerator;
        private int rightNumerator;
        private int commonDenominator;

        private FractionHelper(Fraction left, Fraction right) {
            calculate(left, right);
        }

        private void calculate(Fraction left, Fraction right) {
            int gcd = gcd(left.denominator, right.denominator); // нод для вычисления множителя
            int leftMultiplier = right.denominator / gcd; // множитель для левой дроби
            int rightMultiplier = left.denominator / gcd; // множитель для правой дроби

            // приводим к общему знаменателю
            commonDenominator = left.denominator * leftMultiplier;
            leftNumerator = left.numerator * leftMultiplier;
            rightNumerator = right.numerator * rightMultiplier;
        }
    }
}
