import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Q4_1_1{
	public static void main(String[] args) {
		// stack�� ��� �����϶�s
	}
}
public class IntStack{
	private int max;
	private int ptr;
	private int[] stk;
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		}catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	public void push(int x) throws OverflowIntStackException{
		if (ptr>=max) {
			throw new OverflowIntStackException();
		}
		stk[ptr++] = x;
	}
	public int pop() throws EmptyIntStackException{
		if (ptr<=0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}
	public int peek() throws EmptyIntStackException{
		if (ptr<=0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr-1];
	}
	public int indexOf(int flag) throws EmptyIntStackException{
		if (ptr<=0) {
			throw new EmptyIntStackException();
		}
		for (int i = ptr-1; i>=0;i--) {
			if(stk[i]==flag) {
				return i;
			} 
		}
		return -1;
	}
	public void clear() {
		ptr = 0;
	}
	public int capacity() {
		return max;
	}
	public int size() {
		return ptr;
	}
	public boolean isEmpty() {
		return (ptr<=0);
	}
	public boolean isFull() {
		return (ptr>=max);
	}
	public void dump() {
		if (ptr<=0) {
			System.out.println("������ ����ֽ��ϴ�.");
		} else {
			for (int i = 0; i<ptr;i++) {
				System.out.print(stk[i]+" ");
			}
		}
	}
}
