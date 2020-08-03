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
