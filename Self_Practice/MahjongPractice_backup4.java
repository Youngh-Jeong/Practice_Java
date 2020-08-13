import java.util.*;

class MahjongPractice_backup4{
	public static void main(String[] args) {
		

		while (true){//무한루프 : 반드시 빠져나올 조건이 있어야 함
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 나홀로 조패연습(25회)");
			System.out.println("2. 텐파이 로직 확인");
			System.out.println("9. 프로그램 종료");
			System.out.print("선택 >> ");
			TilePile mountain = new TilePile(); //패산 생성
			Player me = new Player(0, mountain);

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1:
				mountain.shuffle();	 // 패산 세팅
				me.firsthand();  // 배패 받음
				System.out.println("나의 배패"); me.showhand(); // 배패 보여줌
				try	{
					boolean isNotTenpai = true;
					while (mountain.count <= 136 && isNotTenpai){
						isNotTenpai = me.drawDiscard();	// 쯔모기리
						me.showhand();
						if (!isNotTenpai){
							System.out.println("쯔모");
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
					} // 반복
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("-끝-");
					e.printStackTrace();
					
					break;
				}
				
				break;

			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				//메소드 강제 종료로 현재는 main()메소드이므로 프로그램이 종료됨
			}

		}
	}
}

class TilePile{

	Tile[] pile = new Tile[136]; // 패산
	int count = 0; // 다음 패
	boolean canDraw = true;

	int[][] pilecode = new int[136][3]; // 패산 순서 거쳐갈 데이터셋

