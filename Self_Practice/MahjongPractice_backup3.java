import java.util.*;

class MahjongPractice{
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

		if (manMod==1||sakMod==1||tongMod==1||zaMod==1||(manMod*sakMod*tongMod*zaMod)%3==1){
			return false;
		}

		/*int headColor;

		if (manMod==2)	{headColor = 0;}
		if (sakMod==2)	{headColor = 1;}
		if (tongMod==2)	{headColor = 2;}
		if (zaMod==2)	{headColor = 3;}*/
		man = sortColor(man);
		sak = sortColor(sak);
		tong = sortColor(tong);
		za = sortColor(za);
		int bodyCount = 0;

		ArrayList<Tile> tmpMan = man; // ���� üũ (�������)
		System.out.println("tmpMan : " + tmpMan.size());
		while (!tmpMan.isEmpty()){
			if (tmpMan.size()==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderMan1: 
				for (int i = 0; i<tmpMan.size();i++){ 
					for (int j = i+1; j<tmpMan.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpMan.get(i)).isHead(tmpMan.get(j))){ // i, j�� �Ӹ���
						head.add(tmpMan.get(i));	head.add(tmpMan.get(j)); //head�� �߰�
						tmpMan.remove(i); tmpMan.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						System.out.println("�Ӹ��� ������ ����");
						break headfinderMan1; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					tmpMan = man;
					bodyCount=0;
					break;
				}
			} else{

				// 3�ǹ�� ������ ���� ã��
				if (tmpMan.isEmpty()){ // 0���̸� Ż��
					break;
				}
				boolean existBody = false;
				bodyfinderMan1:
				for (int i = 0;i<tmpMan.size() ;i++ ){
					for (int j = i+1;j<tmpMan.size() ;j++){
						for (int k = j+1;k<tmpMan.size() ;k++){ //���� �� �� 3���� ���ؼ�
							if ((tmpMan.get(i)).isBody(tmpMan.get(j), tmpMan.get(k))){ // ������ ���������
								switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
								case 0: body1.add(tmpMan.get(i)); body1.add(tmpMan.get(j)); body1.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								case 1: body2.add(tmpMan.get(i)); body2.add(tmpMan.get(j)); body2.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								case 2: body3.add(tmpMan.get(i)); body3.add(tmpMan.get(j)); body3.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								case 3: body4.add(tmpMan.get(i)); body4.add(tmpMan.get(j)); body4.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								default: System.out.println("����: ����-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderMan1;
							}
						}
					}
				}
				System.out.println("existBody : " + existBody);
				if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
				System.out.println("existBody ���� return");
				return false;
				}
			}
		}

