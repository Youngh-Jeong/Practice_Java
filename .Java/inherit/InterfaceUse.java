import java.util.*;

interface Week{
	int MON = 1, TUE = 2, WED = 3, THU = 4, FRI = 5, SAT = 6, SUN = 7;
	// 인터페이스에서 선언한 변수이므로 자동으로 public static final로 선언됨
}

class InterfaceUse{
	public static void main(String[] args) 	{
		System.out.println("오늘의 요일을 선택하세요.");
		System.out.println("1: 월, 2: 화, 3: 수, 4: 목, 5: 금, 6: 토, 7: 일");
		System.out.print("요일 번호 입력 : ");

		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();

		switch (sel){
		case Week.MON:
			System.out.println("월요일  입니다."); break;
		case Week.TUE:
			System.out.println("화요일  입니다."); break;
		case Week.WED:
			System.out.println("수요일  입니다."); break;
		case Week.THU:
			System.out.println("목요일  입니다."); break;
		case Week.FRI:
			System.out.println("금요일  입니다."); break;
		case Week.SAT:
			System.out.println("토요일  입니다."); break;
		case Week.SUN:
			System.out.println("일요일  입니다."); break;
		
		}
	}
}
