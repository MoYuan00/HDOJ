package 母函数.IgnatiusandthePrincessIII_1028;

import java.util.Scanner;

/**
 * 用母函数求
求用1，2，3，4，5.。。。。拼出来的数字n 的不同数值的方案数：
这里每个数字是无限的。故其母函数为:
				1						2								3								n
g(x) = (1 + x + x^2 + x^3 + ...) * (1 + x^2 + x^4 + x^6 + ...) * (1 + x^3 + x^6 + x^9 +.....) * .... (1 + x^n)
 * @author Rnti
 * 比记忆化递归更耗费时间 为ON^3
 */
public class Main母函数 {
	/**
	 * 生成母函数的某一项
	 * i=1时：(1 + x + x^2 + x^3 + ....)
	 * i=2:  (1 + x^2 + x^4 + x^6 + ....)
	 * ...
	 * @param n
	 * @param i
	 * @return
	 */
	private static long[] getPn(int n, int i) {
		long pn[] = new long[n + 1];
		for(int j = 0; j <= n; j += i) 
			pn[j] = 1;
		return pn;
	}
	/**
	 * 1.构造母函数
	 * 2.展开
	 * @param n
	 * @return 展开式后至少为0...n项, 长度为n+1
	 */
	public static long[] generationFunction(int n) {
		long[][] pnns = new long[n + 1][n + 1];
		for(int i = 1; i <= n; i++) 
			pnns[i] = getPn(n, i);
		// 展开
		for(int i = 2; i <= n; i++) {
			pnns[i] = pnMult(pnns[i - 1], n, pnns[i], n, n);
		}
		return pnns[n];
	}
	/**
	 * 多项式乘法 改进：增加参数n,m. 使得可以只 计算pn1[1..n] * pn2[1..m], 并返回前k项
	 * @param pn1 
	 * @param pn2
	 * @return
	 */
	static long[] pnMult(long[] pn1, int n, long pn2[], int m, int k) {
		long pn[] = new long[k + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i + j <= k)// 只保留前k项结果
					pn[i + j] += pn1[i] * pn2[j];
			}
		}
		return pn;
	}
	public static void main(String[] args) {
		// 直接将前121项求出
		long re[] = generationFunction(1000);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			System.out.println(re[N]);
		}
		sc.close();
	}
}
