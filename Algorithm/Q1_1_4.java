import java.util.Scanner;
class Q1_1_4{
	public static void main(String[] args) {
		//  �� ���� �߾Ӱ��� ���Ͽ� ����ϴ� ���α׷�
		Scanner input = new Scanner(System.in);
		System.out.println("�� ������ �߾Ӱ��� ���մϴ�.");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		System.out.print("c : "); int c = input.nextInt();
		System.out.print("�߾Ӱ� : " + med3(a, b, c));
	}
	public static int med3(int a, int b, int c) {
		if(a>b) {
			if(b>=c) { // a>b>=c
				return b;
			}
			else if(a>=c) {// a>=c>b
				return c;
			}
			else { // c>a>b
				return a;
			}
		}
		else if(c>=b) {// c>=b>=a
			return b;
		}
		else if(a>=c) { // b>=a>=c
			return a;
		}
		else { // b>c>a
			return c;
		}
	};
}
