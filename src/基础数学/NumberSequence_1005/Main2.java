package ������ѧ.NumberSequence_1005;

import java.util.Scanner;
/**
 * A number sequence is defined as follows:

	f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
	
	Given A, B, and n, you are to calculate the value of f(n).
 * @author Rnti
 * 2. ����һ���� % 7ֻ���� 0,1,2,3,4,5,6 ���ֿ��ܣ���f1 = 1, f2=1,���������������ֳ��� fn=1,f��n-1��=1���������ô���Եõ����е�����Ϊn-2
 *
 */
public class Main2 {
	/**
	 * �ⷨ2��
	 * 2. ����һ���� % 7ֻ���� 0,1,2,3,4,5,6 ���ֿ��ܣ���f1 = 1, f2=1,
	 * ���������������ֳ��� fn=1,f��n-1��=1���������ô���Եõ����е�����Ϊn-1
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 7;
		int a[] = new int[1001];// ��ǰ1000�����ҹ��ɣ�0-6�����������ᳬ��1000
		int T;
		int i;
		while(sc.hasNextInt()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int n = sc.nextInt();
			if(A == 0 && B == 0 && n == 0) break;
			a[1] = 1; a[2] = 1;
			for(i = 3; i <= 1000; i++) {// ������ 
				a[i] = (A*a[i - 1] + B*a[i - 2]) % mod;
				if(a[i] == 1 && a[i - 1] == 1) // �ҵ�������
					break;
			}
			T = i - 2;
			if(n % T == 0) System.out.println(a[T]);// 1 1 0 0 1 1������Ϊ4��f4 = 0, ����û��f0, ֻ��f1..ft,������f0...ft-1
			else System.out.println(a[(n % T)]);// ��������ֱ����ֵ
		}
		sc.close();
	}
}
