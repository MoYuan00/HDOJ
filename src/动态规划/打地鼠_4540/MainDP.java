package ��̬�滮.�����_4540;

import java.util.Scanner;

/**
 * ͨ��245ms
 * @author Rnti
 *
 */
public class MainDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int PO[][] = new int[N + 1][K];
			for(int t = 0; t < N; t++)
				for(int k = 0; k < K; k++) 
					PO[t][k] = sc.nextInt();
			
			// f(n, p) = min(f(n + 1, q) + |PO[n][q] - PO[n + 1][q]|); q:1->k, n:1->N
			// f(n ,p) = min(f(n - 1, q), + |PO[n][p] - PO[n - 1][q]|); q:1->k, n: 1->N, p:1->k
			int DP[][] = new int[N + 1][K];
			for(int n = 1; n < N; n++) {// ����1��ʼ�� ��Ϊ��һ�����󲻺�����
				for(int p = 0; p < K; p++) {// ��ÿ����һ��������ֵ�λ��Ϊ���
					int tempMin = Integer.MAX_VALUE;
					for(int q = 0; q < K; q++) {
						int temp = Math.abs(PO[n][p] - PO[n - 1][q]) + DP[n - 1][q];
						if(temp < tempMin) tempMin = temp;
					}
					DP[n][p] = tempMin;
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < K; i++) {
				if(DP[N - 1][i] < min) min = DP[N - 1][i];
			} 
			System.out.println(min);
		}
		sc.close();
	}
}
