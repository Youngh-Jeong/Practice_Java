class StringEx2{
	public static void main(String[] args) {
		String str1 = "test@abc.com";		String str2 = "testabc.com";
		String str3 = "test@abccom";		String str4 = "test.abc@com";

		emailTest(str1);		emailTest(str2);
		emailTest(str3);		emailTest(str4);
	}
	public static void emailTest(String str) {// �̸��� �ּҸ� �˻��� �� ����� ����ϴ� �޼ҵ�
		/*
		1. �ݵ�� '@'�� �־�� �Ѵ�. 2. �ݵ�� '.'�� �־�� �Ѵ�. 3. '@'�� '.'���� �տ� �־�� �Ѵ�.
		�̸����� ������ �̸����ּ� + "�� �̸����ּҰ� �½��ϴ�."
		�̸����� �ƴϸ� �̸����ּ� + "�� �̸����ּҰ� �ƴմϴ�."
		*/

		int at = str.indexOf('@'); //str���� '@'�� ��ġ �ε����� at�� ����
		int dot = str.indexOf('.'); //str���� '.'�� ��ġ �ε����� dot�� ����

		/*
		boolean isEmail = true; // �̸��� �ּҰ� �´��� ���θ� ������ ����
		if (at == -1) isEmail = false;	// '@'�� ���� ����
		if (dot == -1) isEmail = false; // '.'�� ���� ����
		if (at>dot) isEmail = false;	// '@'�� ��ġ�� '.'���� ������ ����

		if (isEmail){
			System.out.println(str + "�� �̸����ּҰ� �½��ϴ�.");
		} else {
			System.out.println(str + "�� �̸����ּҰ� �ƴմϴ�.");
		}
		*/

		boolean cond1;
		boolean cond2;
		boolean cond3;

		cond1 = at>0;
		cond2 = dot>0;
		cond3 = at<dot;


		if (cond1&&cond2&&cond3){
			System.out.println(str + "�� �̸����ּҰ� �½��ϴ�.");
		} else {
			System.out.println(str + "�� �̸����ּҰ� �ƴմϴ�.");
		}
	}
}