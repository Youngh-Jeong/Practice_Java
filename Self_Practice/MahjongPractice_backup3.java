import java.util.*;

class MahjongPractice{
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

		ArrayList<Tile> tmpMan = man; // 만수 체크 (몸통먼저)
		System.out.println("tmpMan : " + tmpMan.size());
		while (!tmpMan.isEmpty()){
			if (tmpMan.size()==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderMan1: 
				for (int i = 0; i<tmpMan.size();i++){ 
					for (int j = i+1; j<tmpMan.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpMan.get(i)).isHead(tmpMan.get(j))){ // i, j가 머리면
						head.add(tmpMan.get(i));	head.add(tmpMan.get(j)); //head에 추가
						tmpMan.remove(i); tmpMan.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						System.out.println("머리가 만수에 있음");
						break headfinderMan1; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					tmpMan = man;
					bodyCount=0;
					break;
				}
			} else{

				// 3의배수 개에서 몸통 찾기
				if (tmpMan.isEmpty()){ // 0개이면 탈출
					break;
				}
				boolean existBody = false;
				bodyfinderMan1:
				for (int i = 0;i<tmpMan.size() ;i++ ){
					for (int j = i+1;j<tmpMan.size() ;j++){
						for (int k = j+1;k<tmpMan.size() ;k++){ //남은 것 중 3개를 비교해서
							if ((tmpMan.get(i)).isBody(tmpMan.get(j), tmpMan.get(k))){ // 몸통이 만들어지면
								switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
								case 0: body1.add(tmpMan.get(i)); body1.add(tmpMan.get(j)); body1.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								case 1: body2.add(tmpMan.get(i)); body2.add(tmpMan.get(j)); body2.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								case 2: body3.add(tmpMan.get(i)); body3.add(tmpMan.get(j)); body3.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								case 3: body4.add(tmpMan.get(i)); body4.add(tmpMan.get(j)); body4.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
								default: System.out.println("에러: 몸통-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderMan1;
							}
						}
					}
				}
				System.out.println("existBody : " + existBody);
				if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
				System.out.println("existBody 에서 return");
				return false;
				}
			}
		}

