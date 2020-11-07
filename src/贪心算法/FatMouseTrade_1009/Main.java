package 贪心算法.FatMouseTrade_1009;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Goods implements Comparable<Goods>{
		public int j;// 物品价值
		public int f;// 物品价格
		public Goods(int j, int f) {
			this.j = j; this.f = f;
		}
		@Override
		public int compareTo(Goods o) {
			if(o.f == 0 && this.f == 0) return 0;// 如果有免费的
			if(o.f == 0) return 1;
			if(this.f == 0) return -1;
			double t = (
					((double)this.j / (double)this.f) - ((double)o.j / (double)o.f)
					);// 物品价值/价格比值
			if(t > 0) return -1;// 注意精度，double不能准换成int然后
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
			int M = sc.nextInt();// 钱的数量
			int N = sc.nextInt();// 物品数量
			if(N == -1 && M == -1)
				break;
			Goods goods[] = new Goods[N];
			double T[] = new double[N];
			for(int i = 0; i < N; i++) 
				goods[i] = new Goods(sc.nextInt(), sc.nextInt());
			Arrays.sort(goods);// 由大到小排序
			// 从前面依次选取，直到不能选取为止
			double sum = 0;
			for(int i = 0; i < N; i++) {
				if(goods[i].f == 0) {// 白拿
					sum += goods[i].j;
				}else {
					if(goods[i].f <= M) {// 买下
						sum += goods[i].j;
						M -= goods[i].f;
					} else {// 如果 买不下，就买一部分，然后退出
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
