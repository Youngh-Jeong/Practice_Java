import java.util.Arrays;
import java.util.Scanner;
class Q3_1_6{
	public static void main(String[] args) {
		// Arrays.binarySearch�� �ϵ� �˻��� �����ϸ� ���� ����Ʈ�� �� ���
		Scanner input = new Scanner(System.in);
		System.out.print("��� ��");
		int num = input.nextInt();
		int[] x = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = input.nextInt();
		}

		System.out.print("�˻��� ��");
		int ky = input.nextInt();

		int idx = Arrays.binarySearch(x,  ky);

		if (idx < 0)
			System.out.println("���� ����Ʈ : " + (-idx-1));
		else
			System.out.println("���� " + idx );
	}
}
