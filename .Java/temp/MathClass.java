class MathClass {
	public static void main(String[] args) {
		System.out.println("¿øÁÖÀ² : "+Math.PI);
		System.out.println("2ÀÇ Á¦°ö±Ù : "+Math.sqrt(2));

		double radian45 = Math.toRadians(45);
		System.out.println("½ÎÀÎ45 : " + Math.sin(radian45));
		System.out.println("ÄÚ½ÎÀÎ45 : " + Math.cos(radian45));
		System.out.println("ÅºÁ¨Æ®45 : " + Math.tan(radian45));
		
		System.out.println("·Î±× 25 : " + Math.log(25));
		System.out.println("2ÀÇ 4½Â : " + Math.pow(2,4));
	}
}