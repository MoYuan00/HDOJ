package 基础数学.NumberSequence_1005;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A number sequence is defined as follows:

	f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
	
	Given A, B, and n, you are to calculate the value of f(n).
 * @author Rnti
 * 这题没找到明显规律，用矩阵快速幂做算了
 * 2. 由于一个数 % 7只存在 0,1,2,3,4,5,6 几种可能，而f1 = 1, f2=1,如果后面的序列中又出现 fn=1,f（n-1）=1的情况，那么可以得到数列的周期为n-2
 *
 */
public class Main {
	// 矩阵乘法
	public static int[][] multiply(int[][] A, int B[][], int mod) {
		int n = A.length;
		int s = B.length;
		int m = B[0].length;
		int result[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < s; k++) {
					result[i][j] = (result[i][j] + (A[i][k] * B[k][j]) % mod) % mod;
				}
			}
		}
		return result;
	}
	// 快速幂 应用于矩阵
	public static int[][] quickPower(int[][] A, int n, int mod) {
		int result[][] = {{1, 0},
						  {0, 1} };// 单位矩阵
		while(n > 0) {
			if((n & 1) == 1) 
				result = multiply(result, A, mod);
			n >>= 1;
			if(n == 0) break;
			A = multiply(A, A, mod);
		}
		return result;
	}
	// 矩阵快速幂 求 第 n项
	public static int fn(int A, int B, int n, int mod) {
		int[][] F = {{1, 1}};// f1 = 1, f2 = 1
		int[][] T = { {0, B}, {1, A} };
		T = quickPower(T, n - 2, mod);
		int [][] result = multiply(F, T, mod);
		int fn = result[0][1];
		return fn;
	}
	// 蛮力法求第n项
	public static int butreFn(int A, int B, int n, int mod) {
		int a[] = new int[n + 1];
		a[1] = 1; a[2] = 1;
		for(int i = 3; i <= n; i++) {
			a[i] = (A*a[i - 1] + B*a[i - 2]) % mod;
			System.out.printf("%d,",a[i]);
		}
		int fn = a[n];
		return fn;
	}
	// 打印矩阵
	public static void show(int [][] A) {
		for(int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	public static void main(String[] args) {
//		int n = 20;// test
//		int A = 13;
//		int B = 22;
//		int mod = 7;
//		butreFn(A, B, n, 7);
//		System.out.println();
//		for(int i = 3; i <= n; i++) {
//			System.out.printf("%d,", fn(A, B, i, mod));
//		}
		
		Scanner sc = new Scanner(System.in);
		int mod = 7;
		while(sc.hasNextInt()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int n = sc.nextInt();
			if(A == 0 && B == 0 && n == 0) break;
			if(n == 1 || n == 2) {
				System.out.println(1); continue;
			}
			System.out.println(fn(A, B, n, mod));
		}
		sc.close();
	}

}
