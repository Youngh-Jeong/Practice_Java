import java.util.*;

class AgeInputException extends Exception{
	// Exception 클래스를 상속받았으므로 예외 클래스가 됨
	public AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
		// 예외발생시 보여줄 메세지를 매개변수로 하여 상위클래스의 생성자를 호출
	}
}

class UserDefineException{
	public static void main(String[] args) 	{
		System.out.print("나이를 입력하세요 : ");

		try{
			int age = readAge();
			System.out.println("당신은 : " + age + "세입니다.");
		} catch (AgeInputException e){
			System.out.println(e.getMessage());
		}
	}
	public static int readAge() throws AgeInputException {
	// throwes AgeInputException : 메소드 선언부에 입력하는 예외처리 문구로, 예외가 발생하면 현 메소드에서 처리하는 것이 아닌 현 메소드를 호출한 곳으로 처리를 넘기겠다는 의미
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age<0){ // 유효하지 않은 나잇값을 입력했을 경우
			AgeInputException excpt = new AgeInputException();
			// 예외클래스의 인스턴스 생성 (생성된 인스턴스가 발생한 예외)
			throw excpt;
			// excpt에 해당하는 예외가 발생했다는 것을 JVM에 알려주는 역할
			// JVM은 예외발생에 대한 처리 메카니즘을 발동시킴
		}
		return age;
	}
}
