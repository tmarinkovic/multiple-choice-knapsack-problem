package knapsack.model;

import java.util.Arrays;

public class Solution {

    private boolean[] solution;

    public Solution(boolean[] solution) {
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution1 = (Solution) o;
        return Arrays.equals(solution, solution1.solution);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(solution);
    }

    @Override
    public String toString() {
        return "Solution{solution=" + Arrays.toString(solution) + '}';
    }
}
