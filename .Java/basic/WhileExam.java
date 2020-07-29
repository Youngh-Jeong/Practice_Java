class WhileExam {
	public static void main(String[] args)	{
		// 1~100까지의 합을 구하여 출력(while문 이용)
		// 결과 : 1~100까지의 합 : 5050
		int i = 1;
		int add = 0;
		while (i<=100){
			add = add + i;
			i++;
		}
		System.out.println("1~100까지의 합 : " + add);

		//100이하의 양수 중에서 2와 7의 공배수를 모두 구하여 출력 : do-while문 이용
		int n = 0;
		int sum = 0;
		do {
			if (n%2==0&&n%7==0)	{
				sum = sum + n;
			}
			n++;
		}
		while (n<=100);
		System.out.println("공배수의 합 : " + sum);
	}
}
