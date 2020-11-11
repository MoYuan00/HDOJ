package ĸ����.HDU���¼�_1171;

import java.util.Arrays;
import java.util.Scanner;

/**
��Ʒ��ֵΪV[1..N],��Ʒ����ΪW[1..N]
��Ӧ��ֵ�Ķ���ʽΪ:h(i) = (1 + X^V[i] + ...) һ��W[i] + 1��
G(x) = h(1) * h(2) * ... * h(N)
չ����ѡ���һ�����ڵ��� ƽ��ֵ������ ΪA, ���ߵ�һ��С��ƽ��ֵ������ΪB
 * @author Rnti
 * TLE(Time Limit Exceeded) ��ʱ��
 *
 */
public class Mainĸ���� {
	
	/**
	 * ����ĸ������ĳһ������ʽh(i)
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
	 * ����ʽ�˷�
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
	 * ����ĸ������չ��
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
			}// �������
			int B = generationFunction(V, M, N);
			System.out.println(String.format("%d %d", sum- B, B));
		}
		sc.close();
	}
}
