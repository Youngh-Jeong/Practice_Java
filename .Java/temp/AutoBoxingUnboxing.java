class AutoBoxingUnboxing{
	public static void main(String[] args) {
		Integer iValue = 10;
		Double dValue = 3.14;
		// WrapperŬ������ �����ڸ� �̿����� �ʰ� �����͸� ���� �־ ��ü�� ������ : auto boxing
		System.out.println(iValue);
		System.out.println(dValue);

		int n1 = iValue;
		double n2 = dValue;
		// ������ ��ü�� �ٷ� �־ �������� ���۵� : auto unboxing
		System.out.println(n1);
		System.out.println(n2);
	}
}
