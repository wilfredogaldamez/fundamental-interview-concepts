package ideas;

import java.util.Scanner;

public class KnapSackProblem {
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	static int knapSack(int capacity, int weights[], int values[], int n) {
		int i, w;
		int[][]K = new int[n+1][capacity + 1];
		
		for (i = 1; i <= n; i++) {
			int weight = weights[i-1];
			int value = values[i - 1];
			for (w = 0; w <= capacity; w++) {
				if (i==0 || w==0) {
					K[i][w] = 0;
				} else if (weights[i-1] <= w) {
					K[i][w] = max(value + K[i-1][w-weight], K[i-1][w]);
				} else {
					K[i][w] = K[i-1][w];
				}
			}
		}
		
		return K[n][capacity];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of items: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the items weights: ");
		int []wt = new int[n];
		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}
		
		System.out.println("Enter the items values: ");
		int []val = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}
		
		System.out.println("Enter the maximum capacity: ");
		int W = sc.nextInt();
		
		System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + knapSack(W, wt, val, n));
		sc.close();
	}

}
