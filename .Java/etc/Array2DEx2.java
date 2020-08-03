class Array2DEx2{
	public static void main(String[] args){
		int[][] arr = {
			{1, 2},
			{3, 4, 5},
			{6,7,8,9}
		};
		// 자바에서의 2차원 배열에는 각기 다른 크기의 1차원 배열을 넣을 수 있음.

		System.out.println("배열의 세로 길이 : " + arr.length);

		for (int i = 0;i < arr.length ;i++ ){
			System.out.println(i + 1 + "행의 길이 : " + arr[i].length);
		}
	}
}
