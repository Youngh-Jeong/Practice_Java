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
		//구매자가 지불한 금액(money)으로 살 수 있는 사과 개수를 구함
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
	public void showBuyResult() {
		System.out.println("가지고 있는 사과 : " + numOfApple);
		System.out.println("남은 돈 : " + myMoney);
	}
}

class FruitSalesMain1 {
	public static void main(String[] args){
		FruitSeller seller = new FruitSeller();
		//FruitSeller 형 인스턴스 seller를 선언 및 생성
		FruitBuyer buyer = new FruitBuyer();
		//FruitBuyer 형 인스턴스 buyer를 선언 및 생성
		buyer.buyApple(seller, 2000);
		//buyer인스턴스 안의 buyApple() 메소드 실행
		System.out.println("과일 판매자 현황");
		seller.showSaleResult();
		System.out.println("과일 구매자 현황");
		buyer.showBuyResult();
	}
}


/*
문제점
 - 인스턴스들을 여럿 생성해도 모두 동일한 값(멤버변수)을 가지고 있음

해결책
 - 인스턴스 별로 멤버변수의 값을 다르게 지정할 수 있어야 함

*/