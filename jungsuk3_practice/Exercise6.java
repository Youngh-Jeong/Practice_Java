class Exercise6{ //34p
	public static void main(String[] args) {

		//6-2 위 클래스에 두 개의 생성자와 info()를 추가해서 실행결과와 같은 결과를 얻는 코드 (3, 1K)
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();

		System.out.println(card1.info());
		System.out.println(card2.info());
		
		//6-5 홍길동,1,1,100,60,76,236,78.7이 출력되는 코드 (클래스에 생성자와 info()추가)

		Student s = new Student("홍길동",1,1,100,60,76);

		System.out.println(s.info());

		//6-6 확인
		System.out.println(getDistance(1,1,2,2));
		//6-7 p=(1,1)와 (2,2)사이의 거리 구한다		
		MyPoint p = new MyPoint(1,1);
		System.out.println(p.getDistance(2,2));
		//6-20 확인
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		//6-21 확인
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

		//6-22 확인
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));	
		
		//6-23 확인
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최댓값 : " + max(data));
		System.out.println("최댓값 : " + max(null));
		System.out.println("최댓값 : " + max(new int[] {}));

		int value = 5;
		System.out.println(value+"의 절대값:"+abs(value));
		value = -10;
		System.out.println(value+"의 절대값:"+abs(value));

	}

		//6-24 절대값 반환하는 메소드 abs
	public static int abs(int value){
		if (value < 0){
			return -value;
		}
		return value;
	}


		//6-23 주어진 int배열 값 중에서 가장 큰 값을 반환 (만일 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
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

		//6-22 주어진 문자열이 모두 숫자로만 이루어져 있는지 확인하는 메소드 isNumber
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

		//6-20 셔플기능의 메소드
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
	//6-6 두 점의 거리를 계산하는 getDistance() ex) 두 점(x,y)와 (x1,y1)간의 거리 (변수 이 순서)
	public static double getDistance(int x, int y, int x1, int y1){
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
}

//6-1 카드의 숫자(1~10), 광의 여부 를 갖는 SutdaCard 클래스 정의

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

//6-3 Student클래스(멤버변수: 학생이름, 반, 번호, 국어점수, 영어점수, 수학점수)

class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
//6-4 메소드 getTotal (국어, 영어, 수학점수를 모두 더해 반환), getAverage(총점을 과목수로 나눈 평균을 구함, 소수 둘째자리에서 반올림)
	public int getTotal(){
		return kor+eng+math;
	}
	public float getAverage(){
		return (int)((kor+eng+math)/3f*10+0.5f)/10f;
	}
//6-5 추가
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

//6-7 : 6-6의 getDistance()를 MyPoint클래스의 인스턴스메서드로 정의하시오
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

//tv클래스를 주어진 로직대로 완성하시오.
class MyTv{
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff(){
		//(1) isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
		isPowerOn = !isPowerOn;
	}
	void volumeUp(){
		// (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다.
		if (volume<MAX_VOLUME){
			volume+=1;
		}
	}
	void volumeDown(){
		// (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다.
		if (volume>MIN_VOLUME){
			volume-=1;
		}
	}
	void channelUp(){
		//(4) channel의 값을 1 증가시킨다.
		// 만일 channel이 MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다.
		if (channel<MAX_CHANNEL){
			channel+=1;
		} else{
			channel = MIN_CHANNEL;
		}
	}
	void channelDown(){
		//(5) channel의 값을 1 감소시킨다.
		// 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
		if (channel>MIN_CHANNEL){
			channel-=1;
		} else{
			channel = MAX_CHANNEL;
		}
	}
}


