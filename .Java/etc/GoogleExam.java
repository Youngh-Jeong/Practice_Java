class GoogleExam{
	public static void main(String[] args){
		/*
		1~1000 ������ ������ 8�� ������ ���Ͽ� ���
		*/

		//1. int�� Ȱ���� ���
		int count = 0;
		int num;
		for (int i=1;i<=1000;i++){
			num = i;
			while (num!=0){
				if (num%10==8){count ++;}
				num /= 10;
			}
		}

		System.out.println("8�� ���� : " + count);



		//2. String�� Ȱ���� ���
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

		System.out.println("8�� ���� : " + count2);


	}
}
