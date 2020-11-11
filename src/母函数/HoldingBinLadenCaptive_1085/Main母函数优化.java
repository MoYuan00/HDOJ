package ĸ����.HoldingBinLadenCaptive_1085;

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
public class Mainĸ�����Ż� {
	/**
	 * �Ż�ĸ����������������ٶȱ���ͨ�������� ���ڴ˷�����Ҫ���㵽���Nֵ������ͨ��������ÿ�ζ����㵽N
	 * ����ĸ������չ��
	 * @param counts
	 * @return
	 */
	public static int generationFunction(int counts[]) {
		int values[] = {0, 1, 2, 5};// ��ֵ
		int N = 0;// (1 + 2 + 5) * 1000;// ����ƴ����ֵ8000
		for(int i = 1; i <= 3; i++)
			N += values[i] * counts[i];
		
		int pn1[] = new int[N + 1];// ��ʼ��pn1
		for(int i = 0, c = 0; i <= N && c <= counts[1]; i++,c++)
			pn1[i] = 1;
		int pn2[] = new int[N + 1];// ��ʼ��pn2
		
		for(int i = 2; i <= 3; i++) {
			// ����2 ��5��ֵ�����У������
			for(int k = 0, count = 0; k <= N && count <= counts[i]; k += values[i], count++) {
				for(int n1 = 0; n1 + k <= N; n1++) {
					pn2[k + n1] += pn1[n1];
				}
			}
			// �ֻ���pn1��¼�⣬pn2��0
			for(int j = 0; j <= N; j++) {
				if(pn2[j] != 0)// �������������ԣ����ü�¼������֪�����Դճ�����
					pn1[j] = 1;
				else pn1[j] = 0;
				pn2[j] = 0;// pn2��0
			}
		}
		int i = 0;// �ҳ���һ��Ϊ0�ģ�Ҳ�����޷��ճ��ı�ֵ
		while(i <= N && pn1[i] != 0) i++;
		return i;
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
