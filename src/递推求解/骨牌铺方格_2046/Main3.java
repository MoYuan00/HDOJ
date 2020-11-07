package 递推求解.骨牌铺方格_2046;

import java.util.Scanner;

/**
 * 
 * f1 = 1
 * f2 = 2
 * f3 = 3
 * f4 = 5
 * ... 
 * fn = f(n-1) + f(n - 2)
 * (fn-1, fn-2)((0 1)(1, 0)) = (fn-1, fn)/// 矩阵乘法
 * @author Rnti
 *
 */
public class Main3 {
	// 用递归
	static long cache[] = new long[51];
	public static long fn(int n) {
		if(n == 0) return 1;
		if(n == 1) return 1;
		if(cache[n] != 0) return cache[n];
		return cache[n] = fn(n - 1) + fn(n - 2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			System.out.println(fn(N));
		}
		sc.close();
	}
}
