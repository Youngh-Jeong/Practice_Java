class MethodExam{
	public static void main(String[] args) {
		absDiff(10, 20);
		absDiff(35, 20);
	}
	// �� ������ �Է¹޾� �� ���� ���� ���밪���� ���Ͽ� ����ϴ� �޼ҵ� �ۼ�
	// ��) 10�� 20�� ���� 10 / 35�� 20�� ���� 15
	public static void absDiff(int a1, int a2) {
		int diff;
		diff = a1 - a2;
		if (diff>0){//����� �� ��, ���̸� �״�� ���
			System.out.println(a1 + "�� " + a2 + "�� ���� " + diff);
		} else {
			System.out.println(a1 + "�� " + a2 + "�� ���� " + (-diff));
		}
	}
}
