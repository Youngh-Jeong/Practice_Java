class Exercise5{
	public static void main(String[] args){
	// 5-4 ���� �迭�� ���հ� ���
		int[][] arr = {
			{5,5,5,5,5},{10,10,10,10,10},{20,20,20,20,20},{30,30,30,30,30}
		};

		int total = 0;
		float average = 0;
		for (int i = 0;i < arr.length;i++){
			for (int j = 0;j<arr[0].length;j++){
				total += arr[i][j];
			}
		}
		average = total/(float)(arr.length * arr[0].length);

		System.out.println("total = " + total);
		System.out.println("average = " + average);
		
		// 5-5 1�� 9 ������ �ߺ����� ���� ���ڷ� �̷���� 3�ڸ� ���ڸ� ������ ���α׷�
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		for (int i = 0;i<ballArr.length ;i++ ){
			int j = (int)(Math.random()*ballArr.length);
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i]=ballArr[j];
			ballArr[j]=tmp;
		}
		System.arraycopy(ballArr,0,ball3,0,3);
		for (int i = 0;i<ball3.length ;i++ ){
			System.out.print(ball3[i]);
		}
		System.out.println();

		// 5-6 �Ž������� �� ���� �������� ������ �� �ִ��� ����ϴ� ���� (�������� ���� ���� ����)
		/*
		int[] coinUnit = {500, 100, 50, 10};

		int money = 2680;
		System.out.println("money="+money);
		for (int i = 0;i<coinUnit.length ;i++ ){
			int coin = money/coinUnit[i];
			money = money%coinUnit[i];
			System.out.println(coinUnit[i]+"��: " + coin);
		}
		*/
		//5-7 : 5-6�� ������ ������ �߰��� ���α׷�
		if (args.length!=1){
			System.out.println("USAGE: java Exercise7 3120");
			System.exit(0);
		}
		int money = Integer.parseInt(args[0]);
		System.out.println("money="+money);

		int[] coinUnit = {500, 100, 50, 10};
		int[] coin = {5, 5, 5, 5};

		for (int i=0;i<coinUnit.length ;i++ ){
			int coinNum = 0;
			coinNum = money/coinUnit[i];
			if (coinNum<=coin[i]){coin[i]-=coinNum;}
			else {coinNum=coin[i]; coin[i]=0;}

			money -= coinNum*coinUnit[i];

			System.out.println(coinUnit[i]+"�� : " +coinNum);
		}

		if (money>0){
			System.out.println("�Ž������� �����մϴ�.");
			System.exit(0);
		}
		System.out.println("=���� ������ ����=");
		for (int i = 0;i<coinUnit.length ;i++ ){
			System.out.println(coinUnit[i]+"��: "+coin[i]);
		}
	}
}
