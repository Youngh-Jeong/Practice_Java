import java.util.Scanner;
class Q1_2_10{
	public static void main(String[] args) {
		//  b-a�� ���ϵ�, b�� a���� ������ ���� b�� ���� �ٽ� ����
		Scanner input = new Scanner(System.in);
		System.out.println("�� �� �� ���̸� ����");
		System.out.print("a : "); int a = input.nextInt();
		int b;
		do {
			System.out.println("a���� ū ���� �Է��ϼ���.");
			System.out.print("b : "); b = input.nextInt();
		} while (b<a);
		int diff = b-a;
		System.out.println("b-a : " + diff);
	}
}
