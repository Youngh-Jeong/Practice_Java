import java.util.Scanner;
class Q1_1_3{
	public static void main(String[] args) {
		//  �� ���� �ּڰ��� ���ϴ� min4 �޼��带 �ۼ��ϼ���
		Scanner input = new Scanner(System.in);
		System.out.println("�� ������ �ּڰ��� ���մϴ�.");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		System.out.print("c : "); int c = input.nextInt();
		System.out.print("d : "); int d = input.nextInt();
		System.out.print("�ּڰ� : " + min4(a, b, c, d));
	}
	public static int min4(int a, int b, int c, int d) {
		int min = a;
		if(min>b) {
			min = b;
		}
		if(min>c) {
			min = c;
		}
		if(min>d) {
			min = d;
		}
		return min;
	};
}
