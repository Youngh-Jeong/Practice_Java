class WhileDoWhileEx {
	public static void main(String[] args) {
		int n = 0;

		/*
		while (n < 5){
			System.out.print("Hellow World!" + n + "|");
			n++;
		}
		*/

		// 위의 while문에서 n에 5를 넣었으나 do-while문의 특성상 조건을 보지 않고 한 번 실행시킴
		do{
			Syste.out.print("do-while : " + n + "|")
			n++;
		}
		while (n < 5);
		
	}
}
