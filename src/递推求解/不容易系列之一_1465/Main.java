package 递推求解.不容易系列之一_1465;

import java.util.Scanner;

/**
 * 错排问题
 * 某人写了n封信，还有n个信封，如果所有的信都装错了信封，求共有多少种可能的情况？
 * f1 = 0
 * f2 = 1
 * 当有N封信的时候，前面N-1封信可以有N-1或者 N-2封错装
 * f3 1.对于第n封信可以在前n-1封中错排 2.如果前n-1封中有一个没有错排的，那么它与第n封信交换错排,这种情况有n-1次
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
