package 二分匹配及应用.匈牙利算法MachineSchedule_1150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 二分图的最大匹配算法
 * 匈牙利算法实现
 * @author Rnti
 *
 */
public class BGraphMatch邻接表 {
	private static class BGraphMatch_{
		private List<Integer> edges[];// 邻接表
		private int X; // 左边顶点的数量
		private int Y; // 右边顶点的数量
		private int match[];			// 右边顶点集合对应的左侧元素
		private boolean visited[];// 记录右侧顶点是否已经被访问过了- 在一次遍历（寻找增广路径时
		/**
		 * 
		 * @param map 邻接矩阵
		 * @param left 左边顶点的集合
		 * @param right 右边顶点的集合
		 */
		public BGraphMatch_(List<Integer> map[], int M, int N) {
			this.edges = map;
			this.X = M;
			this.Y = N;
			match = new int[Y];
			for(int i = 0; i < Y; i++)
				match[i] = -1;
			visited = new boolean[Y];
		}
		/**
		 * 获取当前二分图的最大匹配值
		 * @return
		 */
		
		public int getMaxMatch() {
			int count = 0;
			for(int x = 0; x < X; x++) {
				for(int j = 0; j < Y; j++) // visited 清0
					visited[j] = false;
				if(find(x)) 	// 如果当前左边顶点匹配, 匹配值加一
					count++;
			}
			return count;
		}
		/**
		 * 在右边集合中找到能与a的匹配的点，或者一条增广路径并记录新匹配的值
		 * @param a
		 * @param visited
		 * @param rightToLeft
		 * @return
		 */
		private boolean find(int x) {
			for(int i = 0, len = edges[x].size(); i < len; i++) {// 在右边集合中寻找一个没有匹配过的点进行匹配
				int y = edges[x].get(i);
				if(!visited[y]) {// 如果没有访问过，且有边
					visited[y] = true;// 访问，防止出现回路
					// 如果当前右边集合点y没有匹配过, 或者能够匹配成功（最后能找到一个没有匹配的右边集合点 - M-交错路径
					if(match[y] < 0 || find(match[y])) {
						match[y] = x;// 记录当前新的匹配值
						return true;// 匹配成功
					}
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int X = sc.nextInt();// A机器
			if(X == 0) break;
			int Y = sc.nextInt();// B机器
			int K = sc.nextInt();// 任务数
			List<Integer> map[] = new List[X];// 邻接矩阵
			for(int i = 0; i < X; i++)
				map[i] = new ArrayList<Integer>(); 
			for(int i = 0; i < K; i++) {
				int mi = sc.nextInt();
				int Ai = sc.nextInt();// Ai
				int Bi = sc.nextInt();// Bi
				if(Ai == 0 || Bi == 0) continue;// 有状态0不需要建边
				map[Ai].add(Bi);// 添加一条边
			}
			int n = new BGraphMatch_(map, X, Y).getMaxMatch();
			System.out.println(n);
		}
		sc.close();
	}
}
