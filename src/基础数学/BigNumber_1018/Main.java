package 基础数学.BigNumber_1018;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 求一个数的十进制位数 log10(a) （表示有多少个10相乘），向下取整即可
		// log10(12*13) = log10(12) + log10(13)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			double sumDigits = 1;// 记录位数
			while(k > 0) {// 自顶向上
				sumDigits += Math.log10(k);
				k--;
			}
			System.out.println((int)sumDigits);
		}
		sc.close();
	}
}
