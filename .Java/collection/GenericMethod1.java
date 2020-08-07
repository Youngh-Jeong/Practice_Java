class Aa{
	public String toString() {return "class Aa";}
	// Object클래스의 메소드로 오버라이딩 해놓음
	// 인스턴스 출력시 자동으로 호출되는 메소드
}

class Bb{
	public String toString() {return "class Bb";}
}

class InstanceTypeShower{
	int showCnt = 0;
	public <T> void showInstType(T inst) {
	// 현 메소드 호출시 매개변수의 자료형을 T로 지정한 자료형으로 작업하라는 의미
		System.out.println(inst);
		showCnt++;
	}
	void showPrintCnt(){System.out.println("show count : " + showCnt);}
}

class  GenericMethod1{
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();
		InstanceTypeShower shower = new InstanceTypeShower();
		shower.<Aa>showInstType(a);
		shower.<Bb>showInstType(b);
		shower.showInstType(a);
		shower.showInstType(b);
		// 제네릭으로 지정한 자료형을 생략해도 정상적으로 동작함
		// 매개변수의 자료형을 그거로 제네릭 자료형 정보를 미리 판단한 것임
		shower.showPrintCnt();
	}
}
