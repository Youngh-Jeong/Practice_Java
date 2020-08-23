import java.util.Scanner;
class Q1_2_6{
	public static void main(String[] args) {
		//  1부터 n까지 합을 구하고 i이 n+1이 되도록 구성
		Scanner input = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구함");
		System.out.print("n : "); int n = input.nextInt();
		int sum = 0;
		int i = 1;
		while (i<=n) {
			sum += i;
			i++;
		}
		System.out.println("합 : " + sum);
		System.out.println("i : " + i);
	}
}
