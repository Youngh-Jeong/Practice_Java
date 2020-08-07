class ShowThread extends Thread{
	// Thread Ŭ������ ��ӹ޾� ShowThread Ŭ������ ������ �۾��� �����ϰ� ��
	String threadName;
	public ShowThread(String name) {
		threadName = name;
	}
	public void run() {
	// Thread Ŭ������ �޼ҵ�� �� ������ Ŭ�������� �������̵��Ͽ� �۾���
	// �� ������ ���� �ؾ� �� �۾��� �����ϴ� �޼ҵ�
	// start()�޼ҵ��� �������� ȣ��Ǵ� �޼ҵ�� start()�� �ƴ� �ٸ� ������� ȣ���ϸ� ������ ������ ������ʹ� ������� �Ϲ� �޼ҵ�� ��޵�
		for (int i = 0;i<5 ;i++ ){
			System.out.println("�ȳ��ϼ���. "+ threadName + "�Դϴ�.");
			try{
				sleep(100);
				// ���� �����ϴ� �����带 100�и���(0.1��) ���� �Ͻø���
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class  ThreadUnderstand{
	public static void main(String[] args) {
		ShowThread st1 = new ShowThread("1st ������");
		ShowThread st2 = new ShowThread("2nd ������");
		//Thread�� ��ӹ��� Ŭ������ �ν��Ͻ��� ����
		// ������ �޸𸮸� �Ҵ�޾� �� �����庰�� ���� �����ϰ� ��

		st1.start();	st2.start();
		// start() : �����带 ���۽�Ű�� �޼ҵ�� run()�޼ҵ带 ȣ���ϴ� ���
	}
}
