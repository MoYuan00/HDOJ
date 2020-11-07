package BFS.倒可乐;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
题目描述：
每当刘一丁买了可乐，刘二丁就要求和他一起分享，而且一定要喝的和刘一丁一样多。
但刘一丁的手中只有两个杯子，它们的容量分别是N和M毫升,可乐的体积为S（S<101）毫升(正好装满一瓶) ，
它们三个之间可以相互倒可乐 (都是没有刻度的，且 S==N+M，101＞S＞0，N＞0，M＞0) 。

如果能平分，请输出倒可乐的最少次数，如果不能，请输出"NO"。

Input
7 4 3
4 1 3
0 0 0
Output
NO
3
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int S = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(S == 0)	break;
			int con[] = {S, N, M}; // 容量
			boolean visited[][][] = new boolean[S + 1][N + 1][M + 1];// 记录3杯水的状态 是否已经访问过
			// BSF 搜索， 搜索到的第一个结点一定是解。。。 
			// 由于可能没有解， 需要记录当前已经访问过的所有结点：当前3个位置水的数量
			Queue<int[]> queue = new LinkedList<int[]>();// s n m 水的数量, 倒水次数
			queue.add(new int[] {S, 0, 0, 0}); // 初始结点
			int count = 0;
			while(!queue.isEmpty()) {
				int[] node = queue.poll();
				count++;
				visited[node[0]][node[1]][node[2]] = true;// 访问此状态
				// 判断当前状态是否满足要求
				if(node[0] == node[1] && node[2] == 0 
						|| node[0] == node[2] && node[1] == 0
						|| node[1] == node[2] && node[0] == 0) {// 成功将水分为两半
//					System.out.println(Arrays.toString(node));
					System.out.println(node[3]);
					break;
				}
//				状态转移规则（倒水规则）：
//				如果i水杯内水的容量大于j水杯内倒满所需的容量x，则——i水杯倒水后的容量为：i-x,j水杯倒水后容量为:j+x
//				如果i水杯内水的容量小于等于j水杯内倒满所需的容量x，则——i水杯倒水后的容量为：0,j水杯倒水后容量为:j+i
//				每操作一次，最少倒水次数+1
				// 将所有可能的状态添加进来
//				System.out.println("当前状态: " + Arrays.toString(node));
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						if(i == j) continue;
						if(node[i] == 0) continue;// 没有水就不倒了
						int newNode[] = new int[4];
						for(int k = 0; k < 4; k++)
							newNode[k] = node[k];
						int x = con[j] - node[j];// 剩余容量x
						if(node[i] > x) {
							newNode[i] = node[i] - x;
							newNode[j] = node[j] + x;
						}else {
							newNode[i] = 0;
							newNode[j] = node[j] + node[i];
						}
						// 生成：
//						System.out.println("i:" + i + " j:" + j + " x:" + x);
//						System.out.println(Arrays.toString(newNode));
						if(!visited[newNode[0]][newNode[1]][newNode[2]]) {// 如果没有访问过此状态, 剪枝
							newNode[3]++;// 倒水次数加一
							queue.add(newNode);
						}
					}
				}
			}
			if (queue.isEmpty()) {// 没有找到 平分方法
				System.out.println("NO");
			}
			System.out.println("搜索结点个数为: " + count);
		}
		sc.close();
	}
}
