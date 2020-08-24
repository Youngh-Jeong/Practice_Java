import java.util.Scanner;
class Q2_1_3{
	public static void main(String[] args) {
		// 배열 앞쪽에 윗자리를 넣어 기수 변환을 실행하는 메서드
		System.out.println("배열을 더합니다.");
		System.out.print("배열 크기 : " );
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		showArr(arr);
		sumOf(arr);
		
		

	}
	public static int cardConv(int x, int r, char[] d) { //x를 r진수로 변환해 d에 저장하고 자릿수를 반환
		int digit = 0;
		String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			
		} while(x!=0)
	}
}
