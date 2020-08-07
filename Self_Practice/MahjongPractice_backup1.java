import java.util.*;

class MahjongPractice_backup1{
	public static void main(String[] args) {
		TilePile mountain = new TilePile(); //�л� ����
		Player me = new Player(0, mountain);

		while (true){//���ѷ��� : �ݵ�� �������� ������ �־�� ��
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. ��Ȧ�� ���п���(25ȸ)");
			System.out.println("2. ������ ��������");
			System.out.println("9. ���α׷� ����");
			System.out.print("���� >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1:
				mountain.shuffle();	 // �л� ����
				me.firsthand();  // ���� ����
				System.out.println("���� ����"); me.showhand(); // ���� ������
				try	{
					while (mountain.count <= 136){
						me.drawDiscard();	// ���⸮
						me.showhand();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
					} // �ݺ�
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("-��-");
					break;
				}
				
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
				//�޼ҵ� ���� ����� ����� main()�޼ҵ��̹Ƿ� ���α׷��� �����
			}

		}
	}
}

class TilePile{

	Tile[] pile = new Tile[136]; // �л�
	int count = 0; // ���� ��
	boolean canDraw = true;

	int[][] pilecode = new int[136][3]; // �л� ���� ���İ� �����ͼ�

	public TilePile(){ // ������ �迭 ����
		for (int i = 0;i<27;i++){// ������ ���� �Է�
			pilecode[i][0] = i/9; //��
			pilecode[i][1] =((i)%9) +1; //�� 
		}
		for (int i = 27;i<34;i++){// ������ ���� �Է�
			pilecode[i][0] = 3;
			pilecode[i][1] =i - 17; //��������
		}
		
		for (int i=0;i<pilecode.length ;i++){// �� * 4
			pilecode[i][2] = i/34;
			if (i>=34){
				pilecode[i][0] = pilecode[i%34][0];
				pilecode[i][1] = pilecode[i%34][1];
			}
		}
		for (int i = 0;i<pile.length ;i++ ){
			pile[i] = new Tile(pilecode[i][0], pilecode[i][1], pilecode[i][2]);
		}


	}
	public void shuffle(){ // ����
		for (int i = 0;i<pile.length ;i++){
			int rnd = (int)(Math.random()*pile.length);
			Tile tmp = pile[i];
			pile[i]=pile[rnd];
			pile[rnd]=tmp;
		}
		count = 0;
	}
	public Tile draw(){
		if (count>=pile.length)	{
			System.out.println("�л��� �������� �ʽ��ϴ�.");
			return null;
		}
		count++;
		return pile[count-1];
	}
}


class Tile {
	private int color; // ��(0: �� 1: �� 2: �� 3: �� 99: ��ĭ)
	private int number; // ��(1~9, 10~16:�������Ϲ����)
	private int ith; //4�� �� ������� ���� (��ī�� 3, �ϴ� �̱���)
	public Tile(int color, int number, int ith){
		this.color = color;
		this.number = number;
		this.ith = ith;
	}
	public String show(){//�ѱ۷� ������
		String num;
		String col;
		if (color != 99){
			switch (number){
			case 10: num = "��"; break;
			case 11: num = "��"; break;
			case 12: num = "��"; break;
			case 13: num = "��"; break;
			case 14: num = "��"; break;
			case 15: num = "��"; break;
			case 16: num = "��"; break;
			default: num = number + "";
			}
		
			switch (color){
			case 0: col = "��"; break;
			case 1: col = "��"; break;
			case 2: col = "��"; break;
			default: col = "";
			}

			return num + col;
		}
		return "";
	}
	public int getColor(){
		return color;
	}
	public int getNumber(){
		return number;
	}
	public int getOrder(){
		return ith;
	}
}

class Player{
	TilePile mountain; // �л�
	int wind; // �� �ٶ� (0~3)
	int point; // ����
	Tile[] hand = new Tile[14]; // ��
	Tile empty = new Tile(99,99,99);
	Tile[] discards = new Tile[25]; // ������
	int discardsCount = 0; // ������ ����
	boolean tenpai = false; // ������ ����
	
	public Player(int wind, TilePile mountain){ // ���� �л�(����)���� ���°)
		if (!(wind>=0&&wind<4))	{
			System.out.println("��ǳ ���� ���� (��ȿ��: 0~3)");
			return;
		}
		this.wind = wind;
		this.mountain = mountain;
		point = 25000;
		for (int i = 0;i<hand.length ;i++ )	{
			hand[i] = null;
		}
	}

