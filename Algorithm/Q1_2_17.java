import java.util.Scanner;
class Q1_2_17{
	public static void main(String[] args) {
		// n단 피라미드 출력
		System.out.println("피라미드를 출력합니다.");
		System.out.println("단 수 : ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		spira(n);
	}
	public static void spira(int n) {
		for (int i = 0; i<n; i++) {
			for (int j = 0; j < i+1;j++){
				System.out.print(" ");
			}
			for (int j = 0; j < (2*(n-i-1)+1);j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
