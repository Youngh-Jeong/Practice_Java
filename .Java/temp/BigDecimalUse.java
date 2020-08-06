import java.math.*;
class BigDecimalUse {
	public static void main(String[] args) {
		double d1 = 1.6, d2 = 0.1;
		System.out.println("덧셈 결과 : " + (d1 + d2));
		// 덧셈 결과 : 1.7000000000000002
		System.out.println("곱셈 결과 : " + (d1 * d2));
		// 곱셈 결과 : 0.16000000000000003
		// 실수의 표현을 정확성 보다 표현 범위에 초점을 두기 때문에 연산시 정확하지 않음

		BigDecimal bd1 = new BigDecimal(1.6);
		BigDecimal bd2 = new BigDecimal(0.1);
		// BigDecimal 인스턴스 생성시 실수를 직접 입력하여 오차가 생기게 됨
		System.out.println("덧셈 결과 : " + bd1.add(bd2));
		// 덧셈 결과 : 1.7000000000000000943689570931383059360086917877197265625
		System.out.println("곱셈 결과 : " + bd1.multiply(bd2));
		// 곱셈 결과 : 0.1600000000000000177635683940025051398161724525855033823303533017413935457540219431393779814243316650390625

		BigDecimal bd3 = new BigDecimal("1.6");
		BigDecimal bd4 = new BigDecimal("0.1");
		// BigDecimal 인스턴스는 문자열로 정확한 실수를 입력한 후 연산해야 함
		System.out.println("덧셈 결과 : " + bd3.add(bd4));
		// 덧셈 결과 : 1.7
		System.out.println("곱셈 결과 : " + bd3.multiply(bd4));
		// 곱셈 결과 : 0.16

	}
}
