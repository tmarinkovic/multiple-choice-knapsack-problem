package knapsack.model;

public class NoGroupsProblem extends Problem {
    public NoGroupsProblem() {
        super();
    }

    public NoGroupsProblem(int w, int[] profit, int[] weight, int[] group) {
        super(w, profit, weight, group);
    }

    @Override
    public boolean getSolution(int option1, int option2, int option3) {
        return (option2 > option1) || (option2 > option3);
    }

    @Override
    public boolean checkIfInSameGroup(int n, int lastTakenGroup, int[] group) {
        return false;
    }

    @Override
    public int getMax(int group, int[] row, int[] groups, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (row[i] > max) max = row[i];
        }
        return max;
    }

    @Override
    public boolean calculateIsMax(int n, int w, int[] groups, int[][] matrix, int N) {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (matrix[w][i] > max) max = matrix[w][i];
        }
        return matrix[w][n] == max;
    }
}
