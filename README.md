Multiple-choice knapsack problem
=============
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
## Content
Java implementation of  Multiple-choice knapsack problem ( MKP ) with 2 sub-problems:
 - No groups constrains
 - One or None from each group
 
## Usage
Every problem extends Problem abstract class that implements IProblem interface

Examples:
```
Knapsack knapsack = new Knapsack(new OneOrNoneFromGroupProblem());
knapsack.solve();

```
```
Knapsack knapsack = new Knapsack(new NoGroupsProblem());
knapsack.solve();
```
Abstract class Problem contains default problem initialisation:
```
Problem() {
    this.bagSize = 15;
    this.profit = new int[]{0, 15, 11, 5, 8, 12, 18, 20, 14, 8, 9, 6, 10, 50, 7, 2, 3, 6, 5};
    this.weight = new int[]{0, 8, 4, 4, 3, 5, 14, 11, 5, 4, 6, 3, 5, 1, 5, 3, 2, 9, 7};
    this.group = new int[]{-1, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4};
}
```
First element in each off arrays is just a placeholder, problem starts with index 1!

Also, you can initialise different problem with using Problem constructor:
```
Problem(int bagSize, int[] profit, int[] weight, int[] group) {
...
}
```
## Context
The knapsack problem is one of the most studied problems in combinatorial optimization, with many real-life applications. For this reason, many special cases and generalizations have been examined.

Common to all versions are a set of n items, with each item 1 <= j <= n having an associated profit pj ,weight wj. The binary decision variable xj is used to select the item. The objective is to pick some of the items,
with maximal total profit, while obeying that the maximum total weight of the chosen items must not exceed W.

Generally, these coefficients are scaled to become integers, and they are almost always assumed to be positive.