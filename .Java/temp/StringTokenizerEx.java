import java.util.*;
class StringTokenizerEx{
	public static void main(String[] args) {
		String str1 = "1+2-3*4/2";
		StringTokenizer st1 = new StringTokenizer(str1, "+-*/");
		while (st1.hasMoreTokens()){
			System.out.print(st1.nextToken() + "  ");
		}
		System.out.println();
		//1  2  3  4  2

		StringTokenizer st2 = new StringTokenizer(str1, "+-*/", true);
		while (st2.hasMoreTokens()){
		System.out.print(st2.nextToken() + "  ");
		}
		System.out.println();
		//1  +  2  -  3  *  4  /  2
	}
}
