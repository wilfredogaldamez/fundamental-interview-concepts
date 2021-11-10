package ideas;


import java.util.ArrayList;
import java.util.List;

public class KnapSack2 {

  /**
   * @param capacity - The maximum capacity of the knapsack
   * @param W - The weights of the items
   * @param V - The values of the items
   * @return The maximum achievable profit of selecting a subset of the elements such that the
   *     capacity of the knapsack is not exceeded
   */
  public static int knapsack(int capacity, int[] weights, int[] values) {
	  if (weights == null || values == null || weights.length!= values.length || capacity < 0) {
		  throw new IllegalArgumentException("Invalid input");
	  }
	  
	  //total number of possible items
	  final int numOfItems = weights.length;
	  
	  //initialize the dp table for memoization
	  int[][] dp = new int[numOfItems + 1][capacity + 1];
	  
	  //fill dp table where dp[i][j] represents the best solution to the subproblem with i items and j weight-capacity
	  for (int i=1; i<= numOfItems; i++) {
		  int weight = weights[i - 1];
		  int value = values[i - 1];
		  for (int j=1; j <= capacity; j++) {
			  if (i == 0 || j==0) {
				  dp[i][j] = 0;
			  } else if (weight <= j) {
				  dp[i][j] = Math.max(value + dp[i - 1][j - weight], dp[i - 1][j]);
			  } else {
				  dp[i][j] = dp[i - 1][j];
			  }
		  }
	  }
	  
	  return dp[numOfItems][capacity];
  }

  public static void main(String[] args) {

    int capacity = 10;
    int[] V = {1, 4, 8, 5};
    int[] W = {3, 3, 5, 6};
    System.out.println(knapsack(capacity, W, V));

  }
}