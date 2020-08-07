class Increment{
	int num = 0;
	public synchronized void increment() { num++;}
	// synchronized : Ư�� �����尡 �۾��ϴ� ���ȿ��� �ٸ� �����尡 �������� ���ϰ� ����
	public int getNum() {return num;}
}

class IncThread extends Thread{
	Increment inc;
	public IncThread(Increment inc){
		this.inc = inc;
	}
	public void run() {
		for (int i = 0;i<100 ;i++ ){
			for (int j =0;j<100 ;j++ ){
				inc.increment();
			}
		}
	}
}

class ThreadSyncronized{
	public static void main(String[] args) {
		Increment inc = new Increment();
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);

		it1.start();	it2.start();	it3.start();
		try{
			it1.join();	it2.join();	it3.join();
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(inc.getNum());

	}
}
