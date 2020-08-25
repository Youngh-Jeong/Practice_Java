import java.util.Scanner;
class Q3_1_3{
	public static void main(String[] args) {
		// 일치하는 key를 모두 찾는 메소드
		Scanner input = new Scanner(System.in);
		System.out.print("요소 수");
		int num = input.nextInt();
		int[] x = new int[num];
		int[] idx = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = input.nextInt();
		}

		System.out.print("검색할 값");
		int ky = input.nextInt();

		int count = searchIdx(x, num, ky, idx);

		if (count == -1)
			System.out.println("없음");
		else
			System.out.println("값은 " + count + "개 있음.");
			for(int j = 0;j<count;j++) {
				System.out.print(idx[j] + " ");
			} 
	}
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;

		for(int i = 0; i<n;i++) {
			if (a[i]==key) {
				idx[count]=i;
				count++;
			}
		}
		if (count==0) {
			return -1;
		}

		return count;
	}
}
