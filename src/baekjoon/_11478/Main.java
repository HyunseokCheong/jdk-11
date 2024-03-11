package baekjoon._11478;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String data;

	static void input() throws IOException {
		data = br.readLine();
	}

	static void process() throws IOException {
		Set<String> result = new HashSet<>();

		int n = data.length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; i + j < n; j++) {
				String cur = data.substring(i, i + j + 1);
				result.add(cur);
			}
		}

		bw.write(result.size() + "\n");
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
