import java.util.Scanner;
class Q1_2_8{
	public static void main(String[] args) {
		//  가우스의 방식을 이용해 1부터 n까지의 합 구하기
		Scanner input = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구함");
		System.out.print("n : "); int n = input.nextInt();
		int sum = (1+n)*(n)/2;
		System.out.println("합 : " + sum);
	}
}
