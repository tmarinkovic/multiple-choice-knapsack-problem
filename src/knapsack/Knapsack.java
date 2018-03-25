package knapsack;

import knapsack.helper.Calculation;
import knapsack.helper.Printer;
import knapsack.model.Solution;

public class Knapsack {

    public Solution solve() {
        //problem
        //size of bag
        int W = 15;
        //profits
        int[] profit = {0, 15, 11, 5, 8, 12, 18, 20, 14, 8, 9, 6, 10, 50, 7, 2, 3, 6, 5};
        //weights
        int[] weight = {0, 8, 4, 4, 3, 5, 14, 11, 5, 4, 6, 3, 5, 1, 5, 3, 2, 9, 7};
        //groups of each item ( array start at 1 so first element is non existing group -1 )
        int[] group = {-1, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4};


        //number of elements
        int N = profit.length - 1;
        int[][] matrix = new int[W + 1][N + 1];
        boolean[][] solution = new boolean[W + 1][N + 1];

        //just to make print pretty :D
        for (int i = 0; i <= W; i++) {
            matrix[i][0] = i;
        }

        for (int w = 1; w <= W; w++) {
            for (int n = 1; n <= N; n++) {
                if (group[n] == 0) {
                    if (weight[n] <= w) {
                        matrix[w][n] = profit[n];
                        solution[w][n] = true;
                    }
                } else {
                    if (group[n] != group[n - 1]) {
                        int option1 = Calculation.getMax(group[n - 1], matrix[w], group, n);
                        int option2 = Integer.MIN_VALUE;
                        if (weight[n] <= w) {
                            option2 = profit[n] + Calculation.getMax(group[n - 1], matrix[w - weight[n]], group, n);
                        }
                        matrix[w][n] = Math.max(option1, option2);
                        solution[w][n] = (option2 > option1);
                    }
                    if (group[n] == group[n - 1]) {
                        int option1 = Calculation.getMax(group[n] - 1, matrix[w], group, n);
                        int option2 = Integer.MIN_VALUE;
                        if (weight[n] <= w) {
                            option2 = profit[n] + Calculation.getMax(group[n] - 1, matrix[w - weight[n]], group, n);
                        }
                        matrix[w][n] = Math.max(option1, option2);
                        solution[w][n] = (option2 > option1);
                    }
                }
            }
        }


        Printer.printBagTable(W, N, matrix);
        boolean[] take = getSolution(N,W,solution,group,matrix,weight);
        Printer.printResult(N, profit, weight, take);

        return new Solution(take);

    }

    private boolean[] getSolution(int N, int W, boolean[][] sol, int[] group, int[][] matrix, int[] weight){
        boolean[] solution = new boolean[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[w][n] && Calculation.IsMaxInGroup(n, w, group, matrix, N)) {
                solution[n] = true;
                w = w - weight[n];
            } else {
                solution[n] = false;
            }
        }
        return solution;
    }
}
