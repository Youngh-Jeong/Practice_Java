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
		//�ֹε�Ϲ�ȣ���� ��������� �����Ͽ� ��� (yyyy-mm-dd)
		String year = num.substring(0,2);
		String month = num.substring(2,4);
		String date = num.substring(4,6);
		char genNum;
		if (num.indexOf('-')>0){
			genNum = num.charAt(num.indexOf('-')+1);
		} else{
			genNum = num.charAt(6);
		}	
		if (genNum=='1'||genNum=='2'){
			year = "19" + year;
		} else{
			year = "20" + year;
		}
		System.out.println(year + "-" + month + "-" + date);
		
	}

	public static void showGender(String num){
		//�ֹε�Ϲ�ȣ���� ���������ڸ� �����Ͽ� ���� ���(���� or ����)
		char genNum;
		if (num.indexOf('-')>0){ //num.length ���� ����� ����
			genNum = num.charAt(num.indexOf('-')+1);
		} else{
			genNum = num.charAt(6);
		}
		
		if (genNum=='1'||genNum=='3'){
			System.out.println("����");
		} else{
			System.out.println("����");
		}
	}
}
