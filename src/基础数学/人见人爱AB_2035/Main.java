package ������ѧ.�˼��˰�AB_2035;

import java.util.Scanner;

/**
 * 	��A^B�������λ����ʾ��������
	˵����A^B�ĺ����ǡ�A��B�η���
 * @author Rnti
 *
 */
public class Main {
	// ���ٳ˷�
	static long quickMultiply(long n, long m, long mod) {
		if(n >= mod) n %= mod;
		if(m >= mod) m %= mod;// ��ֹn,m����
		long result = 0;
		while(m > 0) {
			if((m & 1) == 1){
				result = result + n;
				if(result >= mod) result -= mod;
			}
			n <<= 1;
			if(n >= mod) n -= mod;
			m >>= 1;
		}
		return result;
	}
	// ������
	static long quickPower(long n, long m, long mod) {
		if(n >= mod) n %= mod;
		if(m >= mod) m %= mod;// ��ֹn,m����
		long result = 1;
		while(m > 0) {
			if((m & 1) == 1)
				result = quickMultiply(result, n, mod);
			n = quickMultiply(n, n, mod);
			m >>= 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A == 0 && B == 0) 
				break;
			System.out.println(quickPower(A, B, 1000));
		}
		sc.close();
	}
}
