package ������ѧ.���ǹ�_1205;

import java.util.Scanner;

/**
 * HOHO�����ڴ�Speakless����Ӯ�������е��ǹ���
 * ��Gardon���ǹ�ʱ�и�������ã����ǲ�ϲ����һ�����ǹ�����һ��ԣ�ϲ���ȳ�һ�֣���һ�γ���һ�֣�������
 * ����Gardon��֪���Ƿ����һ�ֳ��ǹ���˳��ʹ�����ܰ������ǹ������ꣿ����д�������æ����һ�¡�
 * @author Rnti
 *
 */
public class Main {
	// ���� ����ÿ�����ǹ� ���abs(A - B) <= 1,��ô���Գ��꣬�����ܳ���
	// ����: ABA, BAB,  �����ǹ���Ҫô��ͬ��Ҫô��һ��������ÿ���ǹ���������ȥ����
	//  3���ǹ���Ҫô��ͬ��Ҫô��1��,Ҫô��2��
	// �������ֵļ�������Ϊ: 01��12 3��: 010��120��131��241�� 4��: 0100... �����ֵС�ڵ��������������ǹ���+1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			long max = -1;
			long sum = 0;
			for(int j = 0; j < n; j++) {
				long t = sc.nextLong();
				sum += t;
				if(max < t) max = t;
			}
			if(sum - max + 1 >= max) {// ���������ǹ��� + 1 ���� ���ֵ�ǹ�
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		sc.close();
	}
}
