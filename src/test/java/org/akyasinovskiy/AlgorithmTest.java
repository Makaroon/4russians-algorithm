package org.akyasinovskiy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    Algorithm testAlg = new Algorithm();

    @Test
    void twoDimTest() {
        int[][] first = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        };
        int[][] second = new int[][]{
                new int[]{0, 0},
                new int[]{1, 1}
        };

        int[][] res = testAlg.multiplication(first, second);

        int[][] actualRes = new int[][]{
                new int[]{0, 0},
                new int[]{1, 1}
        };

        boolean check = true;
        for (int i = 0; i < first.length; ++i) {
            for (int j = 0; j < first.length; ++j) {
                if (res[i][j] != actualRes[i][j]) {
                    check = false;
                    break;
                }
            }
        }

        System.out.println(Arrays.deepToString(res));
        assertTrue(check);
    }

    @Test
    void threeDimTest() {
        int[][] first = new int[][]{
                new int[]{1, 0, 1},
                new int[]{1, 0, 0},
                new int[]{0, 1, 0}
        };
        int[][] second = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 1},
                new int[]{0, 1, 1}
        };

        int[][] res = testAlg.multiplication(first, second);

        int[][] actualRes = new int[][]{
                new int[]{0, 1, 1},
                new int[]{0, 0, 0},
                new int[]{0, 1, 1}
        };

        boolean check = true;
        for (int i = 0; i < first.length; ++i) {
            for (int j = 0; j < first.length; ++j) {
                if (res[i][j] != actualRes[i][j]) {
                    check = false;
                    break;
                }
            }
        }

        System.out.println(Arrays.deepToString(res));
        assertTrue(check);
    }

    @Test
    void fourDimTest() {
        int[][] first = new int[][]{
                new int[]{1, 0, 1, 0},
                new int[]{1, 0, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{0, 1, 0, 0}
        };
        int[][] second = new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 0, 0, 1},
                new int[]{0, 0, 1, 0}
        };

        int[][] res = testAlg.multiplication(first, second);

        int[][] actualRes = new int[][]{
                new int[]{1, 1, 0, 1},
                new int[]{1, 1, 0, 1},
                new int[]{0, 1, 0, 0},
                new int[]{0, 1, 0, 0}
        };

        boolean check = true;
        for (int i = 0; i < first.length; ++i) {
            for (int j = 0; j < first.length; ++j) {
                if (res[i][j] != actualRes[i][j]) {
                    check = false;
                    break;
                }
            }
        }

        System.out.println(Arrays.deepToString(res));
        assertTrue(check);
    }
}