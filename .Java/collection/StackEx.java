import java.util.*;

// 웹브라우저의 '뒤로가기'와 '앞으로가기'를 Stack을 이용하여 구현한 프로그램
class StackEx{
	public static Stack back = new Stack(); // 뒤로가기 히스토리를 저장할 스택
	public static Stack forward = new Stack(); // 앞으로 가기 히스토리를 저장할 스택

	public static void main(String[] args) {
		goURL("1.네이트");		goURL("2.야후");
		goURL("3.네이버");		goURL("4.다음");
		// 특정 주소로 이동시킴 - 뒤로 가기 히스토리에도 쌓임
		printStatus();
		//back : [1.네이트, 2.야후, 3.네이버, 4.다음]
		//forward : []
		//현재 화면은 '4.다음' 입니다.
		goBack();		
		System.out.println("= 뒤로가기 버튼을 누른 후 =");
		printStatus();
		//back : [1.네이트, 2.야후, 3.네이버]
		//forward : [4.다음]
		//현재 화면은 '3.네이버' 입니다.
		goBack();		
		System.out.println("= 뒤로가기 버튼을 누른 후 =");
		printStatus();
		//back : [1.네이트, 2.야후]
		//forward : [4.다음, 3.네이버]
		//현재 화면은 '2.야후' 입니다.

		goForward();		
		System.out.println("= 앞으로가기 버튼을 누른 후 =");
		printStatus();
		//back : [1.네이트, 2.야후, 3.네이버]
		//forward : [4.다음]
		//현재 화면은 '3.네이버' 입니다.

		goURL("google.com");
		System.out.println("= 새로운 주소로 이동 후 =");
		printStatus();
		//back : [1.네이트, 2.야후, 3.네이버, google.com]
		//forward : []
		//현재 화면은 'google.com' 입니다.
	}

	public static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("현재 화면은 '" + back.peek() + "' 입니다.");
		// peek() : Stack의 맨 위 데이터를 추출 (원본은 그대로)
		System.out.println();
	}
	public static void goURL(String url){
		back.push(url);
		// 받아온 url을 back에 저장
		if (!forward.empty()) forward.clear();
		// forward(앞으로가기 히스토리)가 비어있지 않으면 forward를 비움
	}
	public static void goForward() {
		if (!forward.empty()) back.push(forward.pop());
		// forward가 비어있지 않으면 back에 forward의 맨 위 데이터를 뽑아내어 저장시킴
	}
	public static void goBack() {
		if (!back.empty()) forward.push(back.pop());
		// back이 비어있지 않으면 forward에 back의 맨 위 데이터를 뽑아내어 저장시킴
	}
}
