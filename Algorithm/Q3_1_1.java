import java.util.Scanner;
class Q3_1_1{
	public static void main(String[] args) {
		// while문을 for문으로 수정
		Scanner input = new Scanner(System.in);
		System.out.print("요소 수");
		int num = input.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = input.nextInt();
		}

		System.out.print("검색할 값");
		int ky = input.nextInt();

		int idx = seqSearchSen(x, num, ky);

		if (idx == -1)
			System.out.println("없음");
		else
			System.out.println("값은 x[" + idx + "]에 있음.");
	}
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		for(i = 0; a[i]!=key;i++) {
		}
		if (i==n) {
			return -1;
		}
		return 1;
	}
}
