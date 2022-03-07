package app.utils;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

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

    public static Integer[][] getAllIntegerPermutations(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return new Integer[][]{};
        } else if (arr.length == 1) {
            return new Integer[][]{arr};
        } else {
            return new Integer[][]{arr};
        }
    }

        public static Integer[][] swapAllInSubArray(Integer[] arr) {
            Integer[][] allSwapped = new Integer[factorial(arr.length)][arr.length];
            allSwapped[0] = arr.clone();
            for (int i = 1; i < factorial(arr.length); i++) {
                if (i % 2 == 0) {
                    allSwapped[i] = swap(arr, i);
                } else {
                    allSwapped[i] = swap(arr, 0);
                }
            }
            return allSwapped;
        }

        public static Integer[] swap(Integer[] arr, Integer swapIndex) {
            Integer[] swapped = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (i == swapIndex) {
                    swapped[i] = arr[arr.length - 1];
                } else if (i == arr.length - 1) {
                    swapped[i] = arr[swapIndex];
                } else {
                    swapped[i] = arr[i];
                }
            }
            return swapped;
        }


}
