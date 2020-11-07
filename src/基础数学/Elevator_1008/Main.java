package ������ѧ.Elevator_1008;

import java.util.Scanner;

public class Main {
	// ������k�㣬ǰ��target�㲢ͣ��
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
			int k = 0;// ����¥��0����ʱ���Գ���
			int sumSecond = 0;
			for(int i = 0; i < n; i++) {
				int target = sc.nextInt();
				sumSecond += func(k, target);
				k = target;// ���ݵ���target�㲢��ʱ���Գ���
			}
			System.out.println(sumSecond);
		}
		sc.close();
	}
}
