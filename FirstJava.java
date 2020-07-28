class FirstJava {
	public static void main(String[] args) {
		System.out.println("Java를 자바라");
		System.out.println("2 + 5 = " + 2 + 5);		// 2 + 5 = 25 *문자형+2+5 => 문자형
		System.out.println("2 + 5 = " + (2 + 5));	// 2 + 5 = 7  *출력은 서버에서 됨. 따라서 웹에서 띄우려면 다른 방식
		System.out.println(2 + 5 + " = 2 + 5");		// 7 = 2 + 5
	}
}
//중괄호 위치 맞추기, 중괄호 후에는 탭으로 들여쓰기
//javac : 컴파일해줌 [javac 파일이름.java]
//java : 실행해줌 [java 파일이름]
