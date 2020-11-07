package 递推求解.骨牌铺方格_2046;

import java.util.Scanner;

/**
 * 
 * f1 = 1
 * f2 = 2
 * f3 = 3
 * f4 = 5
 * ... 
 * fn = f(n-1) + f(n - 2)
 * (fn-1, fn-2)((0 1)(1, 1)) = (fn-1, fn)/// 矩阵乘法
 * @author Rnti
 * 用矩阵乘法实现, 用矩阵快速幂
 */
public class Main2 {
	/**
	 * Anxs Bsxm
	 * @param A
	 * @param B
	 * @param n
	 * @param s
	 * @param m
	 * @return
	 */
	public static long[][] mMult(long A[][], long B[][], int n, int s, int m) {
		long C[][] = new long[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < s; k++) {
					C[i][j] += + A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}
	/**
	 * 矩阵快速幂 A[][]的N次方
	 * @param A
	 * @param N
	 * @return
	 */
	public static long[][] power(long A[][], int N) {
		long result[][] = {{1, 0}, {0, 1}}; // 单位矩阵 表示0次方
		while(N > 0) {
			if((N & 1) == 1)
				result = mMult(result, A, 2, 2, 2);
			A = mMult(A, A, 2, 2, 2); // A^2
			N >>=1;
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 1 || N == 0) {
				System.out.println(1); continue;
			} 
			if(N == 2) {
				System.out.println(2); continue;
			}
			long fn = mMult(new long[][] {{1, 2}}, power(new long[][] {{0,1},{1, 1}},  N - 2), 1, 2, 2)[0][1];
			System.out.println(fn);
		}
		sc.close();
	}
}
