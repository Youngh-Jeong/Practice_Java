import java.util.*;

class ExceptionUseIf{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];

			for (int i = 0;i<3 ;i++){
				System.out.println("������ ���� �� �Է� : ");
				int num1 = sc.nextInt();

				System.out.println("������ �� �Է� : ");
				int num2 = sc.nextInt();

				if (num2 == 0){
					System.out.println("������ ���� 0�� �� �� �����ϴ�.");
					i--;
					continue;
				}

				System.out.println("������ ��� ���� �ε��� �Է� : ");
				int idx = sc.nextInt();
				if (0>idx||idx>99){
					System.out.println("�ε����� 0~99 ������ ���Դϴ�.");
					i--;
					continue;
				}

				arr[idx] = num1 / num2;
				System.out.println("������ ��� : " + arr[idx]);
				System.out.println("����� ��ġ : " + idx);
			}
	}
}

/*
if���� �̿��� ����ó���� �����δ� ���� ������� ����
*/

