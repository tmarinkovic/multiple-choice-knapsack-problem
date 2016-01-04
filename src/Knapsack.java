class dinamic {
    public int getMax(int group, int[] row, int[] groups, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (groups[i] == group) {
                if (row[i] > max) max = row[i];
            }
        }
        return max;
    }

    public boolean IsMaxInGroup(int n, int w, int[] groups, int[][] matrix, int N) {
        int group = groups[n];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (groups[i] == group) {
                if (matrix[w][i] > max) max = matrix[w][i];
            }
        }
        if (matrix[w][n] != max) return false;
        return true;
    }
}

public class Knapsack {

    public static void main(String[] args) {


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
        dinamic din = new dinamic();
        int[][] matrix = new int[W + 1][N + 1];
        boolean[][] sol = new boolean[W + 1][N + 1];

        //just to make print pretty :D
        for (int i = 0; i <= W; i++) {
            matrix[i][0] = i;
        }

        for (int w = 1; w <= W; w++) {
            for (int n = 1; n <= N; n++) {
                if (group[n] == 0) {
                    if (weight[n] <= w) {
                        matrix[w][n] = profit[n];
                        sol[w][n] = true;
                    }
                } else {
                    if (group[n] != group[n - 1]) {
                        int option1 = din.getMax(group[n - 1], matrix[w], group, n);
                        int option2 = Integer.MIN_VALUE;
                        if (weight[n] <= w) {
                            option2 = profit[n] + din.getMax(group[n - 1], matrix[w - weight[n]], group, n);
                        }
                        matrix[w][n] = Math.max(option1, option2);
                        sol[w][n] = (option2 > option1);
                    }
                    if (group[n] == group[n - 1]) {
                        int option1 = din.getMax(group[n] - 1, matrix[w], group, n);
                        int option2 = Integer.MIN_VALUE;
                        if (weight[n] <= w) {
                            option2 = profit[n] + din.getMax(group[n] - 1, matrix[w - weight[n]], group, n);
                        }
                        matrix[w][n] = Math.max(option1, option2);
                        sol[w][n] = (option2 > option1);
                    }
                }
            }
        }


        //print table
        for (int w = 0; w <= W; w++) {
            for (int n = 0; n <= N; n++) {
                System.out.format("%5d", matrix[w][n]);
            }
            System.out.println();
        }


        // determine which items to take
        boolean[] take = new boolean[N + 1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[w][n] && din.IsMaxInGroup(n, w, group, matrix, N)) {
                take[n] = true;
                w = w - weight[n];
            } else {
                take[n] = false;
            }
        }

        // print results
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t\t" + profit[n] + "\t\t" + weight[n] + "\t\t" + take[n]);
        }


    }
}
