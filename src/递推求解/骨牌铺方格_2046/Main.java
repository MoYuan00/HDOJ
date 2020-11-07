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
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			long a = 0, b = 1;
			long fn = a + b;
			for(int i = 1; i <= N; i++) {
				fn = a + b;
				a = b;
				b = fn;
			}
			System.out.println(fn);
		}
		sc.close();
	}
}
