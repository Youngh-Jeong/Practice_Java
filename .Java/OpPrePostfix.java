class OpPrePostfix {
	public static void main(String[] args) 	{
		int n1 = 7, n2, n3;

		n2 = ++n1;   // n1의 값을 1 증가시킨 후 n2에 넣음
		n3 = --n1;   // n1의 값을 1 감소시킨 후 n3에 넣음
		System.out.println("n1 : " + n1 + ", n2 : " + n2 + ", n3 : "+n3);
		// n1 : 7, n2 : 8, n3 : 7
		n1 = 7;
		n2 = n1++;   // n1을 n2에 넣은 후 값을 1 증가시킴
		n3 = n1--;   // n1을 n3에 넣은 후 값을 1 감소시킴
		System.out.println("n1 : " + n1 + ", n2 : " + n2 + ", n3 : "+n3);
		// n1 : 7, n2 : 7, n3 : 8
		// 실제 증감연산자는 증감후 사용이나 사용후 증감 같은 동시작업을 하지 않고, 증감과 사용을 따로 처리함
		/*
		n1++;
		n3 = n1;
		++n1;
		n3 = n1;
		*/
	}
}