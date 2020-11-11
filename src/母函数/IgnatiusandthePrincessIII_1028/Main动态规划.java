package 母函数.IgnatiusandthePrincessIII_1028;

import java.util.Scanner;

/**
 * max表示当前最大币值
 * N表示当前代分解的数
 * 
 f(N, max) = 0, N <= 0 or max = 0
		 	= 1, N = 1 or max=1
		 	= f(N, max - 1), N < max
		 	= f(N, max - 1) + 1, N = max // 找到一种划分法
		 	= f(N, max - 1) + f(N -max, max), other state
 * @author Rnti
 *
 */
public class Main动态规划 {
	/**
	 * 时间 N^2
	 */
	public static long dp[][] = new long[301][301];
	public static void dp(int N) {
		for(int n = 0; n <= N; n++) {
			for(int max = 0; max <= N; max++) {
				if(n == 0 || max == 0) dp[n][max] = 0;
				else if(n == 1 || max == 1) dp[n][max] = 1;
				else if(n < max) dp[n][max] = dp[n][max - 1];
				else if(n == max) dp[n][max] = dp[n][max - 1] + 1;
				else {
					dp[n][max] = dp[n][max - 1];
					if(n - max > 0)
						dp[n][max] += dp[n - max][max];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		dp(300);// 计算1.。300的所有种数
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			System.out.println(dp[N][N]);
		}
		sc.close();
	}
}	
