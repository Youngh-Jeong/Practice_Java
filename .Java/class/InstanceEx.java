class NumberEx {
	int num = 0;	//멤버변수
	public void addNum(int n) { num += n; }
	public int getNum() { return num;}
}

class InstanceEx {
	static int num2 = 0;
	public static void main(String[] args) {
		NumberEx inst;
		// NumberEx형 인스턴스 inst를 선언 (메모리 상에 위치에 대한 주소만 저장)
		// 인스턴스 특성상 용량을 정확하게 알 수 없으므로 미리 공간을 확보하지는 못함

		inst = new NumberEx(); // new : 인스턴스 생성 명령어
		// inst라는 이름의 NumberEx형 인스턴스를 생성시킴
		System.out.println("메소드 호출 전 : " + inst.getNum());
		// inst.getNum() : inst 안의 getNum() 메소드 호출
		testMethod(inst);
		// testMethod()를 호출하며 inst를 매개변수로 가져감
		// 인스턴스도 매개변수로 사용할 수 있음
		// 인스턴스를 매개변수로 사용하면 인스턴스의 주소가 가서 같은 인스턴스로 작업하게 됨
		System.out.println("메소드 호출 후 : " + inst.getNum()); //12

		testMethod2(num2);
		// 인스턴스가 아닌 일반 변수를 매개변수로 보내면 그 값이 넘어가게 됨
		System.out.println("변수 사용 후 : " + num2);
	}
	public static void testMethod(NumberEx numb) {
	// 인스턴스를 매개변수로 받으면 그 인스턴스의 주소를 받아 오므로 주소에 해당하는 인스턴스를 가지고 작업하게 됨
	// 주소에 해당하는 인스턴스를 직접 가지고 작업하게 됨
		numb.addNum(12);
		// numb 안의 addNum() 메소드 실행
	}
	public static void testMethod2(int n) {
		n += 20;
	}
}
/*
매개변수로 인스턴스와 변수를 각각 사용할 경우 차이점
 - 변수 : 변수의 값만 넘어가게 되어 그 값을 이용해 여러 작업을 할 수 있으나 원본 변수의 값은 변하지 않음
 - 인스턴스 : 인스턴스의 주소값이 넘어가게 되어 그 주소의 인스턴스를 그대로 사용할 수 있으며, 여러 작업을 하게 되면 원본 인스턴스에도 그 영향을 미치게 됨
*/