package 并查集;

/**
 * 并查集-快速合并
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
		while(x != set[x])// 循环查找到父节点
			x = set[x];
		return x;
	}
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;
		set[fa] = fb;// 合并父节点（就合并了集合中所有元素
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
