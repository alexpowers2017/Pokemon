package app.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.Map;

public class PermutationsHelper {

    public static Integer factorial(Integer n) {
        // ex. 5! = 5 * 4 * 3 * 2 * 1
        if (n == null || n < 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * (i + 1);
        }
        return result;
    }

    public static Integer nPr(Integer n, Integer r) {
        if (n == null || r == null) {
            return 0;
        } else if (r > n) {
            throw new IllegalArgumentException("Number selected (r) cannot be greater than number of objects (n).");
        }
        return factorial(n) / factorial(n - r);
    }
}


