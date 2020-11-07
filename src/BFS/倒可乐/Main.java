package BFS.������;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
��Ŀ������
ÿ����һ�����˿��֣���������Ҫ�����һ���������һ��Ҫ�ȵĺ���һ��һ���ࡣ
����һ��������ֻ���������ӣ����ǵ������ֱ���N��M����,���ֵ����ΪS��S<101������(����װ��һƿ) ��
��������֮������໥������ (����û�п̶ȵģ��� S==N+M��101��S��0��N��0��M��0) ��

�����ƽ�֣�����������ֵ����ٴ�����������ܣ������"NO"��

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
			int con[] = {S, N, M}; // ����
			boolean visited[][][] = new boolean[S + 1][N + 1][M + 1];// ��¼3��ˮ��״̬ �Ƿ��Ѿ����ʹ�
			// BSF ������ �������ĵ�һ�����һ���ǽ⡣���� 
			// ���ڿ���û�н⣬ ��Ҫ��¼��ǰ�Ѿ����ʹ������н�㣺��ǰ3��λ��ˮ������
			Queue<int[]> queue = new LinkedList<int[]>();// s n m ˮ������, ��ˮ����
			queue.add(new int[] {S, 0, 0, 0}); // ��ʼ���
			int count = 0;
			while(!queue.isEmpty()) {
				int[] node = queue.poll();
				count++;
				visited[node[0]][node[1]][node[2]] = true;// ���ʴ�״̬
				// �жϵ�ǰ״̬�Ƿ�����Ҫ��
				if(node[0] == node[1] && node[2] == 0 
						|| node[0] == node[2] && node[1] == 0
						|| node[1] == node[2] && node[0] == 0) {// �ɹ���ˮ��Ϊ����
//					System.out.println(Arrays.toString(node));
					System.out.println(node[3]);
					break;
				}
//				״̬ת�ƹ��򣨵�ˮ���򣩣�
//				���iˮ����ˮ����������jˮ���ڵ������������x���򡪡�iˮ����ˮ�������Ϊ��i-x,jˮ����ˮ������Ϊ:j+x
//				���iˮ����ˮ������С�ڵ���jˮ���ڵ������������x���򡪡�iˮ����ˮ�������Ϊ��0,jˮ����ˮ������Ϊ:j+i
//				ÿ����һ�Σ����ٵ�ˮ����+1
				// �����п��ܵ�״̬��ӽ���
//				System.out.println("��ǰ״̬: " + Arrays.toString(node));
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						if(i == j) continue;
						if(node[i] == 0) continue;// û��ˮ�Ͳ�����
						int newNode[] = new int[4];
						for(int k = 0; k < 4; k++)
							newNode[k] = node[k];
						int x = con[j] - node[j];// ʣ������x
						if(node[i] > x) {
							newNode[i] = node[i] - x;
							newNode[j] = node[j] + x;
						}else {
							newNode[i] = 0;
							newNode[j] = node[j] + node[i];
						}
						// ���ɣ�
//						System.out.println("i:" + i + " j:" + j + " x:" + x);
//						System.out.println(Arrays.toString(newNode));
						if(!visited[newNode[0]][newNode[1]][newNode[2]]) {// ���û�з��ʹ���״̬, ��֦
							newNode[3]++;// ��ˮ������һ
							queue.add(newNode);
						}
					}
				}
			}
			if (queue.isEmpty()) {// û���ҵ� ƽ�ַ���
				System.out.println("NO");
			}
			System.out.println("����������Ϊ: " + count);
		}
		sc.close();
	}
}
