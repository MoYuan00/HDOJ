package 动态规划.搬寝室_1421;

import java.util.Arrays;
import java.util.Scanner;

/** 不知道为啥wa了
解题思路：一道DP题
   给定n个物品，每个物品有重量，
   从中选出m对，使得这m对物品重量差的平方和最小。
   疲劳度：m对物品重量差的平方和
   分析与解题思路
   先对n中物品的重量排序
   令dp[i][j]表示前i个物品中选j对的最小疲劳度。
   则dp[i][j]可能含有第i个物品(这种情况下,第i种物品一定是和第i-1个物品配对)，
   则dp[i][j]=dp[i-2][j-1]+(val[i]-val[i-1])*(val[i]-val[i-1])
    dp[i][j]的j对也可能不含有第i个物品，此时有
   dp[i][j]=dp[i-1][j]
   状态转移方程
   dp[i][j]=min{dp[i-2][j-1]+(val[i]-val[i-1])*(val[i]-val[i-1]),dp[i-1][j]
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			long weight[] = new long[N + 1];// 物品重量
			for(int i = 1; i <= N; i++) {
				weight[i] = sc.nextLong();
			} 
			// 排序
			Arrays.sort(weight, 1, N + 1);
			// 选k对
			long dp[][] = new long[N + 1][K + 1];
//			// 初始化
//			for(int i = 1; i <= N; i++) 
//				for(int j = 1; j <= K; j++) 
//					dp[i][j] = (Long.MAX_VALUE >> 1);
			for(int j = 1; j <= K; j++) {// 选k对
				for(int i = 2*j; i <= N; i++) {// k对至少为i=2j个
					long t = (weight[i] - weight[i - 1])*(weight[i] - weight[i - 1]);
					dp[i][j] = dp[i - 2][j - 1] + t;
					if(i > 2*j){// 如果存在多的,有选择的余地，就i > 2*j，就选择i匹配还是不匹配取最大
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);// 匹配和不匹配中选最小的
					}
				}
			}
			System.out.println(dp[N][K]);
		}
	}
}
