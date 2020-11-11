package 并查集;

/**
 * 并查集-快速查找
 * @author Rnti
 *
 */
public class QuickFindUF extends UnionFind {
	private int set[];// 父链接数组
	private int N;
	public QuickFindUF(int N) {
		this.N = N;
		this.set = new int[N + 1];
		for(int i = 1; i <= N; i++)// 初始化并查集
			set[i] = i;
	}
	@Override
	public int find(int x) {
		return set[x];
	}
	@Override
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa == fb) return; // 已经在同一个集合中
		// 不在同一个集合中，将所有b集合的元素全部添加到a集合中
		for(int i = 1; i <= N; i++)
			if(set[i] == fb) set[i] = fa;
	}
	public static void main(String[] args) {
		UnionFind unionFind = new QuickFindUF(10);
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
