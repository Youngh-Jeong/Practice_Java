import java.util.Scanner;
class Q3_1_1{
	public static void main(String[] args) {
		// while���� for������ ����
		Scanner input = new Scanner(System.in);
		System.out.print("��� ��");
		int num = input.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = input.nextInt();
		}

		System.out.print("�˻��� ��");
		int ky = input.nextInt();

		int idx = seqSearchSen(x, num, ky);

		if (idx == -1)
			System.out.println("����");
		else
			System.out.println("���� x[" + idx + "]�� ����.");
	}
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		for(i = 0; a[i]!=key;i++) {
		}
		if (i==n) {
			return -1;
		}
		return 1;
	}
}
