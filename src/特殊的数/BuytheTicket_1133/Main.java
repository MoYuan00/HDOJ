package 特殊的数.BuytheTicket_1133;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 暂时假设每个人相同
 * f(m,n) = 0,  m < n
 *        = 1,  n = 0
 *  	  = f(m - 1, n) + f(m, n - 1)
 *  考虑每个人是不同的则：
 *  f(m,n) = 0,  m < n
 *        = m!,  n = 0
 *  	  = f(m - 1, n)*m + f(m, n - 1)*n
 * @author Rnti
 * 相关练习
 * 1023
	1130/1131
	1133/1134
	1267/2067
 */
public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger array[] = new BigInteger[201];// 计算1.。。200的阶乘
		array[0] = BigInteger.ONE;
		for(int i = 1; i <= 200; i++) {
			array[i] = BigInteger.valueOf(i).multiply(array[i - 1]);
		}
		
		BigInteger dp[][] = new BigInteger[201][201];// m n
		for(int i = 0; i <= 200; i++)
			dp[0][i] = BigInteger.ZERO;
		for(int m = 1; m <= 200; m++) //  m!,  n = 0时
			dp[m][0] = array[m];		// m!
		
		int count = 0;
		while(sc.hasNextInt()) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			if(N == 0 && M == 0) break;
			for(int m = 1; m <= M; m++) {
				for(int n = 1; n <= N; n++) {
					if(m < n) {// m < n == 0
						dp[m][n] = BigInteger.ZERO;
					}else {// f(m - 1, n)*m + f(m, n - 1)*n
						BigInteger big1 = dp[m - 1][n].multiply(BigInteger.valueOf(m));
						BigInteger big2 = dp[m][n - 1].multiply(BigInteger.valueOf(n));
						dp[m][n] = big1.add(big2);	
					}
				}
			}
			System.out.println(String.format("Test #%d:", ++count));
			System.out.println(dp[M][N].toString());
		}
		sc.close();
	}
}
