import java.util.Scanner;
class Q1_2_8{
	public static void main(String[] args) {
		//  ���콺�� ����� �̿��� 1���� n������ �� ���ϱ�
		Scanner input = new Scanner(System.in);
		System.out.println("1���� n������ ���� ����");
		System.out.print("n : "); int n = input.nextInt();
		int sum = (1+n)*(n)/2;
		System.out.println("�� : " + sum);
	}
}
