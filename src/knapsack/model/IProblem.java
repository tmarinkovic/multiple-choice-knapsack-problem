package knapsack.model;

interface IProblem {

    boolean getSolution(int option1, int option2, int option3);

    boolean checkIfInSameGroup(int n, int lastTakenGroup, int[] group);

    int getMax(int group, int[] row, int[] groups, int n);

    boolean calculateIsMax(int n, int w, int[] groups, int[][] matrix, int N);

}
