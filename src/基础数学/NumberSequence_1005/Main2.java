package 基础数学.NumberSequence_1005;

import java.util.Scanner;
/**
 * A number sequence is defined as follows:

	f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
	
	Given A, B, and n, you are to calculate the value of f(n).
 * @author Rnti
 * 2. 由于一个数 % 7只存在 0,1,2,3,4,5,6 几种可能，而f1 = 1, f2=1,如果后面的序列中又出现 fn=1,f（n-1）=1的情况，那么可以得到数列的周期为n-2
 *
 */
public class Main2 {
	/**
	 * 解法2：
	 * 2. 由于一个数 % 7只存在 0,1,2,3,4,5,6 几种可能，而f1 = 1, f2=1,
	 * 如果后面的序列中又出现 fn=1,f（n-1）=1的情况，那么可以得到数列的周期为n-1
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 7;
		int a[] = new int[1001];// 在前1000项中找规律，0-6的排列数不会超过1000
		int T;
		int i;
		while(sc.hasNextInt()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int n = sc.nextInt();
			if(A == 0 && B == 0 && n == 0) break;
			a[1] = 1; a[2] = 1;
			for(i = 3; i <= 1000; i++) {// 找周期 
				a[i] = (A*a[i - 1] + B*a[i - 2]) % mod;
				if(a[i] == 1 && a[i - 1] == 1) // 找到了周期
					break;
			}
			T = i - 2;
			if(n % T == 0) System.out.println(a[T]);// 1 1 0 0 1 1，周期为4，f4 = 0, 由于没有f0, 只有f1..ft,而不是f0...ft-1
			else System.out.println(a[(n % T)]);// 利用周期直接算值
		}
		sc.close();
	}
}
