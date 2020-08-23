import java.util.Scanner;
class Q1_1_2{
	public static void main(String[] args) {
		//  세 값의 최솟값을 구하는 min3 메서드를 작성하세요
		Scanner input = new Scanner(System.in);
		System.out.println("세 정수의 최솟값을 구합니다.");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		System.out.print("c : "); int c = input.nextInt();
		System.out.print("최댓값 : " + min3(a, b, c));
	}
	public static int min3(int a, int b, int c) {
		int min = a;
		if(min>b) {
			min = b;
		}
		if(min>c) {
			min = c;
		}
		return min;
	};
}
