import java.util.Scanner;
class Q1_2_7{
	public static void main(String[] args) {
		//  1���� n���� ���� for���� �̿��� ������ '1+2+..+n = sum�� ���·� ���
		Scanner input = new Scanner(System.in);
		System.out.println("1���� n������ ���� ����");
		System.out.print("n : "); int n = input.nextInt();
		int sum = 0;
		for(int i = 1; i<n+1;i++) {
			sum += i;
			if(i!=n) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i);
			}
		}
		System.out.println(" = " + sum);
	}
}
