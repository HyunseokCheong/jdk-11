package baekjoon._28279;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, cmd, num;
	static String[] data;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			data = br.readLine().split(" ");
			cmd = Integer.parseInt(data[0]);
			switch (cmd) {
				case 1:
					num = Integer.parseInt(data[1]);
					deque.addFirst(num);
					break;
				case 2:
					num = Integer.parseInt(data[1]);
					deque.addLast(num);
					break;
				case 3:
					if (deque.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(deque.pollFirst() + "\n");
					}
					break;
				case 4:
					if (deque.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(deque.pollLast() + "\n");
					}
					break;
				case 5:
					bw.write(deque.size() + "\n");
					break;
				case 6:
					bw.write(deque.isEmpty() ? "1\n" : "0\n");
					break;
				case 7:
					if (deque.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(deque.peekFirst() + "\n");
					}
					break;
				case 8:
					if (deque.isEmpty()) {
						bw.write("-1\n");
					} else {
						bw.write(deque.peekLast() + "\n");
					}
					break;
			}
		}
		
		bw.flush();
		bw.close();
	}
}
