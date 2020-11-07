package 贪心算法.MovingTables_1050;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 将桌子从i移动到j 需要花费10分钟
 * 同时可以移动多个桌子，但是每个移动的区间，i，j不能有重叠
 * 问最少需要多少时间
 * 
 * 分析： 对于每一次移动 都是一个最优工作安排表，以j最小为前提 选取一系列不重复的 序列。
 *      然后将这些序列删除，
 *      重复移动，直到没有桌子
 * @author Rnti
 *
 */
public class Main2 {
	
	static class Table implements Comparable<Table>{
		public int sT;
		public int eT;
		public Table(int sT, int eT) {// 输入中 开始房间有可能大于结束房间编号,   两个坑
			// 由于房间布局为 1  3  5  7
			/// / /       2  4  6  8/// 1） 从2->4，也会占用1，2，3，4.于是如果出发房间为偶数，那么减一. 2）从2->3也会占用1，2，3，4， 于是如果达到房间为奇数,加一
			if(sT > eT) {// 输入中 开始房间有可能大于结束房间编号
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
		int T = sc.nextInt();// 多组测试用例
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			TreeSet<Table> set = new TreeSet<Table>();// 利用TreeSet排序
			for(int i = 0; i < N; i++) 
				set.add(new Table(sc.nextInt(), sc.nextInt()));
			// 开始移动桌子
			int count = 0;// 记录需要多少轮移动
			while(!set.isEmpty()) {
				Iterator<Table> iter = set.iterator();
				int end = -1;// 结束房间， 每次移动都必须保证房间起始编号大于结束编号
				while(iter.hasNext()) {
					Table table = iter.next();
					if(table.sT > end) {// 移动并删除
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
