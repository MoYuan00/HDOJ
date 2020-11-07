package 基础数学.人见人爱AB_2035;

import java.util.Scanner;

/**
 * 	求A^B的最后三位数表示的整数。
	说明：A^B的含义是“A的B次方”
 * @author Rnti
 *
 */
public class Main {
	// 快速乘法
	static long quickMultiply(long n, long m, long mod) {
		if(n >= mod) n %= mod;
		if(m >= mod) m %= mod;// 防止n,m过大
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
	// 快速幂
	static long quickPower(long n, long m, long mod) {
		if(n >= mod) n %= mod;
		if(m >= mod) m %= mod;// 防止n,m过大
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
