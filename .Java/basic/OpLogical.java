class OpLogical 
{
	public static void main(String[] args) 
	{
		int n1 = 0, n2 = 0, n3 = 0;
		boolean result;

		result = (n1 +=10) < 0 && (n2 += 10) > 0;   // &&의 경우 앞에서 거짓이 발생하면 뒷 쪽 조건들은 검사하지 않음
		System.out.println("result : " + result);   // false
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 10, n2 : 0

		result = (n1 +=10) > 0 || (n2 += 10) > 0;   // ||의 경우 앞에서 참이 발생하면 뒷 쪽 조건들은 검사하지 않음
		System.out.println("result : " + result);   // true
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 20, n2 : 0

		// 논리식 내부에서는 변수의 값을 변경하는 등의 명령을 하지 않아야 함
		// 굳이 변경하려면, 논리식 내부가 아닌 외부에서 변경해야 함

		n1 = 0;
		n2 = 0;

		n1 += 10;
		n2 += 10;

		result = (n1 < 0) && (n2 > 0);
		System.out.println("result : " + result);
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 10, n2 : 10

		n1 += 10;
		n2 += 10;

		result = (n1 > 0) || (n2 > 0);
		System.out.println("result : " + result);   
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		// n1 : 20, n2 : 20
	}
}
