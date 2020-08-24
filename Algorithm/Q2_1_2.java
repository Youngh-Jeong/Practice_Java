import java.util.Scanner;
class Q2_1_2{
	public static void main(String[] args) {
		// 배열요소를 역순으로 정렬 (과정 보여줌)
		System.out.println("배열을 뒤집습니다.");
		System.out.print("배열 크기 : " );
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		showArr(arr);
		reverse(arr);
		
		

	}
	public static void reverse(int[] a) { //역순 메소드
		for (int i = 0; i<a.length/2;i++) {
			int tmp = a[i];
			a[i] = a[a.length-i-1];
			a[a.length-i-1] = tmp;
			System.out.println("a[" + i + "]와 a[" +(a.length-i-1) + "]를 교환합니다.");
			showArr(a);
		}
		System.out.println("역순 정렬을 마쳤습니다.");
	}
	public static void showArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
