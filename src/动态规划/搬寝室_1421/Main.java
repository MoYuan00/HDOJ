package ��̬�滮.������_1421;

import java.util.Arrays;
import java.util.Scanner;

/** ��֪��Ϊɶwa��
����˼·��һ��DP��
   ����n����Ʒ��ÿ����Ʒ��������
   ����ѡ��m�ԣ�ʹ����m����Ʒ�������ƽ������С��
   ƣ�Ͷȣ�m����Ʒ�������ƽ����
   ���������˼·
   �ȶ�n����Ʒ����������
   ��dp[i][j]��ʾǰi����Ʒ��ѡj�Ե���Сƣ�Ͷȡ�
   ��dp[i][j]���ܺ��е�i����Ʒ(���������,��i����Ʒһ���Ǻ͵�i-1����Ʒ���)��
   ��dp[i][j]=dp[i-2][j-1]+(val[i]-val[i-1])*(val[i]-val[i-1])
    dp[i][j]��j��Ҳ���ܲ����е�i����Ʒ����ʱ��
   dp[i][j]=dp[i-1][j]
   ״̬ת�Ʒ���
   dp[i][j]=min{dp[i-2][j-1]+(val[i]-val[i-1])*(val[i]-val[i-1]),dp[i-1][j]
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			long weight[] = new long[N + 1];// ��Ʒ����
			for(int i = 1; i <= N; i++) {
				weight[i] = sc.nextLong();
			} 
			// ����
			Arrays.sort(weight, 1, N + 1);
			// ѡk��
			long dp[][] = new long[N + 1][K + 1];
//			// ��ʼ��
//			for(int i = 1; i <= N; i++) 
//				for(int j = 1; j <= K; j++) 
//					dp[i][j] = (Long.MAX_VALUE >> 1);
			for(int j = 1; j <= K; j++) {// ѡk��
				for(int i = 2*j; i <= N; i++) {// k������Ϊi=2j��
					long t = (weight[i] - weight[i - 1])*(weight[i] - weight[i - 1]);
					dp[i][j] = dp[i - 2][j - 1] + t;
					if(i > 2*j){// ������ڶ��,��ѡ�����أ���i > 2*j����ѡ��iƥ�仹�ǲ�ƥ��ȡ���
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);// ƥ��Ͳ�ƥ����ѡ��С��
					}
				}
			}
			System.out.println(dp[N][K]);
		}
	}
}
