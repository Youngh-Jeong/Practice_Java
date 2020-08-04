class Gun{
	int bullet;
	public Gun(int bnum) {bullet = bnum;}
	public void shot() {
		System.out.println("BBANG!!");
		bullet--;
	}
}

class Police{
	int handcuffs;
	Gun pistol;
	public Police(int bnum, int bcuff){
		handcuffs = bcuff;
		if (bnum > 0){
		// bnum이 0보다 크면 (총알이 있으면 == 총을 소지하는 경찰이면)
			pistol = new Gun(bnum);
			// 경찰이 소지할 총의 인스턴스 생성
		} else{
		// bnum이 0이하 이면(총알이 없으면 == 총이 없는 경찰이면)
			pistol = null;
			// 총이 없으므로 선언해 놓은 pistol 인스턴스에 null을 넣어 비워둔다.
			// null : 아무것도 아닌 값으로 주로 객체를 비울 때 사용됨
		}
	}
	public void putHandcuff(){
		System.out.println("SNAP!");
		handcuffs--;
	}
	public void shot() {
		if (pistol == null){
		// 총이 없으면
			System.out.println("총이 없는데요.");
		} else {
			pistol.shot();
		}
	}
}

class HASAComposite{
	public static void main(String[] args){
		Police pman1 = new Police(5, 3);
		//총을 가진 Police 인스턴스 생성
		pman1.shot();
		pman1.putHandcuff();
		
		Police pman2 = new Police(0, 3);
		//총이 없는 Police 인스턴스 생성
		pman2.shot();
	
	}
}
