class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("당도 : " + sugar); }
}

class OrangeBox{
	Orange item;
	public void store(Orange item) { this.item = item; }
	public Orange pullOut() {return item;}
}
class FruitBoxOrange{
	public static void main(String[] args) {
		OrangeBox fBox1 = new OrangeBox();
		fBox1.store(new Orange(10));
		Orange org1 = fBox1.pullOut();
		org1.showSugar();

		OrangeBox fBox2 = new OrangeBox();
		fBox2.store(new String("오렌지"));
		// store()메소드의 매개변수 자료형이 Orange이므로 형변환 불가
		Orange org2 = fBox2.pullOut();
		org2.showSugar();
	}
}

/*
문제점
 - 한 가지 종류의 데이터만 바을 수 있음 (Orange)
 - 다른 종류의 데이터를 받으려면 OrangeBox클래스가 여러 개 필요함

해결책
 - 제네릭 사용
*/
