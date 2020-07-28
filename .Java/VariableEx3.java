class VariableEx3 {
	public static void main(String[] args) 
	{
		char c1 = '0', c2 = '9', c3 = 'A', c4 = 'a', c5 = '°¡', c6 = 'ÆR';
		int i1 = c1, i2 = c2, i3 = c3, i4 = c4, i5 = c5, i6 = c6;
		System.out.println(c1 + " : " + i1);   // 0 : 48
		System.out.println(c2 + " : " + i2);   // 9 : 57
		System.out.println(c3 + " : " + i3);   // A : 65
		System.out.println(c4 + " : " + i4);   // a : 97
		System.out.println(c5 + " : " + i5);   // °¡ : 44032
		System.out.println(c6 + " : " + i6);   // ÆR : 55203

		int num = 13;
		double d1 = num;
		System.out.println(num + " : " + d1);  // 13 : 13.0
	}
}
