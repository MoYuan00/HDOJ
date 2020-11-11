package 母函数.IgnatiusandthePrincessIII_1028;

import java.util.Scanner;

/**

 * max表示当前最大币值
 * N表示当前代分解的数
 f(N, maxI) = 0, N < 0 
		 	= 1, N = 1 or max = 1
		 	= f(N, max - 1), N < max
		 	= f(N, max - 1) + 1, N = max // 找到一种划分法
		 	= f(N, max - 1) + f(N - max, max), other state
 * @author Rnti
 *
 */
public class Main记忆化搜索 {
	/**
	 * 记忆化 递归
	 * 时间低于 N^2
	 */
	public static long dp[][] = new long[2000][2000];
	public static long dfs(int num, int max) {
		if(num == 0 || max == 0) return 0;
		if(num == 1 || max == 1) return 1;// 1 只有一种分解方法
		if(dp[num][max] != 0) return dp[num][max];
		if(num < max) return dp[num][max] = dfs(num, num);// 对6分解 最大值为7， === 对 6 分解 最大值为6
		if(num == max) return dp[num][max] = 1 + dfs(num, max - 1);// 6 + 0 也是一种分解方法
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
