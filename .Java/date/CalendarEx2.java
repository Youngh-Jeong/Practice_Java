import java.util.*;

class CalendarEx2 {
	public static void main(String[] args) {
		final String[] WEEK_DAY = {"", "��", "��", "ȭ", "��", "��", "��", "��"};
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		// date1�� 2019�� 3�� 15�Ϸ� �����ϰ�, date1�� date2�� ���
		// ��½� 'xxxx�� xx�� xx�� x����'�� ���
		date1.set(2019,2,15);
		System.out.println("date 1 : " + dateToString(date1));
		System.out.println("date 2 : " + dateToString(date2));
		
		long d1 = date1.getTimeInMillis(); // date1�� �и��ʷ� ȯ��
		long d2 = date2.getTimeInMillis(); // date2�� �и��ʷ� ȯ��
		
		long diff = (d2 - d1) / (24*60*60*1000); // �� ��¥ ������ ������ �� ������ ȯ��
		System.out.println("���� : " + diff + "��");
		/*
		long diff = d2 - d1;
		Calendar dateTmp = date1;
		dateTmp.add(Calendar.DATE, 1);
		long dTmp = dateTmp.getTimeInMillis();
		long unitDate = dTmp-d1;
		int dateDiff = (int)(diff/unitDate);
		System.out.println("���� : " + dateDiff + "��");
		*/
		// date1�� date2 ������ ����ð��� '��(day)' ������ ���
	}
		//�޼ҵ� ��� ���
	public static String dateToString(Calendar date){
		final String[] WEEK_DAY = {"", "��", "��", "ȭ", "��", "��", "��", "��"};
		return date.get(Calendar.YEAR)+ "�� " + (date.get(Calendar.MONTH)+1) + "�� " + date.get(Calendar.DATE) + "�� " + WEEK_DAY[date.get(Calendar.DAY_OF_WEEK)] + "����";
	}
}