	public TilePile(){ // 마작패 배열 생성
		for (int i = 0;i<27;i++){// 마작패 수패 입력
			pilecode[i][0] = i/9; //색
			pilecode[i][1] =((i)%9) +1; //수 
		}
		for (int i = 27;i<34;i++){// 마작패 자패 입력
			pilecode[i][0] = 3;
			pilecode[i][1] =i - 17; //자패종류
		}
		
		for (int i=0;i<pilecode.length ;i++){// 패 * 4
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
	public void shuffle(){ // 섞음
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
			System.out.println("패산이 남아있지 않습니다.");
			return null;
		}
		count++;
		return pile[count-1];
	}
}


class Tile {
	private int color; // 색(0: 만 1: 삭 2: 통 3: 자 99: 빈칸)
	private int number; // 수(1~9, 10~16:동남서북백발중)
	private int ith; //4개 중 어느건지 구별 (아카는 3, 일단 미구현)
	public Tile(int color, int number, int ith){
		this.color = color;
		this.number = number;
		this.ith = ith;
	}
	public String show(){//한글로 보여줌
		String num;
		String col;
		if (color != 99){
			switch (number){
			case 10: num = "동"; break;
			case 11: num = "남"; break;
			case 12: num = "서"; break;
			case 13: num = "북"; break;
			case 14: num = "백"; break;
			case 15: num = "발"; break;
			case 16: num = "중"; break;
			default: num = number + "";
			}
		
			switch (color){
			case 0: col = "만"; break;
			case 1: col = "삭"; break;
			case 2: col = "통"; break;
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
	TilePile mountain; // 패산
	int wind; // 내 바람 (0~3)
	int point; // 점봉
	Tile[] hand = new Tile[14]; // 손
	Tile empty = new Tile(99,99,99);
	ArrayList<Tile> discards = new ArrayList<>(); // 버림패
	boolean tenpai = false; // 텐파이 여부
	ArrayList<Tile> tenpaiHead = null;
	ArrayList<Tile> tenpaiBody1 = null;
	ArrayList<Tile> tenpaiBody2 = null;
	ArrayList<Tile> tenpaiBody3 = null;
	ArrayList<Tile> tenpaiBody4 = null;
	
	public Player(int wind, TilePile mountain){ // 현재 패산(게임)에서 몇번째)
		if (!(wind>=0&&wind<4))	{
			System.out.println("자풍 설정 오류 (유효값: 0~3)");
			return;
		}
		this.wind = wind;
		this.mountain = mountain;
		point = 25000;
		for (int i = 0;i<hand.length ;i++ )	{
			hand[i] = null;
		}
	}

	public void firsthand(){ // 배패  ***어떻게 만들어진 인스턴스 접근?
		for (int i = 0;i<13 ;i++ ){
			hand[i] = mountain.draw();
		}
		hand[13] = empty;
		arrange();
	}

	public void arrange(){ // 보기좋게 정렬 (만/삭/통/자패, 수는 오름차순)  ***13일때, 14일 때 처리
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

	public void showhand(){ // 패를 보여줌
		String handstr = "";
		for (int i=13;i>-1 ;i-- ){
			handstr += ("[" + hand[i].show() + "] ");
		}
		System.out.println(handstr);
	}

	public void showDiscard(){ // 버림패를 보여줌
		String handstr = "";
		System.out.print("버림패 : ");
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
			System.out.print("기리할 패를 고르세요 (1~14, 0: 정렬 15: 버림패 보기) : "); 
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
		Tile tsumo = mountain.draw(); //쯔모 임시 저장
		System.out.println("쯔모 : " + tsumo.show());
		hand[0] = tsumo; // 쯔모를 손으로 가져옴
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

	public int isStraingtInTmp(ArrayList<Tile> tmp, int i){ // isBasicForm의 형태에서 i번째 패가 슌쯔가 있는지 검사 (true면 i, j, j+1이 커쯔, false면 j=-1)
		if (tmp.size()<3){ return -1; }
		for (int j = i+1;j<tmp.size()-1 ; j++){
			if ((tmp.get(i)).isStraight(tmp.get(j), tmp.get(j+1))){
				return j;
			}
		}
		return -1;
	}

	public boolean is3PairInTmp(ArrayList<Tile> tmp, int i){ // isBasicForm의 형태에서 i번째 패가 커쯔가 있는지 검사 (true면 i, i+1, i+2rk 커쯔)
		if (i+2>=tmp.size()){ return false;} // 비교할 타일이 3개미만
		if (tmp.size()<3){return false;} // 남은 타일이 3개 미만
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

		// 색 별 분류
		for (int i = 0;i < hand.length ;i++ ){
			switch (hand[i].getColor())	{
			case 0: man.add(hand[i]); break;
			case 1: sak.add(hand[i]); break;
			case 2: tong.add(hand[i]); break;
			case 3: za.add(hand[i]); break;
			default: System.out.println("텐파이확인 로직 오류 - 색판별");
			}
		}
		// 개수로 가능한 형태인지 확인 (0 or 2 mod 3)
		int manMod = man.size()%3;	int sakMod = sak.size()%3;	int tongMod = tong.size()%3;	int zaMod = za.size()%3;

		if (manMod==1||sakMod==1||tongMod==1||zaMod==1||(manMod*sakMod*tongMod*zaMod)%3==1){ // 마지막 조건 : 8 2 2 2 또는 5 5 2 2 제외
			return false;
		}


		man = sortColor(man); // 정렬
		sak = sortColor(sak);
		tong = sortColor(tong);
		za = sortColor(za);
		int bodyCount = 0;

		//만수 체크 (슌쯔-커쯔-if머리)
		ArrayList<Tile> tmpMan = man; //임시카피
		//확정 전까진 임시값으로 사용
		ArrayList<Tile> tmpHead = new ArrayList<>();
		ArrayList<Tile> tmpBody1 = new ArrayList<>();
		ArrayList<Tile> tmpBody2 = new ArrayList<>();
		ArrayList<Tile> tmpBody3 = new ArrayList<>();
		ArrayList<Tile> tmpBody4 = new ArrayList<>();

		int tmpCount1 = 0; // 실패판단용
		while (!tmpMan.isEmpty()){ // 다 찾아서 텐파이형태를 만족할 때 까지
			int k = 0; // 첫번째 타일을 대상으로 함. 가능한 상태는 1) 쓸모없음 2) 슌쯔로 사용됨 3) 커쯔로 사용됨 4) 머리로 사용됨  딱히 필요없는데 하다보니 셋팅함
			int t = isStraingtInTmp(tmpMan, k);//슌쯔인지 확인
			if (t!=-1){ // 슌쯔가 되면, 2)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: tmpBody1.add(tmpMan.remove(t+1)); tmpBody1.add(tmpMan.remove(t));tmpBody1.add(tmpMan.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpMan.remove(t+1)); tmpBody2.add(tmpMan.remove(t));tmpBody2.add(tmpMan.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpMan.remove(t+1)); tmpBody3.add(tmpMan.remove(t));tmpBody3.add(tmpMan.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: body4.add(tmpMan.remove(t+1)); body4.add(tmpMan.remove(t));body4.add(tmpMan.remove(k)); body4 = sortColor(body4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (is3PairInTmp(tmpMan,k)){ // 커쯔가 되면, 3)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: tmpBody1.add(tmpMan.remove(k+2)); tmpBody1.add(tmpMan.remove(k+1));tmpBody1.add(tmpMan.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpMan.remove(k+2)); tmpBody2.add(tmpMan.remove(k+1));tmpBody2.add(tmpMan.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpMan.remove(k+2)); tmpBody3.add(tmpMan.remove(k+1));tmpBody3.add(tmpMan.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpMan.remove(k+2)); tmpBody4.add(tmpMan.remove(k+1));tmpBody4.add(tmpMan.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (tmpMan.size()%3==0)	{return false;} // 몸통만 있는 색에서 몸통에 포함이 안되면 완성이 안된 것이다.
			if (tmpMan.size()%3==2){ // 그 요소는 몸통은 안되는데 머리일 수도 있다면
				if (hasHead = true){ // 머리가 있는데 여기로 넘어오면 오류임 (체크용)
					System.out.println("오류 - 머리가 2개인 케이스가 나옴(만수)");
					return false;
				}
					
				if ((tmpMan.get(k)).isHead(tmpMan.get(k+1))){// 다음칸이 머리면 (정렬했으니 다음칸이여야됨) 4)케이스
					tmpHead.add(tmpMan.remove(k+1)); tmpHead.add(tmpMan.remove(k));tmpHead=sortColor(tmpHead); // 머리로 옮김
					hasHead = true; // 머리 있음체크
					continue; // 돌아감 (머리를 찾았음. 무한루프이면 여기가 오류가능성)
				} else {// 머리도 아니면, 1)이므로 
					return false; // 실패
				}
			}
			// 1번 패를 기준으로 삼을 때, k++ 사용 여부

			tmpCount1++; //몇번 돌았는지 셈

			if (tmpCount1 == (man.size()/3)+1){  // 돌 수 있는 최대만큼 돌았다면, k=0에서 스타트한 것은 실패한 것이다.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp값 복원하기
				tmpCount1 = 0;// tmpCount1=0
				k++;// k++ (다음자리부터 알고리즘을 시작함)
			}
			if (k>man.size()-2){//가능한 k를 전부 돌려보았다면
				return false;
			}
		} //만수가 0개가 되면 탈출함
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp을 몸으로 확정


		int tmpCount2 = 0; // 디버그용
		ArrayList<Tile> tmpSak = sak; //임시카피
		while (!tmpSak.isEmpty()){ // 다 찾아서 텐파이형태를 만족할 때 까지
			int k = 0; // 첫번째 타일을 대상으로 함. 가능한 상태는 1) 쓸모없음 2) 슌쯔로 사용됨 3) 커쯔로 사용됨 4) 머리로 사용됨  딱히 필요없는데 하다보니 셋팅함
			int t = isStraingtInTmp(tmpSak, k);//슌쯔인지 확인
			if (t!=-1){ // 슌쯔가 되면, 2)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: tmpBody1.add(tmpSak.remove(t+1)); tmpBody1.add(tmpSak.remove(t));tmpBody1.add(tmpSak.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpSak.remove(t+1)); tmpBody2.add(tmpSak.remove(t));tmpBody2.add(tmpSak.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpSak.remove(t+1)); tmpBody3.add(tmpSak.remove(t));tmpBody3.add(tmpSak.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpSak.remove(t+1)); tmpBody4.add(tmpSak.remove(t));tmpBody4.add(tmpSak.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (is3PairInTmp(tmpSak,k)){ // 커쯔가 되면, 3)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: tmpBody1.add(tmpSak.remove(k+2)); tmpBody1.add(tmpSak.remove(k+1));tmpBody1.add(tmpSak.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpSak.remove(k+2)); tmpBody2.add(tmpSak.remove(k+1));tmpBody2.add(tmpSak.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpSak.remove(k+2)); tmpBody3.add(tmpSak.remove(k+1));tmpBody3.add(tmpSak.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpSak.remove(k+2)); tmpBody4.add(tmpSak.remove(k+1));tmpBody4.add(tmpSak.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (tmpSak.size()%3==0)	{return false;} // 몸통만 있는 색에서 몸통에 포함이 안되면 완성이 안된 것이다.
			if (tmpSak.size()%3==2){ // 그 요소는 몸통은 안되는데 머리일 수도 있다면
				if (hasHead = true){ // 머리가 있는데 여기로 넘어오면 오류임 (체크용)
					System.out.println("오류 - 머리가 2개인 케이스가 나옴(삭수)");
					return false;
				}
					
				if ((tmpSak.get(k)).isHead(tmpSak.get(k+1))){// 다음칸이 머리면 (정렬했으니 다음칸이여야됨) 4)케이스
					tmpHead.add(tmpSak.remove(k+1)); tmpHead.add(tmpSak.remove(k));tmpHead=sortColor(tmpHead); // 머리로 옮김
					hasHead = true; // 머리 있음체크
					continue; // 돌아감 (머리를 찾았음. 무한루프이면 여기가 오류가능성)
				} else {// 머리도 아니면, 1)이므로 
					return false; // 실패
				}
			}
			tmpCount2++;
			if (tmpCount2 == (sak.size()/3)+1){  // 돌 수 있는 최대만큼 돌았다면, k=0에서 스타트한 것은 실패한 것이다.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp값 복원하기
				tmpCount2 = 0;// tmpCount2=0
				k++;// k++ (다음자리부터 알고리즘을 시작함)
			}
			if (k>sak.size()-2){//가능한 k를 전부 돌려보았다면
				return false;
			}
		} //삭수가 0개가 되면 탈출함
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp을 몸으로 확정
		


		int tmpCount3 = 0; // 디버그용
		ArrayList<Tile> tmpTong = tong; //임시카피
		while (!tmpTong.isEmpty()){ // 다 찾아서 텐파이형태를 만족할 때 까지
			int k = 0; // 첫번째 타일을 대상으로 함. 가능한 상태는 1) 쓸모없음 2) 슌쯔로 사용됨 3) 커쯔로 사용됨 4) 머리로 사용됨  딱히 필요없는데 하다보니 셋팅함
			int t = isStraingtInTmp(tmpTong, k);//슌쯔인지 확인
			if (t!=-1){ // 슌쯔가 되면, 2)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: tmpBody1.add(tmpTong.remove(t+1)); tmpBody1.add(tmpTong.remove(t));tmpBody1.add(tmpTong.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpTong.remove(t+1)); tmpBody2.add(tmpTong.remove(t));tmpBody2.add(tmpTong.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpTong.remove(t+1)); tmpBody3.add(tmpTong.remove(t));tmpBody3.add(tmpTong.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpTong.remove(t+1)); tmpBody4.add(tmpTong.remove(t));tmpBody4.add(tmpTong.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (is3PairInTmp(tmpTong,k)){ // 커쯔가 되면, 3)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: tmpBody1.add(tmpTong.remove(k+2)); tmpBody1.add(tmpTong.remove(k+1));tmpBody1.add(tmpTong.remove(k)); tmpBody1 = sortColor(tmpBody1); bodyCount++;continue;
				case 1: tmpBody2.add(tmpTong.remove(k+2)); tmpBody2.add(tmpTong.remove(k+1));tmpBody2.add(tmpTong.remove(k)); tmpBody2 = sortColor(tmpBody2); bodyCount++;continue;
				case 2: tmpBody3.add(tmpTong.remove(k+2)); tmpBody3.add(tmpTong.remove(k+1));tmpBody3.add(tmpTong.remove(k)); tmpBody3 = sortColor(tmpBody3); bodyCount++;continue;
				case 3: tmpBody4.add(tmpTong.remove(k+2)); tmpBody4.add(tmpTong.remove(k+1));tmpBody4.add(tmpTong.remove(k)); tmpBody4 = sortColor(tmpBody4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (tmpTong.size()%3==0)	{return false;} // 몸통만 있는 색에서 몸통에 포함이 안되면 완성이 안된 것이다.
			if (tmpTong.size()%3==2){ // 그 요소는 몸통은 안되는데 머리일 수도 있다면
				if (hasHead = true){ // 머리가 있는데 여기로 넘어오면 오류임 (체크용)
					System.out.println("오류 - 머리가 2개인 케이스가 나옴");
					return false;
				}
					
				if ((tmpTong.get(k)).isHead(tmpTong.get(k+1))){// 다음칸이 머리면 (정렬했으니 다음칸이여야됨) 4)케이스
					tmpHead.add(tmpTong.remove(k+1)); tmpHead.add(tmpTong.remove(k));tmpHead=sortColor(tmpHead); // 머리로 옮김
					hasHead = true; // 머리 있음체크
					continue; // 돌아감 (머리를 찾았음. 무한루프이면 여기가 오류가능성)
				} else {// 머리도 아니면, 1)이므로 
					return false; // 실패
				}
			}
			tmpCount3++;
			if (tmpCount3 == (tong.size()/3)+1){  // 돌 수 있는 최대만큼 돌았다면, k=0에서 스타트한 것은 실패한 것이다.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp값 복원하기
				tmpCount3 = 0;// tmpCount3=0
				k++;// k++ (다음자리부터 알고리즘을 시작함)
			}
			if (k>tong.size()-2){//가능한 k를 전부 돌려보았다면
				return false;
			}
		} //삭수가 0개가 되면 탈출함
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp을 몸으로 확정





		int tmpCount4 = 0; 
		ArrayList<Tile> tmpZa = za; //임시카피
		while (!tmpZa.isEmpty()){ // 다 찾아서 텐파이형태를 만족할 때 까지
			int k = 0; // 첫번째 타일을 대상으로 함. 가능한 상태는 1) 쓸모없음 3) 커쯔로 사용됨 4) 머리로 사용됨  딱히 필요없는데 하다보니 셋팅함
			if (is3PairInTmp(tmpZa,k)){ // 커쯔가 되면, 3)케이스
				switch (bodyCount){ // 만들어진 몸통 개수에 맞게 넣고 정렬 후 지움
				case 0: body1.add(tmpZa.remove(k+2)); body1.add(tmpZa.remove(k+1));body1.add(tmpZa.remove(k)); body1 = sortColor(body1); bodyCount++;continue;
				case 1: body2.add(tmpZa.remove(k+2)); body2.add(tmpZa.remove(k+1));body2.add(tmpZa.remove(k)); body2 = sortColor(body2); bodyCount++;continue;
				case 2: body3.add(tmpZa.remove(k+2)); body3.add(tmpZa.remove(k+1));body3.add(tmpZa.remove(k)); body3 = sortColor(body3); bodyCount++;continue;
				case 3: body4.add(tmpZa.remove(k+2)); body4.add(tmpZa.remove(k+1));body4.add(tmpZa.remove(k)); body4 = sortColor(body4); bodyCount++;continue;
				default : System.out.println("오류 - 몸통 개수가 4개이상");
				}
			}
			if (tmpZa.size()%3==2){ // 그 요소는 몸통은 안되는데 머리일 수도 있다면
				if (hasHead = true){ // 머리가 있는데 여기로 넘어오면 오류임 (체크용)
					System.out.println("오류 - 머리가 2개인 케이스가 나옴");
					return false;
				}
					
				if ((tmpZa.get(k)).isHead(tmpZa.get(k+1))){// 다음칸이 머리면 (정렬했으니 다음칸이여야됨) 4)케이스
					tmpHead.add(tmpZa.remove(k+1)); tmpHead.add(tmpZa.remove(k));tmpHead=sortColor(tmpHead); // 머리로 옮김
					hasHead = true; // 머리 있음체크
					continue; // 돌아감 (머리를 찾았음. 무한루프이면 여기가 오류가능성)
				} else {// 머리도 아니면, 1)이므로 
					return false; // 실패
				}
			}
			tmpCount4++;
			if (tmpCount4 == (za.size()/3)+1){  // 돌 수 있는 최대만큼 돌았다면, k=0에서 스타트한 것은 실패한 것이다.
				tmpHead = head;		tmpBody1 = body1;	tmpBody2 = body2;	tmpBody3 = body3;	tmpBody4 = body4;// tmp값 복원하기
				tmpCount4 = 0;// tmpCount4=0
				k++;// k++ (다음자리부터 알고리즘을 시작함)
			}
			if (k>za.size()-2){//가능한 k를 전부 돌려보았다면
				return false;
			}
		} //자패가 0개가 되면 탈출함
		head = tmpHead;		body1 = tmpBody1;	body2 = tmpBody2;	body3 = tmpBody3;	body4 = tmpBody4;// tmp을 몸으로 확정

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


