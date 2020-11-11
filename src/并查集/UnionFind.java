package 并查集;

/**
 * 并查集抽象类
 * @author Rnti
 *
 */
public abstract class UnionFind {
	/**
	 * 查找x所在集合的父链接（所在集合的根
	 * @param x
	 * @return
	 */
	public abstract int find(int x);
	/**
	 * 查询a，b集合是否在同一个集合中
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean connected(int a, int b) {
		return find(a) == find(b);
	}
	/**
	 * 合并两个集合a，b
	 * @param a
	 * @param b
	 */
	public abstract void union(int a, int b);
}
