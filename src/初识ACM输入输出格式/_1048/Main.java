package ��ʶACM���������ʽ._1048;

import java.util.Scanner;

public class Main {
	public static char tranform(char a) {
		if(a < 'A' || a > 'Z') return a;
		char c = (char)((int)a - 5);// shift it five places to left 
		if(c < 'A') c += (char)('Z' - 'A' + 1);// ȡģ��С��A������Ӧƫ�Ƶ�β���ˣ���Ҫ����Z - A + 1����λ
		return c;
	}
	public static String tranform(String aStr) {
		int len = aStr.length();
		char aChs[] = new char[len];
		for(int i = 0; i < len; i++) {
			aChs[i] = tranform(aStr.charAt(i));
		}
		return new String(aChs);
	}
	public static void main(String[] args) {
//		for(int i = (char)'A'; i <= (char)'Z'; i++) {
//			System.out.print(tranform((char)i));
//		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			if(s.equals("ENDOFINPUT")) break;// end program
			if(s.equals("START")) {
				s = sc.nextLine();// a line string
				System.out.println(tranform(s));
			}
		}
		sc.close();
	}
}
