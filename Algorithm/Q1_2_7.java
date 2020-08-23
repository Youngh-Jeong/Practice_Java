import java.util.Scanner;
class Q1_2_7{
	public static void main(String[] args) {
		//  1부터 n까지 합을 for문을 이용해 구성후 '1+2+..+n = sum의 형태로 출력
		Scanner input = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구함");
		System.out.print("n : "); int n = input.nextInt();
		int sum = 0;
		for(int i = 1; i<n+1;i++) {
			sum += i;
			if(i!=n) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i);
			}
		}
		System.out.println(" = " + sum);
	}
}
