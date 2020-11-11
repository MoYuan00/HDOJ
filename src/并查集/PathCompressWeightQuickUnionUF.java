package 并查集;

/**
 * 并查集-路径压缩加权快速合并版。 是最优算法
 * @author Rnti
 *
 */
public class PathCompressWeightQuickUnionUF extends UnionFind {
	private int set[];
	private int size[];// 记录结点的深度
	public PathCompressWeightQuickUnionUF(int N) {
		this.set = new int[N + 1];
		for(int i = 1; i <= N; i++)// 初始化集合
			set[i] = i;
		this.size = new int[N + 1];
		for(int i = 1; i <= N; i++)// 初始化结点深度
			size[i] = 1;
	}
	/**
	 * 将查找路径上的结点全部指向根结点
	 * 时间复杂度：均摊复杂度非常非常接近O(1)
	 */
	@Override
	public int find(int x) {
		int fx = x;
		while(fx != set[fx])// 查找根结点
			fx = set[fx];
		
		int leaf = x;// 将查找路径上的结点全部指向根结点
		while(leaf != fx) {
			int root = set[leaf];
			set[leaf] = fx;// 将查找路径上的结点全部指向根结点
			leaf = root;
		}
		return fx;
	}
	/**
	 * 将深度较小的合并到较大的树上.
	 * 时间复杂度：均摊复杂度非常非常接近O(1)
	 */
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;
		if(size[fa] < size[fb]) {// 将深度较小的合并到较大的树上.
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
