package knapsack.helper;

public class Printer {

    public static void printBagTable(int W, int N, int[][] matrix){
        for (int w = 0; w <= W; w++) {
            for (int n = 0; n <= N; n++) {
                System.out.format("%5d", matrix[w][n]);
            }
            System.out.println();
        }
    }

    public static void printResult(int N, int[] profit, int[] weight, boolean[] take){
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t\t" + profit[n] + "\t\t" + weight[n] + "\t\t" + take[n]);
        }
    }

}
