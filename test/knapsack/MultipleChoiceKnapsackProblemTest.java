package knapsack;

import knapsack.model.NoGroupsProblem;
import knapsack.model.OneOrNoneFromGroupProblem;
import knapsack.model.Problem;
import knapsack.model.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleChoiceKnapsackProblemTest {

    @Test
    void shouldReturnDesiredSolution1() {
        Knapsack knapsack = new Knapsack(new OneOrNoneFromGroupProblem());
        Solution solution = knapsack.solve();

        Solution expectedSolution = new Solution(
                new boolean[]{false, false, true, false, false, false, false, false, true, false, false,
                        false, true, true, false, false, false, false, false}
        );
        assertEquals(expectedSolution, solution);
        assertEquals(85, knapsack.getMaximumProfit());
    }

    @Test
    void shouldReturnDesiredSolution2() {
        Knapsack knapsack = new Knapsack(getProblem2());
        Solution solution = knapsack.solve();

        Solution expectedSolution = new Solution(
                new boolean[]{false, false, false, true, false, false, false, false, true, false, false, false,
                        true, false, false, false, true, false, false, false, false, true,
                        false, false, false, false}
        );
        assertEquals(expectedSolution, solution);
        assertEquals(42, knapsack.getMaximumProfit());

    }

    @Test
    void shouldReturnDesiredSolution3() {
        Knapsack knapsack = new Knapsack(getProblem3());
        Solution solution = knapsack.solve();

        Solution expectedSolution = new Solution(
                new boolean[]{false, true, true, false, false, false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false, false, false,
                        false, false, false}
        );
        assertEquals(expectedSolution, solution);
        assertEquals(200, knapsack.getMaximumProfit());

    }

    @Test
    void shouldReturnDesiredSolution4() {
        Knapsack knapsack = new Knapsack(getProblem4());
        Solution solution = knapsack.solve();

        Solution expectedSolution = new Solution(
                new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false, true, true,
                        false, false, false}
        );
        assertEquals(expectedSolution, solution);
        assertEquals(200, knapsack.getMaximumProfit());

    }


    private Problem getProblem2() {
        int W = 10;
        int[] profit = {0,
                0, 0, 3, 4, 5,
                0, 4, 6, 10, 10,
                5, 8, 12, 18, 17,
                10, 12, 18, 30, 24,
                15, 20, 27, 44, 30};
        int[] weight = {0, 0, 0, 1, 2, 5,
                0, 1, 2, 5, 10,
                1, 2, 4, 9, 17,
                2, 3, 6, 15, 24,
                3, 5, 9, 22, 30};
        int[] group = {-1, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1,
                2, 2, 2, 2, 2,
                3, 3, 3, 3, 3,
                4, 4, 4, 4, 4};
        return new OneOrNoneFromGroupProblem(W, profit, weight, group);

    }

    private Problem getProblem3() {
        int W = 2;
        int[] profit = {0,
                100, 100, 3, 4, 5,
                0, 4, 6, 10, 10,
                5, 8, 12, 18, 17,
                10, 12, 18, 30, 24,
                15, 20, 27, 44, 30};
        int[] weight = {0,
                1, 1, 1, 2, 5,
                0, 1, 2, 5, 10,
                1, 2, 4, 9, 17,
                2, 3, 6, 15, 24,
                3, 5, 9, 22, 30};
        int[] group = {-1,
                0, 0, 0, 0, 0,
                1, 1, 1, 1, 1,
                2, 2, 2, 2, 2,
                3, 3, 3, 3, 3,
                4, 4, 4, 4, 4};
        return new NoGroupsProblem(W, profit, weight, group);

    }

    private Problem getProblem4() {
        int W = 2;
        int[] profit = {0,
                1, 1, 3, 4, 5,
                0, 4, 6, 10, 10,
                5, 8, 12, 18, 17,
                10, 12, 18, 30, 24,
                100, 100, 27, 44, 30};
        int[] weight = {0,
                10, 10, 1, 2, 5,
                0, 1, 2, 5, 10,
                1, 2, 4, 9, 17,
                2, 3, 6, 15, 24,
                1, 1, 9, 22, 30};
        int[] group = {-1,
                0, 0, 0, 0, 0,
                1, 1, 1, 1, 1,
                2, 2, 2, 2, 2,
                3, 3, 3, 3, 3,
                4, 4, 4, 4, 4};
        return new NoGroupsProblem(W, profit, weight, group);

    }
}
