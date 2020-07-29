class  VariableEx2 {
	public static void main(String[] args) {
		long num = 12345678900L; // 그냥 12345678900으로 쓰면, 상수이므로 int(기본형)로 사용되고, 오버플로우 전에 체크함
		// 정수 사용시 int의 범위를 벗어나는 값을 사용할 때에는 접미사 (l 또는 L)를 사용함
		// 유일하게 대소문자를 구분하지 않고 사용할 수 있음
		System.out.println("num : "+ num);

		float f1 = 3.14F;
		// 실수의 기본형은 double이므로 float형 변수에 넣을 때는 접미사 (f 또는 F)를 사용함
		System.out.println("f1 : "+ f1);
	}
}
