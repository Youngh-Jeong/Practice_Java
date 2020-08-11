import java.util.*;

class ArraysEx {
	public static void main(String[] args){
		int[] arr = {0, 1, 2, 3, 4};
		int[][] arr2D = {{11,12,13},{21,22,23}};

		System.out.println("arr : " + Arrays.toString(arr)); // arr : [0, 1, 2, 3, 4]
		System.out.println("arr2D : " + Arrays.deepToString(arr2D)); // arr2D : [[11, 12, 13], [21, 22, 23]]
		// deepToString() : 2차원 배열 전용 toString() 메소드

		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, 3);
		int[] arr4 = Arrays.copyOf(arr, 7);
		// copyOf() : 원본 배열을 복사하여 새로운 배열로 생성시킴
		// 두번째 인수는 인덱스번호가 아닌 복사할 요소의 개수
		// 두번째 인수가 원본 배열의 길이를 넘어가면 넘어간 만큼 새 배열에 칸을 만들고 기본값을 채움
		int[] arr5 = Arrays.copyOfRange(arr,2,4);
		int[] arr6 = Arrays.copyOfRange(arr,0,7);
		// copyOfRange() : 원본 배열의 특정 부분을 복사하여 새로운 배열로 생성시킴
		// 두번째 인수 인덱스 부터 세번째 인수 -1 인덱스 까지 범위로 지정
		// 세번째 인수가 원본 배열의 길이를 넘어가면 넘어간 만큼 새 배열에 칸을 만들고 기본값을 채움
		System.out.println("arr2 : " + Arrays.toString(arr2)); // arr2 : [0, 1, 2, 3, 4]
		System.out.println("arr3 : " + Arrays.toString(arr3)); // arr3 : [0, 1, 2]
		System.out.println("arr4 : " + Arrays.toString(arr4)); // arr4 : [0, 1, 2, 3, 4, 0, 0]
		System.out.println("arr5 : " + Arrays.toString(arr5)); // arr5 : [2, 3]
		System.out.println("arr6 : " + Arrays.toString(arr6)); // arr6 : [0, 1, 2, 3, 4, 0, 0]

		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9);
		// fill() : 배열에 지정한 값(두번째 인수)을 채움
		System.out.println("arr7 : " + Arrays.toString(arr7)); // arr7 : [9, 9, 9, 9, 9]

		char[] chArr = {'A', 'D', 'C', 'B', 'E'};
		System.out.println("chArr : " + Arrays.toString(chArr)); // chArr : [A, D, C, B, E]
		System.out.println("index of B : " + Arrays.binarySearch(chArr, 'B')); // index of B : -2
		// chArr배열에서 'B'의 위치를 binarySearch() 메소드를 이용하여 출력
		// binarySearch() : 이분(진) 검색으로, 반드시 데이터가 오름차순으로 정렬되어 있어야 함
		// 정렬되어있지 않으면 알 수 없는 값이 나옴

		System.out.println("= After sorting =");
		Arrays.sort(chArr);
		// 지정한 배열을 오름차순으로 정렬시킴
		System.out.println("chArr : " + Arrays.toString(chArr)); // chArr : [A, B, C, D, E]
		System.out.println("index of B : " + Arrays.binarySearch(chArr, 'B')); // index of B : 1
	}
}
