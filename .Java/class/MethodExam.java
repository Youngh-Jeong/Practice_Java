class MethodExam{
	public static void main(String[] args) {
		absDiff(10, 20);
		absDiff(35, 20);
	}
	// 두 정수를 입력받아 두 수의 차를 절대값으로 구하여 출력하는 메소드 작성
	// 예) 10과 20의 차는 10 / 35와 20의 차는 15
	public static void absDiff(int a1, int a2) {
		int diff;
		diff = a1 - a2;
		if (diff>0){//양수일 때 즉, 차이를 그대로 출력
			System.out.println(a1 + "과 " + a2 + "의 차는 " + diff);
		} else {
			System.out.println(a1 + "과 " + a2 + "의 차는 " + (-diff));
		}
	}
}
