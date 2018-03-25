package knapsack;

public class Calculation {
    public static int getMax(int group, int[] row, int[] groups, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (groups[i] == group) {
                if (row[i] > max) max = row[i];
            }
        }
        return max;
    }

    public static boolean IsMaxInGroup(int n, int w, int[] groups, int[][] matrix, int N) {
        int group = groups[n];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (groups[i] == group) {
                if (matrix[w][i] > max) max = matrix[w][i];
            }
        }
        return matrix[w][n] == max;
    }

}
