package ������ѧ.RightmostDigit_1061;

import java.util.Scanner;

/**
 * Given a positive integer N, you should output the most right digit of N^N.
 * @author Rnti
 *
 */
public class Main {
	// ���ٳ˷� n*m = (n *2)*(m / 2) :nΪż���� n*m = (n *2)*(m / 2) + n :nΪ������
	public static long quickMult(long n, long m, long mod) {
		if(n >= mod) n %= mod;// Ԥ��ȡģ����ֹ n,mԶԶ����mod
		if(m >= mod) n %= mod;
		long result = 0;
		while(m > 0) {
			if((m & 1) == 1) {
				result = (result + n);
				while(result >= mod) result -= mod;// �ü�������ȡģ (�����ü������������ʹ�ü�������result  >> ���� modʱ����Ϊ�ķ�ʱ��)
			}
			n = (n << 1);
			while(n >= mod) n -= mod;
			m >>= 1;
		}
		return result;
	}
	// ������ N^N = (N^(N/2))^2: N��ż��ʱ�� N^N = (N^(N/2))^2 * N: N������ʱ
	public static long quickPower(long n, long m, long mod) {
		long result = 1;
		while(m > 0) {
			if((m & 1) == 1)
				result = quickMult(result, n, mod);
			n = quickMult(n, n, mod); 
			m >>= 1;
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(quickPower(n, n, 10));
		}
		sc.close();
	}
}
