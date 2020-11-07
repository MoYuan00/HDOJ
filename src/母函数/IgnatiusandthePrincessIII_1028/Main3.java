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
public class Main3 {
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
		long pn[] = getPn(n, 1);
		// 边计算，边展开
		for(int i = 2; i <= n; i++) {
			pn = pnMult(pn, n, getPn(n, i), n, n);
		}
		return pn;
	}
	/**
	 * 多项式乘法 改进：增加参数n,m. 使得可以只 计算pn1[1..n] * pn2[1..m], 并返回前k项
	 * @param pn1 
	 * @param pn2
	 * @return
	 */
	static long[] pnMult(long[] pn1, int n, long pn2[], int m, int k) {
		long pn[] = new long[k + 1];
		// 缩减区间为刚刚好能计算出k项
		if(m + n > k) {// 再优化： 只计算前k项结果,,, ( 保证对于任意的m，n,k都正确计算
			int half = k >> 1;
			if(m > half && n > half) {// 两个区间都要缩减
				n = m = half;
			}else {
				if(n > half) // 缩减一个, 其余可能需要长的补充，于是减去多余的就可以
					n = n - (k - m);
				else 
					m = m - (k - n);
			}
		}
		// 相乘
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
//				if(i + j <= k)// 只保留前k项结果
					pn[i + j] += pn1[i] * pn2[j];
			}
		}
		return pn;
	}
	
	
	public static void main(String[] args) {
		// 直接将前121项求出
		long sT = System.currentTimeMillis();
		long re[] = generationFunction(1900);
		System.out.println(System.currentTimeMillis() - sT);
		long sT2 = System.currentTimeMillis();
		long re2[] = gF2(1900);
		System.out.println(System.currentTimeMillis() - sT2);
		System.out.println(re[120]);
		System.out.println(re2[120]);
		System.out.println(re.length);
		System.out.println(re2.length);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			System.out.println(re[N]);
		}
		sc.close();
	}
	/**
	 * 母函数优化 --- 由于每个母函数系数都是1，改乘法为加法
	 * @return
	 */
	public static long[] gF2(int N) {
		long pn1[] = new long[N + 1];
		long pn2[] = new long[N + 1];
		for(int i = 0; i <= N; i++)// 第一项 1 + x + x^2 + ...
			pn1[i] = 1;
		for(int xn = 2; xn <= N; xn++) {// 2...n项
			for(int n1 = 0; n1 <= N; n1++) {// 相乘
				for(int n2 = 0; n2 + n1 <= N; n2 += xn) {
					pn2[n1 + n2] += pn1[n1];
				}
			}
			for(int n1 = 0; n1 <= N; n1++) {// 轮换
				pn1[n1] = pn2[n1];
				pn2[n1] = 0;
			}
		}
		return pn1;
	}
}
/** 母函数优化 --- 由于每个母函数系数都是1，改乘法为加法
#include <iostream>
using namespace std;
const int lmax = 10000;
int c1[lmax + 1], c2[lmax + 1];
int main()
{
	int n, i, j, k;
	while (cin >> n)
	{
		for (i = 0; i <= n; i++) // 初始化 数组
		{
			c1[i] = 0;
			c2[i] = 0;
		}
		for (i = 0; i <= n; i++)// c1 = 1 + x + x^2 + .... 数1的函数
			c1[i] = 1;

		for (i = 2; i <= n; i++)// 计算c1 * c2 * c3 *.....*cn
		{
			for (j = 0; j <= n; j++){
				for (k = 0; k + j <= n; k += i)
				{
					c2[j + k] += c1[j];// c1 * ..// 应该是乘法，但由于 另一个多项式总是由多个1,0构成，于是省略1，跳过0
				}
			}

			for (j = 0; j <= n; j++)// 记录结果 c1 = c2, 初始化临时变量c2 = 0
			{
				c1[j] = c2[j];
				c2[j] = 0;
			}
		}
		cout << c1[n] << endl;
	}
	return 0;
}
*/
