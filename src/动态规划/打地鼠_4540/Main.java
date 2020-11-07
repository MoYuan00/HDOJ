package ��̬�滮.�����_4540;

import java.util.Scanner;

public class Main {
	
	/**
	 * �Զ����¶�̬�滮����ʱ
	 * f(n, p) = min(f(n + 1, q) + |PO[n][p] - PO[n + 1][q]|); q:1->k, n:1->N, p:1->k
	 * @param n ��ǰ����
	 * @param N �ܴ���
	 * @param K ÿ�γ����������
	 * @param p �ϴ���������λ��
	 * @param PO PO[i][j] i��ʱ����j������ ����λ��
	 * @param memory ��̬�滮��
	 * @return
	 */
	public static int func(int n, int N, int K, int p, int PO[][], int memory[][]) {
		if(n > N) {
			return 0;
		}
		if(memory[n][p] > 0)
			return memory[n][p];
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < K; i++) {
			int temp = Math.abs(p - PO[N][i]);
			int nextP = PO[N][i];
			if(memory[n][nextP] > temp) continue; // ��֦
			temp += func(n + 1, N, K, nextP, PO, memory);
			if(temp < result) {
				result = temp;
				memory[n][p] = result; // ��¼��������������¼������Լ�֦
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int PO[][] = new int[N + 1][K];
			for(int t = 0; t < N; t++)
				for(int k = 0; k < K; k++) 
					PO[t][k] = sc.nextInt();
			
			int min = Integer.MAX_VALUE;
			int memory[][] = new int[N + 1][501];
			for(int i = 0; i < K; i++) {// ��ÿ����һ��������ֵ�λ��Ϊ���
				int t = func(1, N, K, PO[0][i], PO, memory);
				if(t < min) min = t;
			}
			System.out.println(min);
		}
		sc.close();
	}
}
