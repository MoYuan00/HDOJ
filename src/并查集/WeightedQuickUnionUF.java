package 并查集;

/**
 * 并查集-加权（根据深度）快速合并
 * @author Rnti
 *
 */
public class WeightedQuickUnionUF extends UnionFind {
	private int set[];
	private int size[]; // 每个结点的深度
	public WeightedQuickUnionUF(int N) {
		this.set = new int[N + 1];
		for(int i = 1; i <= N; i++)
			set[i] = i;
		this.size = new int[N + 1];
		for(int i = 1; i <= N; i++)// 初始化结点深度
			size[i] = 1;
	}
	
	@Override
	public int find(int x) {
		while(x != set[x])
			x = set[x];
		return x;
	}
	/**
	 * 将深度较小的集合 合并到较大集合中
	 * 使得树的深度为logN,优化了查找
	 */
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return;
		if(size[fa] < size[fb]) {// 将深度较小的集合 合并到较大集合中
			set[fa] = fb; 
			size[fa] += size[fb];
		}else {
			set[fb] = fa; 
			size[fb] += size[fa];
		}
	}
	public static void main(String[] args) {
		UnionFind unionFind = new WeightedQuickUnionUF(10);
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
