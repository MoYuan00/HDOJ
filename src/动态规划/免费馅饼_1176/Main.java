package 动态规划.免费馅饼_1176;

import java.util.Scanner;

/**
 * 免费馅饼
 * 设当前时刻为T,剩余时间为Ts, 最后一个饼落下的时间为ST, 当前位置为p
 * 则要求的函数表示为:F(Ts=0, p=5) or F(T=ST, p不知道是多少。。)
 * f(Ts, p) = max{f(Ts + 1, p - 1), f(Ts + 1, p + 1), f(Ts + 1, p)} // 向左向右，不移动， 3个间最大值
 * @author Rnti
 *
 */
public class Main {
	
	/**
	 * 自顶向下 搜索
	 * @param time 当前时间
	 * @param spanTime 截至时间/最后一个饼落下的时间
	 * @param point
	 * @param cakePoint
	 * @return
	 */
	public static int func(int time, final int spanTime, int point, int cakePoint[][]) {
		if(point < 0 || point > 10) return 0;		// 控制移动范围
		if(spanTime == time) return cakePoint[time][point];		// 只剩0秒，那么只能获取当前时间的饼
		int noMove = func(time + 1, spanTime, point, cakePoint); 		// 不移动
		int moveLeft = func(time + 1, spanTime, point + 1, cakePoint);  // 左移动，
		int moveRight = func(time + 1, spanTime, point - 1, cakePoint); // 右移动
		return Math.max(noMove, Math.max(moveLeft, moveRight))  + cakePoint[time][point];	// 向左/向右移动，不移动最大值 + 当前时间获得的饼
	}
	/**
	 * 自底向上 动态规划
	 */
	public static long dp(int spanTime, long cakePoint[][]) {
		// 考虑动态规划
		for(int t = spanTime - 1; t >= 0; t--) {
			for(int p = 0; p <= 10; p ++) {
				long left = 0;// 整了半天原来是int类型，溢出了妈的
				long right = 0;
				if(p > 0) left = cakePoint[t + 1][p - 1];
				if(p < 10) right = cakePoint[t + 1][p + 1];
				long result = Math.max(Math.max(cakePoint[t + 1][p], left),  right);// 不移动， 3个间最大值
				cakePoint[t][p] += result;
			}
		}
		return cakePoint[0][5];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			if(N == 0) break;
			long cakePoint[][] = new long[100001][13];// 第i秒 落在j位置上 有cakePoint[i][j]个馅饼  落下
			int spanTime = 0;// 记录持续时间
			for(int i = 0; i < N; i++) {
				int point = sc.nextInt();
				int time = sc.nextInt();
				if(time > spanTime) spanTime = time;
				cakePoint[time][point]++;
			}
//			System.out.println(func(0, spanTime, 5, cakePoint));// O(3^T)次方
			System.out.println(dp(spanTime, cakePoint));// O(T)
			
		}
		sc.close();
	}
	
}
