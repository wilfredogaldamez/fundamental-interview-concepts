package ideas;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

	static boolean isValid(int x, int y, int width, int height) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
	static int rowNum[] = {-1, 0, 0, 1};
	static int colNum[] = {0, -1, 1, 0};
	
	static int BFS(int mat[][]) {
		
		int height = mat.length;
		int width = mat[0].length;
		
		boolean visited[][] = new boolean[width][height];
		visited[0][0] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		
		int count = 0;
		int[] temp = new int[2]; 
		while(!q.isEmpty()) {
			count++;
			temp = q.peek();
			System.out.println(temp[0] + " " + temp[1]);
			if (mat[temp[0]][temp[1]] == 9) {
				return count;
			}
			
			q.remove();
			
			for (int i = 0; i < 4; i++) {
				int row = temp[0] + rowNum[i];
				int col = temp[1] + colNum[i];
				
				if (isValid(row, col, width, height) && mat[row][col] == 1 && !visited[row][col]) {
					visited[row][col] = true;
					System.out.println(row + " " + col);
					q.add(new int[] {row, col});
				}
				
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
		                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
		                { 0, 0, 0, 0, 9, 0, 0, 0, 0, 1 },
		                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
		                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
		                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
		
		int shortestPath = BFS(mat);
		System.out.println(shortestPath);
		
	}

}

















