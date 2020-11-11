package 母函数.HoldingBinLadenCaptive_1085;

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
public class Main母函数优化 {
	/**
	 * 优化母函数（这种情况下速度比普通方法慢， 由于此方法需要计算到最大N值，而普通方法不必每次都计算到N
	 * 构建母函数并展开
	 * @param counts
	 * @return
	 */
	public static int generationFunction(int counts[]) {
		int values[] = {0, 1, 2, 5};// 币值
		int N = 0;// (1 + 2 + 5) * 1000;// 最大可拼出币值8000
		for(int i = 1; i <= 3; i++)
			N += values[i] * counts[i];
		
		int pn1[] = new int[N + 1];// 初始化pn1
		for(int i = 0, c = 0; i <= N && c <= counts[1]; i++,c++)
			pn1[i] = 1;
		int pn2[] = new int[N + 1];// 初始化pn2
		
		for(int i = 2; i <= 3; i++) {
			// 生成2 和5币值的序列，并相乘
			for(int k = 0, count = 0; k <= N && count <= counts[i]; k += values[i], count++) {
				for(int n1 = 0; n1 + k <= N; n1++) {
					pn2[k + n1] += pn1[n1];
				}
			}
			// 轮换，pn1记录解，pn2清0
			for(int j = 0; j <= N; j++) {
				if(pn2[j] != 0)// 由于问题特殊性，不用记录种数，知道可以凑出就行
					pn1[j] = 1;
				else pn1[j] = 0;
				pn2[j] = 0;// pn2清0
			}
		}
		int i = 0;// 找出第一个为0的，也就是无法凑出的币值
		while(i <= N && pn1[i] != 0) i++;
		return i;
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
