package ����ƥ�估Ӧ��.�������Ӽ�GirlsAndBoys_1068;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class �������Ӽ� {
	
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
		 * �������Ӽ� = ������� - ���ƥ����
		 * ��������=���е���-���ƥ������ ����û�����ֿ���Ů ��һ��������ƥ���������ظ�������Ҫ����2
		 *
		 * @return
		 */
		public int getMaxSubSetCount() {
			int count = 0;
			for(int x = 0; x < N; x++) {
				for(int i = 0; i < N; i++)// ��0
					visited[i] = false;
				if(find(x)) count++;// ���ƥ��ɹ�
			}
			return N - count / 2;
		}
		public boolean find(int x) {
			for(Integer y : edges[x]) {// ��ϲ��Ů
				if(!visited[y]) {// ŮҲϲ���У�����ƥ��
					visited[y] = true;
					if(match[y] == -1 || find(match[y])) {
						match[y] = x; // ƥ��
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
			sc.nextLine();// ��ջس�
			for(int j = 0; j < stuCount; j++) {
				String line = sc.nextLine();
				String str[] = line.split(":");
				int n = Integer.parseInt(str[0]);// ���ĸ��������
				
				String edge[] = str[1].trim().split(" ");// ���ĸ�����
				for(int i = 1, len = edge.length; i < len; i++)
					if(edge[i].length() > 0)
						edges[n].add(Integer.parseInt(edge[i]));// ��ӱ�
			}
			System.out.println(new MaxSubSet(edges).getMaxSubSetCount());
		}
		sc.close();
	}
}
