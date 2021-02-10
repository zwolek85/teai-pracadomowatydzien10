package pl.dzw.testyjednostkowe.calculator;

public class Calculator {

    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public double divide(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException();
        }
        return number1 / number2;
    }
}
