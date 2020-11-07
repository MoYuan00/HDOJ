package ̰���㷨.MovingTables_1050;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * �����Ӵ�i�ƶ���j ��Ҫ����10����
 * ͬʱ�����ƶ�������ӣ�����ÿ���ƶ������䣬i��j�������ص�
 * ��������Ҫ����ʱ��
 * 
 * ������ ����ÿһ���ƶ� ����һ�����Ź������ű���j��СΪǰ�� ѡȡһϵ�в��ظ��� ���С�
 *      Ȼ����Щ����ɾ����
 *      �ظ��ƶ���ֱ��û������
 * @author Rnti
 *
 */
public class Main2 {
	
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
			TreeSet<Table> set = new TreeSet<Table>();// ����TreeSet����
			for(int i = 0; i < N; i++) 
				set.add(new Table(sc.nextInt(), sc.nextInt()));
			// ��ʼ�ƶ�����
			int count = 0;// ��¼��Ҫ�������ƶ�
			while(!set.isEmpty()) {
				Iterator<Table> iter = set.iterator();
				int end = -1;// �������䣬 ÿ���ƶ������뱣֤������ʼ��Ŵ��ڽ������
				while(iter.hasNext()) {
					Table table = iter.next();
					if(table.sT > end) {// �ƶ���ɾ��
						end = table.eT;
						iter.remove();
					}
				}
				count++;
			}
			System.out.println(count * 10);
		}
		sc.close();
	}
}
