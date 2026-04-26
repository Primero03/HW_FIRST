import java.util.Random;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = filling(SIZE);
        print(colors);
        System.out.println("_____________________________________");
        int[][] rotatedColors = rotated(SIZE, colors);
        print(rotatedColors);

        rotated(SIZE, colors);


    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int cell : row) {
                System.out.format("%4d", cell);
            }
            System.out.print(" ]");
            System.out.println();
        }
    }

    public static int[][] filling(int size) {
        Random rnd = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int z = rnd.nextInt(255);
                matrix[i][j] = z;
            }
        }
        return matrix;
    }

    public static int[][] rotated(int size, int[][] basic) {
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - 1 - i] = basic[i][j];
            }
        }
        return rotated;
    }
}