		System.out.println("tmpMan : " + tmpMan.size());
		// 예외 확인 위한 역으로 검사 (머리먼저)
		while (!tmpMan.isEmpty()){
			if (tmpMan.size()%3==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderMan2: 
				for (int i = 0; i<tmpMan.size();i++){ 
					for (int j = i+1; j<tmpMan.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpMan.get(i)).isHead(tmpMan.get(j))){ // i, j가 머리면
						head.add(tmpMan.get(i));	head.add(tmpMan.get(j)); //head에 추가
						tmpMan.remove(i); tmpMan.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						System.out.println("머리가 만수에 있음");
						break headfinderMan2; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					System.out.println("existHead 에서 return");
					return false;
				}
			} 

			// 3의배수 개에서 몸통 찾기
			if (tmpMan.isEmpty()){ // 0개이면 탈출
				break;
			}
			boolean existBody = false;
			bodyfinderMan2:
			for (int i = 0;i<tmpMan.size() ;i++ ){
				for (int j = i+1;j<tmpMan.size() ;j++){
					for (int k = j+1;k<tmpMan.size() ;k++){ //남은 것 중 3개를 비교해서
						if ((tmpMan.get(i)).isBody(tmpMan.get(j), tmpMan.get(k))){ // 몸통이 만들어지면
							switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
							case 0: body1.add(tmpMan.get(i)); body1.add(tmpMan.get(j)); body1.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							case 1: body2.add(tmpMan.get(i)); body2.add(tmpMan.get(j)); body2.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							case 2: body3.add(tmpMan.get(i)); body3.add(tmpMan.get(j)); body3.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							case 3: body4.add(tmpMan.get(i)); body4.add(tmpMan.get(j)); body4.add(tmpMan.get(k)); tmpMan.remove(i); tmpMan.remove(j-1); tmpMan.remove(k-2); break;
							default: System.out.println("에러: 몸통-bodyCount");
							}
							bodyCount++;
							existBody = true;
							break bodyfinderMan2;
						}
					}
				}
			}
			if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
				System.out.println("2번째 existBody 에서 return");
			return false;
			}
			
		}

		System.out.println("tmpMan : " + tmpMan.size());
		System.out.println("head : " + head.size());

		int tmpBody = bodyCount;
		ArrayList<Tile> tmpSak = sak; // 삭수 체크
		System.out.println("tmpSak : " + tmpSak.size());
		while (!tmpSak.isEmpty()){
			if (tmpSak.size()==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderSak1: 
				for (int i = 0; i<tmpSak.size();i++){ 
					for (int j = i+1; j<tmpSak.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpSak.get(i)).isHead(tmpSak.get(j))){ // i, j가 머리면
						head.add(tmpSak.get(i));	head.add(tmpSak.get(j)); //head에 추가
						tmpSak.remove(i); tmpSak.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						break headfinderSak1; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					tmpSak = sak;
					bodyCount=tmpBody;
					break;
				}
			} else{
				// 3의배수 개에서 몸통 찾기
				if (tmpSak.isEmpty()){ // 0개이면 탈출
					break;
				}
				boolean existBody = false;
				bodyfinderSak1:
				for (int i = 0;i<tmpSak.size() ;i++ ){
					for (int j = i+1;j<tmpSak.size() ;j++){
						for (int k = j+1;k<tmpSak.size() ;k++){ //남은 것 중 3개를 비교해서
							if ((tmpSak.get(i)).isBody(tmpSak.get(j), tmpSak.get(k))){ // 몸통이 만들어지면
								switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
								case 0: body1.add(tmpSak.get(i)); body1.add(tmpSak.get(j)); body1.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								case 1: body2.add(tmpSak.get(i)); body2.add(tmpSak.get(j)); body2.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								case 2: body3.add(tmpSak.get(i)); body3.add(tmpSak.get(j)); body3.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								case 3: body4.add(tmpSak.get(i)); body4.add(tmpSak.get(j)); body4.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
								default: System.out.println("에러: 몸통-bodyCount");
								}
								bodyCount++;
								existBody = true;
								System.out.println("머리가 삭수에 있음");
								break bodyfinderSak1;
							}
						}
					}
				}
				if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
					return false;
				}
			}
		}
		// 머리부터
		System.out.println("tmpSak : " + tmpSak.size());
		while (!tmpSak.isEmpty()){
			if (tmpSak.size()%3==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderSak2: 
				for (int i = 0; i<tmpSak.size();i++){ 
					for (int j = i+1; j<tmpSak.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpSak.get(i)).isHead(tmpSak.get(j))){ // i, j가 머리면
						head.add(tmpSak.get(i));	head.add(tmpSak.get(j)); //head에 추가
						tmpSak.remove(i); tmpSak.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						break headfinderSak2; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					return false;
				}
			} 
			// 3의배수 개에서 몸통 찾기
			if (tmpSak.isEmpty()){ // 0개이면 탈출
				break;
			}
			boolean existBody = false;
			bodyfinderSak2:
			for (int i = 0;i<tmpSak.size() ;i++ ){
				for (int j = i+1;j<tmpSak.size() ;j++){
					for (int k = j+1;k<tmpSak.size() ;k++){ //남은 것 중 3개를 비교해서
						if ((tmpSak.get(i)).isBody(tmpSak.get(j), tmpSak.get(k))){ // 몸통이 만들어지면
							switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
							case 0: body1.add(tmpSak.get(i)); body1.add(tmpSak.get(j)); body1.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							case 1: body2.add(tmpSak.get(i)); body2.add(tmpSak.get(j)); body2.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							case 2: body3.add(tmpSak.get(i)); body3.add(tmpSak.get(j)); body3.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							case 3: body4.add(tmpSak.get(i)); body4.add(tmpSak.get(j)); body4.add(tmpSak.get(k)); tmpSak.remove(i); tmpSak.remove(j-1); tmpSak.remove(k-2); break;
							default: System.out.println("에러: 몸통-bodyCount");
							}
							bodyCount++;
							existBody = true;
							System.out.println("머리가 삭수에 있음");
							break bodyfinderSak2;
						}
					}
				}
			}
			if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
				return false;
			}
		
		}


		tmpBody = bodyCount;
		ArrayList<Tile> tmpTong = tong; // 통수 체크
		while (!tmpTong.isEmpty()){
			System.out.println("tmpTong.get(i) : " + (tmpTong.get(0)).show());
			if (tmpTong.size()==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderTong1: 
				for (int i = 0; i<tmpTong.size();i++){ 
					for (int j = i+1; j<tmpTong.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpTong.get(i)).isHead(tmpTong.get(j))){ // i, j가 머리면
						head.add(tmpTong.get(i));	head.add(tmpTong.get(j)); //head에 추가
						tmpTong.remove(i); tmpTong.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						System.out.println("머리가 통수에 있음");
						break headfinderTong1; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					tmpTong = tong;
					bodyCount=tmpBody;
					break;
				}
			} else {
				// 3의배수 개에서 몸통 찾기
				if (tmpTong.isEmpty()){ // 0개이면 탈출
					break;
				}
				boolean existBody = false;
				bodyfinderTong1:
				for (int i = 0;i<tmpTong.size() ;i++ ){
					for (int j = i+1;j<tmpTong.size() ;j++){
						for (int k = j+1;k<tmpTong.size() ;k++){ //남은 것 중 3개를 비교해서
							if ((tmpTong.get(i)).isBody(tmpTong.get(j), tmpTong.get(k))){ // 몸통이 만들어지면
								switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
								case 0: body1.add(tmpTong.get(i)); body1.add(tmpTong.get(j)); body1.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								case 1: body2.add(tmpTong.get(i)); body2.add(tmpTong.get(j)); body2.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								case 2: body3.add(tmpTong.get(i)); body3.add(tmpTong.get(j)); body3.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								case 3: body4.add(tmpTong.get(i)); body4.add(tmpTong.get(j)); body4.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
								default: System.out.println("에러: 몸통-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderTong1;
							}
						}
					}
				}
				if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
					return false;
				}
			}
		}

		while (!tmpTong.isEmpty()){
			System.out.println("tmpTong.get(i) : " + (tmpTong.get(0)).show());
			if (tmpTong.size()%3==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderTong2: 
				for (int i = 0; i<tmpTong.size();i++){ 
					for (int j = i+1; j<tmpTong.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpTong.get(i)).isHead(tmpTong.get(j))){ // i, j가 머리면
						head.add(tmpTong.get(i));	head.add(tmpTong.get(j)); //head에 추가
						tmpTong.remove(i); tmpTong.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						System.out.println("머리가 통수에 있음");
						break headfinderTong2; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					return false;
				}
			} 
			// 3의배수 개에서 몸통 찾기
			if (tmpTong.isEmpty()){ // 0개이면 탈출
				break;
			}
			boolean existBody = false;
			bodyfinderTong1:
			for (int i = 0;i<tmpTong.size() ;i++ ){
				for (int j = i+1;j<tmpTong.size() ;j++){
					for (int k = j+1;k<tmpTong.size() ;k++){ //남은 것 중 3개를 비교해서
						if ((tmpTong.get(i)).isBody(tmpTong.get(j), tmpTong.get(k))){ // 몸통이 만들어지면
							switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
							case 0: body1.add(tmpTong.get(i)); body1.add(tmpTong.get(j)); body1.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							case 1: body2.add(tmpTong.get(i)); body2.add(tmpTong.get(j)); body2.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							case 2: body3.add(tmpTong.get(i)); body3.add(tmpTong.get(j)); body3.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							case 3: body4.add(tmpTong.get(i)); body4.add(tmpTong.get(j)); body4.add(tmpTong.get(k)); tmpTong.remove(i); tmpTong.remove(j-1); tmpTong.remove(k-2); break;
							default: System.out.println("에러: 몸통-bodyCount");
							}
							bodyCount++;
							existBody = true;
							break bodyfinderTong1;
						}
					}
				}
			}
			if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
				return false;
			}
		
		}



		tmpBody = bodyCount;
		ArrayList<Tile> tmpZa = za; // 자패 체크
		while (!tmpZa.isEmpty()){
			if (tmpZa.size()==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderZa1: 
				for (int i = 0; i<tmpZa.size();i++){ 
					for (int j = i+1; j<tmpZa.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpZa.get(i)).isHead(tmpZa.get(j))){ // i, j가 머리면
						head.add(tmpZa.get(i));	head.add(tmpZa.get(j)); //head에 추가
						tmpZa.remove(i); tmpZa.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						System.out.println("머리가 자패에 있음");
						break headfinderZa1; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					tmpZa = za;
					bodyCount=tmpBody;
					break;
				}
			} else{
			// 3의배수 개에서 몸통 찾기
				if (tmpZa.isEmpty()){ // 0개이면 탈출
					break;
				}
				boolean existBody = false;
				bodyfinderZa1:
				for (int i = 0;i<tmpZa.size() ;i++ ){
					for (int j = i+1;j<tmpZa.size() ;j++){
						for (int k = j+1;k<tmpZa.size() ;k++){ //남은 것 중 3개를 비교해서
							if ((tmpZa.get(i)).isBody(tmpZa.get(j), tmpZa.get(k))){ // 몸통이 만들어지면
								switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
								case 0: body1.add(tmpZa.get(i)); body1.add(tmpZa.get(j)); body1.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 1: body2.add(tmpZa.get(i)); body2.add(tmpZa.get(j)); body2.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 2: body3.add(tmpZa.get(i)); body3.add(tmpZa.get(j)); body3.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 3: body4.add(tmpZa.get(i)); body4.add(tmpZa.get(j)); body4.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								default: System.out.println("에러: 몸통-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderZa1;
							}
						}
					}
				}
				if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
					return false;
				}
			}
		}

		while (!tmpZa.isEmpty()){
			if (tmpZa.size()%3==2){ // 머리가 있는 색이면
				boolean existHead = false; // 머리를 찾았는지 체크
				headfinderZa1: 
				for (int i = 0; i<tmpZa.size();i++){ 
					for (int j = i+1; j<tmpZa.size() ;j++ ){ // 1쌍씩 비교하기 위한 이중for문
						if ((tmpZa.get(i)).isHead(tmpZa.get(j))){ // i, j가 머리면
						head.add(tmpZa.get(i));	head.add(tmpZa.get(j)); //head에 추가
						tmpZa.remove(i); tmpZa.remove(j-1); //tmp에서 제거
						existHead = true; // 머리 찾음
						System.out.println("머리가 자패에 있음");
						break headfinderZa1; // 탈출
						}
					}
				}
				if (!existHead)	{ // 전부 찾았을 때,  머리를 찾지 못했으면 false
					return false;
				}
			} 
			// 3의배수 개에서 몸통 찾기
				if (tmpZa.isEmpty()){ // 0개이면 탈출
					break;
				}
				boolean existBody = false;
				bodyfinderZa1:
				for (int i = 0;i<tmpZa.size() ;i++ ){
					for (int j = i+1;j<tmpZa.size() ;j++){
						for (int k = j+1;k<tmpZa.size() ;k++){ //남은 것 중 3개를 비교해서
							if ((tmpZa.get(i)).isBody(tmpZa.get(j), tmpZa.get(k))){ // 몸통이 만들어지면
								switch (bodyCount){ // 몸통이 몇갠지에 따라 body에 추가하고 tmp에서 제거
								case 0: body1.add(tmpZa.get(i)); body1.add(tmpZa.get(j)); body1.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 1: body2.add(tmpZa.get(i)); body2.add(tmpZa.get(j)); body2.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 2: body3.add(tmpZa.get(i)); body3.add(tmpZa.get(j)); body3.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								case 3: body4.add(tmpZa.get(i)); body4.add(tmpZa.get(j)); body4.add(tmpZa.get(k)); tmpZa.remove(i); tmpZa.remove(j-1); tmpZa.remove(k-2); break;
								default: System.out.println("에러: 몸통-bodyCount");
								}
								bodyCount++;
								existBody = true;
								break bodyfinderZa1;
							}
						}
					}
				}
				if (!existBody){ // 전부 찾았을 때, 몸통을 찾지 못했으면 false
					return false;
				}
			}


		System.out.println("tmpZa : " + tmpZa.size());
		System.out.println("head : " + head.size());
		System.out.println("머리 : " + (head.get(0)).show() + (head.get(1)).show());
		System.out.println("몸통1 : " + (body1.get(0)).show() + (body1.get(1)).show() + (body1.get(2)).show());
		System.out.println("몸통2 : " + (body2.get(0)).show() + (body2.get(1)).show() + (body2.get(2)).show());
		System.out.println("몸통3 : " + (body3.get(0)).show() + (body3.get(1)).show() + (body3.get(2)).show());
		System.out.println("몸통4 : " + (body4.get(0)).show() + (body4.get(1)).show() + (body4.get(2)).show());
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
		
		// 머리검사
		for (int i=0;i<hand.length;i++) {
			if(i!=0) {
				if (hand[i].isHead(hand[i-1])) {
				continue; //이미 고려된 것이면 탈출 (정렬된 것 기준)
				}
			}
			for (int j=i+1;j<hand.length;j++) {
				if (hand[i].isHead(hand[j])) {
					headLine[headCount][0]=i;
					headLine[headCount][1]=j;
					headCount++;
					break; // i번과 머리가 되면 다른것 고려할 필요 없음
				} 
			}
		} // 가능한 head 수: headCount개
		
		if (headCount==7) { 
			return true; //치토이츠
		}
		
		// 남은것 중 몸통검사
		arrange();
		for (int i=0;i<headCount;i++) {//가능한 머리마다
			//머리를 제외한 손패 정렬
			Tile[] bodyHand = new Tile[12];
			int countBh = 0;
			for (int j=0;j<hand.length;j++) {
				if (!(headLine[i][0]==j||headLine[i][1]==j)) {
					bodyHand[countBh] = hand[j];
					countBh++;
				}
			}// 정렬한 손패 : bodyHand
			countBh=0;
			head[0] = hand[headLine[i][0]];
			head[1] = hand[headLine[i][1]]; // 머리 확정
			boolean isBody1;
			for (int j=0;j<bodyHand.length;j++) {
				for (int k=j+1;k<bodyHand.length;k++) {
					for(int l=k+1;l<bodyHand.length;l++) {
						isBody1 = bodyHand[j].isBody(bodyHand[k], bodyHand[l]);
						if (isBody1) {//몸통을 bodyHand 에서 제외, 또 체크
							body1[0]=bodyHand[j]; body1[1]=bodyHand[k]; body1[2]=bodyHand[l];
							
							Tile[] bodyHand2 = removeTile(bodyHand, bodyHand[j], bodyHand[k], bodyHand[l]);
							// 정렬한 손패 : bodyHand2
							boolean isBody2;
							for (int m=0;m<bodyHand2.length;m++) {
								for (int n=m+1;n<bodyHand2.length;n++) {
									for (int o=n+1; o<bodyHand2.length;o++) {
										isBody2 = bodyHand2[m].isBody(bodyHand2[n], bodyHand2[o]);
										if (isBody2) {
											body2[0]=bodyHand2[m]; body2[1]=bodyHand2[n]; body2[2]=bodyHand2[o]; //몸통 저장
											
											Tile[] bodyHand3 = removeTile(bodyHand2, bodyHand[m], bodyHand[n], bodyHand[o]);
											// 정렬한 손패 : bodyHand3
											boolean isBody3;
											for (int p=0;p<bodyHand3.length;p++) {
												for (int q=p+1;q<bodyHand3.length;q++) {
													for (int r=q+1;r<bodyHand3.length;r++) {
														isBody3 = bodyHand3[p].isBody(bodyHand3[q], bodyHand3[r]);
														if (isBody3) {
															body3[0]=bodyHand3[p]; body3[1]=bodyHand3[q]; body3[2]=bodyHand3[r];
															Tile[] bodyHand4 = removeTile(bodyHand3, bodyHand3[p], bodyHand3[q], bodyHand3[r]);
															// 정렬한 손패 : bodyHand4
															boolean isBody4;
															isBody4 = bodyHand4[0].isBody(bodyHand4[1], bodyHand[2]);
															if (isBody4) {
																body4[0]=bodyHand4[0]; body4[1]=bodyHand4[1]; body4[2]=bodyHand4[2];
																isTenpai = true;
																System.out.println("머리 : " + head[0].show() + head[1].show());
																System.out.println("몸통");
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


