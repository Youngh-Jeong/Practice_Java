class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("�絵 : " + sugar); }
}

class Apple {
	int weight;
	public Apple(int weight) {this.weight = weight;}
	public void showWeight() {System.out.println("���� : " + weight);}
}

class FruitBox<T> {
	// <T> : FruitBoxŬ�������� T�� ������ ��� �ڷ����� Objectó�� ����� �� ����
	// ��, �ν��Ͻ� ������ ������ �ִ� �ڷ������� ����
	T item;
	public void store(T item) { this.item = item; }
	public T pullOut() {return item;}
}
class FruitBoxGeneric {
	public static void main(String[] args) {
		FruitBox<Orange> fBox1 = new FruitBox<Orange>();
		// FruitBox<Orange> : FruitBox�� �ν��Ͻ� ������ ���׸��� ������ T�� Orange Ŭ������ ����ϰڴٴ� �ǹ�
		fBox1.store(new Orange(10));
		Orange org = fBox1.pullOut();
		// ���׸����� Orange�� �����߱� ������ ����ȯ ���� Orange�� ���� �� ����
		org.showSugar();

		FruitBox<Apple> fBox2 = new FruitBox<Apple>();
		// FruitBoxŬ������ ���׸� T�� AppleŬ������ ����ϰڴٴ� �ǹ�
		fBox2.store(new Apple(20));
		Apple app = fBox2.pullOut();
		app.showWeight();
	}
}


