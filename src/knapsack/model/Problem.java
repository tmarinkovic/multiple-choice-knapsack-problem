package knapsack.model;

public abstract class Problem implements IProblem {

    private int bagSize;
    private int[] profit;
    private int[] weight;
    private int[] group;

    Problem() {
        this.bagSize = 15;
        this.profit = new int[]{0, 15, 11, 5, 8, 12, 18, 20, 14, 8, 9, 6, 10, 50, 7, 2, 3, 6, 5};
        this.weight = new int[]{0, 8, 4, 4, 3, 5, 14, 11, 5, 4, 6, 3, 5, 1, 5, 3, 2, 9, 7};
        this.group = new int[]{-1, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4};
    }

    Problem(int bagSize, int[] profit, int[] weight, int[] group) {
        this.bagSize = bagSize;
        this.profit = profit;
        this.weight = weight;
        this.group = group;
    }

    public int getBagSize() {
        return bagSize;
    }

    public int[] getProfit() {
        return profit;
    }

    public int[] getWeight() {
        return weight;
    }

    public int[] getGroup() {
        return group;
    }

}
