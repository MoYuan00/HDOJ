package ��̬�滮.����ڱ�_1176;

import java.util.Scanner;

/**
 * ����ڱ�
 * �赱ǰʱ��ΪT,ʣ��ʱ��ΪTs, ���һ�������µ�ʱ��ΪST, ��ǰλ��Ϊp
 * ��Ҫ��ĺ�����ʾΪ:F(Ts=0, p=5) or F(T=ST, p��֪���Ƕ��١���)
 * f(Ts, p) = max{f(Ts + 1, p - 1), f(Ts + 1, p + 1), f(Ts + 1, p)} // �������ң����ƶ��� 3�������ֵ
 * @author Rnti
 *
 */
public class Main {
	
	/**
	 * �Զ����� ����
	 * @param time ��ǰʱ��
	 * @param spanTime ����ʱ��/���һ�������µ�ʱ��
	 * @param point
	 * @param cakePoint
	 * @return
	 */
	public static int func(int time, final int spanTime, int point, int cakePoint[][]) {
		if(point < 0 || point > 10) return 0;		// �����ƶ���Χ
		if(spanTime == time) return cakePoint[time][point];		// ֻʣ0�룬��ôֻ�ܻ�ȡ��ǰʱ��ı�
		int noMove = func(time + 1, spanTime, point, cakePoint); 		// ���ƶ�
		int moveLeft = func(time + 1, spanTime, point + 1, cakePoint);  // ���ƶ���
		int moveRight = func(time + 1, spanTime, point - 1, cakePoint); // ���ƶ�
		return Math.max(noMove, Math.max(moveLeft, moveRight))  + cakePoint[time][point];	// ����/�����ƶ������ƶ����ֵ + ��ǰʱ���õı�
	}
	/**
	 * �Ե����� ��̬�滮
	 */
	public static long dp(int spanTime, long cakePoint[][]) {
		// ���Ƕ�̬�滮
		for(int t = spanTime - 1; t >= 0; t--) {
			for(int p = 0; p <= 10; p ++) {
				long left = 0;// ���˰���ԭ����int���ͣ���������
				long right = 0;
				if(p > 0) left = cakePoint[t + 1][p - 1];
				if(p < 10) right = cakePoint[t + 1][p + 1];
				long result = Math.max(Math.max(cakePoint[t + 1][p], left),  right);// ���ƶ��� 3�������ֵ
				cakePoint[t][p] += result;
			}
		}
		return cakePoint[0][5];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			if(N == 0) break;
			long cakePoint[][] = new long[100001][13];// ��i�� ����jλ���� ��cakePoint[i][j]���ڱ�  ����
			int spanTime = 0;// ��¼����ʱ��
			for(int i = 0; i < N; i++) {
				int point = sc.nextInt();
				int time = sc.nextInt();
				if(time > spanTime) spanTime = time;
				cakePoint[time][point]++;
			}
//			System.out.println(func(0, spanTime, 5, cakePoint));// O(3^T)�η�
			System.out.println(dp(spanTime, cakePoint));// O(T)
			
		}
		sc.close();
	}
	
}
