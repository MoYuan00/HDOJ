package ĸ����.SquareCoins_1398;

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
 * ���仯�������������ֵ��ƹ�
 * array[1..17] ���17�ֱ�ֵ
 * maxI��ʾ��ǰ����ֵ�±꣬array[maxI]��ʾ��ǰ����ֵ
 * N��ʾ��ǰ���ֽ����
 * 
 f(N, maxI) = 0, N < 0
		 	= 1, N = 1 or array[maxI]=1
		 	= f(N, maxI - 1), N < array[maxI]
		 	= f(N, maxI - 1) + 1, N = array[maxI] // �ҵ�һ�ֻ��ַ�
		 	= f(N, maxI - 1) + f(N - array[maxI], maxI), other state
 */
public class Main���仯���� {
	/**
	 * 
	 * @param N ���ֽ�ı�ֵ
	 * @param maxI ��ǰ����ֵ�±�
	 * @param array ��ֵ����
	 * @param dp ��̬�滮��
	 * @return
	 */
	public static int dfs(int N, int maxI, int array[], int dp[][]) {
		if(N <= 0) return 0;
		if(N == 1 || array[maxI] == 1) return 1;
		if(dp[N][maxI] != 0) return dp[N][maxI];
		if(N < array[maxI]) return dp[N][maxI] = dfs(N, maxI - 1, array, dp);
		if(N == array[maxI]) return dp[N][maxI] = 1 + dfs(N, maxI - 1, array, dp);
		return dp[N][maxI] = dfs(N, maxI - 1, array, dp) + dfs(N - array[maxI], maxI, array, dp);
	}
	public static void main(String[] args) {
		int elem[] = new int[18];// ���ÿһ�ֱ�ֵ
		for(int i = 1; i <= 17; i++) 
			elem[i] = i*i;
		int dp[][] = new int[301][18];
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			System.out.println(dfs(N, 17, elem, dp));
		}
		sc.close();
	}
}
