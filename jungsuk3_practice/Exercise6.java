class Exercise6{ //34p
	public static void main(String[] args) {

		//6-2 �� Ŭ������ �� ���� �����ڿ� info()�� �߰��ؼ� �������� ���� ����� ��� �ڵ� (3, 1K)
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();

		System.out.println(card1.info());
		System.out.println(card2.info());
		
		//6-5 ȫ�浿,1,1,100,60,76,236,78.7�� ��µǴ� �ڵ� (Ŭ������ �����ڿ� info()�߰�)

		Student s = new Student("ȫ�浿",1,1,100,60,76);

		System.out.println(s.info());

		//6-6 Ȯ��
		System.out.println(getDistance(1,1,2,2));
		//6-7 p=(1,1)�� (2,2)������ �Ÿ� ���Ѵ�		
		MyPoint p = new MyPoint(1,1);
		System.out.println(p.getDistance(2,2));
		//6-20 Ȯ��
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		//6-21 Ȯ��
		MyTv t = new MyTv();

		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);

		t.channelDown();
		t.volumeDown();
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);

		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);

		//6-22 Ȯ��
		String str = "123";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));

		str = "1234o";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));	
		
		//6-23 Ȯ��
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ� : " + max(data));
		System.out.println("�ִ� : " + max(null));
		System.out.println("�ִ� : " + max(new int[] {}));

		int value = 5;
		System.out.println(value+"�� ���밪:"+abs(value));
		value = -10;
		System.out.println(value+"�� ���밪:"+abs(value));

	}

		//6-24 ���밪 ��ȯ�ϴ� �޼ҵ� abs
	public static int abs(int value){
		if (value < 0){
			return -value;
		}
		return value;
	}


		//6-23 �־��� int�迭 �� �߿��� ���� ū ���� ��ȯ (���� �迭�� null�̰ų� ũ�Ⱑ 0�� ���, -999999�� ��ȯ�Ѵ�.
	public static int max(int[] arr){
		if (arr==null || arr.length==0){
			return -999999;
		}
		int higher = arr[0];
		for (int i=0;i<arr.length;i++){
			if (higher<arr[i]){
				higher = arr[i];
			} 
		}
		return higher;
	}

		//6-22 �־��� ���ڿ��� ��� ���ڷθ� �̷���� �ִ��� Ȯ���ϴ� �޼ҵ� isNumber
	public static boolean isNumber(String str){
		if (str==null || str==""){
			return false;
		}
		for (int i=0;i<str.length();i++ ){
			if('0'>=str.charAt(i)||'9'<=str.charAt(i)){
				return false;
			}
		}
		return true;
	}

		//6-20 ���ñ���� �޼ҵ�
	public static int[] shuffle(int[] arr){
		if (arr==null ||arr.length==0){
			return arr;
		} else {
			for (int i=0;arr.length>i;i++ ){
				int tmp;
				int rand = (int)(Math.random()*(arr.length));
				tmp = arr[i];
				arr[i]=arr[rand];
				arr[rand] = tmp ;
			}
			return arr;
		}
	}
	//6-6 �� ���� �Ÿ��� ����ϴ� getDistance() ex) �� ��(x,y)�� (x1,y1)���� �Ÿ� (���� �� ����)
	public static double getDistance(int x, int y, int x1, int y1){
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
}

//6-1 ī���� ����(1~10), ���� ���� �� ���� SutdaCard Ŭ���� ����

class SutdaCard{
	int num1;
	boolean isKwang;
	SutdaCard(){
		num1 = 1;
		isKwang = true;
	}
	SutdaCard(int n, boolean k){
		num1 = n;
		isKwang = k;
	}
	public String info() {
		if (isKwang){
			return num1+"K";
		} else {
			return num1+"";
		}
	}
}

//6-3 StudentŬ����(�������: �л��̸�, ��, ��ȣ, ��������, ��������, ��������)

class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
//6-4 �޼ҵ� getTotal (����, ����, ���������� ��� ���� ��ȯ), getAverage(������ ������� ���� ����� ����, �Ҽ� ��°�ڸ����� �ݿø�)
	public int getTotal(){
		return kor+eng+math;
	}
	public float getAverage(){
		return (int)((kor+eng+math)/3f*10+0.5f)/10f;
	}
//6-5 �߰�
	public Student(String n1, int b1, int n2, int k1, int e1, int m1){
		name = n1;
		ban = b1;
		no = n2;
		kor = k1;
		eng = e1;
		math = m1;		
	}
	public String info(){
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}
}

//6-7 : 6-6�� getDistance()�� MyPointŬ������ �ν��Ͻ��޼���� �����Ͻÿ�
class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}

	double getDistance(int x1, int y1){
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
}

//tvŬ������ �־��� ������� �ϼ��Ͻÿ�.
class MyTv{
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff(){
		//(1) isPowerOn�� ���� true�� false��, false�� true�� �ٲ۴�.
		isPowerOn = !isPowerOn;
	}
	void volumeUp(){
		// (2) volume�� ���� MAX_VOLUME���� ���� ���� ���� 1 ������Ų��.
		if (volume<MAX_VOLUME){
			volume+=1;
		}
	}
	void volumeDown(){
		// (3) volume�� ���� MIN_VOLUME���� Ŭ ���� ���� 1 ���ҽ�Ų��.
		if (volume>MIN_VOLUME){
			volume-=1;
		}
	}
	void channelUp(){
		//(4) channel�� ���� 1 ������Ų��.
		// ���� channel�� MAX_CHANNEL�̸�, channel�� ���� MIN_CHANNEL�� �ٲ۴�.
		if (channel<MAX_CHANNEL){
			channel+=1;
		} else{
			channel = MIN_CHANNEL;
		}
	}
	void channelDown(){
		//(5) channel�� ���� 1 ���ҽ�Ų��.
		// ���� channel�� MIN_CHANNEL�̸�, channel�� ���� MAX_CHANNEL�� �ٲ۴�.
		if (channel>MIN_CHANNEL){
			channel-=1;
		} else{
			channel = MAX_CHANNEL;
		}
	}
}