	public void firsthand(){ // ����  ***��� ������� �ν��Ͻ� ����?
		for (int i = 0;i<13 ;i++ ){
			hand[i] = mountain.draw();
		}
		hand[13] = empty;
		arrange();
	}

	public void arrange(){ // �������� ���� (��/��/��/����, ���� ��������)  ***13�϶�, 14�� �� ó��
		boolean needshuffle = true;
		while (needshuffle){
			for (int i = 0;i < hand.length ;i++ ){
				for (int j = 0 ;j < i;j++ )	{
					if (hand[i].getColor()>hand[j].getColor()){
						Tile tmp = hand[i];
						hand[i] = hand[j];
						hand[j] = tmp;
						i = 0;
						break;
					} else if ((hand[i].getColor() == hand[j].getColor())&&(hand[i].getNumber()>hand[j].getNumber()))	{
						Tile tmp = hand[i];
						hand[i] = hand[j];
						hand[j] = tmp;
						i = 0;
						break;
					} 
				}

			}
			needshuffle = false;
		}
		
	}

	public void showhand(){ // �и� ������
		String handstr = "";
		for (int i=13;i>-1 ;i-- ){
			handstr += ("[" + hand[i].show() + "] ");
		}
		System.out.println(handstr);
	}

	public void showDiscard(){ // �����и� ������
		String handstr = "";
		System.out.print("������ : ");
		for (int i=0;i<discardsCount ;i++ ){
			handstr += ("[" + discards[i].show() + "] ");
		}
		System.out.println(handstr);
	}

	public void discard(){
		int giri = 99;
		Scanner sc2 = new Scanner(System.in);
		while (!(giri>0&&giri<15))
		{
			System.out.print("�⸮�� �и� ������ (1~14, 0: ���� 15: ������ ����) : "); 
			int input = Integer.valueOf(sc2.nextLine());
			switch (input)	{
			case 0: arrange(); showhand(); break;
			case 15: showDiscard(); break;
			default: giri = input;
			}
		}

		Tile tmp = hand[14-giri];
		hand[14-giri] = empty;
		discards[discardsCount] = tmp;
		discardsCount++;
	}
	
	public void draw(){
		Tile tsumo = mountain.draw(); //��� �ӽ� ����
		System.out.println("��� : " + tsumo.show());
		hand[0] = tsumo; // ��� ������ ������
	}

	public void drawDiscard(){
		draw();	showhand(); 		
		discard(); arrange();

	}

/*
	boolean basicForm(){
		Tile[] head = new Tile[2];
		Tile[] body1 = new Tile[3];
		Tile[] body2 = new Tile[3];
		Tile[] body3 = new Tile[3];
		Tile[] body4 = new Tile[3];
		int bodycount = 0;
		Tile[][] checkArr = {body1, body2, body3, body4};
		Tile[] handTest = new Tile[14];
		for (int i=0;i<handTest.length ;i++ ){
			handTest[i] = hand[i];
		}
		boolean trueHead = false;


		first: for (int i = 0;i<handTest.length ;i++ ){
			for (int j = i+1;j<handTest.length ;j++ ){
				if (handTest[j].getNumber()==handTest[i].getNumber()&&handTest[j].getColor()==handTest[i].getColor()){
					trueHead = true;
					head[0] = handTest[i]; head[1] = handTest[j];
					handTest[i] = empty;	handTest[j] = empty;
					testArrange(handTest);
					break first; 
				} 
			}
		}

		if (!tureHead){ return;}

		
		for (int i = 2;i<handTest.length ;i++ )	{
			if (handTest[i].getColor==handTest[i+1].getColor&&handTest[i+1].getColor==handTest[i+2].getColor&&handTest[i].getNumber==handTest[i+1].getNumber&&handTest[i+1].getNumber==handTest[i+2].getNumber){
				
			}
		}
	}

	public void testArrange(Tile[] handTest){ // �������� ���� (��/��/��/����, ���� ��������)  ***13�϶�, 14�� �� ó��
		boolean needshuffle = true;
		while (needshuffle){
			for (int i = 0;i < handTest.length ;i++ ){
				for (int j = 0 ;j < i;j++ )	{
					if (handTest[i].getColor()>handTest[j].getColor()){
						Tile tmp = handTest[i];
						handTest[i] = handTest[j];
						handTest[j] = tmp;
						i = 0;
						break;
					} else if ((handTest[i].getColor() == handTest[j].getColor())&&(handTest[i].getNumber()>handTest[j].getNumber()))	{
						Tile tmp = handTest[i];
						handTest[i] = handTest[j];
						handTest[j] = tmp;
						i = 0;
						break;
					} 
				}

			}
			needshuffle = false;
		}
		
	}
	*/

}


