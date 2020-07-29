class MethodEx2{
	public static void main(String[] args){
		int n1, n2, n3;
		n3 = adder(4, 5);
		System.out.println("4와 5의 합 : " + n3);
		System.out.println("3.5의 제곱 : " + square(3.5));
		System.out.println("3은 " + evenOdd(3) + "수 입니다.");
	}
	public static int adder(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	public static double square(double d1) {
		return d1*d1;
	}
	public static char evenOdd(int n) {
		if (n%2==0){
			return '짝';
		} else {
			return '홀';
		}
		// if문 안에서 return을 하려면 반드시 else문을 사용해서 return해야 함
		// else if 문에서 return하는 걸로 끝나면 JVM은 조건에 따라 return되지 않을 수도 있다고 판단하여 missing return statement 오류를 발생시킴
	}
}