		System.out.println("tmpMan : " + tmpMan.size());
		// ���� Ȯ�� ���� ������ �˻� (�Ӹ�����)
		while (!tmpMan.isEmpty()){
			if (tmpMan.size()%3==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderMan2: 
				for (int i = 0; i<tmpMan.size();i++){ 
					for (int j = i+1; j<tmpMan.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpMan.get(i)).isHead(tmpMan.get(j))){ // i, j�� �Ӹ���
						head.add(tmpMan.get(i));	head.add(tmpMan.get(j)); //head�� �߰�
						tmpMan.remove(i); tmpMan.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						System.out.println("�Ӹ��� ������ ����");
						break headfinderMan2; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					System.out.println("existHead ���� return");
					return false;
				}
			} 

			// 3�ǹ�� ������ ���� ã��
			if (tmpMan.isEmpty()){ // 0���̸� Ż��
				break;
			}
			boolean existBody = false;
			bodyfinderMan2:
			for (int i = 0;i<tmpMan.size() ;i++ ){
				for (int j = i+1;j<tmpMan.size() ;j++){
					for (int k = j+1;k<tmpMan.size() ;k++){ //���� �� �� 3���� ���ؼ�
						if ((tmpMan.get(i)).isBody(tmpMan.get(j), tmpMan.get(k))){ // ������ ���������
							switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
							case 0: body1.add(tmpMan.get(i)); body1.add(tmpMan.get(j)); body1.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							case 1: body2.add(tmpMan.get(i)); body2.add(tmpMan.get(j)); body2.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							case 2: body3.add(tmpMan.get(i)); body3.add(tmpMan.get(j)); body3.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							case 3: body4.add(tmpMan.get(i)); body4.add(tmpMan.get(j)); body4.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							default: System.out.println("����: ����-bodyCount");
							}
							bodyCount++;
							existBody = true;
							break bodyfinderMan2;
						}
					}
				}
			}
			if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
				System.out.println("2��° existBody ���� return");
			return false;
			}
			
		}

		System.out.println("tmpMan : " + tmpMan.size());
		System.out.println("head : " + head.size());

		int tmpBody = bodyCount;
		ArrayList<Tile> tmpSak = sak; // ��� üũ
		System.out.println("tmpSak : " + tmpSak.size());
		while (!tmpSak.isEmpty()){
			if (tmpSak.size()==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderSak1: 
				for (int i = 0; i<tmpSak.size();i++){ 
					for (int j = i+1; j<tmpSak.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpSak.get(i)).isHead(tmpSak.get(j))){ // i, j�� �Ӹ���
						head.add(tmpSak.get(i));	head.add(tmpSak.get(j)); //head�� �߰�
						tmpSak.remove(i); tmpSak.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						break headfinderSak1; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					tmpSak = sak;
					bodyCount=tmpBody;
					break;
				}
			} else{
				// 3�ǹ�� ������ ���� ã��
				if (tmpSak.isEmpty()){ // 0���̸� Ż��
					break;
				}
				boolean existBody = false;
				bodyfinderSak1:
				for (int i = 0;i<tmpSak.size() ;i++ ){
					for (int j = i+1;j<tmpSak.size() ;j++){
						for (int k = j+1;k<tmpSak.size() ;k++){ //���� �� �� 3���� ���ؼ�
							if ((tmpSak.get(i)).isBody(tmpSak.get(j), tmpSak.get(k))){ // ������ ���������
								switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
								case 0: body1.add(tmpSak.get(i)); body1.add(tmpSak.get(j)); body1.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								case 1: body2.add(tmpSak.get(i)); body2.add(tmpSak.get(j)); body2.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								case 2: body3.add(tmpSak.get(i)); body3.add(tmpSak.get(j)); body3.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								case 3: body4.add(tmpSak.get(i)); body4.add(tmpSak.get(j)); body4.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								default: System.out.println("����: ����-bodyCount");
								}
								bodyCount++;
								existBody = true;
								System.out.println("�Ӹ��� ����� ����");
								break bodyfinderSak1;
							}
						}
					}
				}
				if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
					return false;
				}
			}
		}
		// �Ӹ�����
		System.out.println("tmpSak : " + tmpSak.size());
		while (!tmpSak.isEmpty()){
			if (tmpSak.size()%3==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderSak2: 
				for (int i = 0; i<tmpSak.size();i++){ 
					for (int j = i+1; j<tmpSak.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpSak.get(i)).isHead(tmpSak.get(j))){ // i, j�� �Ӹ���
						head.add(tmpSak.get(i));	head.add(tmpSak.get(j)); //head�� �߰�
						tmpSak.remove(i); tmpSak.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						break headfinderSak2; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					return false;
				}
			} 
			// 3�ǹ�� ������ ���� ã��
			if (tmpSak.isEmpty()){ // 0���̸� Ż��
				break;
			}
			boolean existBody = false;
			bodyfinderSak2:
			for (int i = 0;i<tmpSak.size() ;i++ ){
				for (int j = i+1;j<tmpSak.size() ;j++){
					for (int k = j+1;k<tmpSak.size() ;k++){ //���� �� �� 3���� ���ؼ�
						if ((tmpSak.get(i)).isBody(tmpSak.get(j), tmpSak.get(k))){ // ������ ���������
							switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
							case 0: body1.add(tmpSak.get(i)); body1.add(tmpSak.get(j)); body1.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							case 1: body2.add(tmpSak.get(i)); body2.add(tmpSak.get(j)); body2.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							case 2: body3.add(tmpSak.get(i)); body3.add(tmpSak.get(j)); body3.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							case 3: body4.add(tmpSak.get(i)); body4.add(tmpSak.get(j)); body4.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							default: System.out.println("����: ����-bodyCount");
							}
							bodyCount++;
							existBody = true;
							System.out.println("�Ӹ��� ����� ����");
							break bodyfinderSak2;
						}
					}
				}
			}
			if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
				return false;
			}
		
		}


		tmpBody = bodyCount;
		ArrayList<Tile> tmpTong = tong; // ��� üũ
		while (!tmpTong.isEmpty()){
			System.out.println("tmpTong.get(i) : " + (tmpTong.get(0)).show());
			if (tmpTong.size()==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderTong1: 
				for (int i = 0; i<tmpTong.size();i++){ 
					for (int j = i+1; j<tmpTong.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpTong.get(i)).isHead(tmpTong.get(j))){ // i, j�� �Ӹ���
						head.add(tmpTong.get(i));	head.add(tmpTong.get(j)); //head�� �߰�
						tmpTong.remove(i); tmpTong.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						System.out.println("�Ӹ��� ����� ����");
						break headfinderTong1; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					tmpTong = tong;
					bodyCount=tmpBody;
					break;
				}
			} else {
				// 3�ǹ�� ������ ���� ã��
				if (tmpTong.isEmpty()){ // 0���̸� Ż��
					break;
				}
				boolean existBody = false;
				bodyfinderTong1:
				for (int i = 0;i<tmpTong.size() ;i++ ){
					for (int j = i+1;j<tmpTong.size() ;j++){
						for (int k = j+1;k<tmpTong.size() ;k++){ //���� �� �� 3���� ���ؼ�
							if ((tmpTong.get(i)).isBody(tmpTong.get(j), tmpTong.get(k))){ // ������ ���������
								switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
								case 0: body1.add(tmpTong.get(i)); body1.add(tmpTong.get(j)); body1.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								case 1: body2.add(tmpTong.get(i)); body2.add(tmpTong.get(j)); body2.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								case 2: body3.add(tmpTong.get(i)); body3.add(tmpTong.get(j)); body3.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								case 3: body4.add(tmpTong.get(i)); body4.add(tmpTong.get(j)); body4.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								default: System.out.println("����: ����-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderTong1;
							}
						}
					}
				}
				if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
					return false;
				}
			}
		}

		while (!tmpTong.isEmpty()){
			System.out.println("tmpTong.get(i) : " + (tmpTong.get(0)).show());
			if (tmpTong.size()%3==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderTong2: 
				for (int i = 0; i<tmpTong.size();i++){ 
					for (int j = i+1; j<tmpTong.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpTong.get(i)).isHead(tmpTong.get(j))){ // i, j�� �Ӹ���
						head.add(tmpTong.get(i));	head.add(tmpTong.get(j)); //head�� �߰�
						tmpTong.remove(i); tmpTong.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						System.out.println("�Ӹ��� ����� ����");
						break headfinderTong2; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					return false;
				}
			} 
			// 3�ǹ�� ������ ���� ã��
			if (tmpTong.isEmpty()){ // 0���̸� Ż��
				break;
			}
			boolean existBody = false;
			bodyfinderTong1:
			for (int i = 0;i<tmpTong.size() ;i++ ){
				for (int j = i+1;j<tmpTong.size() ;j++){
					for (int k = j+1;k<tmpTong.size() ;k++){ //���� �� �� 3���� ���ؼ�
						if ((tmpTong.get(i)).isBody(tmpTong.get(j), tmpTong.get(k))){ // ������ ���������
							switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
							case 0: body1.add(tmpTong.get(i)); body1.add(tmpTong.get(j)); body1.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							case 1: body2.add(tmpTong.get(i)); body2.add(tmpTong.get(j)); body2.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							case 2: body3.add(tmpTong.get(i)); body3.add(tmpTong.get(j)); body3.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							case 3: body4.add(tmpTong.get(i)); body4.add(tmpTong.get(j)); body4.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							default: System.out.println("����: ����-bodyCount");
							}
							bodyCount++;
							existBody = true;
							break bodyfinderTong1;
						}
					}
				}
			}
			if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
				return false;
			}
		
		}



		tmpBody = bodyCount;
		ArrayList<Tile> tmpZa = za; // ���� üũ
		while (!tmpZa.isEmpty()){
			if (tmpZa.size()==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderZa1: 
				for (int i = 0; i<tmpZa.size();i++){ 
					for (int j = i+1; j<tmpZa.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpZa.get(i)).isHead(tmpZa.get(j))){ // i, j�� �Ӹ���
						head.add(tmpZa.get(i));	head.add(tmpZa.get(j)); //head�� �߰�
						tmpZa.remove(i); tmpZa.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						System.out.println("�Ӹ��� ���п� ����");
						break headfinderZa1; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					tmpZa = za;
					bodyCount=tmpBody;
					break;
				}
			} else{
			// 3�ǹ�� ������ ���� ã��
				if (tmpZa.isEmpty()){ // 0���̸� Ż��
					break;
				}
				boolean existBody = false;
				bodyfinderZa1:
				for (int i = 0;i<tmpZa.size() ;i++ ){
					for (int j = i+1;j<tmpZa.size() ;j++){
						for (int k = j+1;k<tmpZa.size() ;k++){ //���� �� �� 3���� ���ؼ�
							if ((tmpZa.get(i)).isBody(tmpZa.get(j), tmpZa.get(k))){ // ������ ���������
								switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
								case 0: body1.add(tmpZa.get(i)); body1.add(tmpZa.get(j)); body1.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 1: body2.add(tmpZa.get(i)); body2.add(tmpZa.get(j)); body2.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 2: body3.add(tmpZa.get(i)); body3.add(tmpZa.get(j)); body3.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 3: body4.add(tmpZa.get(i)); body4.add(tmpZa.get(j)); body4.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								default: System.out.println("����: ����-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderZa1;
							}
						}
					}
				}
				if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
					return false;
				}
			}
		}

		while (!tmpZa.isEmpty()){
			if (tmpZa.size()%3==2){ // �Ӹ��� �ִ� ���̸�
				boolean existHead = false; // �Ӹ��� ã�Ҵ��� üũ
				headfinderZa1: 
				for (int i = 0; i<tmpZa.size();i++){ 
					for (int j = i+1; j<tmpZa.size() ;j++ ){ // 1�־� ���ϱ� ���� ����for��
						if ((tmpZa.get(i)).isHead(tmpZa.get(j))){ // i, j�� �Ӹ���
						head.add(tmpZa.get(i));	head.add(tmpZa.get(j)); //head�� �߰�
						tmpZa.remove(i); tmpZa.remove(j-1); //tmp���� ����
						existHead = true; // �Ӹ� ã��
						System.out.println("�Ӹ��� ���п� ����");
						break headfinderZa1; // Ż��
						}
					}
				}
				if (!existHead)	{ // ���� ã���� ��,  �Ӹ��� ã�� �������� false
					return false;
				}
			} 
			// 3�ǹ�� ������ ���� ã��
				if (tmpZa.isEmpty()){ // 0���̸� Ż��
					break;
				}
				boolean existBody = false;
				bodyfinderZa1:
				for (int i = 0;i<tmpZa.size() ;i++ ){
					for (int j = i+1;j<tmpZa.size() ;j++){
						for (int k = j+1;k<tmpZa.size() ;k++){ //���� �� �� 3���� ���ؼ�
							if ((tmpZa.get(i)).isBody(tmpZa.get(j), tmpZa.get(k))){ // ������ ���������
								switch (bodyCount){ // ������ ����� ���� body�� �߰��ϰ� tmp���� ����
								case 0: body1.add(tmpZa.get(i)); body1.add(tmpZa.get(j)); body1.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 1: body2.add(tmpZa.get(i)); body2.add(tmpZa.get(j)); body2.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 2: body3.add(tmpZa.get(i)); body3.add(tmpZa.get(j)); body3.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 3: body4.add(tmpZa.get(i)); body4.add(tmpZa.get(j)); body4.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								default: System.out.println("����: ����-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderZa1;
							}
						}
					}
				}
				if (!existBody){ // ���� ã���� ��, ������ ã�� �������� false
					return false;
				}
			}


		System.out.println("tmpZa : " + tmpZa.size());
		System.out.println("head : " + head.size());
		System.out.println("�Ӹ� : " + (head.get(0)).show() + (head.get(1)).show());
		System.out.println("����1 : " + (body1.get(0)).show() + (body1.get(1)).show() + (body1.get(2)).show());
		System.out.println("����2 : " + (body2.get(0)).show() + (body2.get(1)).show() + (body2.get(2)).show());
		System.out.println("����3 : " + (body3.get(0)).show() + (body3.get(1)).show() + (body3.get(2)).show());
		System.out.println("����4 : " + (body4.get(0)).show() + (body4.get(1)).show() + (body4.get(2)).show());
		return true;
	}
	/*
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
		
	}*/

}


