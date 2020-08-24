import java.util.Scanner;
class Q2_1_6{
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no; 
		int cd; 
		int dno; 
		int retry; 
		char[] cno = new char[32]; 

		System.out.println("10진수를 기수변환함");
		do {
			do {
				System.out.print("변환할 10진수");
				no = stdIn.nextInt();
			} while (no < 0);

			do {
				System.out.print("몇진수로?(2~36)");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);

			dno = cardConv(no, cd, cno); 

			System.out.print(cd + "진수로");
			for (int i = 0; i < dno; i++) 
				System.out.print(cno[i]);

			System.out.print("한번더? (1.네/0.아니오)");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		do {
			d[digits++] = dchar.charAt(x % r); 
			x /= r;
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) { // 역순으로 정렬
			char temp = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = temp;
		}
		return digits;
	}
}
