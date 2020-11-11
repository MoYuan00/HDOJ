package 母函数.HDU大事件_1171;

import java.util.Arrays;
import java.util.Scanner;

/**
物品价值为V[1..N],物品数量为W[1..N]
对应价值的多项式为:h(i) = (1 + X^V[i] + ...) 一共W[i] + 1项
G(x) = h(1) * h(2) * ... * h(N)
展开后选择第一个大于等于 平均值的项数 为A, 或者第一个小于平均值的项数为B
 * @author Rnti
 * TLE(Time Limit Exceeded) 超时了
 *
 */
public class Main母函数 {
	
	/**
	 * 构造母函数的某一个多项式h(i)
	 * @param V
	 * @param M
	 * @return
	 */
	public static int[] getPn(int V, int M) {
		int pn[] = new int[V * M + 1];
		for(int i = 0, c = 0; c <= M; i += V, c++)
			pn[i] = 1;
		return pn;
	}
	/**
	 * 多项式乘法
	 * @param pn1
	 * @param n
	 * @param pn2
	 * @param m
	 * @return
	 */
	public static int[] mult(int pn1[], int n, int pn2[], int m) {
		int pn[] = new int[n + m + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				pn[i + j] += pn1[i] * pn2[j];
			}
		}
		return pn;
	}
	public static void show(int pn[]) {
		for(int i = 0; i < pn.length; i++) {
			if(pn[i] > 0)
				System.out.print("[" + i + "], ");
			else System.out.print(0 + ", ");
		}
		System.out.println();
	}
	/**
	 * 构建母函数并展开
	 * @param V
	 * @param M
	 * @return
	 */
	public static int generationFunction(int V[], int M[], int N) {
		int pn[] = getPn(V[1], M[1]);
		for(int i = 2; i <= N; i++) {
			int pn1[] = getPn(V[i], M[i]);
			pn = mult(pn, pn.length - 1, pn1, pn1.length - 1);
		}
		for(int i = (pn.length - 1) / 2; i >= 0; i--) 
			if(pn[i] > 0) 
				return i;// B
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N <= 0) break;
			int V[] = new int[N + 1];
			int M[] = new int[N + 1];
			int sum = 0;
			for(int i = 1; i <= N; i++) {
				V[i] = sc.nextInt();
				M[i] = sc.nextInt();
				sum += V[i] * M[i];
			}// 输入结束
			int B = generationFunction(V, M, N);
			System.out.println(String.format("%d %d", sum- B, B));
		}
		sc.close();
	}
}
