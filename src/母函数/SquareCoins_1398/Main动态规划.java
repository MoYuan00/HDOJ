package 母函数.SquareCoins_1398;

import java.util.Arrays;
import java.util.Scanner;

/**
People in Silverland use square coins.
Not only they have square shapes but also their values are square numbers. 
Coins with values of all square numbers up to 289 (=17^2), 
i.e., 1-credit coins, 4-credit coins, 9-credit coins, ..., and 289-credit coins, 
are available in Silverland.

ten 1-credit coins,
one 4-credit coin and six 1-credit coins,
two 4-credit coins and two 1-credit coins, and
one 9-credit coin and one 1-credit coin.
 * @author Rnti
 * 对递推方程进行动态规划
 * array[1..17] 存放17种币值
 * maxI表示当前最大币值下标，array[maxI]表示当前最大币值
 * N表示当前代分解的数
 f(N, maxI) = 0, N < 0 
		 	= 1, N = 1 or array[maxI]=1
		 	= f(N, maxI - 1), N < array[maxI]
		 	= f(N, maxI - 1) + 1, N = array[maxI] // 找到一种划分法
		 	= f(N, maxI - 1) + f(N - array[maxI], maxI), other state
 */
public class Main动态规划 {
	/**
	 * 自底向上 动态规划
	 * @param N 待分解的币值
	 * @return
	 */
	public static int[][] dp(int N) {
		int array[] = new int[18];// 存放每一种币值
		for(int i = 1; i <= 17; i++) 
			array[i] = i*i;
		int dp[][] = new int[N + 1][18];
		for(int n = 0; n <= N; n++) {// 分解 1。。。N
			for(int maxI = 1; maxI <= 17; maxI++) {// 最大值下标
				if(n == 0) dp[n][maxI] = 0;
				else if(n == 1 || array[maxI] == 1) dp[n][maxI] = 1;
				else if(n < array[maxI]) dp[n][maxI] = dp[n][maxI - 1];
				else if(n == array[maxI]) dp[n][maxI] = dp[n][maxI - 1] + 1;
				else {
					dp[n][maxI] = dp[n][maxI - 1];
					if(n - array[maxI] > 0)// 防止越界产生
						dp[n][maxI] += dp[n - array[maxI] ][maxI];
				}
			}
		}
		return dp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result[][] = dp(300);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			System.out.println(result[N][17]);
		}
		sc.close();
	}
}
