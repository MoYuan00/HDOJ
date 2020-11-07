package DFS.斐波那契数列;


public class Main {
	
	/**
	 * 求斐波那契数列
	 * //首先分析问题的“递归特征”——除了规模，其它一样
	 * @param n
	 * @return
	 */
	public static int dfs1(int n) {
		if(n == 0) return 1; //先写出口（不需递归的特殊情况）
		if(n == 1) return 1;
		return dfs1(n - 1) + dfs1(n - 2);//再写普通情况（递归）
	}
	
	/**
	 * 求斐波那契数列， 记忆化
	 * @param n
	 * @return
	 */
	public static int dp[] = new int[100];
	public static int dfs2(int n) {
		if(n == 0 || n == 1) return 1; //先写出口（不需递归的特殊情况）
		if(dp[n] != 0) return dp[n];
		return dp[n] = dfs1(n - 1) + dfs1(n - 2);//再写普通情况（递归）
	}
	
	public static void main(String[] args) {
		int n = 20;
		System.out.println(dfs1(n));
		System.out.println(dfs2(n));
	}
}
