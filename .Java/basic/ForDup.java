class ForDup{
	public static void main(String[] args){
		for (int i = 1;i<4;i++){
			System.out.println("*** i : " + i);
			for (int j = 1;j<4;j++)	{
				System.out.println("j : " + j);
			}
		}

		/*±¸±¸´Ü
		2 x 1 = 2   3 x 1 = 3   ... 5 x 1 = 5
		2 x 2 = 4    
		...
		2 x 9 = 18     ...
		*/
		for (int i = 1;i<=9;i++){
			for (int j = 2;j<=5;j++){
				System.out.print(j + " X " + i + " = " + i*j + "  ");
				if (i*j<10){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
