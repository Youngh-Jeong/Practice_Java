import java.util.Arrays;
import java.util.Scanner;
class Q3_1_6{
	public static void main(String[] args) {
		// Arrays.binarySearch를 하되 검색에 실패하면 삽입 포인트의 값 출력
		Scanner input = new Scanner(System.in);
		System.out.print("요소 수");
		int num = input.nextInt();
		int[] x = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = input.nextInt();
		}

		System.out.print("검색할 값");
		int ky = input.nextInt();

		int idx = Arrays.binarySearch(x,  ky);

		if (idx < 0)
			System.out.println("삽입 포인트 : " + (-idx-1));
		else
			System.out.println("값은 " + idx );
	}
}
