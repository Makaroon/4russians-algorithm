package org.akyasinovskiy;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * First matrix as a 2-dim array
     */
    public static int[][] arr1;

    /**
     * Second matrix as a 2-dim array
     */
    public static int[][] arr2;

    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        System.out.println("Input matrix dimension: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int dim = scanner.nextInt();
            System.out.println("Input first matrix: ");
            arr1 = inputMatrix(dim, scanner);
            System.out.println("Input second matrix: ");
            arr2 = inputMatrix(dim, scanner);
        } catch (InputMismatchException e) {
            if (e.getMessage()==null)
                System.out.println("Error. Matrix dimension is an integer number.");
            else System.out.println(e.getMessage());
            System.exit(1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("First matrix: " + Arrays.deepToString(arr1));
        System.out.println("Second matrix: " + Arrays.deepToString(arr2));

        Algorithm fourRussiansAlg = new Algorithm();

        int[][] resArr = fourRussiansAlg.multiplication(arr1, arr2);

        System.out.println("Result matrix: " + Arrays.deepToString(resArr));
    }

    /**
     * @param dim matrix dimension
     * @param scanner scanner to read numbers in matrix from command line
     * @return filled matrix
     */
    private static int[][] inputMatrix(int dim, Scanner scanner) {
        int[][] arr = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                arr[i][j] = scanner.nextInt();
                if (!(arr[i][j] == 0 || arr[i][j] == 1))
                    throw new InputMismatchException("Error. Matrix should consist of 0 or 1");
            }
        }
        return arr;
    }
}

