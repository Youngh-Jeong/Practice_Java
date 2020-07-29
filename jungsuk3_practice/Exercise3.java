class Exercise3{
	public static void main(String[] args) {

		//3-2 사과를 담는 데 필요한 바구니 수를 구하는 코드
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket =(numOfApples+9)/10;
		System.out.println("필요한 바구니의 수 : " + numOfBucket);

		//3-3 num의 값에 따라 양수, 음수, 0을 출력하는 삼항연산자를 이용한 코드
		int num_1 = 10;
		System.out.println(num_1 > 0 ? "양수" : num_1 == 0 ? "0" : "음수");

		//3-4 num의 값 중에서 백의 자리 이하를 버리는 코드
		int num_2 = 456;
		System.out.println((num_2/100)*100);

		//3-5 num의 값 중에서 일의 자리를 1로 바꾸는 코드
		int num_3 = 333;
		System.out.println((num_3/10)*10+1);

		//3-6 num의 값보다 크면서도 가장 가까운 10의 배수에서 num의 값을 뺀 나머지를 구하는 코드 ex. 24->6
		int num_4 = 24;
		System.out.println(10-(num_4%10));


		//3-7 화씨를 섭씨로 변환하는 코드 (변환식 c=5/9*(f-32)이고, 변환 결과값은 소수 셋째자리에서 반올림하며, math.round()를 사용하지 않고 처리할 것

		int fahrenheit = 100;
		float celcius = ((int)((5/9.0f*(fahrenheit-32))*100+0.5))/100.0f;
		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius : " + celcius);

		//3-8 코드 수정하기
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);

		char ch = 'A';
		ch = (char)(ch + 2);

		float f = 3/2f;
		long l = 3000l*3000*3000;

		float f2 = 0.1f;
		double d = 0.1;

		boolean result = (float)d==(f2);

		System.out.println("c="+c); //30
		System.out.println("ch="+ch); //C
		System.out.println("f="+f); //1.5
		System.out.println("l="+l); //27000000000
		System.out.println("result="+result); //true

		//3-9 ch가 영문자(대문자 or 소문자)거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 코드
		char ch_9 = 'z';
		boolean b_9 = (('a'<=ch_9&&ch_9<='z')||('A'<=ch_9&&ch_9<='Z')||('0'<=ch_9&&ch_9<='9'));
		System.out.println(b_9);

		//3-10 대문자를 소문자로 변경하는데, ch가 대문자일 때만 소문자로 변경한다. 문자코드는 소문자가 대문자보다 32만큼 더 크다.

		char ch_10 = 'D';
		char lowerCase = ('A'<=ch_10&&ch_10<='Z') ? (char)(ch_10 + 32) : ch;

		System.out.println("ch: " + ch_10);
		System.out.println("ch to lowerCase : "+lowerCase);
	}
}
