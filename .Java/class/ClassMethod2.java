class SimpleMath{
	public static final double PI = 3.1415;
	public double add(double n1, double n2) {return n1 + n2;}
	public double min(double n1, double n2) {return n1 - n2;}
	public double mul(double n1, double n2) {return n1 * n2;}
}

class AreaMath{
	public double calCircleArea(double rad) {
		SimpleMath sm = new SimpleMath();
		double result = sm.mul(rad, rad);
		result = sm.mul(result, SimpleMath.PI);
		return result;
	}
	public double calRectArea(double width, double height){
		SimpleMath sm = new SimpleMath();
		return sm.mul(width, height);
	}
}

class PeriMath{
	public double calCirclePeri(double rad){
		SimpleMath sm = new SimpleMath();
		double result = sm.mul(rad,2);
		return sm.mul(result, SimpleMath.PI);
	}
	public double calRectPeri(double width, double height){
		SimpleMath sm = new SimpleMath();
		return sm.add(sm.mul(width, 2), sm.mul(height,2));
	}
}

class ClassMethod2 {
	public static void main(String[] args) {
		AreaMath am = new AreaMath();
		PeriMath pm = new PeriMath();
		System.out.println("원의 넓이 : " + am.calCircleArea(2.4));
		System.out.println("사각형의 둘레 : " + pm.calRectPeri(2.0,4.0));
	}

}
