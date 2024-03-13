package baekjoon._18513;

import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			visited.add(x);
			queue.add(new int[] {x, 0});
		}
		
		long result = 0;
		while (k != 0 && !queue.isEmpty()) {
			int[] cur = queue.poll();
			int idx = cur[0];
			int dist = cur[1];
			if (!visited.contains(idx - 1)) {
				k--;
				visited.add(idx - 1);
				result += dist + 1;
				queue.add(new int[] {idx - 1, dist + 1});
			}
			if (k == 0) {
				break;
			}
			if (!visited.contains(idx + 1)) {
				k--;
				visited.add(idx + 1);
				result += dist + 1;
				queue.add(new int[] {idx + 1, dist + 1});
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
