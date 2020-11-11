package 母函数.HDU大事件_1171;

import java.util.Arrays;
import java.util.Scanner;

/**
物品价值为V[1..N],物品数量为W[1..N]
对应价值的多项式为:h(i) = (1 + X^V[i] + ...) 一共W[i] + 1项
G(x) = h(1) * h(2) * ... * h(N)
展开后选择第一个大于等于 平均值的项数 为A, 或者第一个小于平均值的项数为B
 * @author Rnti
 * HDOJ 针对JAVA 不给我过，，，
 *
 */
public class Main母函数优化 {
	
	/**
	 * 构建母函数并展开
	 * @param V
	 * @param M
	 * @return
	 */
	public static int generationFunction(int V[], int M[], int N, int sum) {
		if(N == 0) return 0;
		int pn1[] = new int[sum + 1];
		int pn2[] = new int[sum + 1]; // 临时变量
		for(int i = 0; i <= V[1] * M[1]; i += V[1])// 第一项
			pn1[i] = 1;
		for(int n = 2; n <= N; n++) {// 2... N项
			// 对每项都 执行乘法，展开
			for(int n1 = 0; n1 <= sum; n1++) { // OK
				for(int k = 0, c = 0; n1 + k <= sum && c <= M[n]; k += V[n], c++) {// 增量, 和控制每个多项式的项数
					pn2[k + n1] += pn1[n1];// OK
				}
			}
			// 轮换 OK
			for(int j = 0; j <= sum; j++) {
				if(pn2[j] > 0) pn1[j] = 1;// 不用求组合数，标记就行
				pn2[j] = 0;// 清0
			}
		}
		for(int i = sum / 2; i >= 0; i--) // OK
			if(pn1[i] != 0) 
				return i;// B
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N <= 0) break;
			int V[] = new int[N + 1];
			int M[] = new int[N + 1];
			int sum = 0;
			for(int i = 1; i <= N; i++) {
				V[i] = sc.nextInt();
				M[i] = sc.nextInt();
				sum += V[i] * M[i];
			}// 输入结束
			int B = generationFunction(V, M, N, sum);
			System.out.println(String.format("%d %d", sum - B, B));
		}
		sc.close();
	}
}
