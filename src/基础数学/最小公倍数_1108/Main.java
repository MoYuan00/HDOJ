package ������ѧ.��С������_1108;

import java.util.Scanner;

public class Main {
	// �������
	static int gcd(int m, int n) {
		if(n > m) {
			int t = n; n = m; m = t;// swap
		}
		int r = 0;
		while(n != 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	// ��С������
	static int lcm(int m, int n) {
		return (m * n) / gcd(m, n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) 
			System.out.println(lcm(sc.nextInt(), sc.nextInt()));
		sc.close();
	}
}
