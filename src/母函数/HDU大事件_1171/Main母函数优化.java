package ĸ����.HDU���¼�_1171;

import java.util.Arrays;
import java.util.Scanner;

/**
��Ʒ��ֵΪV[1..N],��Ʒ����ΪW[1..N]
��Ӧ��ֵ�Ķ���ʽΪ:h(i) = (1 + X^V[i] + ...) һ��W[i] + 1��
G(x) = h(1) * h(2) * ... * h(N)
չ����ѡ���һ�����ڵ��� ƽ��ֵ������ ΪA, ���ߵ�һ��С��ƽ��ֵ������ΪB
 * @author Rnti
 * HDOJ ���JAVA �����ҹ�������
 *
 */
public class Mainĸ�����Ż� {
	
	/**
	 * ����ĸ������չ��
	 * @param V
	 * @param M
	 * @return
	 */
	public static int generationFunction(int V[], int M[], int N, int sum) {
		if(N == 0) return 0;
		int pn1[] = new int[sum + 1];
		int pn2[] = new int[sum + 1]; // ��ʱ����
		for(int i = 0; i <= V[1] * M[1]; i += V[1])// ��һ��
			pn1[i] = 1;
		for(int n = 2; n <= N; n++) {// 2... N��
			// ��ÿ� ִ�г˷���չ��
			for(int n1 = 0; n1 <= sum; n1++) { // OK
				for(int k = 0, c = 0; n1 + k <= sum && c <= M[n]; k += V[n], c++) {// ����, �Ϳ���ÿ������ʽ������
					pn2[k + n1] += pn1[n1];// OK
				}
			}
			// �ֻ� OK
			for(int j = 0; j <= sum; j++) {
				if(pn2[j] > 0) pn1[j] = 1;// ���������������Ǿ���
				pn2[j] = 0;// ��0
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
			}// �������
			int B = generationFunction(V, M, N, sum);
			System.out.println(String.format("%d %d", sum - B, B));
		}
		sc.close();
	}
}
