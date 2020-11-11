package 母函数.HoldingBinLadenCaptive_1085;

import java.util.Scanner;

/**
“Given some Chinese Coins (硬币) (three kinds-- 1, 2, 5), 
and their number is num_1, num_2 and num_5 respectively, 
please output the minimum value that you cannot pay with given coins.”
 * @author Rnti
 values[1..3] 表示币值1,2,5
 counts[1..3] 表示每个币值的最大个数

 */
public class Main蛮力减治 {
	/**
	 * 暴力枚举
	 * @param values
	 * @param counts
	 * @return
	 */
	public static int divide(int values[], int counts[]) {
		int result = 0;
		// 直接暴力, true表示当前值可以被凑出
		// 当前币值为1：数量为5，将1，2，3，4，5标记为true
		// 币值为2: 数量为8， 将数组中原本就为true的 1，2，3，4，5加上1个2，2个2。。。8个2也全部标记 . 然后将2，4，6，8，10，12，14，16标记，
		int count = 3;
		boolean pay[][] = new boolean[8001][4];
		for(int numI = 1; numI <= count; numI++) {
			for(int i = 0; i <= 8000; i++) {
				if(pay[i][numI - 1]) {// 将原本为true的，i加上自己的 0.。。k倍全标记
					for(int k = 0; k <= counts[numI]; k++) {
						pay[i + values[numI] * k][numI] = true;
					}
				}
			}
			for(int k = 1; k <= counts[numI]; k++) {// 将自己的倍数标记 将2，4，6，8，10，12，14，16标记，
				pay[values[numI] * k][numI] = true;
			}
		}
		int i = 1;
		while(i <= 8000 && pay[i][3]) i++;
		result = i;
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int values[] = {0, 1, 2, 5};// 币值
		while(sc.hasNextInt()) {
			int counts[] = new int[4];// 各个币值的数量
			for(int i = 1; i <= 3; i++)
				counts[i] = sc.nextInt();
			if(counts[1] == 0 && counts[2] == 0 && counts[3] == 0) break;
			System.out.println(divide(values, counts));
		}
		sc.close();
	}
}
