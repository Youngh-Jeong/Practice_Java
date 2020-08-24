import java.util.Scanner;
class Q2_1_8{
	public static void main(String[] args) {
		// dayOfYear를 변수i와 days없이 구현하세요.(while문 사용)
		Scanner input = new Scanner(System.in);
		System.out.print("년");
		int year = input.nextInt(); 
		System.out.print("월");
		int month = input.nextInt(); 
		System.out.print("일");
		int day = input.nextInt(); 

		System.out.printf("경과 일 수 : " + dayOfYear(year, month, day));
	}
	static int dayOfYear(int y, int m, int d) {
		while(m>0) {
			d += mdays[isLeap(y)][m-1];
			m--;
		}
		return d;
	}
	static int[][] mdays = {{31,28,31,30,31,30,31,31,30,31,30,31},{31,29,31,30,31,30,31,31,30,31,30,31}};
	
	static int isLeap(int year) {
		return (year % 4 == 0 && year%100 != 0||year%400 == 0) ? 1 : 0;
	}
}
