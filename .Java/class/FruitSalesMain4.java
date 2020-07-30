class FruitSeller{
	int numOfApple;	
	int myMoney;		
	final int APPLE_PRICE;
	public FruitSeller(int num, int money, int price) {
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
	int myMoney;
	public FruitBuyer(int money){
		myMoney = money;
	}
	public void buyApple(FruitSeller seller, int money){
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("가지고 있는 사과 : " + numOfApple);
		System.out.println("남은 돈 : " + myMoney);
	}
}

class FruitSalesMain4 {
	public static void main(String[] args){
		FruitSeller seller1 = new FruitSeller(30, 0, 1500);
		FruitSeller seller2 = new FruitSeller(20, 0, 1000);
		FruitBuyer buyer = new FruitBuyer(10000);

		seller1.myMoney += 500;		buyer.myMoney -=500;
		// 구매자가 판매자에게 500원을 주고 

		seller1.numOfApple -=20;	buyer.numOfApple +=20;
		// 사과 20개를 가지고 나옴

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
 - 멤버변수에 직접적으로 접근하여 값을 변경할 수 있다.

해결책
 - 멤버변수에 직접적으로 접근할 수 없게 함
*/
