import java.util.Scanner;
class Q2_1_5{
	public static void main(String[] args) {
		// �迭b�� a�� �������� �����ϴ� �޼���
		Scanner stdIn = new Scanner(System.in);

		System.out.print("�迭 a�� ũ�⸦ �Է��ϼ���");
		int numa = stdIn.nextInt(); 
		int[] a = new int[numa]; 
		for (int i = 0; i < numa; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}

		System.out.print("�迭 b�� ũ�⸦ �Է��ϼ���");
		int numb = stdIn.nextInt(); 
		int[] b = new int[numb]; 
		for (int i = 0; i < numb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}

		copy(a, b); 

		System.out.println("���� �Ϸ�");
		for (int i = 0; i < numa; i++)
			System.out.println("a[" + i + "] = " + a[i]);
	}
	public static void copy(int[] a, int[] b) { 
		int num = a.length;
		if (num>b.length) {num = b.length;}
		for (int i = 0; i < num;i++) {
			a[i] = b[b.length-i-1];
		}
	}
}
