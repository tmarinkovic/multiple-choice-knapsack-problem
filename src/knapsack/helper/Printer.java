package knapsack.helper;

public class Printer {

    public static void printBagTable(int W, int N, int[][] matrix) {
        for (int w = 0; w <= W; w++) {
            for (int n = 0; n <= N; n++) {
                System.out.format("%5d", matrix[w][n]);
            }
            System.out.println();
        }
    }

    public static void printChosenItems(int N, int[] profit, int[] weight, int[] group, boolean[] take) {
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "group" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t\t" + profit[n] + "\t\t" + weight[n] + "\t\t" + group[n] + "\t\t" + take[n]);
        }
    }

    public static void printSolutionTable(int W, int N, boolean[][] solution) {
        for (int w = 1; w <= W; w++) {
            for (int n = 1; n <= N; n++) {
                System.out.format("%7s", solution[w][n]);
            }
            System.out.println();
        }
    }

    public static void printResult(int N, int[] profit, int[] weight, int[] group, boolean[] take) {
        StringBuilder result = new StringBuilder("Items picked: ");
        int totalProfit = 0;
        int totalWeight = 0;
        for (int n = 1; n <= N; n++) {
            if (take[n]) {
                result.append(n).append(" ");
                totalProfit += profit[n];
                totalWeight += weight[n];
            }
        }
        result.append(String.format("with total profit of %s and weight %s", totalProfit, totalWeight));
        System.out.println(result);
    }
}
