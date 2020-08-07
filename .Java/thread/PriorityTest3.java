class MessageSendingThread extends Thread{
	String message;
	public MessageSendingThread(String str, int prio) {
		message = str;
		setPriority(prio);
	}
	public void run() {
		for (int i = 0;i<10 ;i++ ){
			System.out.println(message + "(" + getPriority() + ")");
			try	{
				sleep(1);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class PriorityTest3 {
	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("1st", Thread.MAX_PRIORITY);
		MessageSendingThread tr2 = new MessageSendingThread("2nd", Thread.NORM_PRIORITY);
		MessageSendingThread tr3 = new MessageSendingThread("3rd", Thread.MIN_PRIORITY);
		tr1.start();	tr2.start();	tr3.start();
	}
}
