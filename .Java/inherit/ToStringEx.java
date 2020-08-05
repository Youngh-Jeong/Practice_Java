class MemberInfo{
	private String id, name, gender, addr;
	public MemberInfo(String i, String n, String g, String a){
		id = i;		name = n;		gender = g;		addr = a;
	}
	public String getId() { return id;}
	public String getName() { return name;}
	public String getGender() { return gender;}
	public String getAddr() { return addr;}
	public void setAddr(String addr) { this.addr = addr; }
	public String toString() {
		// Object 클래스에 있는 메소드 오버라이딩하여 사용하는 것을 권장
		// 객체(인스턴스)를 출력할 대 자동으로 호출되는 메소드
		String str = "ID : " + id + " / 이름 : " + name + " / 성병 : " + gender + " / 주소 : " + addr;
		return str;
	}
}

class ToStringEx{
	public static void main(String[] args) {
		MemberInfo mi1 = new MemberInfo("tes1", "홍길동", "남", "서울");
		MemberInfo mi2 = new MemberInfo("tes2", "전우치", "남", "함경도");
		MemberInfo mi3 = new MemberInfo("tes3", "임꺽정", "남", "지리산");
		
		System.out.println(mi1);
		System.out.println(mi2);
		System.out.println(mi3);
		// 인스턴스를 출력하면 자동으로 Object클래스의 toString()메소드가 동작하여 인스턴스를 출력할 수 있는 문자열로 만들어 줌
	}
}
