package 二分匹配及应用.DAG图的最小路径覆盖AirRaid_1151;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 匈牙利算法 {
	
	/**
	 * 有向无环图 的最小路径覆盖数=(顶点个数 - 二分图的最大匹配)
	 * @author Rnti
	 *
	 */
	static class DAGMatch{
		private List<Integer>[] edges;// 邻接表
		private int xN; // x点集合的 顶点个数
		private int yN; // y点集合的 顶点个数
		private boolean visited[];
		private int yMatch[]; // 顶点匹配值
		
		public DAGMatch(List<Integer>[] edges) {
			this.edges = edges;
			this.xN = edges.length - 1;
			this.yN = xN;
			yMatch = new int[this.xN + 1];
			for(int i = 1; i <= this.yN; i++)
				yMatch[i] = -1;
			visited = new boolean[this.yN + 1];
		}
		public int getMaxMatchCount() {
			int count = 0;// 匹配数
			for(int x = 1; x <= xN; x++) {
				for(int v = 1; v <= yN; v++)// 清0
					visited[v] = false;
				if(match(x))
					count++;
			}
			return this.xN - count;// 有向无环图 的最小路径覆盖数=(顶点个数 - 二分图的最大匹配)
		}
		/**
		 * 匹配x
		 * @param x
		 * @return
		 */
		private boolean match(int x) {
			for(Integer y : edges[x]) {
				if(!visited[y]) {// 未访问过
					visited[y] = true;
					if(yMatch[y] < 0) {// 未匹配
						yMatch[y] = x;// 匹配
						return true;
					}else if(match(yMatch[y])) {// 如果能够找到增广路径
						yMatch[y] = x;// 匹配
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 几组数据
		for(int i = 0; i < N; i++) {
			int cityCount = sc.nextInt(); // 城市个数
			int streetCount = sc.nextInt(); // 街道个数
			List[] edges = new List[cityCount + 1];// 邻接表
			for(int s = 1; s <= cityCount; s++) 
				edges[s] = new ArrayList<Integer>();
			for(int s = 0; s < streetCount; s++)
				edges[sc.nextInt()].add(sc.nextInt());
			System.out.println(new DAGMatch(edges).getMaxMatchCount());
		}
		sc.close();
	}
}
