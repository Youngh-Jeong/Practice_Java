import java.util.*;

class HashSetEx2{
	public static void main(String[] args){
		// 1~45 사이의 중복되지 않는 정수 6개를 구하여 HashSet에 저장하고 출력
		Set ball = new HashSet();
		while (ball.size() < 6){
			int num = (int)(Math.random()*45)+1;
			ball.add(new Integer(num));
		}
		System.out.println(ball);
	}
}
