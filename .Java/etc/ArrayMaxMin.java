import java.util.*;

class ArrayMaxMin{
	public static void main(String[] args){
		int[] arrInt = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0;i<arrInt.length;i++){
			System.out.print(i + 1 + "��° ���� �Է� : ");
			arrInt[i] = sc.nextInt();
		}
		System.out.println("�迭�� �ּҰ� : " + minValue(arrInt));
		System.out.println("�迭�� �ִ밪 : " + maxValue(arrInt));
	}
	public static int minValue(int[] arr){
		int min = arr[0];
		for (int i = 0;i<arr.length ;i++){
			if (min > arr[i]){min = arr[i];}
		}
		return min;
	}
	public static int maxValue(int[] arr){
		int max = arr[0];
		for (int i = 0;i<arr.length ;i++){
			if (max < arr[i]){max = arr[i];}
		}
		return max;
	}
}
