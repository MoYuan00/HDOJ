package 二分匹配及应用.最大独立子集GirlsAndBoys_1068;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 最大独立子集 {
	
	static class MaxSubSet{
		private List<Integer>[] edges;
		private int N;
		private int match[];
		private boolean visited[];
		public MaxSubSet(List<Integer>[] edges) {
			this.edges = edges;
			this.N = edges.length;
			this.match = new int[N];
			for(int i = 0; i < N; i++)
				match[i] = -1;
			this.visited = new boolean[N];
		}
		/**
		 * 最大独立子集 = 顶点个数 - 最大匹配数
		 * 最大独立集=所有点数-最大匹配数， 由于没有区分开男女 这一道题的最大匹配数会有重复，所以要除以2
		 *
		 * @return
		 */
		public int getMaxSubSetCount() {
			int count = 0;
			for(int x = 0; x < N; x++) {
				for(int i = 0; i < N; i++)// 清0
					visited[i] = false;
				if(find(x)) count++;// 如果匹配成功
			}
			return N - count / 2;
		}
		public boolean find(int x) {
			for(Integer y : edges[x]) {// 男喜欢女
				if(!visited[y]) {// 女也喜欢男，才算匹配
					visited[y] = true;
					if(match[y] == -1 || find(match[y])) {
						match[y] = x; // 匹配
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int stuCount = sc.nextInt();
			
			List<Integer>[] edges = new List[stuCount];
			for(int i = 0; i < stuCount; i++)
				edges[i] = new LinkedList<Integer>();
			sc.nextLine();// 清空回车
			for(int j = 0; j < stuCount; j++) {
				String line = sc.nextLine();
				String str[] = line.split(":");
				int n = Integer.parseInt(str[0]);// 从哪个顶点出发
				
				String edge[] = str[1].trim().split(" ");// 到哪个顶点
				for(int i = 1, len = edge.length; i < len; i++)
					if(edge[i].length() > 0)
						edges[n].add(Integer.parseInt(edge[i]));// 添加边
			}
			System.out.println(new MaxSubSet(edges).getMaxSubSetCount());
		}
		sc.close();
	}
}
