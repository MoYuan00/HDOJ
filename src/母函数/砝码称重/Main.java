package ĸ����.�������;

import java.util.ArrayList;
import java.util.List;

/**
��1������1�ˡ�2�ˡ�3�ˡ�4�˵������һ ö���ܳƳ��ļ������������м��ֿ��ܷ�����
��ν����������أ����ǹ���ĸ������
�����x��ָ����ʾ�Ƴ�����������
	1��1�˵���������ú���1+x��ʾ��
	1��2�˵���������ú���1+x2��ʾ��
	1��3�˵���������ú���1+x3��ʾ��
	1��4�˵���������ú���1+x4��ʾ,
	��(1 + x)(1 + x^2)(1 + x^3)(1 + x^4)
			= 1 + x+ x^2 + 2x^3 + 2x^4 + 2x^5 + 2x^6 + 2x^7 + x^8 + x^9 + x^10
			������ĺ���֪�����ɳƳ���1�˵�10�ˣ�ϵ�����Ƿ�������
 * @author Rnti
 *
 */
public class Main {
	/**
	 * ��ȡ��1+x^n�η�����ʽ
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
	 * ����ʽ�˷�
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
	 * չ��ĸ������ϵ�����ǽ�
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
