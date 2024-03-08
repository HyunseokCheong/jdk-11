package baekjoon._17503;

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, m, k, result;
	static PriorityQueue<Integer> prefers;
	static List<Beer> beerList;

	static class Beer {
		int prefer, alcohol;

		public Beer(int prefer, int alcohol) {
			this.prefer = prefer;
			this.alcohol = alcohol;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		beerList = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int prefer = Integer.parseInt(st.nextToken());
			int alcohol = Integer.parseInt(st.nextToken());
			beerList.add(new Beer(prefer, alcohol));
		}
	}

	static void process() throws IOException {
		beerList.sort(new Comparator<Beer>() {
			@Override
			public int compare(Beer o1, Beer o2) {
				if (o1.alcohol == o2.alcohol) {
					return o2.prefer - o1.prefer;
				}
				return o1.alcohol - o2.alcohol;
			}
		});

		prefers = new PriorityQueue<>();
		int total = 0;
		result = -1;
		for (Beer beer : beerList) {
			prefers.add(beer.prefer);
			total += beer.prefer;
			if (prefers.size() > n) {
				total -= prefers.poll();
			}
			if (prefers.size() == n && total >= m) {
				result = beer.alcohol;
				break;
			}
		}
	}

	static void output() throws IOException {
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		process();
		output();
	}
}
