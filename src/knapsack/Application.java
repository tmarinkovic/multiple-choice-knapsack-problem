package knapsack;

import knapsack.model.Problem;

public class Application {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(new Problem());
        knapsack.solve();
    }
}
