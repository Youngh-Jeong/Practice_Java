import java.util.*;

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
	
		int[] coinUnit = {500, 100, 50, 10};

		int money = 2680;
		System.out.println("money="+money);
		for (int i = 0;i<coinUnit.length ;i++ ){
			int coin = money/coinUnit[i];
			money = money%coinUnit[i];
			System.out.println(coinUnit[i]+"��: " + coin);
		}
			/*
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
			*/
		//5-8 : answer�� ��� �����͸� �а� �� ������ ������ ��� ������ŭ '*'�� ��� �׷����� �׸��� ���α׷�
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

		//5-9 : �־��� �迭�� �ð�������� 90�� ȸ������ ����ϴ� ���α׷�
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

		//5-10 : ��ȣǥ�� ��ȣȭ�ϴ� ���α׷�
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

		//5-11 : 2���� �迭�� �����Ϳ� �� ���� ���� ������ �����ϰ� ���

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

		//5-12 : ������ ������, ������ ���߰� ������ �ҷ��´� �ڵ� �ۼ�
		String[][] words = {{"chair","����"},{"computer","��ǻ��"},{"integer","����"}};
		int score12 = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0;i<words.length ;i++ ){
			System.out.printf("Q%d. %s�� ����?", i+1, words[i][0]);
			String tmp = scanner.nextLine();
			if (tmp.equals(words[i][1])){
				System.out.printf("�����Դϴ�.%n%n");
				score12++;
			} else {
				System.out.printf("Ʋ�Ƚ��ϴ�. ������ %s�Դϴ�.%n%n",words[i][1]);
			}
		}
		System.out.printf("��ü %d���� �� %d���� ���߼̽��ϴ�.%n", words.length, score12);

		//5-13 ������ġ�� ���� �����ְ� ���� �ܾ ���ߴ� �ڵ�
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
			System.out.printf("Q%d. %s�� ������ �Է��ϼ���.>", i+1, new String(question));
			String answer2 = scanner2.nextLine();
			if (words13[i].equals(answer2.trim())){
				System.out.printf("�¾ҽ��ϴ�.%n%n");
			} else System.out.printf("Ʋ�Ƚ��ϴ�.%n%n");
		}

	}
}
