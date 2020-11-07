package BFS.解救丁爸;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
题目大意：
    丁爸被火星人抓走，关在一个N * M矩形的监狱（监狱里有墙壁、道路和警卫队）。
丁爸的学生想拯救他（到达丁爸停留的位置即视为成功）。拯救过程中若遇到警卫，则必须干掉。
假设每次向上，向下，向右，向左移动需要1个单位时间，杀死一个守卫额外需要1个单位时间。 /// 需要额外时间，那么可能导致出队元素所记忆的时间并不是层次递增的..
    请计算：拯救丁爸需要的最短时间。
（每次只能上，下，左，右移动到边界内的邻居网格。）

Sample Input
7 8
#.#####.
#.a#..r.
#..#x...
..#..#.#
#...##..
.#......
........
Sample Output
13

 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Row = sc.nextInt();
		int Col = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[Row][Col];
		for(int i = 0; i < Row; i++) 
			map[i] = sc.nextLine().toCharArray();
		// 输入结束
		// 找学生a的位置
		int startRow = 0;
		int startCol = 0;
		// 找出丁爸r的位置
		int endRow = 0;
		int endCol = 0;
		for(int i = 0; i < Row; i++) 
			for(int j = 0; j < Col; j++) {
				if(map[i][j] == 'a') {
					startRow = i;
					startCol = j;
				}else if(map[i][j] == 'r'){
					endRow = i;
					endCol = j;
				}
			}
		BFS(map, Row, Col, startRow, startCol, endRow, endCol);
		BFS2(map, Row, Col, startRow, startCol, endRow, endCol);
	}
	public static void BFS(char[][] map, final int Row, final int Col, int startRow, int startCol, final int endRow, final int endCol) {
		int count = 0;// 记录搜索结点个数
		int buildCount = 0; // 生成结点的个数
		Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];// 路径短的排在前面
			}
		});// 优先队列
		// 添加visited 记录已经到达过的状态，防止多次搜索
		boolean visited[][] = new boolean[Row][Col];
		
		queue.add(new int[] {startRow, startCol, 0});
		visited[startRow][startCol] = true;
		int dir[][] = {{1, 0},{0, 1},{-1, 0},{0, -1}};// 4个方向
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			count++;
			if(map[node[0]][node[1]] == 'r') {// 找到了第一个解，即最优解
				System.out.println(node[2]); break;
			}
			// 生成所有状态
			for(int i = 0; i < 4; i++) {
				int newRow = node[0] + dir[i][0];
				int newCol = node[1] + dir[i][1];
				if(newRow < 0 || newCol < 0 || newRow >= Row || newCol >= Col) continue;// 限制边界
				if(map[newRow][newCol] == '#') continue;		// 墙壁
				
				if(visited[newRow][newCol]) continue;// 如果已经搜索过这个状态，就跳过
				visited[newRow][newCol] = true;// 生成就标记， 否则会导致生成太多相同结点
				buildCount++;
				int [] newNode = {newRow, newCol, node[2] + 1};	// 下一个状态
				if(map[newRow][newCol] == 'x') 					// 警卫需要额外的一个时间
					newNode[2] ++;
				
				queue.add(newNode);
			}
		}
		System.out.println("搜索结点个数: " + count);
		System.out.println("生成结点个数: " + buildCount);
	}
	public static void BFS2(char[][] map, final int Row, final int Col, int startRow, int startCol, final int endRow, final int endCol) {
		int count = 0;// 记录搜索结点个数
		int buildCount = 0;
		Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] != o2[2]) return o1[2] - o2[2];// 路径短的排在前面
				// 再次优化优先队列函数, 使得相同路经长度的结点 按照与终点距离排序。。 （启发式搜索
				int d1 = Math.abs(endRow - o1[0]) + Math.abs(endCol - o2[1]);// 哈曼吨距离
				int d2 = Math.abs(endRow - o2[0]) + Math.abs(endCol - o2[1]);
				return d1 - d2;
			}
		});// 优先队列
		// 添加visited 记录已经到达过的状态，防止多次搜索
		boolean visited[][] = new boolean[Row][Col];
		
		queue.add(new int[] {startRow, startCol, 0});
		visited[startRow][startCol] = true;
		int dir[][] = {{1, 0},{0, 1},{-1, 0},{0, -1}};// 4个方向
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			
			count++;
			if(map[node[0]][node[1]] == 'r') {// 找到了第一个解，即最优解
				System.out.println(node[2]); break;
			}
			// 生成所有状态
			for(int i = 0; i < 4; i++) {
				int newRow = node[0] + dir[i][0];
				int newCol = node[1] + dir[i][1];
				if(newRow < 0 || newCol < 0 || newRow >= Row || newCol >= Col) continue;// 限制边界
				if(map[newRow][newCol] == '#') continue;		// 墙壁
				
				if(visited[newRow][newCol]) continue;// 如果已经搜索过这个状态，就跳过
				visited[newRow][newCol] = true;// 生成就标记， 否则会导致生成太多相同结点
				buildCount ++;
				int [] newNode = {newRow, newCol, node[2] + 1};	// 下一个状态
				if(map[newRow][newCol] == 'x') 					// 警卫需要额外的一个时间
					newNode[2] ++;
				
				queue.add(newNode);
			}
		}
		System.out.println("搜索结点个数: " + count);
		System.out.println("生成结点个数: " + buildCount);
	}
}
