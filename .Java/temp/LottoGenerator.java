import java.util.*;
/*
1���� 45 ������ ���� 6���� �ߺ����� �������� ����Ͻÿ�.
*/
class LottoGenerator {
	public static void main(String[] args) {
		//1. �迭���� �̿��� ���
		Random rand = new Random();
		int[] balls = new int[45];
		for (int i=0;i<balls.length  ;i++){ // �ʱ�ȭ
			balls[i]=i;
		}
		for (int i = 0;i < balls.length ; i++){ //����
			int r = rand.nextInt(45);
			int tmp = balls[i];
			balls[i]=balls[r];
			balls[r] = tmp;
		}
		System.out.println("��÷ ��ȣ : ");
		for (int i = 0;i < 6 ;i++ ){ // 6�� �̱�
			System.out.print(balls[i] + " ");
		}

		//2. �ߺ��� �Ź� �˻��ϸ� �̴� ���
		System.out.println();
		System.out.println("��÷ ��ȣ2 : ");
		int[] balls2 = new int[6]; // ���� ����� �����ϴ� ��
		int count = 0; // ���� Ƚ��
		for (int i = 0;i<6 ;i++ ){
			int ball = rand.nextInt(45)+1; // �̱�
			balls2[i] = ball;
			for (int j = 0;j <i ;j++){
				if (balls2[j]==ball){ // �ߺ��˻�
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
