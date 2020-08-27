import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Q4_1_5{
	public static void main(String[] args) {
		// IntQueue ±¸Çö
	}
}
public class IntQueue{
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		}catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	public void enque(int x) throws OverflowIntQueueException{
		if(num>=max) throw new OverflowIntQueException();
		que[rear++] = x;
		num++;
		if (rear == max) rear = 0;
	}
	public int deque() throws EmptyIntQueueException{
		if(num<=0) throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if(front==max) front = 0;
		return x;
	}
	public int peek() throws EmptyIntQueueException{
		if(num<=0) throw new EmptyIntQueueException();
		return que[front];
	}
	public int indexOf(int x) {
		for (int i = 0; i<num;i++) {
			int idx = (i + front)%max;
			if(que[idx]==x) return idx;
		}
		return -1;
	}
	public void clear() {
		num = front = rear = 0;
	}
	public int capacity() {
		return max;
	}
	public int size() {
		return num;
	}
	public boolean isEmpty() {
		return num<=0;
	}
	public boolean isFull() {
		return num>=max;
	}
	public int search(int x) {
		for(int i = 0; i<num; i++) {
			if(que[(i+front)%max]==x) {
				return i+1;
			}
		}
		return 0;
	}
}
