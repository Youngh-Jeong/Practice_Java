import java.util.*;

class HashSetEx2{
	public static void main(String[] args){
		// 1~45 ������ �ߺ����� �ʴ� ���� 6���� ���Ͽ� HashSet�� �����ϰ� ���
		Set ball = new HashSet();
		while (ball.size() < 6){
			int num = (int)(Math.random()*45)+1;
			ball.add(new Integer(num));
		}
		System.out.println(ball);
	}
}
