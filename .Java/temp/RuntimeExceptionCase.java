class RuntimeExceptionCase{
	public static void main(String[] args) {
		try{
			int[] arr = new int[3];
			arr[-1] = 10;
		}catch (ArrayIndexOutOfBoundsException e){
		// 배열의 크기를 벗어나는 범위의 인덱스를 사용했을 경우
			System.out.println(e.getMessage());	
		}
		try{
			Object obj = new int[10];
			String str = (String)obj;			
		}catch (ClassCastException e){
		// 잘못된 형변환시 발생하는 예외
			System.out.println(e.getMessage());
		}
		try{
			int[] arr = new int[-10];
		}catch (NegativeArraySizeException e){
		// 배열의 크기를 음수로 입력할 경우 발생하는 예외
			System.out.println(e.getMessage());
		}
		try{
			String str = null;
			int len = str.length();
		}catch (NullPointerException e){
		// 비어있는 객체를 참조할 경우 발생하는 예외
			System.out.println(e.getMessage());
		}
		try{
			String str = "abcd";
			char c = str.charAt(5);
		}catch (StringIndexOutOfBoundsException e){
		// 문자열의 크기를 벗어나는 범위의 인덱스를 사용했을 경우
			System.out.println(e.getMessage());
		}
	}
}
