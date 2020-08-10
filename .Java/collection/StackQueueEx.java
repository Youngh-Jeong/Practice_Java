import java.util.*;

class  StackQueueEx{
	public static void main(String[] args){
		Stack st = new Stack();
		Queue q = new LinkedList();
		// LinkedList가 아닌 Queue로서 생성이 되며, Queue의 기능들 만을 사용하게 됨
		// Queue가 LinkedList의 상위클래스(실제로는 인터페이스) 개념이므로 JVM이 q를 LinkedList가 아닌 Queue형 인스턴스로 인식

		st.push("0");		st.push("1");		st.push("2");
		// 스택 st에 세 개의 객체를 저장

		q.offer("0");		q.offer("1");		q.offer("2");
		// 큐 q에 세 개의 객체를 저장
		System.out.println("==Stack==");
		while (!st.empty()){
		//st가 빌 때까지 루프를 돌면서 st의 객체를 하나씩 추출하여 출력
			System.out.print(st.pop() + " ");
		}
		// 루프가 끝나면 st는 비게 됨
		System.out.println();
		System.out.println("==Queue==");
		while (!q.isEmpty()){
		//q가 빌 때까지 루프를 돌면서 q의 객체를 하나씩 추출하여 출력
			System.out.print(q.poll() + " ");
		}
		//루프가 끝나면 q는 비게 됨

		/*
		System.out.println("==Stack==");
		final int STSIZE = st.size();
		for (int i = 0;i<STSIZE ;i++ ){
			System.out.print(st.pop() + " ");
		}
		System.out.println();
		System.out.println("==Queue==");
		final int QSIZE = q.size();
		for (int i = 0;i<QSIZE ;i++ ){
			System.out.print(q.poll() + " ");
			
		}*/
	}
}
