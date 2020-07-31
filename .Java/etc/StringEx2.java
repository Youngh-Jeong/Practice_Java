class StringEx2{
	public static void main(String[] args) {
		String str1 = "test@abc.com";		String str2 = "testabc.com";
		String str3 = "test@abccom";		String str4 = "test.abc@com";

		emailTest(str1);		emailTest(str2);
		emailTest(str3);		emailTest(str4);
	}
	public static void emailTest(String str) {// 이메일 주소를 검사한 후 결과를 출력하는 메소드
		/*
		1. 반드시 '@'가 있어야 한다. 2. 반드시 '.'이 있어야 한다. 3. '@'가 '.'보다 앞에 있어야 한다.
		이메일이 맞으면 이메일주소 + "는 이메일주소가 맞습니다."
		이메일이 아니면 이메일주소 + "는 이메일주소가 아닙니다."
		*/

		int at = str.indexOf('@'); //str에서 '@'의 위치 인덱스를 at에 저장
		int dot = str.indexOf('.'); //str에서 '.'의 위치 인덱스를 dot에 저장

		/*
		boolean isEmail = true; // 이메일 주소가 맞는지 여부를 저장할 변수
		if (at == -1) isEmail = false;	// '@'의 존재 유무
		if (dot == -1) isEmail = false; // '.'의 존재 유무
		if (at>dot) isEmail = false;	// '@'의 위치가 '.'보다 앞인지 여부

		if (isEmail){
			System.out.println(str + "는 이메일주소가 맞습니다.");
		} else {
			System.out.println(str + "는 이메일주소가 아닙니다.");
		}
		*/

		boolean cond1;
		boolean cond2;
		boolean cond3;

		cond1 = at>0;
		cond2 = dot>0;
		cond3 = at<dot;


		if (cond1&&cond2&&cond3){
			System.out.println(str + "는 이메일주소가 맞습니다.");
		} else {
			System.out.println(str + "는 이메일주소가 아닙니다.");
		}
	}
}
