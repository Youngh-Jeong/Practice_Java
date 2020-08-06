import java.util.*;

class  TokenizerString {
	public static void main(String[] args) {
		String strData = "11:22:33:44:55";
		StringTokenizer st = new StringTokenizer(strData, ":");

		while (st.hasMoreTokens()){
			// st에 토큰이 더 있으면
			System.out.println(st.nextToken());
		}
		// StringTokenizer는 한 번 루프를 돌리면 다음에는 돌 수 없음. 다시 사용하려면 새로 만들어야 함

		// 동일한 결과를 String클래스의 split()메소드로 표현

		String[] data = strData.split(":");
		// strData의 문자열을 ":"을 기준으로 잘라 문자열 배열 arr로 만듦
		for (int i = 0;i<data.length ;i++ )	{
			System.out.println(data[i]);
		}
	}
}
