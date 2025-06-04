package matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Utilidad para leer matrices de adyacencia o incidencia desde archivos .txt
 * Formatos soportados:
 *  Adyacencia:
 *      n
 *      n×n números (0/1)
 *      línea opcional con etiquetas de nodos
 *  Incidencia:
 *      n m
 *      n×m números (-1, 0, 1)
 *      línea opcional con etiquetas de nodos
 */
public final class MatrixReader {

    private MatrixReader() {}

    public static int[][] readAdjacency(String path) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(path))) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();
            return matrix;   // etiquetas de nodos pueden ignorarse
        }
    }

    public static int[][] readIncidence(String path) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(path))) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();
            return matrix;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
}
