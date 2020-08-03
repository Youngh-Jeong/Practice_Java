class GoogleExam{
	public static void main(String[] args){
		/*
		1~1000 사이의 정수중 8의 개수를 구하여 출력
		*/

		//1. int를 활용한 방법
		int count = 0;
		int num;
		for (int i=1;i<=1000;i++){
			num = i;
			while (num!=0){
				if (num%10==8){count ++;}
				num /= 10;
			}
		}

		System.out.println("8의 개수 : " + count);



		//2. String을 활용한 방법
		String seq = "";
		int count2 = 0;
		for (int i=1;i<=1000;i++){
			seq += i;
		}

		while (!seq.isEmpty()){
			if (seq.equals(seq.substring(seq.indexOf('8')+1))){
				seq="";
			}else{
				seq=seq.substring(seq.indexOf('8')+1);
				count2 ++;
			}
		}

		System.out.println("8의 개수 : " + count2);


		//3. 학원 방법

		int count3 = 0;
		for (int i = 1;i<=1000 ;i++){
			String str = i + "";
			for (int j = 0;j <str.lengtg();j++){
				char c = str.charAt(j);
				if (c=='8') count++;
			}
		}
		System.out.println("8의 개수 : " + count3);

		//4. 8이 들어있는 숫자의 개수를 구하여 출력
		
		int count4 = 0;
		int num4 = 0;
		boolean hasEight = false;
		for (int i = 1;i<=1000;i++){
			num4 = i;
			while (num4 == 0){
				if (num4%10 == 8){
					hasEight = true;
					count4 ++;
					break;
				}
				num4 = num4/10;
			}
		}

		System.out.println("8의 개수 : " + count4);
	}
}
