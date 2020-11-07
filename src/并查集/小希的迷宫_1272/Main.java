package ���鼯.Сϣ���Թ�_1272;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String ans = "Yes";
			int set[] = new int[100001];
			for(int i = 0; i <= 100000; i++)// ��ʼ�����鼯
				set[i] = i;
			int maxNode = 0;
			int minNode = Integer.MAX_VALUE;
			boolean isShow[] = new boolean[100001]; // ���Ϊi�Ķ����Ƿ������ͼ��
			do{
				int A = sc.nextInt();
				int B = sc.nextInt();
				if(A == 0 && B == 0) break;
				if(A == -1 && B == -1) return;
				isShow[A] = isShow[B] = true;// ��¼�ѳ���
				maxNode = Math.max(maxNode, Math.max(A, B)); // ��¼���ֹ�����󶥵�
				minNode = Math.min(minNode, Math.min(A, B)); // ��¼���ֹ�����С�Ķ���
				if(find(A, set) == find(B, set))// ����ϲ�ǰ���Լ���һ�����ϣ��ٺϲ� �ͻ�ɻ�
					ans = "No";
				merge(A, B, set);
				
			}while(true);
//			System.out.println(Arrays.toString(set));
			// �������ͨͼ�� ֻ��Ҫ��黷·�Ϳ��ԣ� ����Ҳ���ܲ���ͨ�� ������Ҫ���
			int treeCount = 0;
			for(int i = minNode; i <= maxNode; i++) 
				if(set[i] == i && isShow[i]) treeCount++;
			if(treeCount > 1) ans = "No"; // ������ͨ��
			System.out.println(ans);
		}
		sc.close();	
	}
	/**
	 * ����x�ĸ���� �� �������ĸ����ϣ� ��ѹ��·��
	 * @param x
	 * @param set
	 * @return
	 */
	public static int find(int x, int[] set) {
		if(x == set[x])// �ҵ��˸����
			return x;
		return set[x] = find(set[x], set);// ����Ѱ�Ҹ���㣬�������õ�ǰֵ Ϊ���ڵ�
	}
	/**
	 * �ϲ�a���ڼ��Ϻ�b���ڼ���
	 * @param a
	 * @param b
	 * @param set
	 */
	public static void merge(int a, int b, int[]set) {
		int fa = find(a, set);
		int fb = find(b, set);
		if(fa != fb)// �����������һ�����ϣ��ͺϲ��� ��ֹ����4->3 �ϲ�����3->3,4->4�Ĵ���
			set[fa] = fb;
	}
}
