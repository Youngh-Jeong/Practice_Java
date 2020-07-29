/* 사과 판매 프로그램
사과판매자 : FruitSeller 클래스
 - 멤버변수 : 보유사과량(numOfApple), 매출액(myMoney), 가격(APPLE_PRICE)
 - 메소드 : 판매(saleApple()), 현황보기(showSaleResult())
사과구매자 : FruitBuyer 클래스
 - 멤버변수 : 구매사과량(numOfApple), 잔액(myMoney)
 - 메소드 : 구매(buyApple()), 현황보기(showBuyResult())
*/
class FruitSeller{
	int numOfApple = 20;	// 보유 사과량
	int myMoney = 0;		// 매출액
	final int APPLE_PRICE = 1000;	// 사과가격
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
	int numOfApple = 0;	// 구매 사과량
	int myMoney = 5000;		// 잔액
	public void buyApple(FruitSeller seller, int money){
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
}

class FruitSalesMain1 {
	public static void main(String[] args){
		FruitSeller seller = new FruitSeller();
		FruitBuyer buyer = new FruitBuyer();
		buyer.buyApple(seller, 2000);

		System.out.println("과일 판매자 현황");
		seller.showSaleResult();
	}
}
