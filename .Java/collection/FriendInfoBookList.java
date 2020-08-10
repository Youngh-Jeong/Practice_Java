/*
친구 주소록 프로그램
1. 기능
 - 친구 등록 : 고교친구와 대학친구로 구분하여 등록(받는 데이터도 차이가 남)
    친구 정보를 메모리에 저장(배열에 저장)
 - 정보 출력 : 등록된 친구들의 정보를 보여주기

2. 클래스
 - Friend : 범용 친구정보 저장용 클래스 : 고교와 대학으로 나뉘지 않고 친구의 공통적인 부분을 저장할 클래스 
 - HighFriend : Friend 클래스를 상속받아 기본정보를 제외한 고교친구 전용 정보를 저장할 클래스
 - UnivFriend : Friend 클래스를 상속받아 기본정보를 제외한 대학친구 전용 정보를 저장할 클래스
 - FriendHandler : 친구 정보를 이용해 작업을 처리하는 클래스
 - FriendInfoBook : 프로그램의 시작과 종료를 담당 (main()메소드가 있는 클래스)

Friend클래스가 HighFriend와 UnivFriend의 상위클래스이므로 Friend클래스형으로 두 클래스를 묶을 수 있음
두 클래스를 동일한 방식으로 제어할 수 있게 해줌
*/
import java.util.*;

class Friend{
	String name, phone, addr;
	public Friend(String name, String phone, String addr){
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showData(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);
	}
	public void showBasicInfo(){}
}

class HighFriend extends Friend{
	String work;	
	public HighFriend(String name, String phone, String addr, String job){
		super(name, phone, addr);
		work = job;
	}
	public void showData(){
		super.showData();
		System.out.println("직업 : " + work);
	}
	public void showBasicInfo(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
	}
}

class UnivFriend extends Friend{
	String major;	
	public UnivFriend(String name, String phone, String addr, String major){
		super(name, phone, addr);
		this.major = major;
	}
	public void showData(){
		super.showData();
		System.out.println("전공 : " + major);
	}
	public void showBasicInfo(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("전공 : " + major);
	}
}

class FriendHandler{
	private ArrayList<Friend> friends;
	public FriendHandler() {
		friends = new ArrayList();
	}
	// Friend형 인스턴스만 저장하는 ArrayList인 friends를 선언 및 생성
	// 제네릭으로 <Friend>를 선언했으므로 오직 Friend형 객체만 저장할 수 있게 됨
	// 안에 저장된 객체를 사용시 Friend클래스로 형변환하지 않아도 자동으로 Friend형으로 인식함
	// 만약 제네릭으로 선언하지 않았으면 안에 저장된 객체는 Object로 인식되어 사용시 형변환을 해야 함
	private void addFriendInfo(Friend fren){
		friends.add(fren);
	}
	public void addFriend(int choice){
		String name, phone, addr, work, major;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : "); name = sc.nextLine();
		System.out.print("전화 : "); phone = sc.nextLine();
		System.out.print("주소 : "); addr = sc.nextLine();

		if (choice == 1){
			System.out.print("직업 : "); work = sc.nextLine();
			addFriendInfo(new HighFriend(name, phone, addr, work));
		} else {
			System.out.print("전공 : "); major = sc.nextLine();
			addFriendInfo(new HighFriend(name, phone, addr, major));
		}
		System.out.println("입력 완료\n");
	}
	public void showAllData() {
		for (int i = 0;i < friends.size() ;i++ ){
			(friends.get(i)).showData();
			// ArrayList 생성시 <Friend>로 선언하여 Friend형 인스턴스만 저장했기 때문에 따로 형변환 없이 사용 가능
			// 상위클래스인 Friend에 메소드들이 정의되어 있고, 하위클래스인 HighFriend와 UnivFriend에서 오버라이딩했디 때문에 Friend형으로도 메소드 호출이 가능
			System.out.println();
		}
	}
	public void showBasicData() {
		for (int i = 0;i < friends.size() ;i++ ){
			friends.get(i).showBasicInfo();

			System.out.println();
		}
	}
}

class FriendInfoBookList{
	public static void main(String[] args){
		FriendHandler handler = new FriendHandler();
		while (true){//무한루프 : 반드시 빠져나올 조건이 있어야 함
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1: case 2: 
				handler.addFriend(choice);	break;
			case 3:
				handler.showAllData();			break;
			case 4:
				handler.showBasicData();			break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
