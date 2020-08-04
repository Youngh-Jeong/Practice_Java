class Gun{
	int bullet;
	public Gun(int bnum) {bullet = bnum;}
	public void shot() {
		System.out.println("BBANG!!");
		bullet--;
	}
}

class Police extends Gun{
	//Police와 Gun은 has-a관계이므로 모든 Police는 Gun을 소유하고 있어야 정확한 상속이 이루어짐
	//문제는 Gun을 소유하고 있지 않은 Police가 있을 경우 표현할 수가 없음
	int handcuffs;
	public Police(int bnum, int bcuff){
		super(bnum);
		handcuffs = bcuff;
	}
	public void putHandcuff(){
		System.out.println("SNAP!");
		handcuffs--;
	}
}

class  HASAInheritance{
	public static void main(String[] args){
		Police pman = new Police(5, 3);
		// 5발의 총알과 3개의 수갑을 가진 경찰 인스턴스 생성
		pman.shot();
		pman.putHandcuff();

		// 현재 클래스에서는 총이 없는 경찰의 인스턴스는 생성하 ㄹ수 없음
		// 그러므로 총이 없는 경찰이 존재할 경우 Police와 Gun의 상속은 잘못된 방법이 됨
	}
}
