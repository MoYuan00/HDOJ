package 母函数.SquareCoins_1398;

import java.util.Arrays;
import java.util.Scanner;

/**
People in Silverland use square coins.
Not only they have square shapes but also their values are square numbers. 
Coins with values of all square numbers up to 289 (=17^2), 
i.e., 1-credit coins, 4-credit coins, 9-credit coins, ..., and 289-credit coins, 
are available in Silverland.

ten 1-credit coins,
one 4-credit coin and six 1-credit coins,
two 4-credit coins and two 1-credit coins, and
one 9-credit coin and one 1-credit coin.
 * @author Rnti
 * 构建母函数
 * g(x) =  (1 + x + x^2 + x^3 + ..) *  : 1^2 = 2
 * 		 (1 + x^4 + x^8 + x^12 + ..) * : 2^2 = 4
 * 			 .... *
 * 		 (1 + x^289)   				   : 17^2 = 289
 *
 */
public class Main尝试优化母函数 {
	/**
	 * 生成母函数的某一项
	 * @param N
	 * @param k
	 * @return
	 */
	public static long[] getPn(int N, int k) {
		long pn[] = new long[N + 1];
		k = k*k;
		for(int j = 0; j <= N; j += k)
			pn[j] = 1;
		return pn;
	}
	/**
	 * 优化母函数计算
	 * @return
	 */
	public static long[] greatGenerationFunction(int N) {
		long pn1[] = getPn(N, 1);// 获取第一项
		long pn2[] = new long[N + 1];// 临时项
		for(int i = 2; i <= N; i++) {// 从第i=2项开始
			int d = i*i;
			// 相乘， 由于乘数为1，改为相加
			for(int n1 = 0; n1 <= N; n1++) {// 
				for(int k = 0; k + n1 <= N; k += d) {
					pn2[n1 + k] += pn1[n1];
				}
			}
			// 轮换 pn1和pn2,使乘法继续。。 回归初始状态，pn1保存结果，pn2临时变量
			for(int j = 0; j <= N; j++) {
				pn1[j] = pn2[j];
				pn2[j] = 0;
			}
		}
		return pn1;
	}
	/**
	 * 优化母函数计算
	 * @return
	 */
	public static long[] greatGenerationFunction2(int N) {
		int elem[] = new int[18];// 存放母函数每一项的增量， 更灵活
		for(int i = 1; i <= 17; i++) 
			elem[i] = i*i;
		long pn1[] = getPn(N, elem[1]);// 获取第一项
		long pn2[] = new long[N + 1];// 临时项
		for(int i = 2; i <= 17; i++) {// 从第i=2项开始 一直到第17项
			// 相乘， 由于乘数为1，改为相加
			for(int k = 0; k <= N; k += elem[i]) {// 使用增量代替每次计算，更加灵活多变
				for(int n1 = 0; n1 + k <= N; n1++) {// 两行互换也可行。 这种更易懂
					pn2[n1 + k] += pn1[n1];
				}
			}
			// 轮换 pn1和pn2,使乘法继续。。 回归初始状态，pn1保存结果，pn2临时变量
			for(int j = 0; j <= N; j++) {
				pn1[j] = pn2[j];
				pn2[j] = 0;
			}
		}
		return pn1;
	}
	/**
	 * 优化母函数计算
	 * @return
	 */
	public static long[] greatGenerationFunction3(int N) {
		int elem[] = new int[18];// 存放母函数每一项的增量， 更灵活
		for(int i = 1; i <= 17; i++) 
			elem[i] = i*i;
		long pn1[] = getPn(N, elem[1]);// 获取第一项
		long pn2[] = new long[N + 1];// 临时项
		for(int i = 2; i <= 17; i++) {// 从第i=2项开始 一直到第17项
			// 相乘， 由于乘数为1，改为相加
			for(int n1 = 0; n1 <= N; n1++) {
				for(int k = 0; k + n1 <= N; k += elem[i]) {// 使用增量代替每次计算，更加灵活多变
					pn2[n1 + k] += pn1[n1];
				}
			}
			// 轮换 pn1和pn2,使乘法继续。。 回归初始状态，pn1保存结果，pn2临时变量
			for(int j = 0; j <= N; j++) {
				pn1[j] = pn2[j];
				pn2[j] = 0;
			}
		}
		return pn1;
	}
	public static void main(String[] args) {
		long pn2[] = greatGenerationFunction2(300);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			System.out.println(pn2[N]);
		}
		sc.close();
	}
}
