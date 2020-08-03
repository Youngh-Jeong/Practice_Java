class Array2DEx1{
	public static void main(String[] args){
		int[][] arr = new int[3][4];
		//3행 4열의 2차원 배열 arr을 생성
		for (int i = 0;i < arr.length ;i++ ){
			for (int j = 0;j <arr[i].length ;j++ ){
				arr[i][j]=i+j;
			}
		}

		for (int i = 0;i < arr.length ;i++ ){
			for (int j = 0;j <arr[i].length ;j++ ){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
