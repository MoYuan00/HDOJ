package BFS.��ֵĵ���;

import java.util.LinkedList;
import java.util.Queue;

/**
��һ����ֵĵ��ݣ�������ͣ���κ�һ�㣬������ÿ��¥����һ��Ki��0 <= Ki <= N����
����ֻ��������ť���ϡ��¡������ڵ�i�㣬����㰴�¡�UP����ť���㽫����Ki�㣬Ҳ����˵���㽫�ᵽ���i+Ki�㣬
����㰴�¡�DOWN����ť������½� Ki�㣬������ǰ����i-Ki�㡣��Ȼ�����ݲ��ܸ���N��Ҳ���ܵ���1��
���磬
��5��Ľ��������k1=3��k2=3��k3=1��k4=2��k5=5����1¥��ʼ��
����԰��¡�UP����ť����ᵽ4¥��������㰴�¡�DOWN����ť�����ݲ���������Ϊ�������µ�-2¥��
�ʣ�������A¥����ȥB¥ʱ�������밴�¡�UP����DOWN����ť���ٴΣ� ���У�1 <= N,A,B <= 200

 * @author Rnti
 * ������
 * ÿ��¥������ ����K[1..n],
 * ���Ҫ�����٣� Ҳ�� �����������
 * 1. DFS ���������ݷ��� ���Ż� ��Ҫ��¼��ǰ¥���Ƿ��Ѿ��ﵽ���� ���ʺϽ�����⣬���һֱ��ĳ����ť �Ҳ�����ļ��ʺܴ󡣶��Ҳ�����һ���ҵ����Ž�
 * 2. BFS ������   ���Ż� ��Ҫ��¼��ǰ¥���Ƿ��Ѿ��ﵽ��         ����  ���������ǲ��ݽ��ģ���һ���ҵ��Ľ�һ�������Ž�
 * // BFS�ʺ������Ž⣬DFS�ʺϼ�֦�������н�
 */
public class Main {
	public static void main(String[] args) {
		int K[] = new int[] {3, 3, 1, 2, 5};
		int kLen = K.length;
		int N = 5;// ¥��
		int A = 1;// ��ǰ¥��
		int B = 5;
		// BFS
		Queue<int[]> queue = new LinkedList<int[]>();// ��ŵ�ǰ¥��Ͱ��°�ť����
		queue.add(new int[] {A, 0});
		while(!queue.isEmpty()) {
			int [] node = queue.poll();
			if (node[0] == B) {// ����¥��
				System.out.println(node[1]);
				break;
			}
			for(int i = 0; i < kLen; i++) {// ������һ�����ܵ�����״̬�����ڵ�ǰ¥�㰴�����а�ť
				if(node[0] + K[i] <= N)
					queue.add(new int[] {node[0] + K[i], node[1] + 1});
				if(node[0] - K[i] > 0)
					queue.add(new int[] {node[0] - K[i], node[1] - 1});
			}
		}
	}
}
