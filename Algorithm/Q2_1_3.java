import java.util.Scanner;
class Q2_1_3{
	public static void main(String[] args) {
		// �迭 ���ʿ� ���ڸ��� �־� ��� ��ȯ�� �����ϴ� �޼���
		System.out.println("�迭�� ���մϴ�.");
		System.out.print("�迭 ũ�� : " );
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		showArr(arr);
		sumOf(arr);
		
		

	}
	public static int cardConv(int x, int r, char[] d) { //x�� r������ ��ȯ�� d�� �����ϰ� �ڸ����� ��ȯ
		int digit = 0;
		String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			
		} while(x!=0)
	}
}
