import java.util.*;

class ExceptionUseIf{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];

			for (int i = 0;i<3 ;i++){
				System.out.println("나누어 지는 수 입력 : ");
				int num1 = sc.nextInt();

				System.out.println("나누는 수 입력 : ");
				int num2 = sc.nextInt();

				if (num2 == 0){
					System.out.println("나누는 수는 0이 될 수 없습니다.");
					i--;
					continue;
				}

				System.out.println("나눗셈 결과 저장 인덱스 입력 : ");
				int idx = sc.nextInt();
				if (0>idx||idx>99){
					System.out.println("인덱스는 0~99 사이의 값입니다.");
					i--;
					continue;
				}

				arr[idx] = num1 / num2;
				System.out.println("나눗셈 결과 : " + arr[idx]);
				System.out.println("저장된 위치 : " + idx);
			}
	}
}

/*
if문을 이용한 예외처리로 실제로는 거의 사용하지 않음
*/

