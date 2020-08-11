import java.util.*;

class  IteratorListIteratorEx{
	public static void main(String[] args){
		ArrayList list = new ArrayList();
		list.add("1");	list.add("2");	list.add("3");
		list.add("4");	list.add("5");	list.add("6");

		Iterator it = list.iterator();
		while (it.hasNext()){
			Object obj = it.next();
			System.out.print(obj + "  ");
		}
		System.out.println("\n");

		// ListIterator를 이용하여 순방향과 역방향으로 각각 데이터를 출력

		ListIterator lit = list.listIterator();
		while (lit.hasNext()){
			Object obj = lit.next();
			System.out.print(obj + "  ");
		}
		System.out.println("\n");
		while (lit.hasPrevious()){
			Object obj = lit.previous();
			System.out.print(obj+ "  ");
		}
		System.out.println("\n");
	}
}
