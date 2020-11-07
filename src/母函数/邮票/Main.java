package 母函数.邮票;

import java.util.Arrays;

/**
 * 
求用1分、2分、3分的邮票贴出不同数值的方案数：
这里每种是无限的。故其母函数为
				1分						2分
g(x) = (1 + x + x^2 + x^3 + ...) * (1 + x^2 + x^4 + x^6 + ...) * (1 + x^3 + x^6 + x^9 +.....)
将其展开即可
 * @author Rnti
 *
 */
public class Main {
	
	/**
	 * 多项式乘法
	 * @param pn1
	 * @param pn2
	 * @return
	 */
	static int[] pnMult(int[] pn1, int pn2[]) {
		int len1 = pn1.length; int len2 = pn2.length;
		int pn[] = new int[len1 + len2 - 1];
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				pn[i + j] += pn1[i] * pn2[j];
			}
		}
		return pn;
	}
	/**
	 * 构建母函数并展开
	 * @param n
	 * @return
	 */
	static int generationFunction(int n) {
		// 初始化1，2，3 这3个多项式
		int pn1[] = new int[n + 1];
		int pn2[] = new int[n + 1];
		int pn3[] = new int[n + 1];
		for(int i = 0; i <= n; i++)
			pn1[i] = 1;
		for(int i = 0; i <= n; i += 2)
			pn2[i] = 1;
		for(int i = 0; i <= n; i += 3)
			pn3[i] = 1;
		// 母函数初始化完成
		int result = 0;
		//展开母函数
		int pn[] = pnMult(pn1, pnMult(pn2, pn3));
		result = pn[n];
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int n = 200;
		System.out.println(generationFunction(n));
		System.out.println(dfs(n, 3));
	}
	public static long dp[][] = new long[300][300];
	public static long dfs(int num, int max) {
		if(num == 0 || max == 0) return 0;
		if(num == 1 || max == 1) return 1;
		if(dp[num][max] != 0) return dp[num][max];
		if(num < max) return dp[num][max] = dfs(num, num);
		if(num == max) return dp[num][max] = 1 + dfs(num, max - 1);
		return dp[num][max] = dfs(num, max - 1) + dfs(num - max, max); 
	}
}
