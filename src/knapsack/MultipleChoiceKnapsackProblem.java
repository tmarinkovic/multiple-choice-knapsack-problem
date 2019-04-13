package knapsack;

import knapsack.model.OneOrNoneFromGroupProblem;

public class MultipleChoiceKnapsackProblem {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(new OneOrNoneFromGroupProblem());
        knapsack.solve();
    }
}
