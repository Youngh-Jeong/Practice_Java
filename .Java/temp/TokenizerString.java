import java.util.*;

class  TokenizerString {
	public static void main(String[] args) {
		String strData = "11:22:33:44:55";
		StringTokenizer st = new StringTokenizer(strData, ":");

		while (st.hasMoreTokens()){
			// st�� ��ū�� �� ������
			System.out.println(st.nextToken());
		}
		// StringTokenizer�� �� �� ������ ������ �������� �� �� ����. �ٽ� ����Ϸ��� ���� ������ ��

		// ������ ����� StringŬ������ split()�޼ҵ�� ǥ��

		String[] data = strData.split(":");
		// strData�� ���ڿ��� ":"�� �������� �߶� ���ڿ� �迭 arr�� ����
		for (int i = 0;i<data.length ;i++ )	{
			System.out.println(data[i]);
		}
	}
}
