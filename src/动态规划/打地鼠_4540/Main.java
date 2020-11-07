package 动态规划.打地鼠_4540;

import java.util.Scanner;

public class Main {
	
	/**
	 * 自顶向下动态规划，超时
	 * f(n, p) = min(f(n + 1, q) + |PO[n][p] - PO[n + 1][q]|); q:1->k, n:1->N, p:1->k
	 * @param n 当前次数
	 * @param N 总次数
	 * @param K 每次出现老鼠个数
	 * @param p 上次我们所在位置
	 * @param PO PO[i][j] i次时，第j个老鼠 出现位置
	 * @param memory 动态规划表
	 * @return
	 */
	public static int func(int n, int N, int K, int p, int PO[][], int memory[][]) {
		if(n > N) {
			return 0;
		}
		if(memory[n][p] > 0)
			return memory[n][p];
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < K; i++) {
			int temp = Math.abs(p - PO[N][i]);
			int nextP = PO[N][i];
			if(memory[n][nextP] > temp) continue; // 剪枝
			temp += func(n + 1, N, K, nextP, PO, memory);
			if(temp < result) {
				result = temp;
				memory[n][p] = result; // 记录结果。。在这里记录结果可以剪枝
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int PO[][] = new int[N + 1][K];
			for(int t = 0; t < N; t++)
				for(int k = 0; k < K; k++) 
					PO[t][k] = sc.nextInt();
			
			int min = Integer.MAX_VALUE;
			int memory[][] = new int[N + 1][501];
			for(int i = 0; i < K; i++) {// 以每个第一个老鼠出现的位置为起点
				int t = func(1, N, K, PO[0][i], PO, memory);
				if(t < min) min = t;
			}
			System.out.println(min);
		}
		sc.close();
	}
}
