/*
클래스명 : Triangle
멤버변수 : 밑변과 높이를 저장할 수 있는 double형 변수
 - 인스턴스 생성과 동시에 초기화가 이루어 져야 함
메소드 : 밑변과 높이의 값을 변경할 수 있는 setter, 삼가형의 넓이를 구하여 리턴하는 메소드
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
		// 밑변 25.5, 높이 13.5인 삼각형 인스턴스생성 후 넓이를 출력
		// 밑변을 23.4, 높이를 17.5로 변경한 후 넓이를 출력
		Triangle t = new Triangle(25.5, 13.5);
		System.out.println("넓이 : " + t.area());
		t.setBase(23.4);
		t.setHeight(17.5);
		System.out.println("변경 후 넓이 : " + t.area());
	}
}
