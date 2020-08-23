import java.util.Scanner;
class Q1_2_9{
	public static void main(String[] args) {
		//  정수 a, b를 입력하면 둘을 포함해 그 사이의 모든 정수 합을 구하여 반환하는 메서드 작성
		Scanner input = new Scanner(System.in);
		System.out.println("두 수 사이 숫자들의 합을 구함");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		int diff = b-a;
		if (diff<0) diff = -diff;
		int sum = (b+a)*(diff+1)/2;
		System.out.println("합 : " + sum);
	}
}
