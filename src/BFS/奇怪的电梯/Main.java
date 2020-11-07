package BFS.奇怪的电梯;

import java.util.LinkedList;
import java.util.Queue;

/**
有一个奇怪的电梯，他可以停在任何一层，并且在每个楼层有一个Ki（0 <= Ki <= N）。
电梯只有两个按钮：上、下。当你在第i层，如果你按下“UP”按钮，你将上升Ki层，也就是说，你将会到达第i+Ki层，
如果你按下“DOWN”按钮，你会下降 Ki层，即您将前往第i-Ki层。当然，电梯不能高于N，也不能低于1。
例如，
有5层的建筑物，并且k1=3，k2=3，k3=1，k4=2，k5=5。从1楼开始，
你可以按下“UP”按钮，你会到4楼，但如果你按下“DOWN”按钮，电梯不做处理，因为它不能下到-2楼。
问：当你在A楼而想去B楼时，至少须按下“UP”或“DOWN”按钮多少次？ 其中，1 <= N,A,B <= 200

 * @author Rnti
 * 分析：
 * 每层楼都可以 按下K[1..n],
 * 如果要按最少， 也即 树的深度最少
 * 1. DFS 搜索（回溯法， 可优化 需要记录当前楼层是否已经达到过。 不适合解此问题，如果一直按某个按钮 找不到解的几率很大。而且并不能一次找到最优解
 * 2. BFS 搜索，   可优化 需要记录当前楼层是否已经达到过         。。  由于搜索是层层递进的，第一次找到的解一定是最优解
 * // BFS适合找最优解，DFS适合剪枝搜索所有解
 */
public class Main {
	public static void main(String[] args) {
		int K[] = new int[] {3, 3, 1, 2, 5};
		int kLen = K.length;
		int N = 5;// 楼高
		int A = 1;// 当前楼层
		int B = 5;
		// BFS
		Queue<int[]> queue = new LinkedList<int[]>();// 存放当前楼层和按下按钮次数
		queue.add(new int[] {A, 0});
		while(!queue.isEmpty()) {
			int [] node = queue.poll();
			if (node[0] == B) {// 到达楼层
				System.out.println(node[1]);
				break;
			}
			for(int i = 0; i < kLen; i++) {// 生成下一个可能的所有状态，（在当前楼层按下所有按钮
				if(node[0] + K[i] <= N)
					queue.add(new int[] {node[0] + K[i], node[1] + 1});
				if(node[0] - K[i] > 0)
					queue.add(new int[] {node[0] - K[i], node[1] - 1});
			}
		}
	}
}
