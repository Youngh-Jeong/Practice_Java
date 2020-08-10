import java.util.*;

class  ArrayListLinkedList{
	public static void main(String[] args){
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();

		System.out.println("= ���������� �߰��ϱ� =");
		System.out.println("ArrayList : " + add1(al)); // 94
		System.out.println("LinkedList : " + add1(ll)); // 156
		System.out.println();
		System.out.println("= �߰��� �߰��ϱ� =");
		System.out.println("ArrayList : " + add2(al)); // 9482
		System.out.println("LinkedList : " + add2(ll)); // 16
		System.out.println();
		System.out.println("= �߰����� �����ϱ� =");
		System.out.println("ArrayList : " + remove2(al)); // 8498
		System.out.println("LinkedList : " + remove2(ll)); // 0
		System.out.println();
		System.out.println("= ���������� �����ϱ� =");
		System.out.println("ArrayList : " + remove1(al)); // 16
		System.out.println("LinkedList : " + remove1(ll)); // 15
		System.out.println();

		// �߰��� �۾��ϴ� �ͱ��� ���� LinkedList�� ArrayList���� ��ü������ ����
		// ��, ���� ��κ��� �۾��� ���������� �̷�� ���� ������ ArrayList�� �� ���� ����
		// �߰��� �ϴ� �۾��� ���� ��� LinkedList�� �۾��ϴٰ�, �߰� �۾��� ������ �ٽ� ArrayList�� ��ȯ�Ͽ� �۾��ϴ� ��쵵 �ִ�.
	}

	public static long add1(List list) {
		long start = System.currentTimeMillis();
		// ���� �ð��� �и��� ������ ȯ���Ͽ� ����
		for (int i = 0;i < 1000000 ;i++){
			list.add(i+"");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long add2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0;i < 10000 ;i++){
			list.add(500, "X");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long remove1(List list) {
		long start = System.currentTimeMillis();
		for (int i = list.size()-1;i>=0 ;i--){
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long remove2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0;i < 10000 ;i++){
			list.remove(1);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
