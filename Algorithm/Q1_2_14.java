import java.util.Scanner;
class Q1_2_14{
	public static void main(String[] args) {
		// n짜리 정사각형
		System.out.println("사각형을 출력합니다.");
		System.out.println("단 수 : ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0;i<n;i++) {
			for(int j = 0; j<n;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
