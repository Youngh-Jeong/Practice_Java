import java.util.Scanner;
class Q1_1_1{
	public static void main(String[] args) {
		// �� ���� �ִ��� ���ϴ� max4 �޼��带 �ۼ��ϼ���
		Scanner input = new Scanner(System.in);
		System.out.println("�� ������ �ִ��� ���մϴ�.");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		System.out.print("c : "); int c = input.nextInt();
		System.out.print("d : "); int d = input.nextInt();
		System.out.print("�ִ� : " + max4(a, b, c,d ));
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
