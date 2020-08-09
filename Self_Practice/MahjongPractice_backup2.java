import java.util.*;

class MahjongPractice_backup2{
	public static void main(String[] args) {
		

		while (true){//���ѷ��� : �ݵ�� �������� ������ �־�� ��
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. ��Ȧ�� ���п���(25ȸ)");
			System.out.println("2. ������ ��������");
			System.out.println("9. ���α׷� ����");
			System.out.print("���� >> ");
			TilePile mountain = new TilePile(); //�л� ����
			Player me = new Player(0, mountain);

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1:
				mountain.shuffle();	 // �л� ����
				me.firsthand();  // ���� ����
				System.out.println("���� ����"); me.showhand(); // ���� ������
				try	{
					boolean isNotTenpai = true;
					while (mountain.count <= 136 || isNotTenpai){
						isNotTenpai = me.drawDiscard();	// ���⸮
						me.showhand();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
					} // �ݺ�
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("-��-");
					e.printStackTrace();
					
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
	public boolean isHead(Tile tile) {
		boolean isSameColor = (tile.getColor() == color);
		boolean isSameNumber = (tile.getNumber()==number);
		return (isSameColor&&isSameNumber);
	}
	public boolean is3Pair(Tile tile1, Tile tile2) {
		return (isHead(tile1)&&isHead(tile2));
	}
	public boolean isStraight(Tile tile1, Tile tile2) {
		boolean isSameColor = (color == tile1.getColor())&&(color == tile2.getColor())&&(color!=3);
		int[] numberLine = new int[3];
		numberLine[0]=number; numberLine[1]=tile1.getNumber(); numberLine[2]=tile2.getNumber();
		for (int i = 0;i<numberLine.length;i++) { //������� ����
			for (int j = i+1; j<numberLine.length;j++) {
				if (numberLine[i]>numberLine[j]) {
					int tmp = numberLine[i];
					numberLine[i] = numberLine[j];
					numberLine[j] = tmp;
				}
			}
		}
		return (numberLine[0]+1 == numberLine[1])&&(numberLine[1]+1 == numberLine[2])&&isSameColor;
		
	}
	public boolean isBody(Tile tile1, Tile tile2) {
		return is3Pair(tile1, tile2)&&isStraight(tile1, tile2);
	}
	public boolean isSameTile(Tile tile1) {
		return (number == tile1.getNumber())&&(color == tile1.getColor())&&(ith == tile1.getOrder());
	}
}

class Player{
	TilePile mountain; // �л�
	int wind; // �� �ٶ� (0~3)
	int point; // ����
	Tile[] hand = new Tile[14]; // ��
	Tile empty = new Tile(99,99,99);
	Tile[] discards = new Tile[250]; // ������
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

	public boolean drawDiscard(){
		draw();	arrange(); showhand(); 
		if (isBasicForm()) {
			return false;
		} else {		
		discard(); arrange();
		return true;
		}
	}

	public Tile[] removeTile(Tile[] nowhand, Tile tile1, Tile tile2, Tile tile3) {
		Tile[] newhand = new Tile[nowhand.length-3];
		int count = 0;
		for (int i=0;i<nowhand.length;i++) {
			if (nowhand[i].isSameTile(tile1)||nowhand[i].isSameTile(tile2)||nowhand[i].isSameTile(tile3)) {
				continue;
			}
			newhand[count] = nowhand[i];
		}
		return newhand;
	}
	public boolean isBasicForm() {
		int[][] headLine = new int[7][2];
		int headCount = 0;
		boolean isTenpai = false;
		Tile[] head = new Tile[2];
		Tile[] body1 = new Tile[3];
		Tile[] body2 = new Tile[3];
		Tile[] body3 = new Tile[3];
		Tile[] body4 = new Tile[3];
		
		// �Ӹ��˻�
		for (int i=0;i<hand.length;i++) {
			if(i!=0) {
				if (hand[i].isHead(hand[i-1])) {
				continue; //�̹� ����� ���̸� Ż�� (���ĵ� �� ����)
				}
			}
			for (int j=i+1;j<hand.length;j++) {
				if (hand[i].isHead(hand[j])) {
					headLine[headCount][0]=i;
					headLine[headCount][1]=j;
					headCount++;
					break; // i���� �Ӹ��� �Ǹ� �ٸ��� ����� �ʿ� ����
				} 
			}
		} // ������ head ��: headCount��
		
		if (headCount==7) { 
			return true; //ġ������
		}
		
		// ������ �� ����˻�
		arrange();
		for (int i=0;i<headCount;i++) {//������ �Ӹ�����
			//�Ӹ��� ������ ���� ����
			Tile[] bodyHand = new Tile[12];
			int countBh = 0;
			for (int j=0;j<hand.length;j++) {
				if (!(headLine[i][0]==j||headLine[i][1]==j)) {
					bodyHand[countBh] = hand[j];
					countBh++;
				}
			}// ������ ���� : bodyHand
			countBh=0;
			head[0] = hand[headLine[i][0]];
			head[1] = hand[headLine[i][1]]; // �Ӹ� Ȯ��
			boolean isBody1;
			for (int j=0;j<bodyHand.length;j++) {
				for (int k=j+1;k<bodyHand.length;k++) {
					for(int l=k+1;l<bodyHand.length;l++) {
						isBody1 = bodyHand[j].isBody(bodyHand[k], bodyHand[l]);
						if (isBody1) {//������ bodyHand ���� ����, �� üũ
							body1[0]=bodyHand[j]; body1[1]=bodyHand[k]; body1[2]=bodyHand[l];
							
							Tile[] bodyHand2 = removeTile(bodyHand, bodyHand[j], bodyHand[k], bodyHand[l]);
							// ������ ���� : bodyHand2
							boolean isBody2;
							for (int m=0;m<bodyHand2.length;m++) {
								for (int n=m+1;n<bodyHand2.length;n++) {
									for (int o=n+1; o<bodyHand2.length;o++) {
										isBody2 = bodyHand2[m].isBody(bodyHand2[n], bodyHand2[o]);
										if (isBody2) {
											body2[0]=bodyHand2[m]; body2[1]=bodyHand2[n]; body2[2]=bodyHand2[o]; //���� ����
											
											Tile[] bodyHand3 = removeTile(bodyHand2, bodyHand[m], bodyHand[n], bodyHand[o]);
											// ������ ���� : bodyHand3
											boolean isBody3;
											for (int p=0;p<bodyHand3.length;p++) {
												for (int q=p+1;q<bodyHand3.length;q++) {
													for (int r=q+1;r<bodyHand3.length;r++) {
														isBody3 = bodyHand3[p].isBody(bodyHand3[q], bodyHand3[r]);
														if (isBody3) {
															body3[0]=bodyHand3[p]; body3[1]=bodyHand3[q]; body3[2]=bodyHand3[r];
															Tile[] bodyHand4 = removeTile(bodyHand3, bodyHand3[p], bodyHand3[q], bodyHand3[r]);
															// ������ ���� : bodyHand4
															boolean isBody4;
															isBody4 = bodyHand4[0].isBody(bodyHand4[1], bodyHand[2]);
															if (isBody4) {
																body4[0]=bodyHand4[0]; body4[1]=bodyHand4[1]; body4[2]=bodyHand4[2];
																isTenpai = true;
																System.out.println("�Ӹ� : " + head[0].show() + head[1].show());
																System.out.println("����");
																System.out.println(body1[0].show() + body1[1].show() + body1[2].show());
																System.out.println(body2[0].show() + body2[1].show() + body2[2].show());
																System.out.println(body3[0].show() + body3[1].show() + body3[2].show());
																System.out.println(body4[0].show() + body4[1].show() + body4[2].show());
															}
														}
													}
												}
											}
											
										}
									}
								}
							}
						}
					}	
				}	
			}
		}
		return isTenpai;
		
	}

}


