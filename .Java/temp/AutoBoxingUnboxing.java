class AutoBoxingUnboxing{
	public static void main(String[] args) {
		Integer iValue = 10;
		Double dValue = 3.14;
		// Wrapper클래스의 생성자를 이용하지 않고 데이터를 직접 넣어도 객체가 생성됨 : auto boxing
		System.out.println(iValue);
		System.out.println(dValue);

		int n1 = iValue;
		double n2 = dValue;
		// 변수에 객체를 바로 넣어도 오류없이 동작됨 : auto unboxing
		System.out.println(n1);
		System.out.println(n2);
	}
}
