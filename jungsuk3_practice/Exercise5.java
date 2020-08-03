class Exercise5{
	public static void main(String[] args){
	// 5-4 다음 배열의 총합과 평균
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
		
		// 5-5 1과 9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램
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

		// 5-6 거스름돈을 몇 개의 동전으로 지불할 수 있는지 계산하는 문제 (가능한한 적은 수의 동전)
		/*
		int[] coinUnit = {500, 100, 50, 10};

		int money = 2680;
		System.out.println("money="+money);
		for (int i = 0;i<coinUnit.length ;i++ ){
			int coin = money/coinUnit[i];
			money = money%coinUnit[i];
			System.out.println(coinUnit[i]+"원: " + coin);
		}
		*/
		//5-7 : 5-6에 동전의 개수를 추가한 프로그램
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

			System.out.println(coinUnit[i]+"원 : " +coinNum);
		}

		if (money>0){
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0);
		}
		System.out.println("=남은 동전의 개수=");
		for (int i = 0;i<coinUnit.length ;i++ ){
			System.out.println(coinUnit[i]+"원: "+coin[i]);
		}
	}
}
