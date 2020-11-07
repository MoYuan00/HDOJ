package 递推求解.折线分割平面_2050;

import java.util.Scanner;

/**
		思路：列举找规律
		第0条折线，穿过0条线，多了0个区间；f0 = 1
		第1条折线，穿过0条线，多了1个区间；f1 = 1 + 2*2(1 - 1) + 1  = 2
		第2条折线，穿过2条线，多了5个区间；f2 = f1 + 2*2(2 - 1) + 1  = 7
		第3条折线，穿过4条线，多了9个区间；f3 = f2 + 2*2(3 - 1) + 1  = 16
		第4条折线，穿过6条线，多了13个区间；
		线:2*(n-1) , 多的区间:2*2*(n-1)+1 
		多的区间:  2*2*(n-1)+1 
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
