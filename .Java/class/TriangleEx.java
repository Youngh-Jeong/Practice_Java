/*
Ŭ������ : Triangle
������� : �غ��� ���̸� ������ �� �ִ� double�� ����
 - �ν��Ͻ� ������ ���ÿ� �ʱ�ȭ�� �̷�� ���� ��
�޼ҵ� : �غ��� ������ ���� ������ �� �ִ� setter, �ﰡ���� ���̸� ���Ͽ� �����ϴ� �޼ҵ�
*/
class Triangle{
	double base;
	double height;
	public Triangle (double b, double h){
		base = b;
		height = h;
	}
	public void setBase(double b){
		base = b;
	}
	public void setHeight(double h){
		height = h;
	}
	public double area(){
		return base*height/2;
	}
}
class TriangleEx{
	public static void main(String[] args) {
		// �غ� 25.5, ���� 13.5�� �ﰢ�� �ν��Ͻ����� �� ���̸� ���
		// �غ��� 23.4, ���̸� 17.5�� ������ �� ���̸� ���
		Triangle t = new Triangle(25.5, 13.5);
		System.out.println("���� : " + t.area());
		t.setBase(23.4);
		t.setHeight(17.5);
		System.out.println("���� �� ���� : " + t.area());
	}
}
