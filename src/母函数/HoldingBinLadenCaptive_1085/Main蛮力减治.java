package ĸ����.HoldingBinLadenCaptive_1085;

import java.util.Scanner;

/**
��Given some Chinese Coins (Ӳ��) (three kinds-- 1, 2, 5), 
and their number is num_1, num_2 and num_5 respectively, 
please output the minimum value that you cannot pay with given coins.��
 * @author Rnti
 values[1..3] ��ʾ��ֵ1,2,5
 counts[1..3] ��ʾÿ����ֵ��������

 */
public class Main�������� {
	/**
	 * ����ö��
	 * @param values
	 * @param counts
	 * @return
	 */
	public static int divide(int values[], int counts[]) {
		int result = 0;
		// ֱ�ӱ���, true��ʾ��ǰֵ���Ա��ճ�
		// ��ǰ��ֵΪ1������Ϊ5����1��2��3��4��5���Ϊtrue
		// ��ֵΪ2: ����Ϊ8�� ��������ԭ����Ϊtrue�� 1��2��3��4��5����1��2��2��2������8��2Ҳȫ����� . Ȼ��2��4��6��8��10��12��14��16��ǣ�
		int count = 3;
		boolean pay[][] = new boolean[8001][4];
		for(int numI = 1; numI <= count; numI++) {
			for(int i = 0; i <= 8000; i++) {
				if(pay[i][numI - 1]) {// ��ԭ��Ϊtrue�ģ�i�����Լ��� 0.����k��ȫ���
					for(int k = 0; k <= counts[numI]; k++) {
						pay[i + values[numI] * k][numI] = true;
					}
				}
			}
			for(int k = 1; k <= counts[numI]; k++) {// ���Լ��ı������ ��2��4��6��8��10��12��14��16��ǣ�
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
		int values[] = {0, 1, 2, 5};// ��ֵ
		while(sc.hasNextInt()) {
			int counts[] = new int[4];// ������ֵ������
			for(int i = 1; i <= 3; i++)
				counts[i] = sc.nextInt();
			if(counts[1] == 0 && counts[2] == 0 && counts[3] == 0) break;
			System.out.println(divide(values, counts));
		}
		sc.close();
	}
}
