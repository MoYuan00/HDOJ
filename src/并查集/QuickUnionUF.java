package ���鼯;

/**
 * ���鼯-���ٺϲ�
 * @author Rnti
 *
 */
public class QuickUnionUF extends UnionFind {
	private int set[];
	public QuickUnionUF(int N) {
		this.set = new int[N + 1];
		for(int i = 1; i <= N; i++)
			set[i] = i;
	}
	@Override
	public int find(int x) {
		while(x != set[x])// ѭ�����ҵ����ڵ�
			x = set[x];
		return x;
	}
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;
		set[fa] = fb;// �ϲ����ڵ㣨�ͺϲ��˼���������Ԫ��
	}
	public static void main(String[] args) {
		UnionFind unionFind = new QuickUnionUF(10);
		unionFind.union(1, 2);
		unionFind.union(2, 1);
		unionFind.union(2, 3);
		unionFind.union(2, 4);
		unionFind.union(4, 8);
		System.out.println(unionFind.connected(1, 2));
		System.out.println(unionFind.connected(2, 4));
		System.out.println(unionFind.connected(3, 8));
	}
}
