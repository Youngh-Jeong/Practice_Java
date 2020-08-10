import java.util.*;

class  StackQueueEx{
	public static void main(String[] args){
		Stack st = new Stack();
		Queue q = new LinkedList();
		// LinkedList�� �ƴ� Queue�μ� ������ �Ǹ�, Queue�� ��ɵ� ���� ����ϰ� ��
		// Queue�� LinkedList�� ����Ŭ����(�����δ� �������̽�) �����̹Ƿ� JVM�� q�� LinkedList�� �ƴ� Queue�� �ν��Ͻ��� �ν�

		st.push("0");		st.push("1");		st.push("2");
		// ���� st�� �� ���� ��ü�� ����

		q.offer("0");		q.offer("1");		q.offer("2");
		// ť q�� �� ���� ��ü�� ����
		System.out.println("==Stack==");
		while (!st.empty()){
		//st�� �� ������ ������ ���鼭 st�� ��ü�� �ϳ��� �����Ͽ� ���
			System.out.print(st.pop() + " ");
		}
		// ������ ������ st�� ��� ��
		System.out.println();
		System.out.println("==Queue==");
		while (!q.isEmpty()){
		//q�� �� ������ ������ ���鼭 q�� ��ü�� �ϳ��� �����Ͽ� ���
			System.out.print(q.poll() + " ");
		}
		//������ ������ q�� ��� ��

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
