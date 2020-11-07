package ���鼯.��С������Kruskal;

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
			};// �߼���
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];// ����Ȩֵ����
			}
		});// ���ȶ���
		// �����б���ӵ�������
		for(int i = 0, len = edges.length; i < len; i++) 
			queue.add(edges[i]);
		
		int n = 6;// �������
		int set[] = new int[n + 1];// ���岢�鼯��
		for(int i = 0; i <= n; i++)// ����ʼ��
			set[i] = i;
		
		int edgeSumLength = 0;// ��¼��������ȫ���ߵĳ��ȵĺ�
		for(int i = 1; i <= n - 1; ) {// ����С�������� ��n-1�����
			int edge[] = queue.poll(); // ��ȡ����ͷ������
			int len = edge[2];
			int a = edge[0]; int b = edge[1];
			if(find(a, set) != find(b, set)) {// û�г��ֻ�·������һ�������У�
				// �����߿�ѡ�� �������㼯�Ϻϲ�
				merge(a, b, set);
				edgeSumLength += len;
				i++;
			}
		}
		System.out.println(edgeSumLength);
	}
	/**
	 * ��ѯx�ĸ���㣬��ѹ��·��
	 * @param x
	 * @param set
	 * @return
	 */
	public static int find(int x, int []set) {
		if(x == set[x])
			return x;
		return set[x] = find(set[x], set);// ѹ��·��
	}
	/**
	 * �ϲ�
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
