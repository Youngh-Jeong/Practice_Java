class NewsPaper {
	String todayNews;
	public void setTodayNews(String news) {
		todayNews = news;
	}
	public String getTodayNews() {
		return todayNews;
	}
}

class NewsWriter extends Thread{
	NewsPaper paper;
	public NewsWriter(NewsPaper paper){this.paper = paper;}
	public void run(){
		paper.setTodayNews("���õ� ������ �� �ɴϴ�.");
	}
}

class NewsReader extends Thread{
	NewsPaper paper;
	public NewsReader(NewsPaper paper) {this.paper = paper;}
	public void run() {
		System.out.println("������ ���� : " + paper.getTodayNews());
	}
}

class NewsPaperError{
	public static void main(String[] args) 	{
		NewsPaper paper = new NewsPaper();
		NewsReader reader = new NewsReader(paper);
		NewsWriter writer = new NewsWriter(paper);
		writer.start();	reader.start();
		try	{
		writer.join();	reader.join();
		}
		catch (InterruptedException e)	{
			e.printStackTrace();
		}
	}
}
