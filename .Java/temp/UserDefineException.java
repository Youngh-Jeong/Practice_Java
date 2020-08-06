import java.util.*;

class AgeInputException extends Exception{
	// Exception Ŭ������ ��ӹ޾����Ƿ� ���� Ŭ������ ��
	public AgeInputException() {
		super("��ȿ���� ���� ���̰� �ԷµǾ����ϴ�.");
		// ���ܹ߻��� ������ �޼����� �Ű������� �Ͽ� ����Ŭ������ �����ڸ� ȣ��
	}
}

class UserDefineException{
	public static void main(String[] args) 	{
		System.out.print("���̸� �Է��ϼ��� : ");

		try{
			int age = readAge();
			System.out.println("����� : " + age + "���Դϴ�.");
		} catch (AgeInputException e){
			System.out.println(e.getMessage());
		}
	}
	public static int readAge() throws AgeInputException {
	// throwes AgeInputException : �޼ҵ� ����ο� �Է��ϴ� ����ó�� ������, ���ܰ� �߻��ϸ� �� �޼ҵ忡�� ó���ϴ� ���� �ƴ� �� �޼ҵ带 ȣ���� ������ ó���� �ѱ�ڴٴ� �ǹ�
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age<0){ // ��ȿ���� ���� ���հ��� �Է����� ���
			AgeInputException excpt = new AgeInputException();
			// ����Ŭ������ �ν��Ͻ� ���� (������ �ν��Ͻ��� �߻��� ����)
			throw excpt;
			// excpt�� �ش��ϴ� ���ܰ� �߻��ߴٴ� ���� JVM�� �˷��ִ� ����
			// JVM�� ���ܹ߻��� ���� ó�� ��ī������ �ߵ���Ŵ
		}
		return age;
	}
}
