class NumberPrinter{
	public static void showInt(int n) { System.out.println(n);}
	public static void showDouble(double n) { System.out.println(n);}
}

class ClassMethod{
	public static void main(String[] args){
		NumberPrinter.showInt(20);
		// 클래스 메소드이므로 인스턴스 없이 클래스만으로 호출 가능
		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.14);
		// 클래스 메소드는 인스턴스로도 호출 가능
	}
}
