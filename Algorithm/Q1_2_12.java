import java.util.Scanner;
class Q1_2_12{
	public static void main(String[] args) {
		// 1~9´Ü °ö¼ÀÇ¥
		System.out.println("  | 1  2  3  4  5  6  7  8  9 ");
		System.out.println("--+---------------------------");
		for(int i = 1;i<10;i++) {
			System.out.print(" " + i + "|");
			for(int j = 1; j<10;j++) {
				if(i*j<10) {System.out.print(" " + i*j + " ");}
				else {System.out.print(i*j + " ");}	
			}
			System.out.println();
		}
	}
}
