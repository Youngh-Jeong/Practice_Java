class Exercise3{
	public static void main(String[] args) {

		//3-2 ����� ��� �� �ʿ��� �ٱ��� ���� ���ϴ� �ڵ�
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket =(numOfApples+9)/10;
		System.out.println("�ʿ��� �ٱ����� �� : " + numOfBucket);

		//3-3 num�� ���� ���� ���, ����, 0�� ����ϴ� ���׿����ڸ� �̿��� �ڵ�
		int num_1 = 10;
		System.out.println(num_1 > 0 ? "���" : num_1 == 0 ? "0" : "����");

		//3-4 num�� �� �߿��� ���� �ڸ� ���ϸ� ������ �ڵ�
		int num_2 = 456;
		System.out.println((num_2/100)*100);

		//3-5 num�� �� �߿��� ���� �ڸ��� 1�� �ٲٴ� �ڵ�
		int num_3 = 333;
		System.out.println((num_3/10)*10+1);

		//3-6 num�� ������ ũ�鼭�� ���� ����� 10�� ������� num�� ���� �� �������� ���ϴ� �ڵ� ex. 24->6
		int num_4 = 24;
		System.out.println(10-(num_4%10));


		//3-7 ȭ���� ������ ��ȯ�ϴ� �ڵ� (��ȯ�� c=5/9*(f-32)�̰�, ��ȯ ������� �Ҽ� ��°�ڸ����� �ݿø��ϸ�, math.round()�� ������� �ʰ� ó���� ��

		int fahrenheit = 100;
		float celcius = ((int)((5/9.0f*(fahrenheit-32))*100+0.5))/100.0f;
		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius : " + celcius);

		//3-8 �ڵ� �����ϱ�
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);

		char ch = 'A';
		ch = (char)(ch + 2);

		float f = 3/2f;
		long l = 3000l*3000*3000;

		float f2 = 0.1f;
		double d = 0.1;

		boolean result = (float)d==(f2);

		System.out.println("c="+c); //30
		System.out.println("ch="+ch); //C
		System.out.println("f="+f); //1.5
		System.out.println("l="+l); //27000000000
		System.out.println("result="+result); //true

		//3-9 ch�� ������(�빮�� or �ҹ���)�ų� ������ ���� ���� b�� ���� true�� �ǵ��� �ϴ� �ڵ�
		char ch_9 = 'z';
		boolean b_9 = (('a'<=ch_9&&ch_9<='z')||('A'<=ch_9&&ch_9<='Z')||('0'<=ch_9&&ch_9<='9'));
		System.out.println(b_9);

		//3-10 �빮�ڸ� �ҹ��ڷ� �����ϴµ�, ch�� �빮���� ���� �ҹ��ڷ� �����Ѵ�. �����ڵ�� �ҹ��ڰ� �빮�ں��� 32��ŭ �� ũ��.

		char ch_10 = 'D';
		char lowerCase = ('A'<=ch_10&&ch_10<='Z') ? (char)(ch_10 + 32) : ch;

		System.out.println("ch: " + ch_10);
		System.out.println("ch to lowerCase : "+lowerCase);
	}
}
