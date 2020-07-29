class SwitchEx1 {
	public static void main(String[] args) {
		int n = 2;
		switch (n)	{
			case 1:
				System.out.println("n은 1");
				break;
			case 2:
				System.out.println("n은 2");
				break;
			case 3:
				System.out.println("n은 3");
				break;
			default :
				System.out.println("n은 몰라");
		}

		switch ("abc") {
			case "aaa":
				System.out.println("aaa"); break;
			case "ccc":
				System.out.println("ccc"); break;
			case "abc":
				System.out.println("abc"); break;
			default:
				System.out.println("???"); break;
		
		}

	}
}
