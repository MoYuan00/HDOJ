package BFS.��ȶ���;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
��Ŀ���⣺
    ���ֱ�������ץ�ߣ�����һ��N * M���εļ�������������ǽ�ڡ���·�;����ӣ���
���ֵ�ѧ���������������ﶡ��ͣ����λ�ü���Ϊ�ɹ��������ȹ����������������������ɵ���
����ÿ�����ϣ����£����ң������ƶ���Ҫ1����λʱ�䣬ɱ��һ������������Ҫ1����λʱ�䡣 /// ��Ҫ����ʱ�䣬��ô���ܵ��³���Ԫ���������ʱ�䲢���ǲ�ε�����..
    ����㣺���ȶ�����Ҫ�����ʱ�䡣
��ÿ��ֻ���ϣ��£������ƶ����߽��ڵ��ھ����񡣣�

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
		// �������
		// ��ѧ��a��λ��
		int startRow = 0;
		int startCol = 0;
		// �ҳ�����r��λ��
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
		int count = 0;// ��¼����������
		int buildCount = 0; // ���ɽ��ĸ���
		Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];// ·���̵�����ǰ��
			}
		});// ���ȶ���
		// ���visited ��¼�Ѿ��������״̬����ֹ�������
		boolean visited[][] = new boolean[Row][Col];
		
		queue.add(new int[] {startRow, startCol, 0});
		visited[startRow][startCol] = true;
		int dir[][] = {{1, 0},{0, 1},{-1, 0},{0, -1}};// 4������
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			count++;
			if(map[node[0]][node[1]] == 'r') {// �ҵ��˵�һ���⣬�����Ž�
				System.out.println(node[2]); break;
			}
			// ��������״̬
			for(int i = 0; i < 4; i++) {
				int newRow = node[0] + dir[i][0];
				int newCol = node[1] + dir[i][1];
				if(newRow < 0 || newCol < 0 || newRow >= Row || newCol >= Col) continue;// ���Ʊ߽�
				if(map[newRow][newCol] == '#') continue;		// ǽ��
				
				if(visited[newRow][newCol]) continue;// ����Ѿ����������״̬��������
				visited[newRow][newCol] = true;// ���ɾͱ�ǣ� ����ᵼ������̫����ͬ���
				buildCount++;
				int [] newNode = {newRow, newCol, node[2] + 1};	// ��һ��״̬
				if(map[newRow][newCol] == 'x') 					// ������Ҫ�����һ��ʱ��
					newNode[2] ++;
				
				queue.add(newNode);
			}
		}
		System.out.println("����������: " + count);
		System.out.println("���ɽ�����: " + buildCount);
	}
	public static void BFS2(char[][] map, final int Row, final int Col, int startRow, int startCol, final int endRow, final int endCol) {
		int count = 0;// ��¼����������
		int buildCount = 0;
		Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] != o2[2]) return o1[2] - o2[2];// ·���̵�����ǰ��
				// �ٴ��Ż����ȶ��к���, ʹ����ͬ·�����ȵĽ�� �������յ�������򡣡� ������ʽ����
				int d1 = Math.abs(endRow - o1[0]) + Math.abs(endCol - o2[1]);// �����־���
				int d2 = Math.abs(endRow - o2[0]) + Math.abs(endCol - o2[1]);
				return d1 - d2;
			}
		});// ���ȶ���
		// ���visited ��¼�Ѿ��������״̬����ֹ�������
		boolean visited[][] = new boolean[Row][Col];
		
		queue.add(new int[] {startRow, startCol, 0});
		visited[startRow][startCol] = true;
		int dir[][] = {{1, 0},{0, 1},{-1, 0},{0, -1}};// 4������
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			
			count++;
			if(map[node[0]][node[1]] == 'r') {// �ҵ��˵�һ���⣬�����Ž�
				System.out.println(node[2]); break;
			}
			// ��������״̬
			for(int i = 0; i < 4; i++) {
				int newRow = node[0] + dir[i][0];
				int newCol = node[1] + dir[i][1];
				if(newRow < 0 || newCol < 0 || newRow >= Row || newCol >= Col) continue;// ���Ʊ߽�
				if(map[newRow][newCol] == '#') continue;		// ǽ��
				
				if(visited[newRow][newCol]) continue;// ����Ѿ����������״̬��������
				visited[newRow][newCol] = true;// ���ɾͱ�ǣ� ����ᵼ������̫����ͬ���
				buildCount ++;
				int [] newNode = {newRow, newCol, node[2] + 1};	// ��һ��״̬
				if(map[newRow][newCol] == 'x') 					// ������Ҫ�����һ��ʱ��
					newNode[2] ++;
				
				queue.add(newNode);
			}
		}
		System.out.println("����������: " + count);
		System.out.println("���ɽ�����: " + buildCount);
	}
}
