class Aa{
	public String toString() {return "class Aa";}
}

class Bb{
	public String toString() {return "class Bb";}
}

class InstanceTypeShower2{
	public <T, U> void showInstType(T inst1, U inst2) {
	// 제네릭으로 지정하는 자료형이 두 개 이상일 경우
		System.out.println(inst1);
		System.out.println(inst2);
	}
}

class  GenericMethod2{
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();
		InstanceTypeShower2 shower = new InstanceTypeShower2();
		shower.<Aa, Bb>showInstType(a, b);
		shower.showInstType(a, b);
		// 제네릭으로 지정한 자료형이 두 개 이상일 경우에도 제네릭 생략 가능
	}
}
