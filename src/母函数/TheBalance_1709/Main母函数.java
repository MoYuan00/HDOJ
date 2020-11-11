package 母函数.TheBalance_1709;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
Now you are asked to measure a dose of medicine with a balance and a number of weights.
Certainly it is not always achievable. 
So you should find out the qualities which cannot be measured from the range [1,S]. 
S is the total quality of all the weights.
现在，要求您测量带有天平和重量的药物剂量。当然，这并非总是可以实现的。因此，您应该找出无法在[1，S]范围内测量的质量。S是所有权重的总质量。
 * @author Rnti

h(1) = (1 + x)
h(2) = (1 + x^2)
母函数：
g(x) = h(i) *...*h(n) 

由于砝码可以放到天平的两边，
如 1+9   -  2可以拼出8
相当于负指数, 于是母函数还需要乘他们的负指数h(-1), h(-2)....
(1 + x^-1 + ...)
(1 + x^-9 + ...)
(1 + x^-2)
 *
 */
public class Main母函数 {
	
	public static List<Integer> generationFunction(int nums[], int N){
		int sum = 0;// 总质量
		for(int i = 1; i <= N; i++)
			sum += nums[i];
		int pn[] = new int[sum + 1];
		int pn2[] = new int[sum + 1];
		pn[0] = pn[nums[1]] = 1;
		for(int i = 2; i <= N; i++) {// 2.。。n个
			// 相乘
			for(int k = 0; k <= nums[i]; k += nums[i]) {
				for(int n1 = 0; n1 + k <= sum; n1++) {
					pn2[n1 + k] += pn[n1];// 普通情况，正指数
					pn2[Math.abs(n1 - k)] += pn[n1];// 表示将砝码放到另一边(1 + x^-1 + x^-2 + ....), 负指数
				}
			}
			// 轮换，用pn记录结果
			for(int j = 0; j <= sum; j++) {
				if(pn2[j] > 0) pn[j] = 1; // 只标记不计数
				pn2[j] = 0;// 清0
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		// 扫描结果，将0的个数记下来
		for(int i = 0; i <= sum; i++) {
			if(pn[i] == 0) list.add(i);
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			int nums[] = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				nums[i] = sc.nextInt();
			}
			// 输入结束
			List<Integer> list = generationFunction(nums, N);
			int n = list.size();
			System.out.println(n);
			if(n > 0) {
				System.out.print(list.get(0));
				for(int i = 1; i < n; i++) {
					System.out.print(" " + list.get(i));
				}
				System.out.println();
			}
		}
		
	}
}
