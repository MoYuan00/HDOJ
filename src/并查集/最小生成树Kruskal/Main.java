package 并查集.最小生成树Kruskal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		int edges[][] = 
			{{2, 3, 5}, {2, 1, 6}, {2, 5, 3}, 
					{3, 1, 1}, {3, 5, 6}, {3, 6, 4}, {3, 4, 5},
					{1, 4, 5},
					{4, 6, 2},
					{5, 6, 6}
			};// 边集合
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];// 按边权值排序
			}
		});// 优先队列
		// 将所有边添加到队列中
		for(int i = 0, len = edges.length; i < len; i++) 
			queue.add(edges[i]);
		
		int n = 6;// 顶点个数
		int set[] = new int[n + 1];// 定义并查集，
		for(int i = 0; i <= n; i++)// 并初始化
			set[i] = i;
		
		int edgeSumLength = 0;// 记录生成树的全部边的长度的和
		for(int i = 1; i <= n - 1; ) {// 求最小生成树， 共n-1个结点
			int edge[] = queue.poll(); // 获取到队头并出队
			int len = edge[2];
			int a = edge[0]; int b = edge[1];
			if(find(a, set) != find(b, set)) {// 没有出现回路（不在一个集合中）
				// 这条边可选， 将两顶点集合合并
				merge(a, b, set);
				edgeSumLength += len;
				i++;
			}
		}
		System.out.println(edgeSumLength);
	}
	/**
	 * 查询x的根结点，并压缩路径
	 * @param x
	 * @param set
	 * @return
	 */
	public static int find(int x, int []set) {
		if(x == set[x])
			return x;
		return set[x] = find(set[x], set);// 压缩路径
	}
	/**
	 * 合并
	 * @param a
	 * @param b
	 * @param set
	 */
	public static void merge(int a, int b, int []set) {
		int fa = find(a, set);
		int fb = find(b, set);
		if(fa != fb) set[fa] = fb;
	}
}
