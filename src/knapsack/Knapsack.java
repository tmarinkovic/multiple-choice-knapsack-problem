package knapsack;

import knapsack.helper.Calculation;
import knapsack.helper.Printer;
import knapsack.model.Problem;
import knapsack.model.Solution;

public class Knapsack {

    private Problem problem;
    private int maximumProfit;

    Knapsack(Problem problem) {
        this.problem = problem;
        this.maximumProfit = 0;
    }

    public Solution solve() {
        int bagSize = problem.getBagSize();
        int[] profit = problem.getProfit();
        int[] weight = problem.getWeight();
        int[] group = problem.getGroup();

        int N = profit.length - 1;
        int[][] matrix = new int[bagSize + 1][N + 1];
        boolean[][] solution = new boolean[bagSize + 1][N + 1];

        //just to make print pretty :D
        for (int i = 0; i <= bagSize; i++) {
            matrix[i][0] = i;
        }

        for (int w = 1; w <= bagSize; w++) {
            for (int n = 1; n <= N; n++) {
                if (group[n] == 0) {
                    if (weight[n] <= w) {
                        matrix[w][n] = profit[n];
                        solution[w][n] = true;
                    }
                } else {
                    int option1 = Calculation.getMax(group[n] - 1, matrix[w], group, n);
                    int option2 = Integer.MIN_VALUE;
                    int option3 = Calculation.getMax(group[n], matrix[w], group, n);
                    if (weight[n] <= w) {
                        option2 = profit[n] + Calculation.getMax(group[n] - 1, matrix[w - weight[n]], group, n);
                    }
                    matrix[w][n] = Math.max(option1, option2);
                    updateMaximumProfit(matrix[w][n]);
                    solution[w][n] = (option2 > option1) && (option2 > option3);
                }
            }
        }

        Printer.printBagTable(bagSize, N, matrix);
        Printer.printSolutionTable(bagSize, N, solution);
        boolean[] take = getSolution(N, bagSize, solution, group, matrix, weight);
        Printer.printResult(N, profit, weight, group, take);
        return new Solution(take);
    }

    private void updateMaximumProfit(int profit) {
        if ( profit > maximumProfit){
            maximumProfit = profit;
        }
    }

    private boolean[] getSolution(int N, int W, boolean[][] sol, int[] group, int[][] matrix, int[] weight) {
        boolean[] solution = new boolean[N + 1];
        int lastTakenGroup = -1;
        for (int n = N, w = W; n > 0; n--) {
            if (sol[w][n] && Calculation.IsMaxInGroup(n, w, group, matrix, N)) {
                if(group[n] == lastTakenGroup){
                    continue;
                }
                solution[n] = true;
                w = w - weight[n];
                lastTakenGroup = group[n];
            } else {
                solution[n] = false;
            }
        }
        return solution;
    }

    public int getMaximumProfit() {
        return maximumProfit;
    }
}
