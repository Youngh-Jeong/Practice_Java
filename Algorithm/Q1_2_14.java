import java.util.Scanner;
class Q1_2_14{
	public static void main(String[] args) {
		// n¥�� ���簢��
		System.out.println("�簢���� ����մϴ�.");
		System.out.println("�� �� : ");
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
