package ̰���㷨.FatMouseTrade_1009;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Goods implements Comparable<Goods>{
		public int j;// ��Ʒ��ֵ
		public int f;// ��Ʒ�۸�
		public Goods(int j, int f) {
			this.j = j; this.f = f;
		}
		@Override
		public int compareTo(Goods o) {
			if(o.f == 0 && this.f == 0) return 0;// �������ѵ�
			if(o.f == 0) return 1;
			if(this.f == 0) return -1;
			double t = (
					((double)this.j / (double)this.f) - ((double)o.j / (double)o.f)
					);// ��Ʒ��ֵ/�۸��ֵ
			if(t > 0) return -1;// ע�⾫�ȣ�double����׼����intȻ��
			if(t < 0) return 1;
			return 0;
		}
		@Override
		public String toString() {
			return String.format("%.3f", ((double)this.j / (double) this.f));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int M = sc.nextInt();// Ǯ������
			int N = sc.nextInt();// ��Ʒ����
			if(N == -1 && M == -1)
				break;
			Goods goods[] = new Goods[N];
			double T[] = new double[N];
			for(int i = 0; i < N; i++) 
				goods[i] = new Goods(sc.nextInt(), sc.nextInt());
			Arrays.sort(goods);// �ɴ�С����
			// ��ǰ������ѡȡ��ֱ������ѡȡΪֹ
			double sum = 0;
			for(int i = 0; i < N; i++) {
				if(goods[i].f == 0) {// ����
					sum += goods[i].j;
				}else {
					if(goods[i].f <= M) {// ����
						sum += goods[i].j;
						M -= goods[i].f;
					} else {// ��� ���£�����һ���֣�Ȼ���˳�
						sum += (double) goods[i].j * ((double) M / (double) goods[i].f);
						M = 0;
						break;
					}
				}
			}
			System.out.println(String.format("%.3f", sum));
		}
		sc.close();
	}
}
