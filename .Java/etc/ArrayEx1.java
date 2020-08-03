class ArrayEx1{
	public static void main(String[] args) {
		int[] arrInt = new int[3]; // 3개의 int형 데이터를 저장할 수 있는 int형 배열 생성
		arrInt[0] = 10;	arrInt[1] = 35;	arrInt[2] = 23;
		// 인덱스 번호를 이용하여 배열의 각 칸에 데이터를 저장

		System.out.println("arrInt의 총 합 : " + (arrInt[0] + arrInt[1] + arrInt[2]));

		String[] arrStr = new String[3];
		arrStr[0] = "abc";arrStr[1] = "DEF"; arrStr[2] = "ghi";
		for (int i = 0; i < arrStr.length ;i++ ){
			//arrStr.length : arrStr 배열의 크기
			System.out.println(arrStr[i]);
		}
		//역순으로 출력
		String[] arrRev = new String[3];
		for (int i = 0; i < arrStr.length ;i++ ){
			System.out.println(arrStr[arrStr.length-i-1]);
		}

		// 배열 안의 데이터에서 두 번째 글자만 출력
		for (int i = 0;i<arrStr.length;i++){
			System.out.println(arrStr[i].charAt(1));
		}


		int[] arrInt2 = {2, 4, 6, 8};
		// 2, 4, 6, 8의 값을 가지는 arrInt2 배열 생성
		int sum = 0;
		for (int i = 0;i < arrInt2.length ;i++){
			sum += arrInt2[i];
		}
		System.out.println(sum);



	}
}
