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
		for (int i=1;i<=1000;i++){
			seq += i;
		}

		System.out.println(seq);

	}
}
