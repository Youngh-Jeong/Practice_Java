abstract class PersonalNumberStorage {
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);

}

class PersonalNumInfo{ // 정보 저장용 클래스
	String name, number;
	PersonalNumInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	String getName() {return name;}
	String getNumber() {return number;}
}

class PersonalNumberStorageImpl extends PersonalNumberStorage{
// abstract클래스인 PersonalNumberStorage를 상속받았으므로 PersonalNumberStorage클래스에 있는 abstract메소드를 반드시 구현해야 함
	PersonalNumInfo[] perArr;
	// PersonalNumInfo형 배열 perArr을 선언 (정보가 들어있는 인스턴스를 저장하기 위한 배열)
	int numOfPerInfo;
	// perArr배열의 인덱스 번호 및 저장된 데이터 개수를 저장하기 위한 변수
	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		// 받아온 int값 sz를 이용하여 perArr배열을 생성
		numOfPerInfo = 0;
		// perArr배열에 저장할 데이터의 인덱스번호 초기화
	}
	public void addPersonalInfo(String name, String perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		//받아온 매개변수의 값을 이용하여 PersonalNumInfo의 인스턴스를 생성한 후 perArr배열에 저장
		numOfPerInfo++;
		// 다음에 저장될 PersonalNumInfo 인덱스
	}
	public String searchName(String perNum){
		for (int i = 0; i<numOfPerInfo;i++ ){
			if (perNum.equals(perArr[i].getNumber())){
				// 받아온 perNum과 perArr배열에 들어있는 인스턴스의 number값을 같은지 비교하여 원하는 이름을 리턴
				return perArr[i].getName();
			}
		}
		return null;
		// 리턴타입이 객체이면 어디서든 사용할 수 있음
	}
}


class AbstractEx{
	public static void main(String[] args){
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(10);
		storage.addPersonalInfo("홍길동", "950000-1234567");
		storage.addPersonalInfo("전우치", "970000-1234567");
		// storage인스턴스는 상위클래스인 PersonalNumberStorage의 자료형이나 오버라이딩된 메소드이므로 하위클래스인 PersonalNumberStorageImpl의 addPersonalInfo()메소드가 실행됨됨
	
		String sch1 = storage.searchName("950000-1234567");
		String sch2 = storage.searchName("970000-1234567");
		String sch3 = storage.searchName("940000-1234567");
		// sch1~3까지 검색이 되었으면 이름을, 검색결과가 없으면 "결과가 없습니다"라고 출력
		if (sch1 == null){ System.out.println("950000-1234567 : 검색결과가 없습니다.");}
		else 
			System.out.println("950000-1234567 :" + sch1);
		if (sch2 == null){ System.out.println("970000-1234567 : 검색결과가 없습니다.");}
		else 
			System.out.println("970000-1234567 :" + sch2);
		if (sch3 == null){ System.out.println("940000-1234567 : 검색결과가 없습니다.");}
		else 
			System.out.println("940000-1234567 :" + sch3);
	}
}
