package �������.���߷ָ�ƽ��_2050;

import java.util.Scanner;

/**
		˼·���о��ҹ���
		��0�����ߣ�����0���ߣ�����0�����䣻f0 = 1
		��1�����ߣ�����0���ߣ�����1�����䣻f1 = 1 + 2*2(1 - 1) + 1  = 2
		��2�����ߣ�����2���ߣ�����5�����䣻f2 = f1 + 2*2(2 - 1) + 1  = 7
		��3�����ߣ�����4���ߣ�����9�����䣻f3 = f2 + 2*2(3 - 1) + 1  = 16
		��4�����ߣ�����6���ߣ�����13�����䣻
		��:2*(n-1) , �������:2*2*(n-1)+1 
		�������:  2*2*(n-1)+1 
		fn = f(n-1) + 4(n-1) + 1
		fn = n + 1 + 2n(n-1) = 2n^2 - n + 1
 * 
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			System.out.println(((n * n) << 1) - n + 1);
		}
		sc.close();
	}
}
