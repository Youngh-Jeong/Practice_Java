import java.util.*;

class MahjongPractice_backup1{
	public static void main(String[] args) {
		TilePile mountain = new TilePile(); //패산 생성
		Player me = new Player(0, mountain);

		while (true){//무한루프 : 반드시 빠져나올 조건이 있어야 함
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 나홀로 조패연습(25회)");
			System.out.println("2. 다인전 구현연습");
			System.out.println("9. 프로그램 종료");
			System.out.print("선택 >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1:
				mountain.shuffle();	 // 패산 세팅
				me.firsthand();  // 배패 받음
				System.out.println("나의 배패"); me.showhand(); // 배패 보여줌
				try	{
					while (mountain.count <= 136){
						me.drawDiscard();	// 쯔모기리
						me.showhand();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
					} // 반복
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("-끝-");
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
}

class Player{
	TilePile mountain; // 패산
	int wind; // 내 바람 (0~3)
	int point; // 점봉
	Tile[] hand = new Tile[14]; // 손
	Tile empty = new Tile(99,99,99);
	Tile[] discards = new Tile[25]; // 버림패
	int discardsCount = 0; // 버림패 순서
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
		discards[discardsCount] = tmp;
		discardsCount++;
	}
	
	public void draw(){
		Tile tsumo = mountain.draw(); //쯔모 임시 저장
		System.out.println("쯔모 : " + tsumo.show());
		hand[0] = tsumo; // 쯔모를 손으로 가져옴
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

	public void testArrange(Tile[] handTest){ // 보기좋게 정렬 (만/삭/통/자패, 수는 오름차순)  ***13일때, 14일 때 처리
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


