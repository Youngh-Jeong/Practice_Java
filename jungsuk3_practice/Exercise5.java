import java.util.*;

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
	
		int[] coinUnit = {500, 100, 50, 10};

		int money = 2680;
		System.out.println("money="+money);
		for (int i = 0;i<coinUnit.length ;i++ ){
			int coin = money/coinUnit[i];
			money = money%coinUnit[i];
			System.out.println(coinUnit[i]+"원: " + coin);
		}
			/*
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
			*/
		//5-8 : answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어 그래프를 그리는 프로그램
		int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
		int[] counter = {0, 0, 0, 0};
		for (int i = 0;i<answer.length ;i++){
			counter[answer[i]-1] += 1;
		}
		for (int j = 0;j<counter.length ;j++){
			System.out.print((j+1) + " : " + counter[j] + " | ");
			for (int k = 0;k < counter[j] ;k++){
				System.out.print("*");
			}
			System.out.println();
		}

		//5-9 : 주어진 배열을 시계방향으로 90도 회전시켜 출력하는 프로그램
		char[][] star = {
			{'*','*',' ',' ',' '},
			{'*','*',' ',' ',' '},
			{'*','*','*','*','*'},
			{'*','*','*','*','*'}
		};

		char[][] result = new char[star[0].length][star.length];

		for (int i = 0;i < star.length;i++){
			for (int j=0;j<star[i].length;j++){
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0;i < star.length;i++){
			for (int j=0;j<star[i].length;j++){
				result[j][i] = star[star.length-i-1][j];		
			}
			
		}
		
		for (int i = 0;i < result.length;i++){
			for (int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

		//5-10 : 암호표로 암호화하는 프로그램
		char[] abcCode = {'`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		String src10 = "abc123";
		String result10 = "";
		for (int i = 0;i<src10.length() ;i++ ){
			char ch = src10.charAt(i);
			if ('a'<=ch&&ch<='z'){
				result10 += abcCode[ch-'a'];
			}
			else{result10+= numCode[ch-'0'];}
		}
		System.out.println("src : " + src10);
		System.out.println("result : " + result10);

		//5-11 : 2차원 배열의 데이터에 각 열과 행의 총합을 저장하고 출력

		int[][] score11 = {{100,100,100},{20,20,20},{30,30,30},{40,40,40},{50,50,50}};
		int[][] result11 = new int[score11.length+1][score11[0].length+1];

		for (int i = 0;i < score11.length ;i++ ){
			for (int j = 0;j<score11[i].length ;j++ ){
				result11[i][j] = score11[i][j];
				result11[i][score11[i].length]+=score11[i][j];
				result11[score11.length][j]+=score11[i][j];
				result11[score11.length][score11[i].length]+=score11[i][j];

			}
		}

		for (int i = 0; i < result11.length; i++){
			for (int j=0;j<result11[i].length ;j++)	{
				System.out.printf("%4d",result11[i][j]);
			}
			System.out.println();
		}

		//5-12 : 예제를 변경해, 문제를 맞추고 점수를 불러온느 코드 작성
		String[][] words = {{"chair","의자"},{"computer","컴퓨터"},{"integer","정수"}};
		int score12 = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0;i<words.length ;i++ ){
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
			String tmp = scanner.nextLine();
			if (tmp.equals(words[i][1])){
				System.out.printf("정답입니다.%n%n");
				score12++;
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다.%n%n",words[i][1]);
			}
		}
		System.out.printf("전체 %d문제 중 %d문제 맞추셨습니다.%n", words.length, score12);

		//5-13 글자위치를 섞어 보여주고 원래 단어를 맞추는 코드
		String[] words13 = {"television","computer","mouse","phone"};
		Scanner scanner2 = new Scanner(System.in);

		for (int i = 0;i<words13.length ;i++ ){
			char[] question = words13[i].toCharArray();
			char tmp;
			for (int j = 0;j<question.length ;j++ ){
				int t = (int)(Math.random()*words13.length);
				tmp = question[j];
				question[j]=question[t];
				question[t]=tmp;
			}
			System.out.printf("Q%d. %s의 정답을 입력하세요.>", i+1, new String(question));
			String answer2 = scanner2.nextLine();
			if (words13[i].equals(answer2.trim())){
				System.out.printf("맞았습니다.%n%n");
			} else System.out.printf("틀렸습니다.%n%n");
		}

	}
}
