package 母函数.HDU大事件_1171;

import java.util.Scanner;

/**
f(A,  N) = min{f(A + V[N],  N - 1), f(A,  N - 1)}
 * @author Rnti
 *
 */
public class Main记忆化搜索 {
	/**
	 * 对于每个物体要么A选中要么B选中，枚举所有情况，适当剪枝
	 * WA??????
	 * @param A
	 * @param B
	 * @param N
	 * @param V
	 * @param M
	 * @param allValue
	 * @return
	 */
	public static int func(int A, int N, short V[], int halfValue, short dp[][]) {
		if(N == 0)  return Math.abs(A - halfValue);
		if(halfValue == A) return 0;		// 如果有一个能取到一半的价值，0就是最小值了
		if(halfValue < A) return A - halfValue;// 取到超过一半就不取了
		if(dp[A][N] != 0) return dp[A][N];
		return dp[A][N] = (short)Math.min(
				func(A + V[N], N - 1, V, halfValue, dp), 
				func(A, N - 1, V, halfValue, dp));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short VAll[] = new short[5001];
		short dp[][] = new short[2500 + 52][5001];	// 动态规划表
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N <= 0) break;
			int allValue = 0;		// 计算重价值，用来剪枝
			int count = 0;			// 计算总物品个数
			for(int i = 1; i <= N; i++) {
				short V = sc.nextShort();
				short M = sc.nextShort();
				for(int j = 0; j < V; j++) // 将物品展开
					VAll[++count] = V; 
				allValue += V * M;
			}
			int halfValue = (allValue >> 1);
			if((allValue & 1) == 1) halfValue++;			// 奇数
			int div = func(0, count, VAll, halfValue, dp);	// 差值
			int A = halfValue + div;
			int B = allValue - A;
			System.out.println(String.format("%d %d", A, B));
		}
		sc.close();
	}
}
