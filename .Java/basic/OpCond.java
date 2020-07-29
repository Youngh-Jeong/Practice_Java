class OpCond {
	public static void main(String[] args) {
		int n1 = 110, n2 = 50;
		int big, diff;
		// n1과 n2에 들어있는 값 중에서 큰 값을 big에 넣어 출력, 차를 diff에 넣어 출력

		if (n1 > n2){//n1이 큰 숫자면
			big = n1 ;
			diff = n1 - n2;
		}
		else { //n2가 큰 숫자면
			big = n2 ;
			diff = n2 - n1;
		}
		System.out.println("big : " + big);
		System.out.println("diff : " + diff);
		/*
		big = (n1 > n2) ? n1 : n2;
		diff = (n1 > n2) ? n1 - n2 : n2 - n1;
		*/
		/*
		big = n1;
		if (n2 > n1) big = n2;

		diff = n1-n2;
		if (diff<0) diff *= -1;
		*/
	}
}
