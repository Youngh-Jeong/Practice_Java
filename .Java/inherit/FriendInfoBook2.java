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
	// 하위클래스에서 오버라이딩하기 위해 선언된 메소드
	public String getName(){return name;}
}

class HighFriend extends Friend{
	//Friend클래스를 상속받았으므로 기본정보는 Friend클래스에서 저장하고 HighFriend에서는 고교친구 전용 정보만 저장하면 됨
	String work;	// 고교친구 전용 정보
	public HighFriend(String name, String phone, String addr, String job){
		super(name, phone, addr);
		// 받아온 정보들 중 기본정보에 해당하는 정보들은 상위클래스인 Friend로 올림
		work = job;
	}
	public void showData(){
		super.showData();
		// showData()메소드는 오버라이딩되어 있기 때문에 상위클래스의 원본 메소드를 호출하려면 super을 이용하여 호출하는 방법
		System.out.println("직업 : " + work);
	}
	public void showBasicInfo(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
	}
}

class UnivFriend extends Friend{
	//Friend클래스를 상속받았으므로 기본정보는 Friend클래스에서 저장하고 UnivFriend에서는 대학친구 전용 정보만 저장하면 됨
	String major;	// 대학친구 전용 정보
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
	// 정보저장용 클래스들(Friend, HighFriend, UnivFriend)을 이용하여 실제 작업을 하는 클래스
	private Friend[] friends;
	//Friend형 배열 friends를 선언 : HighFriend와 UnivFriend 모두의 인스턴스를 저장하기 위해
	private int numOfFriends;
	// friends 배열의 인덱스와 배열에 들어있는 데이터의 개수를 표현하는 변수
	public FriendHandler(int num) {
		// 배열의 개수를 받아와서 friends배열을 생성
		friends = new Friend[num];
		numOfFriends = 0;
		//friends배열에 추가할 데이터가 들어갈 인덱스 번호이자 현재 들어있는 데이터의 개수
	}
	private void addFriendInfo(Friend fren){
	// 현재 클래스 내부에서만 사용해야 하는 메소드이므로 private으로 선언됨
	// 친구정보를 담은 인스턴스를 friends배열에 저장하는 메소드
	// 매개변수의 자료형을 Friend로 하여 HighFriend와 UnivFriend 모두 받을 수 있게 함
		friends[numOfFriends] = fren;
		// friends배열에 받아온 데이터를 저장
		numOfFriends++;
		// 다음에 넣을 데이터의 인덱스번호를 1 증가
	}
	public void addFriend(int choice){
		// 저장할 친구정보를 사용자에게 입력받는 메소드
		String name, phone, addr, work, major;
		// 입력받을 정보들을 저장할 변수들
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : "); name = sc.nextLine();
		System.out.print("전화 : "); phone = sc.nextLine();
		System.out.print("주소 : "); addr = sc.nextLine();
		// 친구 기본정보들을 입력 받음

		if (choice == 1){
			System.out.print("직업 : "); work = sc.nextLine();
			addFriendInfo(new HighFriend(name, phone, addr, work));
			// 입력받은 데이터를 이용하여 HighFriend의 인스턴스를 생성한 후 그 인스턴스를 매개변수로 하여 addFriendInfo()메소드를 호출
		} else {
			System.out.print("전공 : "); major = sc.nextLine();
			addFriendInfo(new HighFriend(name, phone, addr, major));
		}
		System.out.println("입력 완료\n");
	}
	public void showAllData() {
		for (int i = 0;i < numOfFriends ;i++ ){
			// 배열의 길이가 아닌 현재 들어있는 데이터 만큼만 루프를 돔
			friends[i].showData();
			// friends배열의 i 인덱스에 들어있는 인스턴스의 showData()메소드 실행
			// friends배열이 Friend형이므로 Friend클래스의 showData()메소드가 실행되어야 하나 오버라이딩되어있기 때문에 하위클래스의 showData()메소드가 실행됨
			System.out.println();
		}
	}
	public void showBasicData() {
		for (int i = 0;i < numOfFriends ;i++ ){
			friends[i].showBasicInfo();
			/*
			shoBasicInfo()메소드가 오버라이딩이 아닐 경우
			if (friends[i] insatnceof HighFriend){
				((HighFriend)friends[i]).showBasicInfo();
			} else if (friends[i] insatnceof UnivFriend){
				((UnivFriend)friends[i]).showBasicInfo();
			}
			*/
			System.out.println();
		}
	}

	public void searchName(){
		Scanner sc2 = new Scanner(System.in);
		System.out.print("검색할 이름 : "); String name = sc2.nextLine();
		boolean isNotFound = true;
		for (int i = 0; i<numOfFriends;i++ ){
			if (name.equals(friends[i].getName())){
				// 받아온 perNum과 perArr배열에 들어있는 인스턴스의 number값을 같은지 비교하여 원하는 이름을 리턴
				friends[i].showData();
				isNotFound = false;
				System.out.println();
			}
		}
		if (isNotFound){System.out.print("검색 결과가 없습니다.");}
	}
}


class FriendInfoBook2{
	public static void main(String[] args){
		FriendHandler handler = new FriendHandler(10);
		while (true){//무한루프 : 반드시 빠져나올 조건이 있어야 함
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 친구정보 검색");
			System.out.println("9. 프로그램 종료");
			System.out.print("선택 >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1: case 2: //choice가 1이나 2이면
				handler.addFriend(choice);	break;
			case 3:
				handler.showAllData();			break;
			case 4:
				handler.showBasicData();			break;
			case 5:
				handler.searchName();			break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				//메소드 강제 종료로 현재는 main()메소드이므로 프로그램이 종료됨
			}
		}
	}
}
