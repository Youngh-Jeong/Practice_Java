import java.util.Scanner;
class Q1_2_11{
	public static void main(String[] args) {
		// ���� ������ �Է��ϰ� �ڸ����� ����ϴ� ���α׷�
		Scanner input = new Scanner(System.in);
		System.out.println("�ڸ����� ����");
		int n;
		do {
			System.out.println("����� �Է��ϼ���.");
			System.out.print("n : "); n = input.nextInt();
		} while (n<=0);
		int count=0;
		while (n!=0) {
			n /=10;
			count++;
		}
		System.out.println("�� ���� " + count + "�ڸ��Դϴ�.");
	}
}
