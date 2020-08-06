import java.math.*;

class BigIntegerUse {
	public static void main(String[] args) {
		System.out.println("최대 정수 : " + Long.MAX_VALUE);
		System.out.println("최소 정수 : " + Long.MIN_VALUE);

		BigInteger big1 = new BigInteger("100000000000000000000");
		BigInteger big2 = new BigInteger("-99999999999999999999");
		BigInteger bigadd = big1 .add(big2);
		BigInteger bigmul = big1.multiply(big2);

		System.out.println("합 : " + bigadd);
		System.out.println("곱 : " + bigmul);
	}
}
