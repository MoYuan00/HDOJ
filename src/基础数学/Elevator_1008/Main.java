package 基础数学.Elevator_1008;

import java.util.Scanner;

public class Main {
	// 电梯在k层，前往target层并停留
	static int func(int k, int target) {
		if(target > k) return (target - k) * 6 + 5;
		else if(target < k) return (k - target) * 4 + 5;
		return 5;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			if(n == 0) break;
			int k = 0;// 电梯楼层0并随时可以出发
			int sumSecond = 0;
			for(int i = 0; i < n; i++) {
				int target = sc.nextInt();
				sumSecond += func(k, target);
				k = target;// 电梯到达target层并随时可以出发
			}
			System.out.println(sumSecond);
		}
		sc.close();
	}
}
