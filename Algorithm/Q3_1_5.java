import java.util.Scanner;
class Q3_1_5{
	public static void main(String[] args) {
		// �����˻��� �ϵ�, �ߺ����� ��� �� ���� ��Ҹ� ã�� �޼ҵ�
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

		int idx = binSearchX(x, num, ky);

		if (idx == -1)
			System.out.println("����");
		else
			System.out.println("���� " + idx + "���� ó������.");
	}
	static int binSearchX(int[] a, int n, int key) {
		int sValue = 0;
		int eValue = n-1;
		while (sValue<=eValue) {
			int nValue = (sValue + eValue)/2;
			if (a[nValue]==key) {
				while (a[nValue]==a[nValue-1]) {
					nValue = nValue - 1;
				}
				return nValue;
			} else if(a[nValue]<key) {
				sValue = nValue+1;
			} else {
				eValue = nValue-1;
			}
		}
		return -1;
	}
}
