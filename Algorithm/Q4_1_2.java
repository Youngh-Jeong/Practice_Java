import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Q4_1_2{
	public static void main(String[] args) {
		// <E>에 대한 stack을 모두 구현하라
	}
}
public class GStack<E>{
	private int max;
	private int ptr;
	private E[] stk;
	
	public class EmptyGStackException extends RuntimeException{
		public EmptyGStackException() {}
	}
	public class OverflowGStackException extends RuntimeException{
		public OverflowGStackException() {}
	}
	public GStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new E[max];
		}catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	public void push(int x) throws OverflowGStackException{
		if (ptr>=max) {
			throw new OverflowGStackException();
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
	public E indexOf(int flag) throws EmptyIntStackException{
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
			System.out.println("스택이 비어있습니다.");
		} else {
			for (int i = 0; i<ptr;i++) {
				System.out.print(stk[i]+" ");
			}
		}
	}
}
