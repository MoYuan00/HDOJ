package 初识ACM输入输出格式._1090;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println(sc.nextInt() + sc.nextInt());
		}
		sc.close();
	}
}
