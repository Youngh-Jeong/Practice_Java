class WhileExam {
	public static void main(String[] args)	{
		// 1~100������ ���� ���Ͽ� ���(while�� �̿�)
		// ��� : 1~100������ �� : 5050
		int i = 1;
		int add = 0;
		while (i<=100){
			add = add + i;
			i++;
		}
		System.out.println("1~100������ �� : " + add);

		//100������ ��� �߿��� 2�� 7�� ������� ��� ���Ͽ� ��� : do-while�� �̿�
		int n = 0;
		int sum = 0;
		do {
			if (n%2==0&&n%7==0)	{
				sum = sum + n;
			}
			n++;
		}
		while (n<=100);
		System.out.println("������� �� : " + sum);
	}
}
