import java.util.Scanner;
class Q1_2_15{
	public static void main(String[] args) {
		// n¥�� �����̵�ﰢ��
		System.out.println("�����̵�ﰢ���� ����մϴ�.");
		System.out.println("�� �� : ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0;i<n;i++) {
			for(int j = 0; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
