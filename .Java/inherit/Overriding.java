class Speaker{
	private int volume;
	public void showCurrentState(){
		System.out.println("볼륨 크기 : " + volume);
	}
	public void setVolume(int vol) {volume = vol;}
}

class BaseSpeaker extends Speaker{
	private int base;
	public void showCurrentState(){ //오버라이딩 된 메소드
		super.showCurrentState(); // 상위클래스의 오버라이딩 원본 메소드를 호출하려면 super 키워드를 이용해서 호출해야 함
		System.out.println("베이스 크기 : " + base);
	}
	public void setBase(int base) {this.base = base;}
}

class Overriding{
	public static void main(String[] args){
		BaseSpeaker bs = new BaseSpeaker();
		bs.setVolume(10);
		bs.setBase(20);
		bs.showCurrentState();
		// 오버라이딩된 메소드를 호출하면 무조건 하위클래스의 메소드가 실행됨
		// 오버라이딩된 상태에서 상위클래스의 원본 메소드를 실행할면 인스턴스로는 불가능하고
		// 하위클래스의 오버라이딩된 메소드에서 super를 이용하여 호출해야 함
	}
}
