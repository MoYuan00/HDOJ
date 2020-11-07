package DFS.쳲���������;


public class Main {
	
	/**
	 * ��쳲���������
	 * //���ȷ�������ġ��ݹ��������������˹�ģ������һ��
	 * @param n
	 * @return
	 */
	public static int dfs1(int n) {
		if(n == 0) return 1; //��д���ڣ�����ݹ�����������
		if(n == 1) return 1;
		return dfs1(n - 1) + dfs1(n - 2);//��д��ͨ������ݹ飩
	}
	
	/**
	 * ��쳲��������У� ���仯
	 * @param n
	 * @return
	 */
	public static int dp[] = new int[100];
	public static int dfs2(int n) {
		if(n == 0 || n == 1) return 1; //��д���ڣ�����ݹ�����������
		if(dp[n] != 0) return dp[n];
		return dp[n] = dfs1(n - 1) + dfs1(n - 2);//��д��ͨ������ݹ飩
	}
	
	public static void main(String[] args) {
		int n = 20;
		System.out.println(dfs1(n));
		System.out.println(dfs2(n));
	}
}
