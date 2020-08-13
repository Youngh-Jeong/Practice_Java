import java.util.*;

class MahjongPractice_backup4{
	public static void main(String[] args) {
		

		while (true){//���ѷ��� : �ݵ�� �������� ������ �־�� ��
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. ��Ȧ�� ���п���(25ȸ)");
			System.out.println("2. ������ ���� Ȯ��");
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
					while (mountain.count <= 136 && isNotTenpai){
						isNotTenpai = me.drawDiscard();	// ���⸮
						me.showhand();
						if (!isNotTenpai){
							System.out.println("���");
							System.out.println(ListHandler.showList(me.tenpaiHead));
							System.out.println(ListHandler.showList(me.tenpaiBody1));
							System.out.println(ListHandler.showList(me.tenpaiBody2));
							System.out.println(ListHandler.showList(me.tenpaiBody3));
							System.out.println(ListHandler.showList(me.tenpaiBody4));
						}
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
		ArrayList<Integer> numberLine = new ArrayList<>();
		numberLine.add(number); numberLine.add(tile1.getNumber()); numberLine.add(tile2.getNumber());
		Collections.sort(numberLine);
		return (numberLine.get(0)+1 == numberLine.get(1))&&(numberLine.get(1)+1 == numberLine.get(2))&&isSameColor;
		
	}
	public boolean isBody(Tile tile1, Tile tile2) {
		return is3Pair(tile1, tile2)||isStraight(tile1, tile2);
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
	ArrayList<Tile> discards = new ArrayList<>(); // ������
	boolean tenpai = false; // ������ ����
	ArrayList<Tile> tenpaiHead = null;
	ArrayList<Tile> tenpaiBody1 = null;
	ArrayList<Tile> tenpaiBody2 = null;
	ArrayList<Tile> tenpaiBody3 = null;
	ArrayList<Tile> tenpaiBody4 = null;
	
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
		for (int i=0;i<discards.size() ;i++ ){
			handstr += ("[" + discards.get(i).show() + "] ");
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
		discards.add(tmp);
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

	public ArrayList<Tile> sortColor(ArrayList<Tile> hand){
		for (int i = 0;i < hand.size() ;i++ ){
			for (int j = i+1;j<hand.size() ;j++ ){
				if ((hand.get(i)).getNumber()>(hand.get(j)).getNumber()){
					Tile tmp = hand.get(i);
					hand.set(i, hand.get(j));
					hand.set(j, tmp);
				}
			}
		}
		return hand;
	}

	public int isStraingtInTmp(ArrayList<Tile> tmp, int i){ // isBasicForm�� ���¿��� i��° �а� ���갡 �ִ��� �˻� (true�� i, j, j+1�� Ŀ��, false�� j=-1)
		if (tmp.size()<3){ return -1; }
		for (int j = i+1;j<tmp.size()-1 ; j++){
			if ((tmp.get(i)).isStraight(tmp.get(j), tmp.get(j+1))){
				return j;
			}
		}
		return -1;
	}

	public boolean is3PairInTmp(ArrayList<Tile> tmp, int i){ // isBasicForm�� ���¿��� i��° �а� Ŀ�갡 �ִ��� �˻� (true�� i, i+1, i+2rk Ŀ��)
		if (i+2>=tmp.size()){ return false;} // ���� Ÿ���� 3���̸�
		if (tmp.size()<3){return false;} // ���� Ÿ���� 3�� �̸�
		if ((tmp.get(i)).is3Pair(tmp.get(i+1), tmp.get(i+2))){
			return true;
		}
		return false;
	}


	public boolean isBasicForm() {
		ArrayList<Tile> tong = new ArrayList<>();
		ArrayList<Tile> man = new ArrayList<>();
		ArrayList<Tile> sak = new ArrayList<>();
		ArrayList<Tile> za = new ArrayList<>();
		ArrayList<Tile> head = new ArrayList<>();
		ArrayList<Tile> body1 = new ArrayList<>();
		ArrayList<Tile> body2 = new ArrayList<>();
		ArrayList<Tile> body3 = new ArrayList<>();
		ArrayList<Tile> body4 = new ArrayList<>();
		
		boolean hasHead = false;
		boolean isTenpai = false;

		// �� �� �з�
		for (int i = 0;i < hand.length ;i++ ){
			switch (hand[i].getColor())	{
			case 0: man.add(hand[i]); break;
			case 1: sak.add(hand[i]); break;
			case 2: tong.add(hand[i]); break;
			case 3: za.add(hand[i]); break;
			default: System.out.println("������Ȯ�� ���� ���� - ���Ǻ�");
			}
		}
		// ������ ������ �������� Ȯ�� (0 or 2 mod 3)
		int manMod = man.size()%3;	int sakMod = sak.size()%3;	int tongMod = tong.size()%3;	int zaMod = za.size()%3;

		if (manMod==1||sakMod==1||tongMod==1||zaMod==1||(manMod*sakMod*tongMod*zaMod)%3==1){ // ������ ���� : 8 2 2 2 �Ǵ� 5 5 2 2 ����
			return false;
		}


		man = sortColor(man); // ����
		sak = sortColor(sak);
		tong = sortColor(tong);
		za = sortColor(za);
		int bodyCount = 0;

		//���� üũ (����-Ŀ��-if�Ӹ�)
		ArrayList<Tile> tmpMan = man; //�ӽ�ī��
		//Ȯ�� ������ �ӽð����� ���
		ArrayList<Tile> tmpHead = new ArrayList<>();
		ArrayList<Tile> tmpBody1 = new ArrayList<>();
		ArrayList<Tile> tmpBody2 = new ArrayList<>();
		ArrayList<Tile> tmpBody3 = new ArrayList<>();
		ArrayList<Tile> tmpBody4 = new ArrayList<>();

		int tmpCount1 = 0; // �����Ǵܿ�
		while (!tmpMan.isEmpty()){ // �� ã�Ƽ� ���������¸� ������ �� ����
			int k = 0; // ù��° Ÿ���� ������� ��. ������ ���´� 1) ������� 2) ����� ���� 3) Ŀ��� ���� 4) �Ӹ��� ����  ���� �ʿ���µ� �ϴٺ��� ������
			int t = isStraingtInTmp(tmpMan, k);//�������� Ȯ��
			if (t!=-1){ // ���갡 �Ǹ�, 2)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: tmpBody1.add(tmpMan.remove(t+1)); tmpBody1.add(tmpMan.remove(t));tmpBody1.add(tmpMan.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpMan.remove(t+1)); tmpBody2.add(tmpMan.remove(t));tmpBody2.add(tmpMan.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpMan.remove(t+1)); tmpBody3.add(tmpMan.remove(t));tmpBody3.add(tmpMan.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: body4.add(tmpMan.remove(t+1)); body4.add(tmpMan.remove(t));body4.add(tmpMan.remove(k)); body4 = sortColor(body4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (is3PairInTmp(tmpMan,k)){ // Ŀ�갡 �Ǹ�, 3)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: tmpBody1.add(tmpMan.remove(k+2)); tmpBody1.add(tmpMan.remove(k+1));tmpBody1.add(tmpMan.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpMan.remove(k+2)); tmpBody2.add(tmpMan.remove(k+1));tmpBody2.add(tmpMan.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpMan.remove(k+2)); tmpBody3.add(tmpMan.remove(k+1));tmpBody3.add(tmpMan.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpMan.remove(k+2)); tmpBody4.add(tmpMan.remove(k+1));tmpBody4.add(tmpMan.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (tmpMan.size()%3==0)	{return false;} // ���븸 �ִ� ������ ���뿡 ������ �ȵǸ� �ϼ��� �ȵ� ���̴�.
			if (tmpMan.size()%3==2){ // �� ��Ҵ� ������ �ȵǴµ� �Ӹ��� ���� �ִٸ�
				if (hasHead = true){ // �Ӹ��� �ִµ� ����� �Ѿ���� ������ (üũ��)
					System.out.println("���� - �Ӹ��� 2���� ���̽��� ����(����)");
					return false;
				}
					
				if ((tmpMan.get(k)).isHead(tmpMan.get(k+1))){// ����ĭ�� �Ӹ��� (���������� ����ĭ�̿��ߵ�) 4)���̽�
					tmpHead.add(tmpMan.remove(k+1)); tmpHead.add(tmpMan.remove(k));tmpHead=sortColor(tmpHead); // �Ӹ��� �ű�
					hasHead = true; // �Ӹ� ����üũ
					continue; // ���ư� (�Ӹ��� ã����. ���ѷ����̸� ���Ⱑ �������ɼ�)
				} else {// �Ӹ��� �ƴϸ�, 1)�̹Ƿ� 
					return false; // ����
				}
			}
			// 1�� �и� �������� ���� ��, k++ ��� ����

			tmpCount1++; //��� ���Ҵ��� ��

			if (tmpCount1 == (man.size()/3)+1){  // �� �� �ִ� �ִ븸ŭ ���Ҵٸ�, k=0���� ��ŸƮ�� ���� ������ ���̴�.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp�� �����ϱ�
				tmpCount1 = 0;// tmpCount1=0
				k++;// k++ (�����ڸ����� �˰����� ������)
			}
			if (k>man.size()-2){//������ k�� ���� �������Ҵٸ�
				return false;
			}
		} //������ 0���� �Ǹ� Ż����
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp�� ������ Ȯ��


		int tmpCount2 = 0; // ����׿�
		ArrayList<Tile> tmpSak = sak; //�ӽ�ī��
		while (!tmpSak.isEmpty()){ // �� ã�Ƽ� ���������¸� ������ �� ����
			int k = 0; // ù��° Ÿ���� ������� ��. ������ ���´� 1) ������� 2) ����� ���� 3) Ŀ��� ���� 4) �Ӹ��� ����  ���� �ʿ���µ� �ϴٺ��� ������
			int t = isStraingtInTmp(tmpSak, k);//�������� Ȯ��
			if (t!=-1){ // ���갡 �Ǹ�, 2)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: tmpBody1.add(tmpSak.remove(t+1)); tmpBody1.add(tmpSak.remove(t));tmpBody1.add(tmpSak.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpSak.remove(t+1)); tmpBody2.add(tmpSak.remove(t));tmpBody2.add(tmpSak.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpSak.remove(t+1)); tmpBody3.add(tmpSak.remove(t));tmpBody3.add(tmpSak.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpSak.remove(t+1)); tmpBody4.add(tmpSak.remove(t));tmpBody4.add(tmpSak.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (is3PairInTmp(tmpSak,k)){ // Ŀ�갡 �Ǹ�, 3)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: tmpBody1.add(tmpSak.remove(k+2)); tmpBody1.add(tmpSak.remove(k+1));tmpBody1.add(tmpSak.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpSak.remove(k+2)); tmpBody2.add(tmpSak.remove(k+1));tmpBody2.add(tmpSak.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpSak.remove(k+2)); tmpBody3.add(tmpSak.remove(k+1));tmpBody3.add(tmpSak.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpSak.remove(k+2)); tmpBody4.add(tmpSak.remove(k+1));tmpBody4.add(tmpSak.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (tmpSak.size()%3==0)	{return false;} // ���븸 �ִ� ������ ���뿡 ������ �ȵǸ� �ϼ��� �ȵ� ���̴�.
			if (tmpSak.size()%3==2){ // �� ��Ҵ� ������ �ȵǴµ� �Ӹ��� ���� �ִٸ�
				if (hasHead = true){ // �Ӹ��� �ִµ� ����� �Ѿ���� ������ (üũ��)
					System.out.println("���� - �Ӹ��� 2���� ���̽��� ����(���)");
					return false;
				}
					
				if ((tmpSak.get(k)).isHead(tmpSak.get(k+1))){// ����ĭ�� �Ӹ��� (���������� ����ĭ�̿��ߵ�) 4)���̽�
					tmpHead.add(tmpSak.remove(k+1)); tmpHead.add(tmpSak.remove(k));tmpHead=sortColor(tmpHead); // �Ӹ��� �ű�
					hasHead = true; // �Ӹ� ����üũ
					continue; // ���ư� (�Ӹ��� ã����. ���ѷ����̸� ���Ⱑ �������ɼ�)
				} else {// �Ӹ��� �ƴϸ�, 1)�̹Ƿ� 
					return false; // ����
				}
			}
			tmpCount2++;
			if (tmpCount2 == (sak.size()/3)+1){  // �� �� �ִ� �ִ븸ŭ ���Ҵٸ�, k=0���� ��ŸƮ�� ���� ������ ���̴�.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp�� �����ϱ�
				tmpCount2 = 0;// tmpCount2=0
				k++;// k++ (�����ڸ����� �˰����� ������)
			}
			if (k>sak.size()-2){//������ k�� ���� �������Ҵٸ�
				return false;
			}
		} //����� 0���� �Ǹ� Ż����
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp�� ������ Ȯ��
		


		int tmpCount3 = 0; // ����׿�
		ArrayList<Tile> tmpTong = tong; //�ӽ�ī��
		while (!tmpTong.isEmpty()){ // �� ã�Ƽ� ���������¸� ������ �� ����
			int k = 0; // ù��° Ÿ���� ������� ��. ������ ���´� 1) ������� 2) ����� ���� 3) Ŀ��� ���� 4) �Ӹ��� ����  ���� �ʿ���µ� �ϴٺ��� ������
			int t = isStraingtInTmp(tmpTong, k);//�������� Ȯ��
			if (t!=-1){ // ���갡 �Ǹ�, 2)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: tmpBody1.add(tmpTong.remove(t+1)); tmpBody1.add(tmpTong.remove(t));tmpBody1.add(tmpTong.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpTong.remove(t+1)); tmpBody2.add(tmpTong.remove(t));tmpBody2.add(tmpTong.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpTong.remove(t+1)); tmpBody3.add(tmpTong.remove(t));tmpBody3.add(tmpTong.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpTong.remove(t+1)); tmpBody4.add(tmpTong.remove(t));tmpBody4.add(tmpTong.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (is3PairInTmp(tmpTong,k)){ // Ŀ�갡 �Ǹ�, 3)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: tmpBody1.add(tmpTong.remove(k+2)); tmpBody1.add(tmpTong.remove(k+1));tmpBody1.add(tmpTong.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpTong.remove(k+2)); tmpBody2.add(tmpTong.remove(k+1));tmpBody2.add(tmpTong.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpTong.remove(k+2)); tmpBody3.add(tmpTong.remove(k+1));tmpBody3.add(tmpTong.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpTong.remove(k+2)); tmpBody4.add(tmpTong.remove(k+1));tmpBody4.add(tmpTong.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (tmpTong.size()%3==0)	{return false;} // ���븸 �ִ� ������ ���뿡 ������ �ȵǸ� �ϼ��� �ȵ� ���̴�.
			if (tmpTong.size()%3==2){ // �� ��Ҵ� ������ �ȵǴµ� �Ӹ��� ���� �ִٸ�
				if (hasHead = true){ // �Ӹ��� �ִµ� ����� �Ѿ���� ������ (üũ��)
					System.out.println("���� - �Ӹ��� 2���� ���̽��� ����");
					return false;
				}
					
				if ((tmpTong.get(k)).isHead(tmpTong.get(k+1))){// ����ĭ�� �Ӹ��� (���������� ����ĭ�̿��ߵ�) 4)���̽�
					tmpHead.add(tmpTong.remove(k+1)); tmpHead.add(tmpTong.remove(k));tmpHead=sortColor(tmpHead); // �Ӹ��� �ű�
					hasHead = true; // �Ӹ� ����üũ
					continue; // ���ư� (�Ӹ��� ã����. ���ѷ����̸� ���Ⱑ �������ɼ�)
				} else {// �Ӹ��� �ƴϸ�, 1)�̹Ƿ� 
					return false; // ����
				}
			}
			tmpCount3++;
			if (tmpCount3 == (tong.size()/3)+1){  // �� �� �ִ� �ִ븸ŭ ���Ҵٸ�, k=0���� ��ŸƮ�� ���� ������ ���̴�.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp�� �����ϱ�
				tmpCount3 = 0;// tmpCount3=0
				k++;// k++ (�����ڸ����� �˰����� ������)
			}
			if (k>tong.size()-2){//������ k�� ���� �������Ҵٸ�
				return false;
			}
		} //����� 0���� �Ǹ� Ż����
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp�� ������ Ȯ��





		int tmpCount4 = 0; 
		ArrayList<Tile> tmpZa = za; //�ӽ�ī��
		while (!tmpZa.isEmpty()){ // �� ã�Ƽ� ���������¸� ������ �� ����
			int k = 0; // ù��° Ÿ���� ������� ��. ������ ���´� 1) ������� 3) Ŀ��� ���� 4) �Ӹ��� ����  ���� �ʿ���µ� �ϴٺ��� ������
			if (is3PairInTmp(tmpZa,k)){ // Ŀ�갡 �Ǹ�, 3)���̽�
				switch (bodyCount){ // ������� ���� ������ �°� �ְ� ���� �� ����
				case 0: body1.add(tmpZa.remove(k+2)); body1.add(tmpZa.remove(k+1));body1.add(tmpZa.remove(k)); body1 = sortColor(body1); bodyCount++;continue;
				case 1: body2.add(tmpZa.remove(k+2)); body2.add(tmpZa.remove(k+1));body2.add(tmpZa.remove(k)); body2 = sortColor(body2); bodyCount++;continue;
				case 2: body3.add(tmpZa.remove(k+2)); body3.add(tmpZa.remove(k+1));body3.add(tmpZa.remove(k)); body3 = sortColor(body3); bodyCount++;continue;
				case 3: body4.add(tmpZa.remove(k+2)); body4.add(tmpZa.remove(k+1));body4.add(tmpZa.remove(k)); body4 = sortColor(body4); bodyCount++;continue;
				default : System.out.println("���� - ���� ������ 4���̻�");
				}
			}
			if (tmpZa.size()%3==2){ // �� ��Ҵ� ������ �ȵǴµ� �Ӹ��� ���� �ִٸ�
				if (hasHead = true){ // �Ӹ��� �ִµ� ����� �Ѿ���� ������ (üũ��)
					System.out.println("���� - �Ӹ��� 2���� ���̽��� ����");
					return false;
				}
					
				if ((tmpZa.get(k)).isHead(tmpZa.get(k+1))){// ����ĭ�� �Ӹ��� (���������� ����ĭ�̿��ߵ�) 4)���̽�
					tmpHead.add(tmpZa.remove(k+1)); tmpHead.add(tmpZa.remove(k));tmpHead=sortColor(tmpHead); // �Ӹ��� �ű�
					hasHead = true; // �Ӹ� ����üũ
					continue; // ���ư� (�Ӹ��� ã����. ���ѷ����̸� ���Ⱑ �������ɼ�)
				} else {// �Ӹ��� �ƴϸ�, 1)�̹Ƿ� 
					return false; // ����
				}
			}
			tmpCount4++;
			if (tmpCount4 == (za.size()/3)+1){  // �� �� �ִ� �ִ븸ŭ ���Ҵٸ�, k=0���� ��ŸƮ�� ���� ������ ���̴�.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp�� �����ϱ�
				tmpCount4 = 0;// tmpCount4=0
				k++;// k++ (�����ڸ����� �˰����� ������)
			}
			if (k>za.size()-2){//������ k�� ���� �������Ҵٸ�
				return false;
			}
		} //���а� 0���� �Ǹ� Ż����
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp�� ������ Ȯ��

		tenpaiHead = head;
		tenpaiBody1 = body1;
		tenpaiBody2 = body2;
		tenpaiBody3 = body3;
		tenpaiBody4 = body4;

		return true;








	}
}

class ListHandler{
	static String showList(ArrayList<Tile> list){
		String str = "";
		for (int i = 0;i<list.size() ;i++ ){
			str = str + " " + (list.get(i)).show();
		}
		return str;
	}
}


