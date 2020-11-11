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
 * 构建母函数
 * g(x) =  (1 + x + x^2 + x^3 + ..) *  : 1^2 = 2
 * 		 (1 + x^4 + x^8 + x^12 + ..) * : 2^2 = 4
 * 			 .... *
 * 		 (1 + x^289)   				   : 17^2 = 289
 *
 */
public class Main母函数 {
	/**
	 * 生成母函数的某一项
	 * @param N
	 * @param k
	 * @return
	 */
	public static long[] getPn(int N, int k) {
		long pn[] = new long[N + 1];
		k = k*k;
		for(int j = 0; j <= N; j += k)
			pn[j] = 1;
		return pn;
	}
	/**
	 * 构建母函数
	 * 展开
	 * @param N
	 * @param k
	 * @return
	 */
	public static long[] generationFunction(int N) {
		long pn[] = getPn(N, 1);// 获取第一项
		for(int i = 2; i*i <= N; i++){// 获取并展开 1 .。n项
			long tpn[] = getPn(N, i);
			pn = pnMult(pn, N, tpn, N, N);
		}
		return pn;
	}
	/**
	 * 多项式乘法，pn1[0...n]*pn2[0...m], 计算前k项结果并返回
	 * @param pn1
	 * @param n
	 * @param pn2
	 * @param m
	 * @param k
	 * @return
	 */
	public static long[] pnMult(long pn1[], int n, long pn2[], int m, int k) {
		long pn[] = new long[k + 1];
//		if(m + n > k) {// 缩减计算区间，避免多余计算,,, 这里不能这样缩减， 因为一个多项式最后可能会有很多0，导致n,m长度并不准确
//			int half = k >> 1;
//			if(m > half && n > half) {
//				n = m = half;
//			}else {
//				if(n > half)
//					n = n - (k - m);
//				else
//					m = m - (k - n);
//			}
//		}
		for(int i = 0; i <= n; i++) 
			for(int j = 0; j <= m; j++) 
				if(i + j <= k)
					pn[i + j] += pn1[i] * pn2[j];
		return pn;
	}
	
	public static void main(String[] args) {
		long pn[] = generationFunction(301);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			System.out.println(pn[N]);
		}
		sc.close();
	}
}
