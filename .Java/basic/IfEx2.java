class IfEx2 
{
	public static void main(String[] args) 
	{
		int num = 120;

		if (num < 0) {
			System.out.println("0 미만");
		}
		else {// num이 0보다 크거나 같으면
			//안쪽 if문은 겉의 else문의 조건이 참인 상태로 동작하게 됨
			if (num < 100){
				// num이 100보다 작으면(else의 조건인 0 이상이 포함된 조건)
				System.out.println("0이상 100 미만");
			} 
			else {
				System.out.println("100 이상");
			}
		}
	}
}
