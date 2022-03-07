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


class GetAllPermutationsTest {

    void assertPermutated(Object[][] expected, Object[] input) {
        Assertions.assertArrayEquals(expected, PermutationsHelper.getAllPermutations(input));
    }

    @Test
    void givenNull_returnsEmptyArray() {
        assertPermutated(new Integer[][]{}, null);
        assertPermutated(new String[][]{}, null);
        assertPermutated(new Boolean[][]{}, null);
    }

    @Test
    void givenEmptyArray_returnsEmpty2dArray() {
        assertPermutated(new Integer[][]{}, new Integer[]{});
        assertPermutated(new String[][]{}, new String[]{});
        assertPermutated(new Boolean[][]{}, new Boolean[]{});
    }

    @Test
    void givenLengthOne_returnsWrapped2dArray() {
        assertPermutated(new Integer[][]{{1}}, new Integer[]{1});
//        assertPermutated(new String[][]{{"a"}}, new String[]{"a"});
    }

    @Test
    void givenLengthTwo() {
        assertPermutated(new Integer[][]{{1, 2}, {2, 1}}, new Integer[]{1, 2});
//        assertPermutated(new String[][]{{"a", "b"}, {"b", "a"}}, new String[]{"a", "b"});
    }

    @Test
    void givenLengthThree() {
        assertPermutated(new Integer[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}}, new Integer[]{1, 2, 3});
//        assertPermutated(new String[][]{{"a", "b", "c"}, {"a", "c", "b"}, {"b", "a", "c"}, {"b", "c", "a"}, {"c", "a", "b"}, {"c", "b", "a"}}, new String[]{"a", "b", "c"});
    }

    @Test
    void givenLengthFour() {
        Integer[][] expectedIntArray = new Integer[][]{
                {1, 2, 3, 4},
                {1, 2, 4, 3},
                {1, 3, 2, 4},
                {1, 3, 4, 2},
                {1, 4, 2, 3},
                {1, 4, 3, 2},

                {2, 1, 3, 4},
                {2, 1, 4, 3},
                {2, 3, 1, 4},
                {2, 3, 4, 1},
                {2, 4, 1, 3},
                {2, 4, 3, 1},

                {3, 1, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 1, 4},
                {3, 2, 4, 1},
                {3, 4, 1, 2},
                {3, 4, 2, 1},

                {4, 1, 2, 3},
                {4, 1, 3, 2},
                {4, 2, 1, 3},
                {4, 2, 3, 1},
                {4, 3, 1, 2},
                {4, 3, 2, 1},
        };
        assertPermutated(expectedIntArray, new Integer[]{1, 2, 3, 4});
    }
}