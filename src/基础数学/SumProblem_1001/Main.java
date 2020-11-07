package »ù´¡ÊýÑ§.SumProblem_1001;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static long func1(int n) {
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	public static long func2(int n) {
		if((n & 1) == 0) return (n >> 1) * (n + 1);
		else return ((n + 1)>> 1) * n;
	}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(func2(n) + "\n");
		}
		sc.close();
	}
}
