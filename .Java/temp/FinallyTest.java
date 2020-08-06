class FinallyTest{
	public static void main(String[] args){
		boolean divOK = divide(4, 2);
		if (divOK)	System.out.println("연산 성공");
		else		System.out.println("연산 실패");

		divOK = divide(4, 0);
		if (divOK)	System.out.println("연산 성공");
		else		System.out.println("연산 실패");
	}

	public static boolean divide(int n1, int n2) {
		try{
			int result = n1/n2;
			System.out.println("나눗셈 결과 : " + result);
			return true;
		}catch (ArithmeticException e){
			e.printStackTrace();
			return false;
		} finally {
		// return되더라도 반드시 실행되는 영역
			System.out.println("finally 영역 실행");
		}
	}
}
