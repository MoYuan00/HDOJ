package 贪心算法.今年暑假不AC_2037;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Tv implements Comparable<Tv>{
		public int sT;
		public int sE;
		public Tv(int sT, int sE) {
			this.sT = sT; this.sE = sE;
		}
		@Override
		public int compareTo(Tv o) {
			if(this.sE != o.sE) return this.sE - o.sE;
			else return this.sT - o.sT;
		}
		@Override
		public String toString() {
			return this.sE + "";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int N = sc.nextInt();
			if(N == 0) break;
			Tv tvs[] = new Tv[N];
			for(int i = 0; i < N; i++) {
				tvs[i] = new Tv(sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(tvs);
			int count = 0;
			int lastEndTime = 0;
			for(int i = 0; i < N; i++) {
				if(lastEndTime <= tvs[i].sT) {
					count++;
					lastEndTime = tvs[i].sE;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}
