package 基础数学.RightmostDigit_1061;

import java.util.Scanner;

/**
 * Given a positive integer N, you should output the most right digit of N^N.
 * @author Rnti
 *
 */
public class Main {
	// 快速乘法 n*m = (n *2)*(m / 2) :n为偶数， n*m = (n *2)*(m / 2) + n :n为奇数数
	public static long quickMult(long n, long m, long mod) {
		if(n >= mod) n %= mod;// 预先取模，防止 n,m远远大于mod
		if(m >= mod) n %= mod;
		long result = 0;
		while(m > 0) {
			if((m & 1) == 1) {
				result = (result + n);
				while(result >= mod) result -= mod;// 用减法代替取模 (不能用减法，如果单纯使用减法，当result  >> 大于 mod时，极为耗费时间)
			}
			n = (n << 1);
			while(n >= mod) n -= mod;
			m >>= 1;
		}
		return result;
	}
	// 快速幂 N^N = (N^(N/2))^2: N是偶数时， N^N = (N^(N/2))^2 * N: N是奇数时
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
