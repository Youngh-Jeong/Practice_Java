interface PersonalNumberStorage {
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);
}

class PersonalNumInfo{
	String name, number;
	PersonalNumInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	String getName() {return name;}
	String getNumber() {return number;}
}

class PersonalNumberStorageImpl implements PersonalNumberStorage{
// PersonalNumberStorage가 인터페이스이므로 상속이 아닌 구현해야 함
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}
	public void addPersonalInfo(String name, String perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}
	public String searchName(String perNum){
		for (int i = 0; i<numOfPerInfo;i++ ){
			if (perNum.equals(perArr[i].getNumber())){
				return perArr[i].getName();
			}
		}
		return null;
	}
}

class InterfaceEx2 {
	public static void main(String[] args){
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(10);
		storage.addPersonalInfo("홍길동", "950000-1234567");
		storage.addPersonalInfo("전우치", "970000-1234567");
		System.out.println(storage.searchName("950000-1234567"));
		System.out.println(storage.searchName("970000-1234567"));

	}
}
