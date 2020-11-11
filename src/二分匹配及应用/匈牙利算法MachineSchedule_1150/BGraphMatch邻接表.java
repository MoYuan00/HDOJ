package ����ƥ�估Ӧ��.�������㷨MachineSchedule_1150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ����ͼ�����ƥ���㷨
 * �������㷨ʵ��
 * @author Rnti
 *
 */
public class BGraphMatch�ڽӱ� {
	private static class BGraphMatch_{
		private List<Integer> edges[];// �ڽӱ�
		private int X; // ��߶��������
		private int Y; // �ұ߶��������
		private int match[];			// �ұ߶��㼯�϶�Ӧ�����Ԫ��
		private boolean visited[];// ��¼�Ҳඥ���Ƿ��Ѿ������ʹ���- ��һ�α�����Ѱ������·��ʱ
		/**
		 * 
		 * @param map �ڽӾ���
		 * @param left ��߶���ļ���
		 * @param right �ұ߶���ļ���
		 */
		public BGraphMatch_(List<Integer> map[], int M, int N) {
			this.edges = map;
			this.X = M;
			this.Y = N;
			match = new int[Y];
			for(int i = 0; i < Y; i++)
				match[i] = -1;
			visited = new boolean[Y];
		}
		/**
		 * ��ȡ��ǰ����ͼ�����ƥ��ֵ
		 * @return
		 */
		
		public int getMaxMatch() {
			int count = 0;
			for(int x = 0; x < X; x++) {
				for(int j = 0; j < Y; j++) // visited ��0
					visited[j] = false;
				if(find(x)) 	// �����ǰ��߶���ƥ��, ƥ��ֵ��һ
					count++;
			}
			return count;
		}
		/**
		 * ���ұ߼������ҵ�����a��ƥ��ĵ㣬����һ������·������¼��ƥ���ֵ
		 * @param a
		 * @param visited
		 * @param rightToLeft
		 * @return
		 */
		private boolean find(int x) {
			for(int i = 0, len = edges[x].size(); i < len; i++) {// ���ұ߼�����Ѱ��һ��û��ƥ����ĵ����ƥ��
				int y = edges[x].get(i);
				if(!visited[y]) {// ���û�з��ʹ������б�
					visited[y] = true;// ���ʣ���ֹ���ֻ�·
					// �����ǰ�ұ߼��ϵ�yû��ƥ���, �����ܹ�ƥ��ɹ���������ҵ�һ��û��ƥ����ұ߼��ϵ� - M-����·��
					if(match[y] < 0 || find(match[y])) {
						match[y] = x;// ��¼��ǰ�µ�ƥ��ֵ
						return true;// ƥ��ɹ�
					}
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int X = sc.nextInt();// A����
			if(X == 0) break;
			int Y = sc.nextInt();// B����
			int K = sc.nextInt();// ������
			List<Integer> map[] = new List[X];// �ڽӾ���
			for(int i = 0; i < X; i++)
				map[i] = new ArrayList<Integer>(); 
			for(int i = 0; i < K; i++) {
				int mi = sc.nextInt();
				int Ai = sc.nextInt();// Ai
				int Bi = sc.nextInt();// Bi
				if(Ai == 0 || Bi == 0) continue;// ��״̬0����Ҫ����
				map[Ai].add(Bi);// ���һ����
			}
			int n = new BGraphMatch_(map, X, Y).getMaxMatch();
			System.out.println(n);
		}
		sc.close();
	}
}
