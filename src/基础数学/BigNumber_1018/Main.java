package ������ѧ.BigNumber_1018;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// ��һ������ʮ����λ�� log10(a) ����ʾ�ж��ٸ�10��ˣ�������ȡ������
		// log10(12*13) = log10(12) + log10(13)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			double sumDigits = 1;// ��¼λ��
			while(k > 0) {// �Զ�����
				sumDigits += Math.log10(k);
				k--;
			}
			System.out.println((int)sumDigits);
		}
		sc.close();
	}
}
