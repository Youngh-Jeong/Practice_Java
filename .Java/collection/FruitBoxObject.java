class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("당도 : " + sugar); }
}

class FruitBox{ // 모든 종류의 과일을 담는 클래스
	Object item;
	// Object로 선언하였기 때문에 어떠한 종류의 데이터도 담을 수 있음
	public void store(Object item) { this.item = item; }
	public Object pullOut() {return item;}
}
class FruitBoxObject{
	public static void main(String[] args) {
		FruitBox fBox1 = new FruitBox();
		fBox1.store(new Orange(10));
		// Orange클래스의 인스턴스를 생성하여 store()메소드의 매개변수로 가져감
		Orange org1 = (Orange)fBox1.pullOut();
		org1.showSugar();

		FruitBox fBox2 = new FruitBox();
		fBox2.store(new String("오렌지"));
		Orange org2 = (Orange)fBox2.pullOut();
		// fBox2에 들어있는 객체는 String이므로 Orange로 형변환이 불가
		// ClassCastException 발생
		org2.showSugar();
	}
}

/*
store()메소드를 통해 Orange가 아닌 String의 인스턴스가 저장이 됨
형변환이 불가능한 코드에서 컴파일시 에러가 나지 않고 실행시 exception이 발생

해결책
 - 정확한 자료형의 인스턴스만 받을 수 있게 작업해야 함
    잘못된 자료형의 인스턴스가 들어오면 예외가 아닌 에러가 발생하게 해야 함
*/


