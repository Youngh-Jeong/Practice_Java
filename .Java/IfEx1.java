class IfEx1
{
	public static void main(String[] args) 
	{
		int num = 11;
		if (num > 0){
			System.out.println("num�� ����̴�.");
		}
		else {
			System.out.println("num�� �����̰ų� 0�̴�.");
		}

		// num�� ���� ¦������ �˻��Ͽ� ���

		if (num % 2 == 0)
		{// true�� ���� �ǹ����� �ּ��� �޾��� �� ex. num�� ¦����
			System.out.println(num + "�� ¦���̴�.");
		}
		else {
		// num�� Ȧ����
			System.out.println(num + "�� Ȧ���̴�.");
		}
	}
}
