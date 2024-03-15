package baekjoon._1747;

import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[10000004];
		isPrime[1] = true;
		for (int i = 2; i < 10000004; i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i * 2; j < 10000004; j += i) {
				isPrime[j] = true;
			}
		}
		
		for (int i = n; i < 10000004; i++) {
			if (!isPrime[i] && isPalindrome(i)) {
				bw.write(String.valueOf(i));
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean isPalindrome(int num) {
		String string = String.valueOf(num);
		int length = string.length();
		for (int i = 0; i < length / 2; i++) {
			if (string.charAt(i) != string.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
