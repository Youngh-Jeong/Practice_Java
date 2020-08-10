import java.util.*;

class  VectorEx{
	public static void main(String[] args) {
		Vector v = new Vector(5);
		v.add("1");	v.add("2");	v.add("3");
		print(v);
		//[1, 2, 3]
		//size: 3
		//capacity: 5

		v.trimToSize(); // 용량을 크기에 맞춰 줄임
		System.out.println("==After trimToSize()==");
		print(v);
		//[1, 2, 3]
		//size: 3
		//capacity: 3

		v.ensureCapacity(6); // 최소 용량을 6으로 지정
		System.out.println("==After ensureCapacity(6)==");
		print(v);
		//[1, 2, 3]
		//size: 3
		//capacity: 6
		
		v.setSize(7); // 크기를 7로 지정(ArrayList에 없음), 빈 공간을 null로 채움
		System.out.println("==After setSize(7)==");
		print(v);
		//[1, 2, 3, null, null, null, null]
		//size: 7
		//capacity: 12

		v.clear();
		System.out.println("==After clear()==");
		print(v);
		//[]
		//size: 0
		//capacity: 12
	}
	public static void print(Vector v) {
		System.out.println(v);
		System.out.println("size: " + v.size());
		System.out.println("capacity: " + v.capacity());
	}
}
