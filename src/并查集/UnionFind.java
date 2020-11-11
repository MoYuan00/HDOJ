package ���鼯;

/**
 * ���鼯������
 * @author Rnti
 *
 */
public abstract class UnionFind {
	/**
	 * ����x���ڼ��ϵĸ����ӣ����ڼ��ϵĸ�
	 * @param x
	 * @return
	 */
	public abstract int find(int x);
	/**
	 * ��ѯa��b�����Ƿ���ͬһ��������
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean connected(int a, int b) {
		return find(a) == find(b);
	}
	/**
	 * �ϲ���������a��b
	 * @param a
	 * @param b
	 */
	public abstract void union(int a, int b);
}
