class Aa {
	public void rideMethod() {System.out.println("Aa's Method");}
	public void loadMethod() {System.out.println("void Method");}
}

class Bb extends Aa {
	public void rideMethod() {System.out.println("Bb's Method");}
	public void loadMethod(int n) {System.out.println("int Method");}
}

class Cc extends Bb {
	public void rideMethod() {System.out.println("Cc's Method");}
	public void loadMethod(double n) {System.out.println("double Method");}
}


class RideAndLoad{
	public static void main(String[] args){
		Aa ref1 = new Cc();	Bb ref2 = new Cc();	Cc ref3 = new Cc();
		// 상위클래스형으로 선언하면 하위클래스의 인스턴스를 넣을 수 있음
		// JVM은 이 인스턴스들을 상위클래스형으로 판단하여 작업함
		// 단, 오버라이딩된 메소드일 경우 최하위 클래스의 메소드가 실행됨
		ref1.rideMethod();	ref2.rideMethod();	ref3.rideMethod();
		//Cc's Method		Cc's Method			Cc's Method
		// 오버라이딩된 메소드를 호출시 최하위 메소드가 실행됨
		ref3.loadMethod();	ref3.loadMethod(10);	ref3.loadMethod(3.14);
		//void Method		int Method				double Method
		// 상속관계에 있는 클래스들 사이에서도 오버로딩이 동작함
	}
}
