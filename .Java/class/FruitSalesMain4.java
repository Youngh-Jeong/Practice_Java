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
		System.out.println("���� ��� : " + numOfApple);
		System.out.println("�Ǹ� ���� : " + myMoney);
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
		System.out.println("������ �ִ� ��� : " + numOfApple);
		System.out.println("���� �� : " + myMoney);
	}
}

class FruitSalesMain4 {
	public static void main(String[] args){
		FruitSeller seller1 = new FruitSeller(30, 0, 1500);
		FruitSeller seller2 = new FruitSeller(20, 0, 1000);
		FruitBuyer buyer = new FruitBuyer(10000);

		seller1.myMoney += 500;		buyer.myMoney -=500;
		// �����ڰ� �Ǹ��ڿ��� 500���� �ְ� 

		seller1.numOfApple -=20;	buyer.numOfApple +=20;
		// ��� 20���� ������ ����

		System.out.println("���� �Ǹ���1 ��Ȳ");
		seller1.showSaleResult();
		System.out.println("���� �Ǹ���2 ��Ȳ");
		seller2.showSaleResult();
		System.out.println("���� ������ ��Ȳ");
		buyer.showBuyResult();
	}
}


/*
������
 - ��������� ���������� �����Ͽ� ���� ������ �� �ִ�.

�ذ�å
 - ��������� ���������� ������ �� ���� ��
*/
