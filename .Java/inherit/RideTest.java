class Aa{
	public void aaMethod() {System.out.println("aa's method");}
	public void ride() {System.out.println("aa's ride method");}
}

class Bb extends Aa{
	public void bbMethod() {System.out.println("bb's method");}
	public void ride() {System.out.println("bb's ride method");}
}

class RideTest{
	public static void main(String[] args){
		Aa a = new Aa();
		a.aaMethod();	a.ride();

		Bb b = new Bb();
		b.aaMethod();	b.bbMethod();	b.ride();

		Aa ab = new Bb();
		ab.aaMethod();
		//ab.bbMethod(); error
		// Aa형으로 선언되었기 때문에 Aa클래스의 메소드만 사용 가능
		ab.ride();
		//상위클래스인 Aa형으로 선언되었어도 오버라이딩된 메소드는 하위클래스의 메소드를 실행시킴
	}
}
