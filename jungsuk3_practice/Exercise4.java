class Exercise4 
{
	public static void main(String[] args) 
	{
		// 4-2 : 1���� 20������ ���� �߿��� 2 �Ǵ� 3�� ����� �ƴ� ���� ������ ���Ͻÿ�.
		int n1 = 1;
		int sum1 = 0;
		while (n1<=20)	{
			if (n1%2!=0&&n1%3!=0){
				sum1=sum1+n1;
				//System.out.println(n1);
			}
			n1++;
		}
		System.out.println("�ƴ� ���� ���� : " + sum1);

		// 4-3 : 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+...+10)�� ����� ����Ͻÿ�
		int sum2 = 0;
		for (int n2=1;n2<=10;n2++){
			for (int i2=1;i2<=n2;i2++){
				sum2 = sum2 + i2;
			}
			//System.out.println(n2 + "��°�������� �� : " + sum2);
		}
		System.out.println("���� : " + sum2);

		// 4-4 : 1+(-2)+3+(-4)+...�� ���� ������ ��� ���س����� ��, ����� ���ؾ� ������ 100�̻��� �Ǵ��� ���Ͻÿ�.
		int sum3 = 0;
		int n3 = 0;
		while (sum3<100){
			if (n3%2==0){
				sum3 = sum3 - n3;
			}
			else {
				sum3 = sum3 + n3;
			}
			n3++;
		}
		System.out.println("���° : " + (n3-1) + ", �� : " + sum3);

		/* 4-5 : ������ for���� while������ �����Ͻÿ�
		for(int i=0; i<=10; i++){
			for(int j=0; j<=i, j++){
				System.out.print("*");
			System.out.println();
		}
		*/
		int i = 0;
		int j = 0;
		while (i<=10){
			while (j<=i){
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			j = 0;
		}

		// 4-6 : �� ���� �ֻ����� ������ ��, ���� ���� 6�� �Ǵ� ��� ����� ���� ���
		for (int i6 = 1;i6<=6;i6++){
			for (int j6 = 1;j6<=6;j6++){
				if (i6+j6 == 6){
					System.out.println("����� �� : " + "(" + i6 +", " + j6 + ")");
				}
			}
		}

		// 4-7 : Math.random()�� �̿��ؼ� 1���� 6������ ������ ������ ���� value�� �����ϴ� �ڵ�
		int value7 = (int)(Math.random()*5+1);
		System.out.println("value : " + value7);


		// 4-8 : ������ 2x+4y=10�� ��� �����ظ� ���Ͻÿ�. (0<=x,y<=10)
		for (int x8 = 0;x8 <= 10 ;x8++){
			for (int y8 = 0;y8 <= 10;y8++){
				if (2*x8+4*y8==10){
					System.out.println("x=" + x8 + " y=" + y8);
				}
			}
		}

		// 4-9 : ���ڷ� �̷���� ���ڿ� str�� ���� ��, �� �ڸ��� ���� ���� ����� ����ϴ� �ڵ带 �ϼ��϶� (hint: charAt(int i)
		String str = "12345";
		int sum = 0;

		for (int i9 = 0;i9 < str.length() ; i9++)	{
			sum = str.charAt(i9) - '0' + sum;
		}
		System.out.println("sum="+sum);

		// 4-10 : int ���� num�� ���� ��, �� �ڸ��� ���� ���� ����� ����ϴ� �ڵ�
		int num10 = 12345;
		int sum10 = 0 ;
		for (int i10 = 0;i10<5;i10++){
			sum10 += num10%10;
			num10 /= 10;
		}
		System.out.println("�� : " + sum10);

		// 4-11 : 1, 1 ... �� �Ǻ���ġ������ 10��° ���� ����ϴ� �ڵ�

		int num11_1 = 1;
		int num11_2 = 1;
		int num11_3 = 0;
		System.out.print(num11_1+","+num11_2);

		for (int i11 = 0;i11 < 8 ; i11++ ){
			num11_3 = num11_1 + num11_2;
			num11_1 = num11_2;
			num11_2 = num11_3;
			System.out.print(","+num11_3);
		}

		System.out.println();

		/* 4-12 : ������ ���
		2 x 1 = 2   3 x 1 = 3    4 x 1 = 4
		2 x 2 = 4
		2 x 3 = 6
		
		5 x 1 = 5
		5 x 2 = 10
		5 x 3 = 15
		
		8 x 1 = 8
		8 x 2 = 16
		8 x 3 = 24    ...                    */
		

		for (int i12=1;i12<=3;i12++){
			for (int j12=1;j12<=3;j12++){
				for (int k12=3*i12-1;k12<=3*i12+1;k12++){
					if (k12 >=10){
						break;
					}
					System.out.print(k12 + " x " + j12 + " = " + k12*j12 + "  " ); //���� : 10��, ĭ��
					if (k12*j12<10)	{
						System.out.print(" ");
					}
				}
				System.out.println();

			}
			System.out.println();
		}

		// 4-13 : �־��� ���ڿ�(value)�� ���������� �Ǻ��ϴ� �ڵ�

		String value13 = "12o34";
		char ch = ' ';
		boolean isNumber = true;

		for (int i13=0;i13<value13.length() ;i13++){
			if ('0'>value13.charAt(i13)||value13.charAt(i13)>'9'){ //char�� �����ϴ°� ����
				isNumber = false;
				break;
			}
		}
		
		if (isNumber){
			System.out.println(value13+"�� �����Դϴ�.");
		} else {
			System.out.println(value13+"�� ���ڰ� �ƴմϴ�.");
		}

		// 4-14 : ������ ���ڸ��߱� �����̴�. ����ڰ� ���� �Է��ϸ�, ũ�� ���� �˷��ش�. ���߸� ������ Ƚ���� �����ش�.
		
		int answer = (int)(Math.random()*99+1);
		int input = 0;
		int count = 0;
		java.util.Scanner s = new java.util.Scanner(System.in);

		do{
			count++;
			System.out.print("1�� 100������ ���� �Է��ϼ��� : ");
			input = s.nextInt();
			if (answer==input){ //�¾��� ��
				System.out.println("������ϴ�.");
				System.out.println("�õ� Ƚ���� " + count + "���Դϴ�.");
				break;
			} else if (answer>input){ //���� �� Ŭ ��
				System.out.println("�� ū ���� �Է��ϼ���.");
			} else {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			}

		}
		while (true); //���ѹݺ�
	

		//ȸ������ �Ǻ��ϴ� ���α׷� (ȸ������, ���ڸ� �Ųٷ� �о ������ �д� �Ͱ� ���� ���� ���Ѵ�.)
		int number = 12321;
		int tmp = number;

		int result = 0;

		while(tmp !=0) {
			result = result * 10 + tmp%10;
			tmp = tmp/10;
		}

		if (number==result)	{
			System.out.println(number + "�� ȸ���� �Դϴ�.");
		} else {
			System.out.println(number + "�� ȸ������ �ƴմϴ�.");
		}
	}
}
