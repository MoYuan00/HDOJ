package �������.������ϵ��֮һ_1465;

import java.util.Scanner;

/**
 * ��������
 * ĳ��д��n���ţ�����n���ŷ⣬������е��Ŷ�װ�����ŷ⣬���ж����ֿ��ܵ������
 * f1 = 0
 * f2 = 1
 * ����N���ŵ�ʱ��ǰ��N-1���ſ�����N-1���� N-2���װ
 * f3 1.���ڵ�n���ſ�����ǰn-1���д��� 2.���ǰn-1������һ��û�д��ŵģ���ô�����n���Ž�������,���������n-1��
 *    fn = f(n-1) * (n - 1) + f(n - 2) * (n - 1)
 * 
 * 
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long chech[] = new long[21];
		chech[2] = 1;
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			for(int i = 3; i <= n; i++) {
				chech[i] = (chech[i - 1] + chech[i - 2]) * (i - 1);
			}
			System.out.println(chech[n]);
		}
		sc.close();
	}
}
