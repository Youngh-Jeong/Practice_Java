import java.util.Scanner;
class Q2_1_9{
	public static void main(String[] args) {
		// �����ϼ� ���ϴ� �޼ҵ�
		Scanner input = new Scanner(System.in);
		System.out.print("��");
		int year = input.nextInt(); 
		System.out.print("��");
		int month = input.nextInt(); 
		System.out.print("��");
		int day = input.nextInt(); 

		System.out.printf("��� �� �� : " + dayOfYear(year, month, day));
		System.out.printf("���� �� �� : " + leftDayOfYear(year, month, day));
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
	static int leftDayOfYear(int y, int m, int d) {
		if (isLeap(y)==0) {
			return 365 - dayOfYear(y, m, d);
		}
		return 366 - dayOfYear(y,m,d);
	}
}
