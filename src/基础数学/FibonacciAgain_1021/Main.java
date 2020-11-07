package 基础数学.FibonacciAgain_1021;

import java.util.Scanner;

/**
 * There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).
 * 
 * output:
 * Print the word "yes" if 3 divide evenly into F(n).
   Print the word "no" if not.
 * @author Rnti
 * 分析：一个数被3整除，那么它自己的各个位数的和也一定被3整除（12 -> 1 + 2 = 3， 27 -> 2 + 7 = 9）
 * 由 (a+b)%m = (a%m + b%m)%m -> 一个数模3只有3种情况 为0， 1，2
 * 而两个数模3，相加模3为0 只有3种组合 为(0,0),(1, 2), (2, 1)
 * 则
 * F(0) = 1
 * F(1) = 2
 * F(2) = 0
 * F(3) = 2
 * F(4) = 2
 * F(5) = 1
 * F(6) = 0
 * F(7) = 1
 * 
 * F(8) = 1  // 到这里出现重复序列，规律为没8个数循环，则 n%8 = 2 or 6时 可以被3整除， 也即 (n + 2)%4 = 0
 * F(9) = 2  // 为什么我们知道这里后面就会出现周期性，那是应为 f(n)只依赖于前两项，如果前两项重复，则表明出现周期
 * F(10) = 0
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if((n + 2) % 4 == 0) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		sc.close();
	}
}
