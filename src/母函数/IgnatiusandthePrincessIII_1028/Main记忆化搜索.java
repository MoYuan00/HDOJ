package ĸ����.IgnatiusandthePrincessIII_1028;

import java.util.Scanner;

/**

 * max��ʾ��ǰ����ֵ
 * N��ʾ��ǰ���ֽ����
 f(N, maxI) = 0, N < 0 
		 	= 1, N = 1 or max = 1
		 	= f(N, max - 1), N < max
		 	= f(N, max - 1) + 1, N = max // �ҵ�һ�ֻ��ַ�
		 	= f(N, max - 1) + f(N - max, max), other state
 * @author Rnti
 *
 */
public class Main���仯���� {
	/**
	 * ���仯 �ݹ�
	 * ʱ����� N^2
	 */
	public static long dp[][] = new long[2000][2000];
	public static long dfs(int num, int max) {
		if(num == 0 || max == 0) return 0;
		if(num == 1 || max == 1) return 1;// 1 ֻ��һ�ַֽⷽ��
		if(dp[num][max] != 0) return dp[num][max];
		if(num < max) return dp[num][max] = dfs(num, num);// ��6�ֽ� ���ֵΪ7�� === �� 6 �ֽ� ���ֵΪ6
		if(num == max) return dp[num][max] = 1 + dfs(num, max - 1);// 6 + 0 Ҳ��һ�ַֽⷽ��
		return dp[num][max] = dfs(num, max - 1) + dfs(num - max, max); // 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			long sT = System.currentTimeMillis();
			System.out.println(dfs(N, N));
			System.out.println(System.currentTimeMillis() - sT);
		}
		sc.close();
	}
}	
