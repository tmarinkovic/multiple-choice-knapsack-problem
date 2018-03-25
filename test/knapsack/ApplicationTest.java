package knapsack;

import knapsack.model.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    @Test
    void shouldReturnDesiredSolution() {
        Knapsack knapsack = new Knapsack();
        Solution solution = knapsack.solve();

        Solution expectedSolution = new Solution(
                new boolean[]{false, false, true, false, false, false, false, false, true, false, false,
                        false, true, true, false, false, false, false, false}
        );
        assertEquals(expectedSolution, solution);
    }
}
