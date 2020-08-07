class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("�絵 : " + sugar); }
}

class FruitBox{ // ��� ������ ������ ��� Ŭ����
	Object item;
	// Object�� �����Ͽ��� ������ ��� ������ �����͵� ���� �� ����
	public void store(Object item) { this.item = item; }
	public Object pullOut() {return item;}
}
class FruitBoxObject{
	public static void main(String[] args) {
		FruitBox fBox1 = new FruitBox();
		fBox1.store(new Orange(10));
		// OrangeŬ������ �ν��Ͻ��� �����Ͽ� store()�޼ҵ��� �Ű������� ������
		Orange org1 = (Orange)fBox1.pullOut();
		org1.showSugar();

		FruitBox fBox2 = new FruitBox();
		fBox2.store(new String("������"));
		Orange org2 = (Orange)fBox2.pullOut();
		// fBox2�� ����ִ� ��ü�� String�̹Ƿ� Orange�� ����ȯ�� �Ұ�
		// ClassCastException �߻�
		org2.showSugar();
	}
}

/*
store()�޼ҵ带 ���� Orange�� �ƴ� String�� �ν��Ͻ��� ������ ��
����ȯ�� �Ұ����� �ڵ忡�� �����Ͻ� ������ ���� �ʰ� ����� exception�� �߻�

�ذ�å
 - ��Ȯ�� �ڷ����� �ν��Ͻ��� ���� �� �ְ� �۾��ؾ� ��
    �߸��� �ڷ����� �ν��Ͻ��� ������ ���ܰ� �ƴ� ������ �߻��ϰ� �ؾ� ��
*/


