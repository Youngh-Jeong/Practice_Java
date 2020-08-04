class Computer {
	String owner;
	public Computer(String name) {owner = name;}
	public void calculate() { System.out.println("요청 내용을 계산합니다."); }
}

class Notebook extends Computer{
	// 'Notebook' is a 'Computer'의 관계가 성립하므로 상속을 받는 데 아무런 문제가 없음
	// 'Notebook' 클래스에서는 Computer의 기능 모두 사용할 수 있으므로 Notebook에서만 필요한 기능을 구현하면 됨
	int battery;
	public Notebook(String name, int init) {
		super(name);
		battery = init;
	}
	public void charging() { battery += 5; }
	public void movingCal() {
		if (battery < 1){
			System.out.println("충전이 필요합니다.");
			return;
		}
		System.out.print("이동하면서 ");
		calculate();
		// 실제 작업부분이나 상위클래스에 구현된 메소드가 있으므로 상위클래스의 메소드를 호출
		battery -= 1;
	}
}

class Tablet extends Notebook{
	// Notebook을 상속받음으로써 Notebook의 상위클래스인 Computer의 기능까지 Tablet에서 사용할 수 있음
	// 즉, Computer의 계산기능(calculate())과 Notebook의 휴대기능(movingCal())을 모두 Tablet에서 사용 가능
	String regPen;
	public Tablet(String name, int init, String pen) {
		super(name, init);
		regPen = pen;
	}
	public void write(String pen){
		if (battery < 1){
			System.out.println("충전이 필요합니다.");
			return;
		}
		if (!regPen.equals(pen)){
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		System.out.println("필기 내용을 처리합니다.");
		battery--;
	} 
}

class ISAInheritance{
	public static void main(String[] args){
		Notebook nb = new Notebook("홍길동", 5);
		Tablet tb = new Tablet("전우치", 5, "ISE-12345");
		nb.movingCal();		tb.write("ISE-12345");
	}
}
