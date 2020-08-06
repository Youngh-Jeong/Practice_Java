import java.util.*;
/*
1부터 45 사이의 숫자 6개를 중복없이 랜덤으로 출력하시오.
*/
class LottoGenerator {
	public static void main(String[] args) {
		//1. 배열섞어 이용한 방법
		Random rand = new Random();
		int[] balls = new int[45];
		for (int i=0;i<balls.length  ;i++){ // 초기화
			balls[i]=i;
		}
		for (int i = 0;i < balls.length ; i++){ //섞기
			int r = rand.nextInt(45);
			int tmp = balls[i];
			balls[i]=balls[r];
			balls[r] = tmp;
		}
		System.out.println("당첨 번호 : ");
		for (int i = 0;i < 6 ;i++ ){ // 6개 뽑기
			System.out.print(balls[i] + " ");
		}

		//2. 중복을 매번 검사하며 뽑는 방법
		System.out.println();
		System.out.println("당첨 번호2 : ");
		int[] balls2 = new int[6]; // 뽑은 기록을 저장하는 곳
		int count = 0; // 뽑은 횟수
		for (int i = 0;i<6 ;i++ ){
			int ball = rand.nextInt(45)+1; // 뽑기
			balls2[i] = ball;
			for (int j = 0;j <i ;j++){
				if (balls2[j]==ball){ // 중복검사
					i--;
					break;
				}
			}
		}
		for (int i = 0;i<balls2.length ;i++ ){
			System.out.print(balls2[i] + " ");
		}
	}
}
