class MethodEx1 {
	public static void main(String[] args) {
		System.out.println("프로그램의 시작");
		testMethod1(23);
		testMethod2(177.8, 75.5);
		System.out.println("프로그램의 종료");
	}
	public static void testMethod1(int age) {
		System.out.println("제 나이는 " + age + " 입니다.");
	}
	public static void testMethod2(double tall, double weight) { // 매개변수는 동일한 자료형이라도 각각 따로 자료형을 지정해야 함
		System.out.println("제 키는 " + tall + "cm 이고, 몸무게는 " + weight + " 입니다.");
	}
}
