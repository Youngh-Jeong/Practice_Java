/*
FruitSeller클래스에 생성자를 작성
 - 멤버변수 및 상수에 초기화시키는 생성자
 - 생성자를 이용하여 seller1, seller2의 인스턴스 생성

 FruitBuyer클래스에 생성자를 작성
  -멤버변수(numOfApple, myMoney)를 초기화
  - buyer인스턴스 생성 (사과개수는 0, 잔액은 10000)
*/
class FruitSeller{
	int numOfApple;	
	int myMoney;		
	final int APPLE_PRICE;
	public FruitSeller(int num, int money, int price) {
		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;
		//생성자에서는 상수에도 값을 초기화 할 수 있음
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

class FruitSalesMain3 {
	public static void main(String[] args){
		FruitSeller seller1 = new FruitSeller(30, 0, 1500);
		FruitSeller seller2 = new FruitSeller(20, 0, 1000);
		FruitBuyer buyer = new FruitBuyer(10000);
		//생성자를 이용하면 멤버변수를 초기화하면서 인스턴스를 생성할 수 있음
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

