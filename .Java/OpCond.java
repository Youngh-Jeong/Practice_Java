class OpCond {
	public static void main(String[] args) {
		int n1 = 110, n2 = 50;
		int big, diff;
		// n1�� n2�� ����ִ� �� �߿��� ū ���� big�� �־� ���, ���� diff�� �־� ���

		if (n1 > n2){//n1�� ū ���ڸ�
			big = n1 ;
			diff = n1 - n2;
		}
		else { //n2�� ū ���ڸ�
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
