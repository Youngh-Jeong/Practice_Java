import java.util.*;

class RandomGenerator {
	public static void main(String[] args) {
		Random rand = new Random();

		for (int i = 0 ;i < 3 ;i++){
			System.out.println(rand.nextDouble());
			// 0 이상 1 미만의 실수를 무작위로 출력
		}
		
		for (int i = 0;i < 5 ;i++ )	{
			System.out.print(rand.nextInt(50) + " ");
			// 0이상 50미만의 정수를 무작위로 출력
		}
	}
}
