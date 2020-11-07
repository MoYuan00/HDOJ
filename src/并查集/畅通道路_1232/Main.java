package ���鼯.��ͨ��·_1232;

import java.util.Arrays;
import java.util.Scanner;

/**
ĳʡ�������ͨ״�����õ����г����·ͳ�Ʊ������г���ÿ����·ֱ����ͨ�ĳ���
ʡ��������ͨ���̡���Ŀ����ʹȫʡ�κ���������䶼����ʵ�ֽ�ͨ������һ����ֱ�ӵĵ�·������ֻҪ������ͨ����·�ɴＴ�ɣ��������ٻ���Ҫ�����������·��
 

Input
��������������ɲ���������ÿ�����������ĵ�1�и����������������ֱ��ǳ�����ĿN ( < 1000 )�͵�·��ĿM��
����M�ж�ӦM����·��ÿ�и���һ�����������ֱ��Ǹ�����·ֱ����ͨ����������ı�š�Ϊ������������1��N��š�
ע��:��������֮������ж�����·��ͨ,Ҳ����˵
3 3
1 2
1 2
2 1
��������Ҳ�ǺϷ���
��NΪ0ʱ�������������������������
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();// ���и���
			if(N == 0) break;
			int M = sc.nextInt();// ��·����
			int set[] = new int[N + 1];
			for(int i = 1; i <= N; i++) // ��ʼ�����鼯 i�ĸ�Ϊi
				set[i] = i;
			for(int i = 1 ; i <= M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				merge(a, b, set);// �ϲ�
			}
			// ���ҵ�ǰ�����ڶ��ٸ������ļ���,, ���Ҹ������� �� set[i] = i
//			System.out.println(Arrays.toString(set));
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(find(i, set) == i) count++;
			}
			if(count > 0) count--;
			System.out.println(count);// 2����ֻ��Ҫһ�κϲ���3������Ҫ����/// Ҳ���ǵ�·
		}
		sc.close();
	}
	/**
	 * �ݹ��
int find(int x)
{
    if(p[x]!=x)
        p[x]=find(p[x]);
    return p[x];
}
int find(int v)
{
	if(f[v]==v)
		return v;
	return f[v]=find(f[v]);
}
	 */
	/**
	 * �ҵ�x���ڼ��ϵĸ� ��ѹ��·��(�ǵݹ��
	 * @param x
	 * @return
	 */
	public static int find(int x, int set[]) {
		int r = x;
		while(set[r] != r)// �ҵ��� 
			r = set[r];
		// ѹ��·��
		int leaf = x;
		while(leaf != r) {
			int root = set[leaf];
			set[leaf] = r;
			leaf = root; // ִ�� leaf�ĸ� ������ ������·���ϵĽ��ȫ����ֱ��ָ���
		}
		return r;
	}
	/**
	 * �Ͳ� �ر�ע�⣺ �ϲ�Ҫ�ϲ�����㡣������
	 * @param a
	 * @param b
	 */
	public static void merge(int a, int b, int set[]) {
		int ar = find(a, set);
		int br = find(b, set);  
	    if(ar != br)  // �ϲ������
	        set[ar]=br;  
//		int max = Math.max(a, b); 
//		int min = Math.min(a, b);		// ��ѡ����С�� ֵΪ��
//		set[max] = min;					// b�ϲ���a��
	}
}
