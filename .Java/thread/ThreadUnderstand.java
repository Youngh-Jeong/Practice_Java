class ShowThread extends Thread{
	// Thread 클래스를 상속받아 ShowThread 클래스도 쓰레드 작업이 가능하게 됨
	String threadName;
	public ShowThread(String name) {
		threadName = name;
	}
	public void run() {
	// Thread 클래스의 메소드로 각 쓰레드 클래스에서 오버라이딩하여 작업함
	// 각 쓰레드 별로 해야 할 작업을 구현하는 메소드
	// start()메소드의 실행으로 호출되는 메소드로 start()가 아닌 다른 방법으로 호출하면 동작은 되지만 쓰레드와는 상관없는 일반 메소드로 취급됨
		for (int i = 0;i<5 ;i++ ){
			System.out.println("안녕하세요. "+ threadName + "입니다.");
			try{
				sleep(100);
				// 현재 동작하는 쓰레드를 100밀리초(0.1초) 동안 일시멈춤
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class  ThreadUnderstand{
	public static void main(String[] args) {
		ShowThread st1 = new ShowThread("1st 쓰레드");
		ShowThread st2 = new ShowThread("2nd 쓰레드");
		//Thread를 상속받은 클래스의 인스턴스를 생성
		// 별도의 메모리를 할당받아 각 쓰레드별로 따로 동작하게 됨

		st1.start();	st2.start();
		// start() : 쓰레드를 시작시키는 메소드로 run()메소드를 호출하는 기능
	}
}
