class NumberEx1 {
	int num;
	public NumberEx1() {
		num = 10;
		System.out.println("생성자 호출");
	}
	public int getNum() {return num;}
}

class NumberEx2{
	int num;
	public NumberEx2(int n){
		num = n;
		System.out.println("매개변수 전달 : " + n);
	}
	public int getNum() {return num;}
}

class ConstructorEx {
	public static void main(String[] args) {
		NumberEx1 num1 = new NumberEx1();
		//NumberEx1() : NumberEx1클래스의 생성자 호출 (인스턴스 생성)
		System.out.println("NumberEx1의 num : " + num1.getNum());
		NumberEx2 num2 = new NumberEx2(25);
		//생성자에도 매개변수(들)을 사용할 수 있음
		System.out.println("NumberEx2의 num : " + num2.getNum());
	}

}
