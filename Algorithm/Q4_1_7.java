import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Q4_1_7{
	public static void main(String[] args) {
		// IntQueue를 양방향으로 구현
	}
}
public class IntDequeue{
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	public class EmptyIntDequeueException extends RuntimeException{
		public EmptyIntDequeueException() {}
	}
	public class OverflowIntDequeueException extends RuntimeException{
		public OverflowIntDequeueException() {}
	}
	public IntDequeue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		}catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	public void frontEnque(int x) throws OverflowIntDequeueException{
		if(num>=max) throw new OverflowIntDequeueException();
		if (--front<0) front = max-1;
		que[front] = x;
		num++;
	}
	public void rearEnque(int x) throws OverflowIntDequeueException{
		if(num>=max) throw new OverflowIntDequeueException();
		que[rear++] = x;
		num++;
		if (rear == max) rear = 0;
	}
	public int frontDeque() throws EmptyIntDequeueException{
		if(num<=0) throw new EmptyIntDequeueException();
		int x = que[front++];
		num--;
		if(front==max) front = 0;
		return x;
	}
	public int rearDeque() throws EmptyIntDequeueException{
		if(num<=0) throw new EmptyIntDequeueException();
		if (--rear<0) rear = max;
		int x = que[rear-1];
		num--;
		return x;
	}
	public int peek() throws EmptyIntDequeueException{
		if(num<=0) throw new EmptyIntDequeueException();
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
