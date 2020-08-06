class BoxingUnboxing{
	public static void main(String[] args) {
		Integer iValue = new Integer(10);
		Double dValue = new Double(3.14);
		// 기본 자료형 데이터를 Wrapper클래스를 이용하여 객체로 생성 : boxing
		System.out.println(iValue);
		System.out.println(dValue);
		// Wrapper클래스의 인스턴스는 출력시 데이터를 그대로 출력함

		int n1 = iValue.intValue();
		double n2 = dValue.doubleValue();
		// 객체를 기본자료형 데이터로 변환 : unboxing
		System.out.println(n1);
		System.out.println(n2);
	}
}
