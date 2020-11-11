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
public class Mainĸ���� {
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
		long[][] pnns = new long[n + 1][n + 1];
		for(int i = 1; i <= n; i++) 
			pnns[i] = getPn(n, i);
		// չ��
		for(int i = 2; i <= n; i++) {
			pnns[i] = pnMult(pnns[i - 1], n, pnns[i], n, n);
		}
		return pnns[n];
	}
	/**
	 * ����ʽ�˷� �Ľ������Ӳ���n,m. ʹ�ÿ���ֻ ����pn1[1..n] * pn2[1..m], ������ǰk��
	 * @param pn1 
	 * @param pn2
	 * @return
	 */
	static long[] pnMult(long[] pn1, int n, long pn2[], int m, int k) {
		long pn[] = new long[k + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i + j <= k)// ֻ����ǰk����
					pn[i + j] += pn1[i] * pn2[j];
			}
		}
		return pn;
	}
	public static void main(String[] args) {
		// ֱ�ӽ�ǰ121�����
		long re[] = generationFunction(1000);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			System.out.println(re[N]);
		}
		sc.close();
	}
}
