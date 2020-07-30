class FruitSeller{
	int numOfApple;	
	int myMoney;		
	int APPLE_PRICE;
	//상수일 경우 일반 메소드에서 값을 넣으면 오류가 발생함
	// 나중에라도 다시 메소드를 호출할 수 있으므로 미리 오류를 발생시킴
	public void initMember(int num, int money, int price) {
	// 멤버변수들을 초기화 시키는 메소드
		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer{
	int numOfApple = 0;	
	int myMoney = 10000;		
	public void buyApple(FruitSeller seller, int money){
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("가지고 있는 사과 : " + numOfApple);
		System.out.println("남은 돈 : " + myMoney);
	}
}

class FruitSalesMain2 {
	public static void main(String[] args){
		FruitSeller seller1 = new FruitSeller();
		// FruitSeller 형 인스턴스 seller1 을 선언 및 생성
		seller1.initMember(30, 0, 1500);
		// seller1의 멤버변수들에 값을 initMember()메소드를 통해 초기화 시킴

		FruitSeller seller2 = new FruitSeller();
		seller2.initMember(20, 0, 1000);
        
		FruitBuyer buyer = new FruitBuyer();
		buyer.buyApple(seller1, 4500);
		buyer.buyApple(seller2, 2000);

		System.out.println("과일 판매자1 현황");
		seller1.showSaleResult();
		System.out.println("과일 판매자2 현황");
		seller2.showSaleResult();
		System.out.println("과일 구매자 현황");
		buyer.showBuyResult();
	}
}

/*
문제점
 - 인스턴스 생성시 두 줄의 명령이 필요함
 - APPLE_PRICE가 상수가 아닌 변수로 지정됨
 - initMember()초기화 메소드를 언제든지 호출할 수 있음 (호출되면 판매기록이 모두 리셋됨)

해결책
 - 생성자 사용
*/
