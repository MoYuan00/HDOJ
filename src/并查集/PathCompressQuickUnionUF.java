package ���鼯;

/**
 * ���鼯-���ٺϲ���·��ѹ����
 * @author Rnti
 *
 */
public class PathCompressQuickUnionUF extends UnionFind {
	private int set[];
	public PathCompressQuickUnionUF(int N) {
		this.set = new int[N + 1];
		for(int i = 1; i <= N; i++)
			set[i] = i;
	}
	/**
	 * ÿ�β��Ҳ���ִ��ʱ����������·���ϵĽ�㣬ȫ��ָ�򸸽ڵ�
	 * ʱ�临�Ӷȣ�С��O(lgN)
	 */
	@Override
	public int find(int x) {
		int r = x;
		while(r != set[r])// �ҵ����ڵ�
			r = set[r];
		// ������·���ϵĽ��ȫ��ֱ��ָ�򸸽ڵ�
		int leaf = x;
		while(leaf != r) {
			int root = set[leaf];// ��ʱ����
			set[leaf] = r;// ֱ��ָ�򸸽ڵ�
			leaf = root;// ������·���ϵĵ����
		}
		return r;
	}
	/**
	 * ʱ�临�Ӷȣ�O(lgN)��δ�ﵽO(1)
	 */
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;// �Ѿ���һ�������оͲ�������
		set[fa] = fb;
	}
	public static void main(String[] args) {
		UnionFind unionFind = new PathCompressQuickUnionUF(10);
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
