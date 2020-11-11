package ���鼯;

/**
 * ���鼯-·��ѹ����Ȩ���ٺϲ��档 �������㷨
 * @author Rnti
 *
 */
public class PathCompressWeightQuickUnionUF extends UnionFind {
	private int set[];
	private int size[];// ��¼�������
	public PathCompressWeightQuickUnionUF(int N) {
		this.set = new int[N + 1];
		for(int i = 1; i <= N; i++)// ��ʼ������
			set[i] = i;
		this.size = new int[N + 1];
		for(int i = 1; i <= N; i++)// ��ʼ��������
			size[i] = 1;
	}
	/**
	 * ������·���ϵĽ��ȫ��ָ������
	 * ʱ�临�Ӷȣ���̯���Ӷȷǳ��ǳ��ӽ�O(1)
	 */
	@Override
	public int find(int x) {
		int fx = x;
		while(fx != set[fx])// ���Ҹ����
			fx = set[fx];
		
		int leaf = x;// ������·���ϵĽ��ȫ��ָ������
		while(leaf != fx) {
			int root = set[leaf];
			set[leaf] = fx;// ������·���ϵĽ��ȫ��ָ������
			leaf = root;
		}
		return fx;
	}
	/**
	 * ����Ƚ�С�ĺϲ����ϴ������.
	 * ʱ�临�Ӷȣ���̯���Ӷȷǳ��ǳ��ӽ�O(1)
	 */
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;
		if(size[fa] < size[fb]) {// ����Ƚ�С�ĺϲ����ϴ������.
			set[fa] = fb;
			size[fa] += fb;
		}else {
			set[fb] = fa;
			size[fb] += fa;
		}
	}
	public static void main(String[] args) {
		UnionFind unionFind = new PathCompressWeightQuickUnionUF(10);
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
