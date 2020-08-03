class Exercise7{
	public static void main(String[] args){
		/*7-14를 위해 주석처리
		//7-1 확인
		SutdaDeck deck = new SutdaDeck();

		for (int i=0;i<deck.cards.length ; i++){
			System.out.print(deck.cards[i]+",");
		}


		//7-2 확인
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
		//7-14확인

		SutdaCard card = new SutdaCard(1,true);

		//7-10 확인
		MyTv2 t = new MyTv2();

		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());
		
		//7-11 확인
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}
}

//7-1 : 섯다 20장의 배열 초기화
//7-14 : 섯다카드의 숫자와 종류는 변경되면 안되는 값이다. 이를 반영하여 수정하시오 (1번을 위해 이름은 안바꿈)

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
	// 7-2 : 다음의 메서드를 추가하시오
	// 1. shuffle : 위치를 뒤섞음 2.pick : 지정된 위치의 SutdaCard 반환 3. pick : 임의의 위치의 SutdaCard반환 (Math.random() 사용)

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

//7-10 : MyTv2클래스의 멤버변수를 클래스 외부에서 접근할 수 없도록 하고 getter와 setter를 추가하라.

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
			System.out.println("유효한 채널이 아닙니다.");
			return;
		}
		this.prevch = this.channel; //7-11을 위해 추가
		this.channel = channel;
	}
	public void setVolume(int vol){
		if (vol<0||vol>100){
			System.out.println("유효한 볼륨이 아닙니다.");
			return;
		}
		volume = vol;
	}
	public boolean getIsPowerOn(){return isPowerOn;}
	public int getChannel(){return channel;}
	public int getVolume(){return volume;}

	//7-11 : 이전 채널로 이동하는 메서드를 추가하라 (이전 채널의 값을 저장할 멤버변수를 정의하라)\
	
	public void gotoPrevChannel(){
		setChannel(prevch);
	}

}
