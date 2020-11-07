package DFS.全排列;

public class Main {
	
	/**
	 * 全排列
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
		for(int i = 1; i <= N; i++) {// 枚举每种可能的情况
			if(!visited[i]) {// 如果当前数字没有选中
				visited[i] = true;// 选中
				nums[n] = i;
				dfs1(nums, visited, n + 1, N);// 生成 2-n的排列
				visited[i] = false;// 取消选中（回溯
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
