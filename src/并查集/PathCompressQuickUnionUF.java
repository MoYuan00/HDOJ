package 并查集;

/**
 * 并查集-快速合并的路径压缩版
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
	 * 每次查找操作执行时，都将查找路径上的结点，全部指向父节点
	 * 时间复杂度：小于O(lgN)
	 */
	@Override
	public int find(int x) {
		int r = x;
		while(r != set[r])// 找到父节点
			r = set[r];
		// 将查找路径上的结点全部直接指向父节点
		int leaf = x;
		while(leaf != r) {
			int root = set[leaf];// 临时保存
			set[leaf] = r;// 直接指向父节点
			leaf = root;// 继续对路径上的点操作
		}
		return r;
	}
	/**
	 * 时间复杂度：O(lgN)，未达到O(1)
	 */
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;// 已经在一个集合中就不做操作
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
