class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("�絵 : " + sugar); }
}

class OrangeBox{
	Orange item;
	public void store(Orange item) { this.item = item; }
	public Orange pullOut() {return item;}
}
class FruitBoxOrange{
	public static void main(String[] args) {
		OrangeBox fBox1 = new OrangeBox();
		fBox1.store(new Orange(10));
		Orange org1 = fBox1.pullOut();
		org1.showSugar();

		OrangeBox fBox2 = new OrangeBox();
		fBox2.store(new String("������"));
		// store()�޼ҵ��� �Ű����� �ڷ����� Orange�̹Ƿ� ����ȯ �Ұ�
		Orange org2 = fBox2.pullOut();
		org2.showSugar();
	}
}

/*
������
 - �� ���� ������ �����͸� ���� �� ���� (Orange)
 - �ٸ� ������ �����͸� �������� OrangeBoxŬ������ ���� �� �ʿ���

�ذ�å
 - ���׸� ���
*/
