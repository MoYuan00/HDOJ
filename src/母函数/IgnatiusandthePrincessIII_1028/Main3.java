package ĸ����.IgnatiusandthePrincessIII_1028;

import java.util.Scanner;

/**
 * ��ĸ������
����1��2��3��4��5.��������ƴ����������n �Ĳ�ͬ��ֵ�ķ�������
����ÿ�����������޵ġ�����ĸ����Ϊ:
				1						2								3								n
g(x) = (1 + x + x^2 + x^3 + ...) * (1 + x^2 + x^4 + x^6 + ...) * (1 + x^3 + x^6 + x^9 +.....) * .... (1 + x^n)
 * @author Rnti
 * �ȼ��仯�ݹ���ķ�ʱ�� ΪON^3
 */
public class Main3 {
	/**
	 * ����ĸ������ĳһ��
	 * i=1ʱ��(1 + x + x^2 + x^3 + ....)
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
	 * 1.����ĸ����
	 * 2.չ��
	 * @param n
	 * @return չ��ʽ������Ϊ0...n��, ����Ϊn+1
	 */
	public static long[] generationFunction(int n) {
		long pn[] = getPn(n, 1);
		// �߼��㣬��չ��
		for(int i = 2; i <= n; i++) {
			pn = pnMult(pn, n, getPn(n, i), n, n);
		}
		return pn;
	}
	/**
	 * ����ʽ�˷� �Ľ������Ӳ���n,m. ʹ�ÿ���ֻ ����pn1[1..n] * pn2[1..m], ������ǰk��
	 * @param pn1 
	 * @param pn2
	 * @return
	 */
	static long[] pnMult(long[] pn1, int n, long pn2[], int m, int k) {
		long pn[] = new long[k + 1];
		// ��������Ϊ�ոպ��ܼ����k��
		if(m + n > k) {// ���Ż��� ֻ����ǰk����,,, ( ��֤���������m��n,k����ȷ����
			int half = k >> 1;
			if(m > half && n > half) {// �������䶼Ҫ����
				n = m = half;
			}else {
				if(n > half) // ����һ��, ���������Ҫ���Ĳ��䣬���Ǽ�ȥ����ľͿ���
					n = n - (k - m);
				else 
					m = m - (k - n);
			}
		}
		// ���
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
//				if(i + j <= k)// ֻ����ǰk����
					pn[i + j] += pn1[i] * pn2[j];
			}
		}
		return pn;
	}
	
	
	public static void main(String[] args) {
		// ֱ�ӽ�ǰ121�����
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
	 * ĸ�����Ż� --- ����ÿ��ĸ����ϵ������1���ĳ˷�Ϊ�ӷ�
	 * @return
	 */
	public static long[] gF2(int N) {
		long pn1[] = new long[N + 1];
		long pn2[] = new long[N + 1];
		for(int i = 0; i <= N; i++)// ��һ�� 1 + x + x^2 + ...
			pn1[i] = 1;
		for(int xn = 2; xn <= N; xn++) {// 2...n��
			for(int n1 = 0; n1 <= N; n1++) {// ���
				for(int n2 = 0; n2 + n1 <= N; n2 += xn) {
					pn2[n1 + n2] += pn1[n1];
				}
			}
			for(int n1 = 0; n1 <= N; n1++) {// �ֻ�
				pn1[n1] = pn2[n1];
				pn2[n1] = 0;
			}
		}
		return pn1;
	}
}
/** ĸ�����Ż� --- ����ÿ��ĸ����ϵ������1���ĳ˷�Ϊ�ӷ�
#include <iostream>
using namespace std;
const int lmax = 10000;
int c1[lmax + 1], c2[lmax + 1];
int main()
{
	int n, i, j, k;
	while (cin >> n)
	{
		for (i = 0; i <= n; i++) // ��ʼ�� ����
		{
			c1[i] = 0;
			c2[i] = 0;
		}
		for (i = 0; i <= n; i++)// c1 = 1 + x + x^2 + .... ��1�ĺ���
			c1[i] = 1;

		for (i = 2; i <= n; i++)// ����c1 * c2 * c3 *.....*cn
		{
			for (j = 0; j <= n; j++){
				for (k = 0; k + j <= n; k += i)
				{
					c2[j + k] += c1[j];// c1 * ..// Ӧ���ǳ˷��������� ��һ������ʽ�����ɶ��1,0���ɣ�����ʡ��1������0
				}
			}

			for (j = 0; j <= n; j++)// ��¼��� c1 = c2, ��ʼ����ʱ����c2 = 0
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
