import java.util.Scanner;
class Q3_1_3{
	public static void main(String[] args) {
		// ��ġ�ϴ� key�� ��� ã�� �޼ҵ�
		Scanner input = new Scanner(System.in);
		System.out.print("��� ��");
		int num = input.nextInt();
		int[] x = new int[num];
		int[] idx = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = input.nextInt();
		}

		System.out.print("�˻��� ��");
		int ky = input.nextInt();

		int count = searchIdx(x, num, ky, idx);

		if (count == -1)
			System.out.println("����");
		else
			System.out.println("���� " + count + "�� ����.");
			for(int j = 0;j<count;j++) {
				System.out.print(idx[j] + " ");
			} 
	}
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;

		for(int i = 0; i<n;i++) {
			if (a[i]==key) {
				idx[count]=i;
				count++;
			}
		}
		if (count==0) {
			return -1;
		}

		return count;
	}
}
