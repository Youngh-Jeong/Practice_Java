import java.util.Scanner;
class Q1_1_1{
	public static void main(String[] args) {
		// 네 값의 최댓값을 구하는 max4 메서드를 작성하세요
		Scanner input = new Scanner(System.in);
		System.out.println("네 정수의 최댓값을 구합니다.");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		System.out.print("c : "); int c = input.nextInt();
		System.out.print("d : "); int d = input.nextInt();
		System.out.print("최댓값 : " + max4(a, b, c,d ));
	}
	public static int max4(int a, int b, int c, int d) {
		int max = a;
		if(max<b) {
			max = b;
		}
		if(max<c) {
			max = c;
		}
		if(max<d) {
			max = d;
		}
		return max;
	};
}
