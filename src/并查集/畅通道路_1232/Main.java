package 并查集.畅通道路_1232;

import java.util.Arrays;
import java.util.Scanner;

/**
某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。
省政府“畅通工程”的目标是使全省任何两个城镇间都可以实现交通（但不一定有直接的道路相连，只要互相间接通过道路可达即可）。问最少还需要建设多少条道路？
 

Input
测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是城镇数目N ( < 1000 )和道路数目M；
随后的M行对应M条道路，每行给出一对正整数，分别是该条道路直接连通的两个城镇的编号。为简单起见，城镇从1到N编号。
注意:两个城市之间可以有多条道路相通,也就是说
3 3
1 2
1 2
2 1
这种输入也是合法的
当N为0时，输入结束，该用例不被处理。
 * @author Rnti
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();// 城市个数
			if(N == 0) break;
			int M = sc.nextInt();// 道路条数
			int set[] = new int[N + 1];
			for(int i = 1; i <= N; i++) // 初始化并查集 i的根为i
				set[i] = i;
			for(int i = 1 ; i <= M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				merge(a, b, set);// 合并
			}
			// 查找当前还存在多少个独立的集合,, 查找根结点就行 即 set[i] = i
//			System.out.println(Arrays.toString(set));
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(find(i, set) == i) count++;
			}
			if(count > 0) count--;
			System.out.println(count);// 2个根只需要一次合并，3个根需要两次/// 也就是道路
		}
		sc.close();
	}
	/**
	 * 递归版
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
	 * 找到x所在集合的根 并压缩路径(非递归版
	 * @param x
	 * @return
	 */
	public static int find(int x, int set[]) {
		int r = x;
		while(set[r] != r)// 找到根 
			r = set[r];
		// 压缩路径
		int leaf = x;
		while(leaf != r) {
			int root = set[leaf];
			set[leaf] = r;
			leaf = root; // 执行 leaf的根 ，，， 将查找路径上的结点全部都直接指向根
		}
		return r;
	}
	/**
	 * 和并 特别注意： 合并要合并根结点。。。。
	 * @param a
	 * @param b
	 */
	public static void merge(int a, int b, int set[]) {
		int ar = find(a, set);
		int br = find(b, set);  
	    if(ar != br)  // 合并根结点
	        set[ar]=br;  
//		int max = Math.max(a, b); 
//		int min = Math.min(a, b);		// 挑选出较小的 值为根
//		set[max] = min;					// b合并到a上
	}
}
