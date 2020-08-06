import java.util.*;
class StringTokenizerEx{
	public static void main(String[] args) {
		String str1 = "1+2-3*4/2";
		StringTokenizer st1 = new StringTokenizer(str1, "+-*/");
		// 구분자로 여러 글자를 입력하면 각 글자별로 구분자로 취급
		// StringTokenizer 에서는 구분자는 한 글자만 허용되므로 여러 글자 입력시 각 글자별로 구분자가 됨
		while (st1.hasMoreTokens()){
			System.out.print(st1.nextToken() + "  ");
		}
		System.out.println();
		//1  2  3  4  2

		StringTokenizer st2 = new StringTokenizer(str1, "+-*/", true);
		// true : 구분자를 토큰으로 취급
		while (st2.hasMoreTokens()){
		System.out.print(st2.nextToken() + "  ");
		}
		System.out.println();
		//1  +  2  -  3  *  4  /  2
	}
}
