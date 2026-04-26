import java.util.Random;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = filling(SIZE);
        System.out.println("_____________________________________");
        printRotated(SIZE, colors);

    }

    

    public static int[][] filling(int size) {
        Random rnd = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.out.print("[");
            for (int j = 0; j < size; j++) {
                int z = rnd.nextInt(255);
                matrix[i][j] = z;
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.print(" ]");
            System.out.println();
        }
        return matrix;
    }

    public static void printRotated(int size, int[][] basic) {
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - 1 - i] = basic[i][j];
            }
        }
        for (int[] row : rotated) {
            System.out.print("[");
            for (int cell : row) {
                System.out.format("%4d", cell);
            }
            System.out.print(" ]");
            System.out.println();

        }
    }
}
