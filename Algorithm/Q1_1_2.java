import java.util.Scanner;
class Q1_1_2{
	public static void main(String[] args) {
		//  �� ���� �ּڰ��� ���ϴ� min3 �޼��带 �ۼ��ϼ���
		Scanner input = new Scanner(System.in);
		System.out.println("�� ������ �ּڰ��� ���մϴ�.");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		System.out.print("c : "); int c = input.nextInt();
		System.out.print("�ִ� : " + min3(a, b, c));
	}
	public static int min3(int a, int b, int c) {
		int min = a;
		if(min>b) {
			min = b;
		}
		if(min>c) {
			min = c;
		}
		return min;
	};
}
