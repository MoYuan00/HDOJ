package 筛选法.判断素数;

import java.util.Arrays;

public class Main {
	/**
	 * 判断一个数是否是素数
	 * @param n
	 * @return
	 */
	public static boolean isPrimary(int n) {
		for(int i = 2; i < n; i++) 
			if(n % i == 0)  return false; 
		return true;
	}
	
	/**
	 * 获取小于n的全部素数 朴素算法
	 * @param n
	 * @return
	 */
	public static int[] getPrimary(int n) {
		int nums[] = new int[n / 2];
		int k = 0;
		int primaryCount = 0;
		for(int i = 2; i <= n; i++) {
			if(isPrimary(i)) {
				nums[k++] = i;
				primaryCount++;
			}
		}
//		System.out.println(Arrays.toString(nums));
		System.out.println(primaryCount);
		return nums;
	}
	
	/**
	 * 筛选次数 接近2n
	 * 获取小于n的全部素数 筛选法
	 * 一个素数的倍数一定不是素数。每次选一个素数n将n*2..n*n的 数据去除
	 * @param n
	 * @return
	 */
	public static int[] getPrimary2(int n) {
		int execCount = 0;// 筛选次数
		boolean map[] = new boolean[n + 1];
		for(int i = 2, t = (int) Math.sqrt(n); i <= t; i++) { // 由于每次都会筛选到 i*i于是 i<sqrt(n);
			if(map[i] == false) {	// 素数
				for(int k = i*2; k <= n; k += i) {// 将n*2..n*n的 数据去除
					map[k] = true;
					execCount++;
				}
			}else {
				execCount++;
			}
		}// 筛选结束
		int nums[] = new int[n / 2];
		int k = 0;
		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(map[i] == false) {
				nums[k++] = i;
				count++;
			}
		}
//		System.out.println(Arrays.toString(nums));
		System.out.println(count);
		System.out.println("筛选次数:" + execCount);
		return nums;
	}
	
	public static void main(String[] args) {
		int n = 10000000;
//		getPrimary(n);
		getPrimary2(n);
		
	}
}
