package 母函数.HoldingBinLadenCaptive_1085;

import java.util.Arrays;
import java.util.Scanner;

/**
“Given some Chinese Coins (硬币) (three kinds-- 1, 2, 5), 
and their number is num_1, num_2 and num_5 respectively, 
please output the minimum value that you cannot pay with given coins.”
 * @author Rnti
 母函数
 values[1..3] 表示币值1,2,5
 counts[1..3] 表示每个币值的最大个数
则：
 values[1]=1: (1 + x + x^2 + ..) 共counts[1]项
 values[2]=3: (1 + x^2 + x^4 + ..) 共counts[2]项
 values[3]=5: (1 + x^5 + ..) 共counts[3]项
母函数: g(x) = (1 + x + x^2 + ..) * (1 + x^2 + x^4 + ..) * (1 + x^5 + ..)
 */
public class Main母函数 {
	/**
	 * 生成一个多项式
	 * @param count 当前币值个数
	 * @param k 币值
	 * @return
	 */
	public static int[] getPn(int count, int k) {
		int pn[] = new int[k * count + 1];// 当前币值个数*币值+1，也就是多项式项数
		for(int i = 0, c = 0;c <= count; i += k, c++) {
			pn[i] = 1; 
		}
		return pn;
	}
	/**
	 * 构建母函数并展开
	 * @param counts
	 * @return
	 */
	public static int generationFunction(int counts[]) {
		int N = (1 + 2 + 5) * 1000;// 最大可拼出币值8000
		int values[] = {0, 1, 2, 5};
		int pn1[] = getPn(counts[1], values[1]);
		for(int i = 2; i <= 3; i++) {
			int pn2[] = getPn(counts[i], values[i]);
			pn1 = pnMult(pn1, pn2);
		}
		int len = pn1.length;
		int i = 0;// 找出第一个为0的，也就是无法凑出的币值
		while(i < len && pn1[i] != 0) i++;
		return i;
	}
	/**
	 * 变异矩阵乘法
	 * @param pn1
	 * @param pn2
	 * @return
	 */
	public static int[] pnMult(int pn1[], int pn2[]) {
		int len1 = pn1.length;
		int len2 = pn2.length;
		int pn[] = new int[len1 + len2 - 1];
		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				if(pn1[i] != 0 && pn2[j] != 0)
					pn[i + j] = 1;// 不需要乘出来， 题目不算种数，只算存在就可以
			}
		}
		return pn;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int nums[] = new int[4];// 各个币值的数量
			for(int i = 1; i <= 3; i++)
				nums[i] = sc.nextInt();
			if(nums[1] == 0 && nums[2] == 0 && nums[3] == 0) break;
			System.out.println(generationFunction(nums));
		}
		sc.close();
	}
}
