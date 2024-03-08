package baekjoon._17266;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, m, max;
	static int[] arr;

	static void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void process() throws IOException {
		max = Math.max(arr[0], n - arr[m - 1]);

		for (int i = 1; i < m; i++) {
			int cur = arr[i] - arr[i - 1];

			if (cur % 2 == 0) {
				cur /= 2;
			} else {
				cur /= 2;
				cur++;
			}

			max = Math.max(max, cur);
		}
		bw.write(max + "\n");
	}

	static void output() throws IOException {
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		process();
		output();
	}
}
