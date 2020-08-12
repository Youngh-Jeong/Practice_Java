import java.util.*;
class CalendarEx1{
	public static void main(String[] args){
		Calendar today = Calendar.getInstance();
		// static�޼ҵ��� getInstance()�� ���� ��¥ �� �ð� �ν��Ͻ� ����
		// Calendar �ν��Ͻ��� �����Ǹ� �⺻������ ���� ��¥ �� ���� �ð��� ������

		System.out.println("�� ���� �⵵ : " + today.get(Calendar.YEAR)); // 2020
		System.out.println("��(0-11) : " + today.get(Calendar.MONTH)); // 7
		//���� 0�� 1���̰�, 12���� 11�� ǥ����
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_YEAR)); // 33
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_MONTH)); // 3
		System.out.println("���� �� �� : " + today.get(Calendar.DATE)); // 12
		System.out.println("���� �� �� : " + today.get(Calendar.DAY_OF_MONTH)); // 12
		// Date�� DAY_OF_MONTH �� ������ ���� ����
		System.out.println("���� �� �� : " + today.get(Calendar.DAY_OF_YEAR)); // 225
		System.out.println("����(1-7, 1:�Ͽ���) : " + today.get(Calendar.DAY_OF_WEEK)); // 4
		System.out.println("���� �� ° ���� : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // 2
		System.out.println("����(0)_����(1) : " + today.get(Calendar.AM_PM)); // 0
		System.out.println("�ð�(0-11) : " + today.get(Calendar.HOUR)); // 10
		System.out.println("�ð�(0-23) : " + today.get(Calendar.HOUR_OF_DAY)); // 10
		System.out.println("��(0-59) : " + today.get(Calendar.MINUTE)); // 12
		System.out.println("��(0-59) : " + today.get(Calendar.SECOND)); // 12
		System.out.println("�и���(0-999) : " + today.get(Calendar.MILLISECOND)); // 394
		System.out.println("���� : " + today.getActualMaximum(Calendar.DATE)); // 31
	}
}
