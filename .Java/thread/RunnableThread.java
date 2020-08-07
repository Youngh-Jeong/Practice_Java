class Sum{
	int num;
	public Sum() {num = 0;}
	public void addNum(int n) {num += n;}
	public int getNum() {return num;}
}

class AdderThread extends Sum implements Runnable{
	// 다른 클래스를 상속받았으므로 Thread클래스를 상속받지 못해 대신 Runnable인터페이스를 구현하는 방식으로 쓰레드를 작업
	int start, end;
	public AdderThread(int s, int e){
		start = s;
		end = e;
	}
	public void run() {
		for (int i = start;i<=end ;i++ ){
			addNum(i);
		}
	}
}

class  RunnableThread{
	public static void main(String[] args){
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		// Thread는 Runnable의 인스턴스를 매개변수로 하여 쓰레드를 생성할 수 있음
		// 사실 Runnable은 인터페이스이므로 인스턴스를 생성할 수 없으나 Runnable을 implements한 AdderThread클래스의 인스턴스가 Runnable의 하위클래스 개념으로 동작하여 Runnable 인터페이스의 인스턴스처럼 사용할 수 있음
		tr1.start();	tr2.start();
		// tr1과 tr2의 쓰레드를 실행시킴 (run()메소드 실행)
		try{
			tr1.join();	tr2.join();
			// tr1과 tr2의 작업이 모두 종료될 때까지 다른 작업을 시작 못하게 함
		}catch (InterruptedException e)	{
			e.printStackTrace();
		}
		System.out.println("1~100 까지의 합 : " + (at1.getNum() + at2.getNum()));
        
	}
}
