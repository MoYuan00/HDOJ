package 并查集.小希的迷宫_1272;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String ans = "Yes";
			int set[] = new int[100001];
			for(int i = 0; i <= 100000; i++)// 初始化并查集
				set[i] = i;
			int maxNode = 0;
			int minNode = Integer.MAX_VALUE;
			boolean isShow[] = new boolean[100001]; // 编号为i的顶点是否出现在图上
			do{
				int A = sc.nextInt();
				int B = sc.nextInt();
				if(A == 0 && B == 0) break;
				if(A == -1 && B == -1) return;
				isShow[A] = isShow[B] = true;// 记录已出现
				maxNode = Math.max(maxNode, Math.max(A, B)); // 记录出现过的最大顶点
				minNode = Math.min(minNode, Math.min(A, B)); // 记录出现过的最小的顶点
				if(find(A, set) == find(B, set))// 如果合并前就以及在一个集合，再合并 就会成环
					ans = "No";
				merge(A, B, set);
				
			}while(true);
//			System.out.println(Arrays.toString(set));
			// 如果是连通图， 只需要检查环路就可以， 但是也可能不连通， 这里需要检查
			int treeCount = 0;
			for(int i = minNode; i <= maxNode; i++) 
				if(set[i] == i && isShow[i]) treeCount++;
			if(treeCount > 1) ans = "No"; // 不是连通的
			System.out.println(ans);
		}
		sc.close();	
	}
	/**
	 * 查找x的根结点 （ 从属于哪个集合， 并压缩路径
	 * @param x
	 * @param set
	 * @return
	 */
	public static int find(int x, int[] set) {
		if(x == set[x])// 找到了根结点
			return x;
		return set[x] = find(set[x], set);// 继续寻找根结点，并且设置当前值 为根节点
	}
	/**
	 * 合并a所在集合和b所在集合
	 * @param a
	 * @param b
	 * @param set
	 */
	public static void merge(int a, int b, int[]set) {
		int fa = find(a, set);
		int fb = find(b, set);
		if(fa != fb)// 如果不从属于一个集合，就合并。 防止出现4->3 合并出现3->3,4->4的错误
			set[fa] = fb;
	}
}
