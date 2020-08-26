import java.util.Scanner;
class Q3_1_4{
	public static void main(String[] args) {
		// 이진검색 과정 출력 프로그램 (이미지는 생략)
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

		int idx = binSearch(x, num, ky);

		if (idx == -1)
			System.out.println("없음");
		else
			System.out.println("값은 " + idx + "에 있음.");
	}
	static int binSearch(int[] a, int n, int key) {
		int sValue = 0;
		int eValue = n-1;
		while (sValue<=eValue) {
			int nValue = (sValue + eValue)/2;
			if (a[nValue]==key) {
				return nValue;
			} else if(a[nValue]<key) {
				sValue = nValue+1;
			} else {
				eValue = nValue-1;
			}
		}
		return -1;
	}
}
