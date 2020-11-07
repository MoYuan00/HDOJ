package ������ѧ.NumberSequence_1005;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A number sequence is defined as follows:

	f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
	
	Given A, B, and n, you are to calculate the value of f(n).
 * @author Rnti
 * ����û�ҵ����Թ��ɣ��þ��������������
 * 2. ����һ���� % 7ֻ���� 0,1,2,3,4,5,6 ���ֿ��ܣ���f1 = 1, f2=1,���������������ֳ��� fn=1,f��n-1��=1���������ô���Եõ����е�����Ϊn-2
 *
 */
public class Main {
	// ����˷�
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
	// ������ Ӧ���ھ���
	public static int[][] quickPower(int[][] A, int n, int mod) {
		int result[][] = {{1, 0},
						  {0, 1} };// ��λ����
		while(n > 0) {
			if((n & 1) == 1) 
				result = multiply(result, A, mod);
			n >>= 1;
			if(n == 0) break;
			A = multiply(A, A, mod);
		}
		return result;
	}
	// ��������� �� �� n��
	public static int fn(int A, int B, int n, int mod) {
		int[][] F = {{1, 1}};// f1 = 1, f2 = 1
		int[][] T = { {0, B}, {1, A} };
		T = quickPower(T, n - 2, mod);
		int [][] result = multiply(F, T, mod);
		int fn = result[0][1];
		return fn;
	}
	// ���������n��
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
	// ��ӡ����
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
