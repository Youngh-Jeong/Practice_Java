class NumberPrinter{
	public static void showInt(int n) { System.out.println(n);}
	public static void showDouble(double n) { System.out.println(n);}
}

class ClassMethod{
	public static void main(String[] args){
		NumberPrinter.showInt(20);
		// Ŭ���� �޼ҵ��̹Ƿ� �ν��Ͻ� ���� Ŭ���������� ȣ�� ����
		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.14);
		// Ŭ���� �޼ҵ�� �ν��Ͻ��ε� ȣ�� ����
	}
}
