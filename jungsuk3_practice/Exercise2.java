class Exercise2 { //x,y,z�� ���� �ٲٽÿ�
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int z = 3;
		
		int tmp;

		tmp = y;
		y = x;
		x = z;
		z = tmp;
	
		System.out.println("x =" + x);
		System.out.println("y =" + y);
		System.out.println("z =" + z);
	}
}
