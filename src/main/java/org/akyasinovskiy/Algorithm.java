package org.akyasinovskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Four Russians Algorithm implementation
 */
public class Algorithm {
    /**
     * list of separated parts for first matrix
     */
    private final List<int[][]> separatedFirst = new ArrayList<>();

    /**
     * list of separated parts for second matrix
     */
    private final List<int[][]> separatedSecond = new ArrayList<>();

    /**
     * multiplication with Four Russian method
     *
     * @param arr1 first matrix
     * @param arr2 second matrix
     * @return result of multiplication
     */
    public int[][] multiplication(int[][] arr1, int[][] arr2) {
        int dim = arr1.length;
        double m = Math.floor((int) (Math.log(dim) / Math.log(2)));

        //preprocessing for creating separated parts of arrays for optimized complexity
        preprocess(arr1, arr2, m);

        //calculating multiplication of two matrices
        int[][] result = new int[dim][dim];
        int i = 0;
        while (i < (int) Math.ceil(dim / m)) {
            int[][] summedRows = new int[(int) Math.pow(2, (int) m)][dim];
            int k = 0;
            int q = 1;
            {
                int j = 1;
                while (j < (int) Math.pow(2, (int) m)) {
                    summedRows[j] = sumRows(summedRows[j - (int) Math.pow(2, k)], lastRow(separatedSecond.get(i), k));
                    if (q != 1) {
                        --q;
                    } else {
                        q = j + 1;
                        ++k;
                    }
                    j++;
                }
            }
            int[][] temp = new int[dim][dim];
            int j = 0;
            while (j < dim) {
                temp[j] = summedRows[getDecimalNumber(separatedFirst.get(i)[j])];
                j++;
            }
            result = sumMatrices(result, temp);
            i++;
        }
        System.out.println("Completed multiplication");
        return result;
    }

    /**
     * @param arr1 first matrix
     * @param arr2 second matrix
     * @param m    size of parts
     */
    private void preprocess(int[][] arr1, int[][] arr2, double m) {
        int n = arr1.length;
        int numberOfParts = (int) Math.ceil(n / m);

        System.out.println("Dividing matrices by " + numberOfParts + " parts");

        for (int i = 0; i < numberOfParts; i++) {
            addPartsFirst(arr1, m, i * (int) m);
            addPartsSecond(arr2, m, i * (int) m);
        }
    }

    /**
     * Adds separated parts of first matrix
     *
     * @param arr        initial matrix
     * @param m          columns number
     * @param startIndex current column
     */
    private void addPartsFirst(int[][] arr, double m, int startIndex) {
        int[][] temp = new int[arr.length][(int) m];
        for (int column = 0; column < m; column++) {
            int[] tempCol = getColRow(arr, startIndex + column, false);
            for (int row = 0; row < arr.length; row++) {
                temp[row][column] = tempCol[row];
            }

        }
        separatedFirst.add(temp);
        System.out.println("Slice of first matrix:\n" +
                Arrays
                        .stream(temp)
                        .map(Arrays::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    /**
     * Adds separated parts of second matrix
     *
     * @param arr        initial matrix
     * @param m          columns number
     * @param startIndex current column
     */
    private void addPartsSecond(int[][] arr, double m, int startIndex) {
        int[][] temp = new int[(int) m][arr.length];
        for (int row = 0; row < m; row++)
            temp[row] = getColRow(arr, startIndex + row, true);
        separatedSecond.add(temp);
        System.out.println("Slice of second matrix:\n" +
                Arrays
                        .stream(temp)
                        .map(Arrays::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    /**
     * sum of 2 matrices
     *
     * @param arr1 first matrix
     * @param arr2 second matrix
     * @return result of summing two matrices
     */
    private int[][] sumMatrices(int[][] arr1, int[][] arr2) {
        int[][] resArr = new int[arr1.length][arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i][j] == 0 && arr2[i][j] == 0)
                    resArr[i][j] = 0;
                else resArr[i][j] = 1;
            }
        }
        return resArr;
    }

    /**
     * @param arr      matrix
     * @param index    index
     * @param inversed сheck
     * @return column or row
     */
    public static int[] getColRow(int[][] arr, int index, boolean inversed) {
        int[] ints = new int[arr.length];
        if (index < arr.length) {
            IntStream.range(0, arr.length).forEach(i -> {
                if (inversed)
                    ints[i] = arr[index][i];
                else
                    ints[i] = arr[i][index];
            });
        }
        return ints;
    }

    /**
     * summing rows
     *
     * @param first  first row slice
     * @param second second row slice
     * @return rows sum
     */
    public static int[] sumRows(int[] first, int[] second) {
        int[] result = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            if (first[i] + second[i] > 0)
                result[i] = 1;
            else
                result[i] = 0;
        }
        return result;
    }

    /**
     * @param arr    matrix
     * @param amount amount of rows
     * @return several last rows of matrix
     */
    public static int[] lastRow(int[][] arr, int amount) {
        return arr[arr.length - amount - 1];
    }

    /**
     * @param row
     * @return
     */
    public static int getDecimalNumber(int[] row) {
        int res = 0;
        for (int i = row.length - 1; i >= 0; i--)
            if (row[i] != 0) {
                res += Math.pow(2, row.length - i - 1);
            }
        return res;
    }


}
