import java.util.*;

class ExceptionUseTry{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];

		for (int i = 0;i<3 ;i++){
			try	{
				System.out.println("나누어 지는 수 입력 : ");
				int num1 = sc.nextInt();

				System.out.println("나누는 수 입력 : ");
				int num2 = sc.nextInt();

				System.out.println("나눗셈 결과 저장 인덱스 입력 : ");
				int idx = sc.nextInt();

				arr[idx] = num1 / num2;
				System.out.println("나눗셈 결과 : " + arr[idx]);
				System.out.println("저장된 위치 : " + idx);	
			} catch (ArithmeticException e)	{
				// ArithmeticException 이 발생할 경우 처리하는 영역
				System.out.println("나누는 수는 0이 될 수 없습니다.");
				i--;
				continue;
			} catch (ArrayIndexOutOfBoundsException e){
				// ArrayIndexOutOfBoundsException 이 발생할 경우 처리하는 영역
				System.out.println("인덱스는 0~99 사이의 값입니다.");
				i--;

				continue;
			} catch (Exception e) {
				// 모든 예외에 대한 처리
				// 소거법으로 흘러가므로 항상 가장 아래에 있어야 함
				System.out.println("예외발생");
			}
		}
	}
}

