class Exercise7{
	public static void main(String[] args){
		/*7-14�� ���� �ּ�ó��
		//7-1 Ȯ��
		SutdaDeck deck = new SutdaDeck();

		for (int i=0;i<deck.cards.length ; i++){
			System.out.print(deck.cards[i]+",");
		}


		//7-2 Ȯ��
		System.out.println();
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		for (int i=0;i<deck.cards.length ; i++){
			System.out.print(deck.cards[i]+",");
		}
		System.out.println();
		System.out.print(deck.pick(0));

*/
		//7-14Ȯ��

		SutdaCard card = new SutdaCard(1,true);

		//7-10 Ȯ��
		MyTv2 t = new MyTv2();

		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());
		
		//7-11 Ȯ��
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());

		//7-17 Ȯ��
		Robot77[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
		for (int i = 0;i < arr.length;i++){
			action(arr[i]);
		}

		//7-19 Ȯ��

		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());

		b.summary();

		//7-23 Ȯ��
		Shape[] arr2 = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
		System.out.println("������ ��:" + sumArea(arr2));

		//7-25
		Outer1 out1 = new Outer1();
		Outer1.Inner in1 = out1.new Inner();
		System.out.println(in1.iv);
		//7-26
		Outer2.Inner in2 = new Outer2.Inner();
		System.out.println(in2.iv);
		//7-27 30,20,10�� ��µǵ��� �ڵ� �ϼ�
		Outer3 o3 = new Outer3();
		Outer3.Inner inner = o3.new Inner();
		inner.method1();

	}
	// 7-23
	static double sumArea(Shape[] arr){
		double sum = 0;
		for (int i = 0;i<arr.length;i++){
			sum += arr[i].calcArea();
		}
		return sum;
	}
	
	//7-17
	static void action(Robot77 r){
		if (r instanceof DanceRobot){
			DanceRobot dr = (DanceRobot)r;
			dr.dance();
		} else if (r instanceof SingRobot){
			SingRobot sr = (SingRobot)r;
			sr.sing();
		} else {
			DrawRobot dr = (DrawRobot)r;
			dr.draw();
		}
	}
}

//7-1 : ���� 20���� �迭 �ʱ�ȭ
//7-14 : ����ī���� ���ڿ� ������ ����Ǹ� �ȵǴ� ���̴�. �̸� �ݿ��Ͽ� �����Ͻÿ� (1���� ���� �̸��� �ȹٲ�)

class SutdaDeck{
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck(){
		int num;
		boolean isKwang;
		for (int i=0;i<CARD_NUM;i++){
			num=i%10+1;
			isKwang = ((i<10)&&(num==1||num==3||num==8));
			cards[i] = new SutdaCard(num, isKwang);
		}
		
	}
	// 7-2 : ������ �޼��带 �߰��Ͻÿ�
	// 1. shuffle : ��ġ�� �ڼ��� 2.pick : ������ ��ġ�� SutdaCard ��ȯ 3. pick : ������ ��ġ�� SutdaCard��ȯ (Math.random() ���)

	public void shuffle(){
		SutdaCard tmp;
		int j;
		for (int i=0;i<cards.length;i++){
			j = (int)(Math.random()*(cards.length - 1)+1);
			tmp = cards[i];
			cards[i]=cards[j];
			cards[j]= tmp;
		}
	}

	public SutdaCard pick(int i){
		return cards[i];
	}
	public SutdaCard pick(){
		int j = (int)(Math.random()*(cards.length - 1)+1);
		return cards[j];
	}
}

class SutdaCard{
	private int num;
	private boolean isKwang;

	SutdaCard(){
		this(1,true);
	}

	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	public String toString(){
		return num + (isKwang ? "K":"");
	}
}

//7-10 : MyTv2Ŭ������ ��������� Ŭ���� �ܺο��� ������ �� ������ �ϰ� getter�� setter�� �߰��϶�.

class MyTv2{
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevch; //7-11

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	public void setIsPowerOn(boolean power){
		isPowerOn = power;
	}
	public void setChannel(int channel){
		if (channel<1||channel>100){
			System.out.println("��ȿ�� ä���� �ƴմϴ�.");
			return;
		}
		this.prevch = this.channel; //7-11�� ���� �߰�
		this.channel = channel;
	}
	public void setVolume(int vol){
		if (vol<0||vol>100){
			System.out.println("��ȿ�� ������ �ƴմϴ�.");
			return;
		}
		volume = vol;
	}
	public boolean getIsPowerOn(){return isPowerOn;}
	public int getChannel(){return channel;}
	public int getVolume(){return volume;}

