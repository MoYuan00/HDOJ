package 母函数.砝码称重;

import java.util.ArrayList;
import java.util.List;

/**
例1：若有1克、2克、3克、4克的砝码各一 枚，能称出哪几种重量？各有几种可能方案？
如何解决这个问题呢？考虑构造母函数。
如果用x的指数表示称出的重量，则：
	1个1克的砝码可以用函数1+x表示，
	1个2克的砝码可以用函数1+x2表示，
	1个3克的砝码可以用函数1+x3表示，
	1个4克的砝码可以用函数1+x4表示,
	则：(1 + x)(1 + x^2)(1 + x^3)(1 + x^4)
			= 1 + x+ x^2 + 2x^3 + 2x^4 + 2x^5 + 2x^6 + 2x^7 + x^8 + x^9 + x^10
			从上面的函数知道：可称出从1克到10克，系数便是方案数。
 * @author Rnti
 *
 */
public class Main {
	/**
	 * 获取倒1+x^n次方多项式
	 * @param n
	 * @return
	 */
	public static int[] get1_xn(int n) {
		int newPn[] = new int[n + 1];
		newPn[0] = 1;
		newPn[n] = 1;
		return newPn;
	}
	/**
	 * 多项式乘法
	 */
	public static int[] pnMult(int pn1[], int pn2[]) {
		int len1 = pn1.length;
		int len2 = pn2.length;
		int newPn[] = new int[len1 + len2 - 1];
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				newPn[i + j] += pn1[i] * pn2[j];
			}
		}
		return newPn;
	}
	/**
	 * 展开母函数，系数就是解
	 */
	public static void GenerationFunction() {
		int[] pn = pnMult(get1_xn(1), pnMult(get1_xn(2), pnMult(get1_xn(3), get1_xn(4))));
		for(int i = 0, len = pn.length; i < len; i++) {
			System.out.print(pn[i] + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		GenerationFunction();
	}
}
