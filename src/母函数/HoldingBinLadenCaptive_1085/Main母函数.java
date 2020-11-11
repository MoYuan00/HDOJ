package ĸ����.HoldingBinLadenCaptive_1085;

import java.util.Arrays;
import java.util.Scanner;

/**
��Given some Chinese Coins (Ӳ��) (three kinds-- 1, 2, 5), 
and their number is num_1, num_2 and num_5 respectively, 
please output the minimum value that you cannot pay with given coins.��
 * @author Rnti
 ĸ����
 values[1..3] ��ʾ��ֵ1,2,5
 counts[1..3] ��ʾÿ����ֵ��������
��
 values[1]=1: (1 + x + x^2 + ..) ��counts[1]��
 values[2]=3: (1 + x^2 + x^4 + ..) ��counts[2]��
 values[3]=5: (1 + x^5 + ..) ��counts[3]��
ĸ����: g(x) = (1 + x + x^2 + ..) * (1 + x^2 + x^4 + ..) * (1 + x^5 + ..)
 */
public class Mainĸ���� {
	/**
	 * ����һ������ʽ
	 * @param count ��ǰ��ֵ����
	 * @param k ��ֵ
	 * @return
	 */
	public static int[] getPn(int count, int k) {
		int pn[] = new int[k * count + 1];// ��ǰ��ֵ����*��ֵ+1��Ҳ���Ƕ���ʽ����
		for(int i = 0, c = 0;c <= count; i += k, c++) {
			pn[i] = 1; 
		}
		return pn;
	}
	/**
	 * ����ĸ������չ��
	 * @param counts
	 * @return
	 */
	public static int generationFunction(int counts[]) {
		int N = (1 + 2 + 5) * 1000;// ����ƴ����ֵ8000
		int values[] = {0, 1, 2, 5};
		int pn1[] = getPn(counts[1], values[1]);
		for(int i = 2; i <= 3; i++) {
			int pn2[] = getPn(counts[i], values[i]);
			pn1 = pnMult(pn1, pn2);
		}
		int len = pn1.length;
		int i = 0;// �ҳ���һ��Ϊ0�ģ�Ҳ�����޷��ճ��ı�ֵ
		while(i < len && pn1[i] != 0) i++;
		return i;
	}
	/**
	 * �������˷�
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
					pn[i + j] = 1;// ����Ҫ�˳����� ��Ŀ����������ֻ����ھͿ���
			}
		}
		return pn;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int nums[] = new int[4];// ������ֵ������
			for(int i = 1; i <= 3; i++)
				nums[i] = sc.nextInt();
			if(nums[1] == 0 && nums[2] == 0 && nums[3] == 0) break;
			System.out.println(generationFunction(nums));
		}
		sc.close();
	}
}
