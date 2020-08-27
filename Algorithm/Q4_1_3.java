import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Q4_1_3{
	public static void main(String[] args) {
		// 한 array에 2개의 스택을 구현
	}
}
public class 2Stack{
	private int max1;
	private int ptr1;
	private int max2;
	private int ptr2;
	private int[] stk;
	
	public class EmptyGStackException extends RuntimeException{
		public EmptyGStackException() {}
	}
	public class OverflowGStackException extends RuntimeException{
		public OverflowGStackException() {}
	}
	public 2Stack(int capacity1, int capacity2) {
		max1 = capacity1;
		max2 = capacity2;
		tMax = max1 + max2;
		ptr1 = 0;
		ptr2 = tMax-1;
		try {
			stk = new E[tMax];
		}catch (OutOfMemoryError e) {
			tMax = 0;
		}
	}
	public void push1(int x) throws OverflowGStackException{
		if (ptr1>=max1) {
			throw new OverflowGStackException();
		}
		stk[ptr1++] = x;
	}
	public void push2(int x) throws OverflowGStackException{
		if (ptr2<max1) {
			throw new OverflowGStackException();
		}
		stk[ptr2--] = x;
	}
	public int pop1() throws EmptyIntStackException{
		if (ptr1<=0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr1];
	}
	public int pop2() throws EmptyIntStackException{
		if (ptr2>=tMax-1) {
			throw new EmptyIntStackException();
		}
		return stk[++ptr2];
	}
	public int peek1() throws EmptyIntStackException{
		if (ptr1<=0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr1-1];
	}
	public int peek2() throws EmptyIntStackException{
		if (ptr2>=tMax-1) {
			throw new EmptyIntStackException();
		}
		return stk[ptr2+1];
	}
	public int indexOf1(int flag) throws EmptyIntStackException{
		if (ptr1<=0) {
			throw new EmptyIntStackException();
		}
		for (int i = ptr1-1; i>=0;i--) {
			if(stk[i]==flag) {
				return i;
			} 
		}
		return -1;
	}
	public int indexOf2(int flag) throws EmptyIntStackException{
		if (ptr2>=tMax-1) {
			throw new EmptyIntStackException();
		}
		for (int i = max1; i<tMax;i++) {
			if(stk[i]==flag) {
				return i;
			} 
		}
		return -1;
	}
	public void clear1() {
		ptr1 = 0;
	}
	public void clear2() {
		ptr2 = tMax-1;
	}
	public int capacity1() {
		return max1;
	}
	public int capacity2() {
		return max2;
	}
	public int size1() {
		return ptr1;
	}
	public int size2() {
		return tMax-ptr2-1;
	}
	public boolean isEmpty1() {
		return (ptr1<=0);
	}
	public boolean isEmpty2() {
		return (ptr2>=tMax);
	}
	public boolean isFull1() {
		return (ptr1>=max1);
	}
	public boolean isFull() {
		return (ptr2<max1);
	}
}
