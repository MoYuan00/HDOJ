package ����ƥ�估Ӧ��.�������㷨MachineSchedule_1150;

import java.util.Scanner;

/**
 * ����ͼ�����ƥ���㷨
 * �������㷨ʵ��
 * @author Rnti
 *
 */
public class BGraphMatch�ڽӾ��� {
	private static boolean edges[][];
	private static int N; // ��߶��������
	private static int M; // �ұ߶��������
	private static int match[] = new int[1001];			// �ұ߶��㼯�϶�Ӧ�����Ԫ��
	private static boolean visited[] = new boolean[1001];// ��¼�Ҳඥ���Ƿ��Ѿ������ʹ���- ��һ�α�����Ѱ������·��ʱ
	public static int getMaxMatch() {
		for(int i = 0; i <= M; i++)
			match[i] = -1;
		int count = 0;
		for(int x = 0; x < N; x++) {
			for(int j = 0; j <= M; j++) // visited ��0
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
	private static boolean find(int x) {
		for(int y = 1; y < M; y++) {// ���ұ߼�����Ѱ��һ��û��ƥ����ĵ����ƥ��
			if(!visited[y] && edges[x][y]) {// ���û�з��ʹ������б�
				visited[y] = true;// ���ʣ���ֹ���ֻ�·
				// �����ǰ�ұ߼��ϵ�yû��ƥ���, �����ܹ�ƥ��ɹ���������ҵ�һ��û��ƥ����ұ߼��ϵ� - M-����·��
				if(match[y] == -1 || find(match[y])) {
					match[y] = x;// ��¼��ǰ�µ�ƥ��ֵ
					return true;// ƥ��ɹ�
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			N = sc.nextInt();// A����
			if(N == 0) break;
			M = sc.nextInt();// B����
			int K = sc.nextInt();// ������
			edges = new boolean[207][207];
			for(int i = 0; i < K; i++) {
				sc.nextInt();
				int Ai = sc.nextInt();// Ai
				int Bi = sc.nextInt();// Bi
				if(Ai == 0 || Bi == 0) continue;// ��״̬0����Ҫ����
				edges[Ai][Bi] = true;// ���һ����
			}
			System.out.println(getMaxMatch());
		}
		sc.close();
	}
}
