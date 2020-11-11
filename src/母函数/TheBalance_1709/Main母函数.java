package ĸ����.TheBalance_1709;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
Now you are asked to measure a dose of medicine with a balance and a number of weights.
Certainly it is not always achievable. 
So you should find out the qualities which cannot be measured from the range [1,S]. 
S is the total quality of all the weights.
���ڣ�Ҫ��������������ƽ��������ҩ���������Ȼ���Ⲣ�����ǿ���ʵ�ֵġ���ˣ���Ӧ���ҳ��޷���[1��S]��Χ�ڲ�����������S������Ȩ�ص���������
 * @author Rnti

h(1) = (1 + x)
h(2) = (1 + x^2)
ĸ������
g(x) = h(i) *...*h(n) 

����������Էŵ���ƽ�����ߣ�
�� 1+9   -  2����ƴ��8
�൱�ڸ�ָ��, ����ĸ��������Ҫ�����ǵĸ�ָ��h(-1), h(-2)....
(1 + x^-1 + ...)
(1 + x^-9 + ...)
(1 + x^-2)
 *
 */
public class Mainĸ���� {
	
	public static List<Integer> generationFunction(int nums[], int N){
		int sum = 0;// ������
		for(int i = 1; i <= N; i++)
			sum += nums[i];
		int pn[] = new int[sum + 1];
		int pn2[] = new int[sum + 1];
		pn[0] = pn[nums[1]] = 1;
		for(int i = 2; i <= N; i++) {// 2.����n��
			// ���
			for(int k = 0; k <= nums[i]; k += nums[i]) {
				for(int n1 = 0; n1 + k <= sum; n1++) {
					pn2[n1 + k] += pn[n1];// ��ͨ�������ָ��
					pn2[Math.abs(n1 - k)] += pn[n1];// ��ʾ������ŵ���һ��(1 + x^-1 + x^-2 + ....), ��ָ��
				}
			}
			// �ֻ�����pn��¼���
			for(int j = 0; j <= sum; j++) {
				if(pn2[j] > 0) pn[j] = 1; // ֻ��ǲ�����
				pn2[j] = 0;// ��0
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		// ɨ��������0�ĸ���������
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
			// �������
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
