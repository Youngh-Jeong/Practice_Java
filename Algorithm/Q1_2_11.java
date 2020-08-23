import java.util.Scanner;
class Q1_2_11{
	public static void main(String[] args) {
		// 양의 정수를 입력하고 자릿수를 출력하는 프로그램
		Scanner input = new Scanner(System.in);
		System.out.println("자릿수를 구함");
		int n;
		do {
			System.out.println("양수를 입력하세요.");
			System.out.print("n : "); n = input.nextInt();
		} while (n<=0);
		int count=0;
		while (n!=0) {
			n /=10;
			count++;
		}
		System.out.println("그 수는 " + count + "자리입니다.");
	}
}
