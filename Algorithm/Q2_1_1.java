class Q2_1_1{
	public static void main(String[] args) {
		// ���� �����, ����Ű ���� �� �ִ밪 ���
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		int num = (int)(Math.random()*100)+1;
		System.out.println("��� �� : " + num);
		int[] height = new int[num];
		for (int i = 0; i<height.length;i++) {
			height[i] = 100 + (int)(Math.random()*60+30);
			System.out.println("height[" + i + "] : " + height[i]);
		}
		System.out.println("�ִ밪�� " + MaxOfArrayRand(height));

	}
	public static int MaxOfArrayRand(int[] a) { // �ִ�Ű �޼ҵ�
		int max = a[0];
		for (int i = 1; i<a.length;i++) {
			if (max<a[i]) {
				max = a[i];
			}
		}
		return max;
	}
}
