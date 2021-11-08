package ideas;

import java.util.*;

public class BFS {

	static int dRow[] = { -1, 0, 1, 0};
	static int dCol[] = { 0, 1, 0, -1};

	static boolean isValid(boolean vis[][], int row, int col) {
		if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length) {
			return false;
		}
		
		if (vis[row][col]) {
			return false;
		}
		
		return true;
	}
	
	static void BFS(int grid[][], boolean vis[][], int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[]{row, col});
		vis[row][col] = true;
		
		while (!q.isEmpty()) {
			int[] pair = q.peek();
			int x = pair[0];
			int y = pair[1];
			
			System.out.print(grid[x][y] + " ");
			q.remove();
			
			for (int i = 0; i < 4; i++) {
				int adjx = x + dRow[i];
				int adjy = y + dCol[i];
				
				if (isValid(vis, adjx, adjy)) {
					q.add(new int[] {adjx, adjy});
					vis[adjx][adjy] = true;
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		int grid[][] = {
				{ 1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16}, { 17, 18, 19, 20}
		};
		
		boolean [][]vis = new boolean[grid.length][grid[0].length];
		BFS(grid, vis, 0, 0);
	}
	
}


















