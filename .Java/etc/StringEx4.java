class StringEx4{
	
	public static void main(String[] args) {
		String num1 = "880525-1234567";
		String num2 = "8905152234567";
		String num3 = "000725-3234567";
		String num4 = "020325-4234567";

		showBirth(num1);	showBirth(num2);
		showBirth(num3);	showBirth(num4);
		showGender(num1);	showGender(num2);
		showGender(num3);	showGender(num4);
	}
	public static void showBirth(String num){
		//주민등록번호에서 생년월일을 추출하여 출력 (yyyy-mm-dd)
		String year = num.substring(0,2);
		String month = num.substring(2,4);
		String date = num.substring(4,6);
		char genNum;
		int n = 7;
		if (num.length() == 13) n=6;
		genNum = num.charAt(n);
		int y = 19;
		if (genNum=='3'||genNum=='4') y = 20;
		year = y + year;
		System.out.println(year + "-" + month + "-" + date);
		
	}

	public static void showGender(String num){
		//주민등록번호에서 성별구분자를 추출하여 성별 출력(남자 or 여자)
		char genNum;
		if (num.indexOf('-')>0){ //num.length 쓰는 방법도 있음. int n = 7; if (num.length() == 13) n = 6;
			genNum = num.charAt(num.indexOf('-')+1);
		} else{
			genNum = num.charAt(6);
		}
		
		if (genNum%2==1){
			System.out.println("남자");
		} else{
			System.out.println("여자");
		}
	}
}
