class MethodEx2{
	public static void main(String[] args){
		int n1, n2, n3;
		n3 = adder(4, 5);
		System.out.println("4�� 5�� �� : " + n3);
		System.out.println("3.5�� ���� : " + square(3.5));
		System.out.println("3�� " + evenOdd(3) + "�� �Դϴ�.");
	}
	public static int adder(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	public static double square(double d1) {
		return d1*d1;
	}
	public static char evenOdd(int n) {
		if (n%2==0){
			return '¦';
		} else {
			return 'Ȧ';
		}
		// if�� �ȿ��� return�� �Ϸ��� �ݵ�� else���� ����ؼ� return�ؾ� ��
		// else if ������ return�ϴ� �ɷ� ������ JVM�� ���ǿ� ���� return���� ���� ���� �ִٰ� �Ǵ��Ͽ� missing return statement ������ �߻���Ŵ
	}
}
