class Access{
	static int num = 0; // 클래스 변수
	Access() {incrCnt();}
	public void incrCnt() {num++;}
}

class ClassMemberAccess{
	public static void main(String[] args) {
		Access.num++;	// 인스턴스의 유무와 상관없이 클래스멤버는 접근가능
		Access ac = new Access();
		ac.num++;		// 클래스멤버는 인스턴스를 통해서 접근할 수도 있음
		Access.num++;	// 클래스멤버는 클래스를 통해서 접근할 수도 있음
		System.out.println("num : " + Access.num); //4
	}
}