	//7-11 : ���� ä�η� �̵��ϴ� �޼��带 �߰��϶� (���� ä���� ���� ������ ��������� �����϶�)\
	
	public void gotoPrevChannel(){
		setChannel(prevch);
	}

}

	//7-17 : �� ���� Ŭ�������� ����κ��� �̾Ƴ� Unit�̶� Ŭ������ ����� �̸� ��ӹ޴� �ڵ� �ۼ�

class Unit{
	int x, y;
	void move (int x, int y){}
	void stop(){}
}

class Marine{
	void stimPack() {}
}
class Tank{
	void changeMod(){}
}
class Dropship{
	void move (int x, int y) {}
	void load (){}
	void unload () {}
}

	//7-18 : ������ ���� �������� �򵵷� �ڵ� �ϼ�

class Robot77{}
class DanceRobot extends Robot77{
	void dance(){System.out.println("������ϴ�.");}
}
class SingRobot extends Robot77{
	void sing(){System.out.println("�뷡���մϴ�.");}
}
class DrawRobot extends Robot77{
	void draw(){System.out.println("�׸����׸��ϴ�.");}
}

	//7-19 : ������ ��� ����� BuyerŬ�����̴�. ��ǰ�� �����ϴ� buy�޼ҵ�, ��ٱ��Ͽ� ������ �߰��ϴ� add�޼ҵ�, ������ ���� ��ϰ� ���ݾ�, �����ݾ��� ����ϴ� summary �޼ҵ� �ۼ�

class Product{
	int price;
	Product(int price) {
		this.price = price;
	}
}
class Tv extends Product{
	Tv() {super(100);}
	public String toString() {return "Tv";}
}
class Computer extends Product{
	Computer() {super(200);}
	public String toString() {return "Computer";}
}
class Audio extends Product{
	Audio() {super(50);}
	public String toString() {return "Audio";}
}

class Buyer{
	int money = 10000;
	Product[] cart = new Product[3];
	int i = 0;

	void buy(Product p){
		if (p.price>money){
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		add(p);
		money -= p.price;
	}

	void add(Product p){
		if (i>=cart.length){
			Product[] tmp = new Product[cart.length*2];
			System.arraycopy(cart, 0, tmp, 0, cart.length);
			cart = tmp;
		}

		cart[i++] = p;
	}

	void summary(){
		String sList = "��ٱ��� : ";
		int totalPrice = 0;
		for (int i=0;i<cart.length ;i++){
			if (cart[i]==null){break;}
			sList = sList + cart[i] + "/";
			totalPrice += cart[i].price;
		}
		System.out.println(sList);
		System.out.println(totalPrice);
		System.out.println(money);
	}
}

// 7-22 : ������ ������ ShapeŬ�����̴�. �� Ŭ������ �������� �ϴ� CircleŬ������ RectangleŬ������ �ۼ�

abstract class Shape{
	Point p;
	Shape () {
		this(new Point(0,0));
	}
	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	void setPosition(Point p) {
		this.p = p;
	}
}

class Point{
	int x;
	int y;

	Point() {
		this(0,0);
	}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "["+x+","+y+"]";
	}
}

class Circle extends Shape{
	double r;
	Circle(double r){
		this(r, new Point());
	}
	Circle(double r, Point p){
		super(p);
		this.r = r;
	}
	double calcArea(){
		return Math.PI*r*r;
	}
}

class Rectangle extends Shape{
	double width;
	double height;

	Rectangle(double width, double height, Point p){
		super(p);
		this.width = width;
		this.height = height;
	}
	Rectangle(double width, double height){
		this(width, height, new Point());
	}
	double calcArea(){
		return width*height;
	}
	boolean isSquare(){
		return width*height!=0&&width == height;
	}
}

// 7-25
class Outer1{
	class Inner{
		int iv = 100;
	}
}
// 7-26
class Outer2{
	static class Inner{
		int iv = 200;
	}
}

// 7-27
class Outer3{
	int value = 10;

	class Inner{
		int value = 20;
		void method1(){
			int value = 30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer3.this.value);
		}
	}
}



