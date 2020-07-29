class Exercise4 
{
	public static void main(String[] args) 
	{
		// 4-2 : 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		int n1 = 1;
		int sum1 = 0;
		while (n1<=20)	{
			if (n1%2!=0&&n1%3!=0){
				sum1=sum1+n1;
				//System.out.println(n1);
			}
			n1++;
		}
		System.out.println("아닌 수의 총합 : " + sum1);

		// 4-3 : 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+...+10)의 결과를 계산하시오
		int sum2 = 0;
		for (int n2=1;n2<=10;n2++){
			for (int i2=1;i2<=n2;i2++){
				sum2 = sum2 + i2;
			}
			//System.out.println(n2 + "번째묶음까지 합 : " + sum2);
		}
		System.out.println("총합 : " + sum2);

		// 4-4 : 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는지 구하시오.
		int sum3 = 0;
		int n3 = 0;
		while (sum3<100){
			if (n3%2==0){
				sum3 = sum3 - n3;
			}
			else {
				sum3 = sum3 + n3;
			}
			n3++;
		}
		System.out.println("몇번째 : " + (n3-1) + ", 합 : " + sum3);

		/* 4-5 : 다음의 for문을 while문으로 변경하시오
		for(int i=0; i<=10; i++){
			for(int j=0; j<=i, j++){
				System.out.print("*");
			System.out.println();
		}
		*/
		int i = 0;
		int j = 0;
		while (i<=10){
			while (j<=i){
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			j = 0;
		}

		// 4-6 : 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력
		for (int i6 = 1;i6<=6;i6++){
			for (int j6 = 1;j6<=6;j6++){
				if (i6+j6 == 6){
					System.out.println("경우의 수 : " + "(" + i6 +", " + j6 + ")");
				}
			}
		}

		// 4-7 : Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드
		int value7 = (int)(Math.random()*5+1);
		System.out.println("value : " + value7);


		// 4-8 : 방정식 2x+4y=10의 모든 정수해를 구하시오. (0<=x,y<=10)
		for (int x8 = 0;x8 <= 10 ;x8++){
			for (int y8 = 0;y8 <= 10;y8++){
				if (2*x8+4*y8==10){
					System.out.println("x=" + x8 + " y=" + y8);
				}
			}
		}

		// 4-9 : 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라 (hint: charAt(int i)
		String str = "12345";
		int sum = 0;

		for (int i9 = 0;i9 < str.length() ; i9++)	{
			sum = str.charAt(i9) - '0' + sum;
		}
		System.out.println("sum="+sum);

		// 4-10 : int 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드
		int num10 = 12345;
		int sum10 = 0 ;
		for (int i10 = 0;i10<5;i10++){
			sum10 += num10%10;
			num10 /= 10;
		}
		System.out.println("합 : " + sum10);

		// 4-11 : 1, 1 ... 인 피보나치수열의 10번째 항을 출력하는 코드

		int num11_1 = 1;
		int num11_2 = 1;
		int num11_3 = 0;
		System.out.print(num11_1+","+num11_2);

		for (int i11 = 0;i11 < 8 ; i11++ ){
			num11_3 = num11_1 + num11_2;
			num11_1 = num11_2;
			num11_2 = num11_3;
			System.out.print(","+num11_3);
		}

		System.out.println();

		/* 4-12 : 구구단 출력
		2 x 1 = 2   3 x 1 = 3    4 x 1 = 4
		2 x 2 = 4
		2 x 3 = 6
		
		5 x 1 = 5
		5 x 2 = 10
		5 x 3 = 15
		
		8 x 1 = 8
		8 x 2 = 16
		8 x 3 = 24    ...                    */
		

		for (int i12=1;i12<=3;i12++){
			for (int j12=1;j12<=3;j12++){
				for (int k12=3*i12-1;k12<=3*i12+1;k12++){
					if (k12 >=10){
						break;
					}
					System.out.print(k12 + " x " + j12 + " = " + k12*j12 + "  " ); //예외 : 10단, 칸수
					if (k12*j12<10)	{
						System.out.print(" ");
					}
				}
				System.out.println();

			}
			System.out.println();
		}

		// 4-13 : 주어진 문자열(value)이 숫자인지를 판별하는 코드

		String value13 = "12o34";
		char ch = ' ';
		boolean isNumber = true;

		for (int i13=0;i13<value13.length() ;i13++){
			if ('0'>value13.charAt(i13)||value13.charAt(i13)>'9'){ //char로 지정하는것 주의
				isNumber = false;
				break;
			}
		}
		
		if (isNumber){
			System.out.println(value13+"는 숫자입니다.");
		} else {
			System.out.println(value13+"는 숫자가 아닙니다.");
		}

		// 4-14 : 다음은 숫자맞추기 게임이다. 사용자가 값을 입력하면, 크기 비교해 알려준다. 맞추면 끝나고 횟수를 보여준다.
		
		int answer = (int)(Math.random()*99+1);
		int input = 0;
		int count = 0;
		java.util.Scanner s = new java.util.Scanner(System.in);

		do{
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = s.nextInt();
			if (answer==input){ //맞았을 때
				System.out.println("맞췄습니다.");
				System.out.println("시도 횟수는 " + count + "번입니다.");
				break;
			} else if (answer>input){ //답이 더 클 때
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println("더 작은 수를 입력하세요.");
			}

		}
		while (true); //무한반복
	

		//회문수를 판별하는 프로그램 (회문수란, 숫자를 거꾸로 읽어도 앞으로 읽는 것과 같은 수를 말한다.)
		int number = 12321;
		int tmp = number;

		int result = 0;

		while(tmp !=0) {
			result = result * 10 + tmp%10;
			tmp = tmp/10;
		}

		if (number==result)	{
			System.out.println(number + "는 회문수 입니다.");
		} else {
			System.out.println(number + "는 회문수가 아닙니다.");
		}
	}
}
