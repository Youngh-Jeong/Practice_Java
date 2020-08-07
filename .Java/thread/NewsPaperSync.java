class NewsPaper {
	String todayNews;
	boolean isTodayNews = false; // 뉴스가 있는지 여부

	public void setTodayNews(String news) {
		todayNews = news;
		isTodayNews = true;
		synchronized(this){
			notifyAll();	// wait()상태의 모든 쓰레드를 깨워 계속 동작하게 함
		}

	}
	public String getTodayNews() {
		if (!isTodayNews){ // todayNews가 비었으면(뉴스가 없으면)
			try{
				synchronized(this) {
					wait();  // sleep()과 다르게 다른 곳에서 깨울 때까지 대기 상태
				}
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		return todayNews;
	}
}

class NewsWriter extends Thread{
	NewsPaper paper;
	public NewsWriter(NewsPaper paper){this.paper = paper;}
	public void run(){
		paper.setTodayNews("오늘도 어김없이 비가 옵니다.");
	}
}

class NewsReader extends Thread{
	NewsPaper paper;
	public NewsReader(NewsPaper paper) {this.paper = paper;}
	public void run() {
		System.out.println("오늘의 뉴스 : " + paper.getTodayNews());
	}
}

class NewsPaperSync{
	public static void main(String[] args) 	{
		NewsPaper paper = new NewsPaper();
		NewsReader reader1 = new NewsReader(paper);
		NewsReader reader2 = new NewsReader(paper);
		NewsWriter writer = new NewsWriter(paper);

		try	{
			reader1.start();	reader2.start();

			Thread.sleep(1000);	writer.start();

			reader1.join();	reader2.join();	writer.join();
		}
		catch (InterruptedException e)	{
			e.printStackTrace();
		}
	}
}
