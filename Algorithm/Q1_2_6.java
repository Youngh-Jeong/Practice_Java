import java.util.Scanner;
class Q1_2_6{
	public static void main(String[] args) {
		//  1���� n���� ���� ���ϰ� i�� n+1�� �ǵ��� ����
		Scanner input = new Scanner(System.in);
		System.out.println("1���� n������ ���� ����");
		System.out.print("n : "); int n = input.nextInt();
		int sum = 0;
		int i = 1;
		while (i<=n) {
			sum += i;
			i++;
		}
		System.out.println("�� : " + sum);
		System.out.println("i : " + i);
	}
}
