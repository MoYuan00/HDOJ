package DFS.ȫ����;

public class Main {
	
	/**
	 * ȫ����
	 * @param nums
	 * @param visited
	 * @param n
	 */
	public static void dfs1(int nums[], boolean visited[], int n, int N) {
		if(n > N) {
			for(int i = 1; i <= N; i++){
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= N; i++) {// ö��ÿ�ֿ��ܵ����
			if(!visited[i]) {// �����ǰ����û��ѡ��
				visited[i] = true;// ѡ��
				nums[n] = i;
				dfs1(nums, visited, n + 1, N);// ���� 2-n������
				visited[i] = false;// ȡ��ѡ�У�����
			}
		}
	}
	public static void main(String[] args) {
		int n = 3;
		int nums[] = new int[n + 1];
		boolean visited[] = new boolean[n + 1];
		dfs1(nums, visited, 1, n);
	}
}
