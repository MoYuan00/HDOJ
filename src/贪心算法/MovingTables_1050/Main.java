package ̰���㷨.MovingTables_1050;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �����Ӵ�i�ƶ���j ��Ҫ����10����
 * ͬʱ�����ƶ�������ӣ�����ÿ���ƶ������䣬i��j�������ص�
 * ��������Ҫ����ʱ��
 * 
 * ������ ����ÿһ���ƶ� ����һ�����Ź������ű���j��СΪǰ�� ѡȡһϵ�в��ظ��� ���С�
 *      Ȼ����Щ����ɾ����
 *      �ظ��ƶ���ֱ��û������
 * 
 * @author Rnti
 *
 */
public class Main {
	
	static class Table implements Comparable<Table>{
		public int sT;
		public int eT;
		public Table(int sT, int eT) {// ������ ��ʼ�����п��ܴ��ڽ���������,   ������
			// ���ڷ��䲼��Ϊ 1  3  5  7
			/// / /       2  4  6  8/// 1�� ��2->4��Ҳ��ռ��1��2��3��4.���������������Ϊż������ô��һ. 2����2->3Ҳ��ռ��1��2��3��4�� ��������ﵽ����Ϊ����,��һ
			if(sT > eT) {// ������ ��ʼ�����п��ܴ��ڽ���������
				this.sT = eT; this.eT = sT;
			}else {
				this.sT = sT; this.eT = eT;
			}
			if((this.sT & 1) == 0) this.sT--;
			if((this.eT & 1) == 1) this.eT++;
		}
		public int compareTo(Table o) {
			return this.eT - o.eT;
		};
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// �����������
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			Table[] tables = new Table[N];
			for(int i = 0; i < N; i++) 
				tables[i]  = new Table(sc.nextInt(), sc.nextInt());
			Arrays.sort(tables);
			int count[] = new int[401];// ��¼ÿ�����䱻ռ�ô��� 265MS	10156K
			for(int i = 0; i < N; i++) {
				for(int j = tables[i].sT; j <= tables[i].eT; j++) {
					count[j]++;// ռ��
				}
			}
			int maxCount = 0;// ��ռ�����ֵ
			for(int i = 0; i <= 400; i++) {
				if(maxCount < count[i]) maxCount = count[i];
			}
			System.out.println(maxCount * 10);
		}
		sc.close();
	}
}
