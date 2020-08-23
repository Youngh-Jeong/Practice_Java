import java.util.Scanner;
class Q1_2_10{
	public static void main(String[] args) {
		//  b-a를 구하되, b가 a보다 작으면 변수 b의 값을 다시 받음
		Scanner input = new Scanner(System.in);
		System.out.println("두 수 의 차이를 구함");
		System.out.print("a : "); int a = input.nextInt();
		int b;
		do {
			System.out.println("a보다 큰 값을 입력하세요.");
			System.out.print("b : "); b = input.nextInt();
		} while (b<a);
		int diff = b-a;
		System.out.println("b-a : " + diff);
	}
}
