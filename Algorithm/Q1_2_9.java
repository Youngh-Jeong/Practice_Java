import java.util.Scanner;
class Q1_2_9{
	public static void main(String[] args) {
		//  ���� a, b�� �Է��ϸ� ���� ������ �� ������ ��� ���� ���� ���Ͽ� ��ȯ�ϴ� �޼��� �ۼ�
		Scanner input = new Scanner(System.in);
		System.out.println("�� �� ���� ���ڵ��� ���� ����");
		System.out.print("a : "); int a = input.nextInt();
		System.out.print("b : "); int b = input.nextInt();
		int diff = b-a;
		if (diff<0) diff = -diff;
		int sum = (b+a)*(diff+1)/2;
		System.out.println("�� : " + sum);
	}
}
