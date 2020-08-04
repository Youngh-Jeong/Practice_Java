class Man{
	private String name;
	public Man(String name) {this.name = name;}
	public void tellYourName() { System.out.println("My name is " + name); }
}

class BusinessMan extends Man{
// extends Man : Man클래스를 상속받아 Man의 멤버를 사용하겠다는 의미
	private String company, position;
	public BusinessMan(String name, String company, String position){
		super(name);
		// 하위클래스의 생성자에서는 가장 첫 줄에 상위클래스의 생성자를 호출해야 함
		this.company = company;
		this.position = position;
	}
	public void tellYourInfo() {
		System.out.println("My company is " + company);
		System.out.println("My position is " + position);
		tellYourName();
		// 상위클래스의 메소드이므로 자유롭게 호출
	}
}

class  BasicInheritance{
	public static void main(String[] args){
		BusinessMan man1 = new BusinessMan("Mr. Hong", "Hybrid 3D ELD", "Staff Eng.");
		BusinessMan man2 = new BusinessMan("Mr. Lee", "Hybrid 3D ELD", "Assist Eng.");

		System.out.println("1st man info............");
		man1.tellYourName();
		// Man클래스를 상속받은 BusinessMan클래스의 인스턴스이므로 Man클래스의 멤버를 자유롭게 호출
		man1.tellYourInfo();
		System.out.println("2nd man info............");
		man2.tellYourInfo();
	}
}
