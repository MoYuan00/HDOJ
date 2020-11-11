package 二分匹配及应用.匈牙利算法MachineSchedule_1150;

import java.util.Scanner;

/**
 * 二分图的最大匹配算法
 * 匈牙利算法实现
 * @author Rnti
 *
 */
public class BGraphMatch邻接矩阵 {
	private static boolean edges[][];
	private static int N; // 左边顶点的数量
	private static int M; // 右边顶点的数量
	private static int match[] = new int[1001];			// 右边顶点集合对应的左侧元素
	private static boolean visited[] = new boolean[1001];// 记录右侧顶点是否已经被访问过了- 在一次遍历（寻找增广路径时
	public static int getMaxMatch() {
		for(int i = 0; i <= M; i++)
			match[i] = -1;
		int count = 0;
		for(int x = 0; x < N; x++) {
			for(int j = 0; j <= M; j++) // visited 清0
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
	private static boolean find(int x) {
		for(int y = 1; y < M; y++) {// 在右边集合中寻找一个没有匹配过的点进行匹配
			if(!visited[y] && edges[x][y]) {// 如果没有访问过，且有边
				visited[y] = true;// 访问，防止出现回路
				// 如果当前右边集合点y没有匹配过, 或者能够匹配成功（最后能找到一个没有匹配的右边集合点 - M-交错路径
				if(match[y] == -1 || find(match[y])) {
					match[y] = x;// 记录当前新的匹配值
					return true;// 匹配成功
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			N = sc.nextInt();// A机器
			if(N == 0) break;
			M = sc.nextInt();// B机器
			int K = sc.nextInt();// 任务数
			edges = new boolean[207][207];
			for(int i = 0; i < K; i++) {
				sc.nextInt();
				int Ai = sc.nextInt();// Ai
				int Bi = sc.nextInt();// Bi
				if(Ai == 0 || Bi == 0) continue;// 有状态0不需要建边
				edges[Ai][Bi] = true;// 添加一条边
			}
			System.out.println(getMaxMatch());
		}
		sc.close();
	}
}
