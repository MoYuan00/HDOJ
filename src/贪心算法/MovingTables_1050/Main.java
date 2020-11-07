package 贪心算法.MovingTables_1050;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将桌子从i移动到j 需要花费10分钟
 * 同时可以移动多个桌子，但是每个移动的区间，i，j不能有重叠
 * 问最少需要多少时间
 * 
 * 分析： 对于每一次移动 都是一个最优工作安排表，以j最小为前提 选取一系列不重复的 序列。
 *      然后将这些序列删除，
 *      重复移动，直到没有桌子
 * 
 * @author Rnti
 *
 */
public class Main {
	
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
			Table[] tables = new Table[N];
			for(int i = 0; i < N; i++) 
				tables[i]  = new Table(sc.nextInt(), sc.nextInt());
			Arrays.sort(tables);
			int count[] = new int[401];// 记录每个房间被占用次数 265MS	10156K
			for(int i = 0; i < N; i++) {
				for(int j = tables[i].sT; j <= tables[i].eT; j++) {
					count[j]++;// 占用
				}
			}
			int maxCount = 0;// 找占用最大值
			for(int i = 0; i <= 400; i++) {
				if(maxCount < count[i]) maxCount = count[i];
			}
			System.out.println(maxCount * 10);
		}
		sc.close();
	}
}
