package ����ƥ�估Ӧ��.DAGͼ����С·������AirRaid_1151;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class �������㷨 {
	
	/**
	 * �����޻�ͼ ����С·��������=(������� - ����ͼ�����ƥ��)
	 * @author Rnti
	 *
	 */
	static class DAGMatch{
		private List<Integer>[] edges;// �ڽӱ�
		private int xN; // x�㼯�ϵ� �������
		private int yN; // y�㼯�ϵ� �������
		private boolean visited[];
		private int yMatch[]; // ����ƥ��ֵ
		
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
			int count = 0;// ƥ����
			for(int x = 1; x <= xN; x++) {
				for(int v = 1; v <= yN; v++)// ��0
					visited[v] = false;
				if(match(x))
					count++;
			}
			return this.xN - count;// �����޻�ͼ ����С·��������=(������� - ����ͼ�����ƥ��)
		}
		/**
		 * ƥ��x
		 * @param x
		 * @return
		 */
		private boolean match(int x) {
			for(Integer y : edges[x]) {
				if(!visited[y]) {// δ���ʹ�
					visited[y] = true;
					if(yMatch[y] < 0) {// δƥ��
						yMatch[y] = x;// ƥ��
						return true;
					}else if(match(yMatch[y])) {// ����ܹ��ҵ�����·��
						yMatch[y] = x;// ƥ��
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// ��������
		for(int i = 0; i < N; i++) {
			int cityCount = sc.nextInt(); // ���и���
			int streetCount = sc.nextInt(); // �ֵ�����
			List[] edges = new List[cityCount + 1];// �ڽӱ�
			for(int s = 1; s <= cityCount; s++) 
				edges[s] = new ArrayList<Integer>();
			for(int s = 0; s < streetCount; s++)
				edges[sc.nextInt()].add(sc.nextInt());
			System.out.println(new DAGMatch(edges).getMaxMatchCount());
		}
		sc.close();
	}
}
