class ForDupBreak{
	public static void main(String[] args) {
		//i, j가 둘다 짝수이면 출력을 멈춤
		outerLoop: // 레이블로서 루프문에 표식을 하는 것
		for (int i = 1; i <= 3 ; i++){
			for (int j = 1; j <= 3 ; j++){
				System.out.println("["+i+","+j+"]");
				if (i%2==0 && j%2==0){ // 둘다 짝수이면
					break outerLoop;
					// outerLoop라는 레이블을 단 루프문을 빠져나감
				}
			}
		}
		
	}
}
