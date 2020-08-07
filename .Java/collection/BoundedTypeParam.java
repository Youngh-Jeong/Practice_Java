interface Test{
	public void showYourName();
}

class UpperClass{
	public void showYourUpper(){
		System.out.println("Upper class");
	}
}

class Aa extends UpperClass implements Test{
	public void showYourName(){
		System.out.println("Aa class");	
	}
}

class Bb extends UpperClass implements Test{
	public void showYourName(){
		System.out.println("Bb class");	
	}
}

class BoundedTypeParam{
	public static <T extends Test> void showInstanceUpper(T param) {
		// <T extends Test> : 매개변수의 자료형은 Test 상속받는 객체
		// 제네릭의 자료형 제한에는 클래스와 인터페이스를 구분하지 않고 둘 다 extends를 사용
		param.showYourName();
	}
	public static <T extends UpperClass> void showInstanceName(T param){
		// <T extends UpperClass> : 매개변수의 자료형은 UpperClass를 상속받는 객체
		param.showYourUpper();
	}

	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();
		showInstanceUpper(a);
		showInstanceName(a);
		showInstanceUpper(b);
		showInstanceName(b);

		//showInstanceName(new String("test"));

		
	}
}
