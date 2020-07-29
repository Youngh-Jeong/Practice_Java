class IfEx1
{
	public static void main(String[] args) 
	{
		int num = 11;
		if (num > 0){
			System.out.println("num은 양수이다.");
		}
		else {
			System.out.println("num은 음수이거나 0이다.");
		}

		// num의 값이 짝수인지 검사하여 출력

		if (num % 2 == 0)
		{// true가 무슨 의미인지 주석을 달아줄 것 ex. num이 짝수면
			System.out.println(num + "은 짝수이다.");
		}
		else {
		// num이 홀수면
			System.out.println(num + "은 홀수이다.");
		}
	}
}
