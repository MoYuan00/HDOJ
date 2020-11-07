package ������ѧ.FibonacciAgain_1021;

import java.util.Scanner;

/**
 * There are another kind of Fibonacci numbers: F(0) = 7, F(1) = 11, F(n) = F(n-1) + F(n-2) (n>=2).
 * 
 * output:
 * Print the word "yes" if 3 divide evenly into F(n).
   Print the word "no" if not.
 * @author Rnti
 * ������һ������3��������ô���Լ��ĸ���λ���ĺ�Ҳһ����3������12 -> 1 + 2 = 3�� 27 -> 2 + 7 = 9��
 * �� (a+b)%m = (a%m + b%m)%m -> һ����ģ3ֻ��3����� Ϊ0�� 1��2
 * ��������ģ3�����ģ3Ϊ0 ֻ��3����� Ϊ(0,0),(1, 2), (2, 1)
 * ��
 * F(0) = 1
 * F(1) = 2
 * F(2) = 0
 * F(3) = 2
 * F(4) = 2
 * F(5) = 1
 * F(6) = 0
 * F(7) = 1
 * 
 * F(8) = 1  // ����������ظ����У�����Ϊû8����ѭ������ n%8 = 2 or 6ʱ ���Ա�3������ Ҳ�� (n + 2)%4 = 0
 * F(9) = 2  // Ϊʲô����֪���������ͻ���������ԣ�����ӦΪ f(n)ֻ������ǰ������ǰ�����ظ����������������
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
