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
            return new Object[][]{};
        } else if (arr.length == 1) {
            return new Object[][]{arr};
        } else {

        }
        }
    }


    public static Object[][] getAllPermutations(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return new Object[][]{};
        } else if (arr.length == 1) {
            return new Object[][]{arr};
        } else {
            ArrayList<ArrayList<Object>> permutations = new ArrayList<>();

            // Add first values to 2d list
            for (int i = 0; i < factorial(arr.length); i++) {
                int firstValueIndex = Math.floorDiv(i, factorial(arr.length - 1));
                permutations.add(new ArrayList<>(Arrays.asList(arr[firstValueIndex])));
            }

            // Fill in remainder of list
            for (int i = 0; i < arr.length - 1; i++) {
                for (Object object : arr) {
                    for (ArrayList<Object> permutation : permutations) {
                        if (!permutation.contains(object)) { //&& !listContains(copyWithNewObject(permutation, object), permutations)) {
                            permutation.add(object);
                        }
                    }
                }
            }

            // Create final 2d array and populate with values of 2d list
            Object[][] permutationsArray = new Object[factorial(arr.length)][arr.length];
            for (int i = 0; i < permutations.size(); i++) {
                permutationsArray[i] = permutations.get(i).toArray(new Object[arr.length]);
            }

            for (Object[] permutation : permutationsArray) {
                for (Object value : permutation) {
                    System.out.print(value + ", ");
                }
                System.out.println();
            }
            return permutationsArray;
        }
    }

        static boolean listContains(ArrayList<Object> comparisonList, ArrayList<ArrayList<Object>> listOfLists){
            for(ArrayList<Object> existingList : listOfLists){
                if (existingList.equals(comparisonList)) {
                    return true;
                }
            }
            return false;
        }

        static ArrayList<Object> copyWithNewObject(ArrayList<Object> originalList, Object newObject) {
            ArrayList<Object> copy = new ArrayList<>(originalList);
            copy.add(newObject);
            return copy;
        }



}
