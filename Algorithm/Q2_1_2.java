import java.util.Scanner;
class Q2_1_2{
	public static void main(String[] args) {
		// �迭��Ҹ� �������� ���� (���� ������)
		System.out.println("�迭�� �������ϴ�.");
		System.out.print("�迭 ũ�� : " );
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		showArr(arr);
		reverse(arr);
		
		

	}
	public static void reverse(int[] a) { //���� �޼ҵ�
		for (int i = 0; i<a.length/2;i++) {
			int tmp = a[i];
			a[i] = a[a.length-i-1];
			a[a.length-i-1] = tmp;
			System.out.println("a[" + i + "]�� a[" +(a.length-i-1) + "]�� ��ȯ�մϴ�.");
			showArr(a);
		}
		System.out.println("���� ������ ���ƽ��ϴ�.");
	}
	public static void showArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
