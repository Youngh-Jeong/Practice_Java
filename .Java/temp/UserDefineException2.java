import java.util.*;

class AgeInputException extends Exception{
	public AgeInputException() {
		super("��ȿ���� ���� ���̰� �ԷµǾ����ϴ�.");
	}
}

class UserDefineException2{
	public static void main(String[] args) throws AgeInputException	{
		// thorws AgeInputException : �� �޼ҵ带 ������ �� AgeInputException ���ܰ� �߻��ϸ� �� �޼ҵ�(main())�� ȣ���� ��(JVM)���� ����ó���� �ѱ�
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = readAge();
		System.out.println("����� : " + age + "���Դϴ�.");
	}
	public static int readAge() throws AgeInputException {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age<0){
			AgeInputException excpt = new AgeInputException();
			throw excpt;
		}
		return age;
	}
}
