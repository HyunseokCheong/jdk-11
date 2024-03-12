package baekjoon._3187;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static boolean[][] visited;
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static final int FENCE = -1;
	static final int SHEEP = 1;
	static final int WOLF = 2;

	static int[][] graph;
	static int r, c;
	static Queue<Point> queue;

	static int sheepResult;
	static int wolfResult;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new int[r][c];
		for (int i = 0; i < r; i++) {
			char[] data = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				char cur = data[j];
				if (cur == '#') {
					graph[i][j] = FENCE;
				}
				if (cur == 'k') {
					graph[i][j] = SHEEP;
				}
				if (cur == 'v') {
					graph[i][j] = WOLF;
				}
			}
		}
	}

	static void process() throws IOException {
		sheepResult = 0;
		wolfResult = 0;
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && graph[i][j] != -1) {
					bfs(new Point(i, j));
				}
			}
		}

		bw.write(sheepResult + " " + wolfResult + "\n");
		bw.flush();
		bw.close();
	}

	static void bfs(Point point) {
		int sheepCount = 0;
		int wolfCount = 0;

		queue = new LinkedList<>();
		queue.offer(point);
		visited[point.row][point.col] = true;

		while (!queue.isEmpty()) {
			point = queue.poll();
			int curRow = point.row;
			int curCol = point.col;

			if (graph[curRow][curCol] == SHEEP) {
				sheepCount++;
			}
			if (graph[curRow][curCol] == WOLF) {
				wolfCount++;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = curRow + dr[i];
				int nextCol = curCol + dc[i];
				if (isOk(nextRow, nextCol)) {
					visited[nextRow][nextCol] = true;
					queue.offer(new Point(nextRow, nextCol));
				}
			}
		}

		sheepResult = sheepCount > wolfCount ? sheepResult + sheepCount : sheepResult;
		wolfResult = sheepCount <= wolfCount ? wolfResult + wolfCount : wolfResult;
	}

	static boolean isOk(int row, int col) {
		if (row < 0 || row >= r || col < 0 || col >= c) {
			return false;
		}
		if (visited[row][col]) {
			return false;
		}
		if (graph[row][col] == FENCE) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		input();
		process();
	}

	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
