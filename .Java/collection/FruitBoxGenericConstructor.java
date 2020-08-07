class Orange{
	int sugar;
	public Orange(int s) {sugar = s;}
	public void showSugar() { System.out.println("당도 : " + sugar); }
}

class Apple {
	int weight;
	public Apple(int weight) {this.weight = weight;}
	public void showWeight() {System.out.println("무게 : " + weight);}
}

class FruitBox<T> {
	T item;
	public FruitBox(T item){this.item = item;}
	public void store(T item) { this.item = item; }
	public T pullOut() {return item;}
}
class FruitBoxGenericConstructor {
	public static void main(String[] args) {
		FruitBox<Orange> fBox1 = new FruitBox<Orange>(new Orange(10));
		Orange org = fBox1.pullOut();
		org.showSugar();

		FruitBox<Apple> fBox2 = new FruitBox<Apple>(new Apple(20));
		Apple app = fBox2.pullOut();
		app.showWeight();
	}
}


