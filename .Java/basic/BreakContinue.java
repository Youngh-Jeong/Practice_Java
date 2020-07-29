class BreakContinue{
	public static void main(String[] args) {
		// 100이하의 양수 중에서 5와 7의 최소공배수를 구하여 출력
		int n = 1;
		boolean search = false;   // 5와 7의 최소공배수를 찾았는 지 여부를 저장할 변수
		while (n<=100){
			if (n%5 == 0 && n%7 == 0){
				search = true;
				break;
				//해당 루프문을 조건에 상관없이 빠져나감
			}
			n++;
		}
		if (search)	{
			System.out.println("5와 7의 최소공배수 : " + n);
		} else {
			System.out.println("5와 7의 최소공배수를 찾지 못했습니다.");
		}

		// 100이하의 양수중에서 5와 7의 공배수와 그 개수를 출력
		int num = 0, count = 0;
		while (num <= 100)	{
			num++;
			if (num%5!=0||num%7!=0)	{
				continue;
			}

			count++;
			System.out.print(num + "  ");
		}
		System.out.println("5와 7의 공배수 개수 :" + count);
	}
}
