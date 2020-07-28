class VariableEx1 { //속도를 위해 ctrl+c ctral+v 이용할 것
	public static void main(String[] args) {
		boolean b1; // boolean형 변수 b1을 선언 및 생성 (선언과 생성이 다른 경우도 있음)
		b1 = false; // 변수에 처음 값을 넣는 행위를 '초기화'라고 함
		// 될 수 있으면 변수의 초기화는 빨리 할 수록 좋다. 사람이 보면 헷갈림

		char c1 = 'a';	// 변수 선언과 동시에 초기화를 할 수도 있음    * 따로 해야 하는것 뭐였는지 찾아보기

		int i1 = 10, i2 = 20, i3;
		// 같은 자료형의 변수는 쉼표로 구분하여 여러 개를 한 줄에 선언할 수 있음
		i3 = i1 + i2;
		System.out.println("b1 : " + b1);
		System.out.println("c1 : " + c1);
		System.out.println("i1 : " + i1);
		System.out.println("i2 : " + i2);
		System.out.println("i3 : " + i3);
	}
}
