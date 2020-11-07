package ɸѡ��.�ж�����;

import java.util.Arrays;

public class Main {
	/**
	 * �ж�һ�����Ƿ�������
	 * @param n
	 * @return
	 */
	public static boolean isPrimary(int n) {
		for(int i = 2; i < n; i++) 
			if(n % i == 0)  return false; 
		return true;
	}
	
	/**
	 * ��ȡС��n��ȫ������ �����㷨
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
	 * ɸѡ���� �ӽ�2n
	 * ��ȡС��n��ȫ������ ɸѡ��
	 * һ�������ı���һ������������ÿ��ѡһ������n��n*2..n*n�� ����ȥ��
	 * @param n
	 * @return
	 */
	public static int[] getPrimary2(int n) {
		int execCount = 0;// ɸѡ����
		boolean map[] = new boolean[n + 1];
		for(int i = 2, t = (int) Math.sqrt(n); i <= t; i++) { // ����ÿ�ζ���ɸѡ�� i*i���� i<sqrt(n);
			if(map[i] == false) {	// ����
				for(int k = i*2; k <= n; k += i) {// ��n*2..n*n�� ����ȥ��
					map[k] = true;
					execCount++;
				}
			}else {
				execCount++;
			}
		}// ɸѡ����
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
		System.out.println("ɸѡ����:" + execCount);
		return nums;
	}
	
	public static void main(String[] args) {
		int n = 10000000;
//		getPrimary(n);
		getPrimary2(n);
		
	}
}
