/* ��� �Ǹ� ���α׷�
����Ǹ��� : FruitSeller Ŭ����
 - ������� : ���������(numOfApple), �����(myMoney), ����(APPLE_PRICE)
 - �޼ҵ� : �Ǹ�(saleApple()), ��Ȳ����(showSaleResult())
��������� : FruitBuyer Ŭ����
 - ������� : ���Ż����(numOfApple), �ܾ�(myMoney)
 - �޼ҵ� : ����(buyApple()), ��Ȳ����(showBuyResult())
*/
class FruitSeller{
	int numOfApple = 20;	// ���� �����
	int myMoney = 0;		// �����
	final int APPLE_PRICE = 1000;	// �������
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("���� ��� : " + numOfApple);
		System.out.println("�Ǹ� ���� : " + myMoney);
	}
}

class FruitBuyer{
	int numOfApple = 0;	// ���� �����
	int myMoney = 5000;		// �ܾ�
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

		System.out.println("���� �Ǹ��� ��Ȳ");
		seller.showSaleResult();
	}
}
