class Person{
	private int perID, milID, bYear, bMonth, bDay; 
	public Person(int pID, int mID, int bYear, int bMonth, int bDay){
		perID = pID;
		milID = mID;
		this.bYear = bYear;
		this.bMonth = bMonth;
		this.bDay = bDay;
	}
	public Person(int pID, int bYear, int bMonth, int bDay){
		/*
		this(pID, 0, bYear, bMonth, bDay);
		this() : 다른 생성자를 호출
		*/
		perID = pID;
		milID = 0;
		this.bYear = bYear;
		this.bMonth = bMonth;
		this.bDay = bDay;
	}
	public void showInfo(){
		System.out.println("민번 : " + perID);
		System.out.println("생일 : " + bYear + "/" + bMonth + "/" + bDay);
		if (milID !=0){
			System.out.println("군번 : " + milID + "\n");
		} else {
			System.out.println("군과 관련 없음\n");
		}
	}
}

class  Overloading{
	public static void main(String[] args) {
		Person p1 = new Person(950123, 880101, 1995, 1, 23);
		Person p2 = new Person(941023, 1994, 10, 23);
		p1.showInfo(); p2.showInfo();
    }
}
