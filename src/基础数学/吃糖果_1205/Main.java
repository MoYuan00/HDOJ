package 基础数学.吃糖果_1205;

import java.util.Scanner;

/**
 * HOHO，终于从Speakless手上赢走了所有的糖果，
 * 是Gardon吃糖果时有个特殊的癖好，就是不喜欢将一样的糖果放在一起吃，喜欢先吃一种，下一次吃另一种，这样；
 * 可是Gardon不知道是否存在一种吃糖果的顺序使得他能把所有糖果都吃完？请你写个程序帮忙计算一下。
 * @author Rnti
 *
 */
public class Main {
	// 由于 对于每两种糖果 如果abs(A - B) <= 1,那么可以吃完，否则不能吃完
	// 例如: ABA, BAB,  两种糖果数要么相同，要么差一个，这样每种糖果都这样消去即可
	//  3种糖果数要么相同，要么差1个,要么差2个
	// 满足两种的极限序列为: 01，12 3种: 010，120，131，241等 4种: 0100... 则最大值小于等于与其他所有糖果和+1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			long max = -1;
			long sum = 0;
			for(int j = 0; j < n; j++) {
				long t = sc.nextLong();
				sum += t;
				if(max < t) max = t;
			}
			if(sum - max + 1 >= max) {// 其余所有糖果和 + 1 大于 最大值糖果
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		sc.close();
	}
}
