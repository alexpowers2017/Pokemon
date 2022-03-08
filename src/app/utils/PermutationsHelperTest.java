package app.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


class FactorialTest {

    void assertFactorial(Integer expected, Integer input) {
        Assertions.assertEquals(expected, PermutationsHelper.factorial(input));
    }

    @Test
    void factorial_givenNull_returnsZero() {
        assertFactorial(0, null);
    }

    @Test
    void factorial_givenNegative_returnsZero() {
        assertFactorial(0, -1);
        assertFactorial(0, -4);
    }

    @Test
    void factorial_givenZero_returnsOne() {
        assertFactorial(1, 0);
    }

    @Test
    void factorial_normalCalculations() {
        assertFactorial(1, 1);
        assertFactorial(2, 2);
        assertFactorial(6, 3);
        assertFactorial(24, 4);
        assertFactorial(120, 5);
    }
}


class NPRTest {
    void assertnPr(Integer expected, Integer n, Integer r) {
        Assertions.assertEquals(expected, PermutationsHelper.nPr(n, r));
    }

    @Test
    void givenNull_returnsZero() {
        assertnPr(0, null, 1);
        assertnPr(0, 4, null);
    }

    @Test
    void givenRGreaterThanN_throwsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer result = PermutationsHelper.nPr(1, 2);
        });
    }

    @Test
    void givenNChooseZero_returnsOne() {
        assertnPr(1, 0, 0);
        assertnPr(1, 1, 0);
        assertnPr(1, 4, 0);
        assertnPr(1, 12, 0);
    }

    @Test
    void givenOneChooseOne_returnsOne() {
        assertnPr(1, 1, 1);
    }

    @Test
    void givenTwoChooseTwo_returnsTwo() {
        assertnPr(2, 2, 2);
    }

    @Test
    void givenThreeAsN() {
        assertnPr(6, 3, 3);
        assertnPr(6, 3, 2);
        assertnPr(3, 3, 1);
    }

    @Test
    void givenFourAsN() {
        assertnPr(24, 4, 4);
        assertnPr(24, 4, 3);
        assertnPr(12, 4, 2);
        assertnPr(4, 4, 1);
    }

    @Test
    void givenFiveAsN() {
        assertnPr(120, 5, 5);
        assertnPr(120, 5, 4);
        assertnPr(60, 5, 3);
        assertnPr(20, 5, 2);
        assertnPr(5, 5, 1);
    }
}


class SwapTest {

    @Test
    void givenNull_returnsEmptyArray

}