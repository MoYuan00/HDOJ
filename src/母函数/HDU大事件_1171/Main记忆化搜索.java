package ĸ����.HDU���¼�_1171;

import java.util.Scanner;

/**
f(A,  N) = min{f(A + V[N],  N - 1), f(A,  N - 1)}
 * @author Rnti
 *
 */
public class Main���仯���� {
	/**
	 * ����ÿ������ҪôAѡ��ҪôBѡ�У�ö������������ʵ���֦
	 * WA??????
	 * @param A
	 * @param B
	 * @param N
	 * @param V
	 * @param M
	 * @param allValue
	 * @return
	 */
	public static int func(int A, int N, short V[], int halfValue, short dp[][]) {
		if(N == 0)  return Math.abs(A - halfValue);
		if(halfValue == A) return 0;		// �����һ����ȡ��һ��ļ�ֵ��0������Сֵ��
		if(halfValue < A) return A - halfValue;// ȡ������һ��Ͳ�ȡ��
		if(dp[A][N] != 0) return dp[A][N];
		return dp[A][N] = (short)Math.min(
				func(A + V[N], N - 1, V, halfValue, dp), 
				func(A, N - 1, V, halfValue, dp));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short VAll[] = new short[5001];
		short dp[][] = new short[2500 + 52][5001];	// ��̬�滮��
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N <= 0) break;
			int allValue = 0;		// �����ؼ�ֵ��������֦
			int count = 0;			// ��������Ʒ����
			for(int i = 1; i <= N; i++) {
				short V = sc.nextShort();
				short M = sc.nextShort();
				for(int j = 0; j < V; j++) // ����Ʒչ��
					VAll[++count] = V; 
				allValue += V * M;
			}
			int halfValue = (allValue >> 1);
			if((allValue & 1) == 1) halfValue++;			// ����
			int div = func(0, count, VAll, halfValue, dp);	// ��ֵ
			int A = halfValue + div;
			int B = allValue - A;
			System.out.println(String.format("%d %d", A, B));
		}
		sc.close();
	}
}
