import java.util.*;

class  ArrayListLinkedList{
	public static void main(String[] args){
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();

		System.out.println("= 순차적으로 추가하기 =");
		System.out.println("ArrayList : " + add1(al)); // 94
		System.out.println("LinkedList : " + add1(ll)); // 156
		System.out.println();
		System.out.println("= 중간에 추가하기 =");
		System.out.println("ArrayList : " + add2(al)); // 9482
		System.out.println("LinkedList : " + add2(ll)); // 16
		System.out.println();
		System.out.println("= 중간에서 삭제하기 =");
		System.out.println("ArrayList : " + remove2(al)); // 8498
		System.out.println("LinkedList : " + remove2(ll)); // 0
		System.out.println();
		System.out.println("= 순차적으로 삭제하기 =");
		System.out.println("ArrayList : " + remove1(al)); // 16
		System.out.println("LinkedList : " + remove1(ll)); // 15
		System.out.println();

		// 중간에 작업하는 것까지 보면 LinkedList가 ArrayList보다 전체적으로 빠름
		// 단, 거의 대부분의 작업이 순차적으로 이루어 지기 때문에 ArrayList가 더 많이 사용됨
		// 중간에 하는 작업이 많을 경우 LinkedList로 작업하다가, 중간 작업이 끝나면 다시 ArrayList로 변환하여 작업하는 경우도 있다.
	}

	public static long add1(List list) {
		long start = System.currentTimeMillis();
		// 현재 시간을 밀리초 단위로 환산하여 저장
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
