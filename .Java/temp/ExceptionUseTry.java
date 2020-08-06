import java.util.*;

class ExceptionUseTry{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];

		for (int i = 0;i<3 ;i++){
			try	{
				System.out.println("������ ���� �� �Է� : ");
				int num1 = sc.nextInt();

				System.out.println("������ �� �Է� : ");
				int num2 = sc.nextInt();

				System.out.println("������ ��� ���� �ε��� �Է� : ");
				int idx = sc.nextInt();

				arr[idx] = num1 / num2;
				System.out.println("������ ��� : " + arr[idx]);
				System.out.println("����� ��ġ : " + idx);	
			} catch (ArithmeticException e)	{
				// ArithmeticException �� �߻��� ��� ó���ϴ� ����
				System.out.println("������ ���� 0�� �� �� �����ϴ�.");
				i--;
				continue;
			} catch (ArrayIndexOutOfBoundsException e){
				// ArrayIndexOutOfBoundsException �� �߻��� ��� ó���ϴ� ����
				System.out.println("�ε����� 0~99 ������ ���Դϴ�.");
				i--;

				continue;
			} catch (Exception e) {
				// ��� ���ܿ� ���� ó��
				// �ҰŹ����� �귯���Ƿ� �׻� ���� �Ʒ��� �־�� ��
				System.out.println("���ܹ߻�");
			}
		}
	}
}

