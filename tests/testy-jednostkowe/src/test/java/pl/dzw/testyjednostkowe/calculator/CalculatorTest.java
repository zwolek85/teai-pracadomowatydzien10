package pl.dzw.testyjednostkowe.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void should_add_two_numbers() {
        //given
        Calculator calculator = new Calculator();
        //when
        int add = calculator.add(1, 2);
        //then
        Assertions.assertEquals(3, add);
    }

    @Test
    void should_not_add_two_numbers() {
        //given
        Calculator calculator = new Calculator();
        //when
        int add = calculator.add(1, 2);
        //then
        Assertions.assertNotEquals(4, add);
    }

    @Test
    void should_divide_two_numbers() {
        //given
        Calculator calculator = new Calculator();
        //when
        double divide = calculator.divide(2, 2);
        //then
        Assertions.assertEquals(1, divide);
    }

    @Test
    void should_no_divide_by_zero() {
        //given
        Calculator calculator = new Calculator();
        //when
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(2, 0)) ;

    }

}
