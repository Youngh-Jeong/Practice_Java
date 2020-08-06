import java.util.*;

class AgeInputException extends Exception{
	public AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}

class UserDefineException2{
	public static void main(String[] args) throws AgeInputException	{
		// thorws AgeInputException : 현 메소드를 실행할 때 AgeInputException 예외가 발생하면 현 메소드(main())를 호출할 곳(JVM)으로 예외처리를 넘김
		System.out.print("나이를 입력하세요 : ");
		int age = readAge();
		System.out.println("당신은 : " + age + "세입니다.");
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
