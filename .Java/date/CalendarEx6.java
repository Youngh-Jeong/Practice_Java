import java.util.*;

class  CalendarEx6{
	public static void main(String[] args) {
		int year;
		int month;
		Calendar sdate = Calendar.getInstance();	// ������
		if (args.length == 2){ // ��� �Է�������
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
		} else { // �Է� ��������
			year = sdate.get(Calendar.YEAR);
			month = sdate.get(Calendar.MONTH) + 1;
		}
		sdate.set(year, month - 1, 1);
		// �Է¹��� �⵵�� ���� �̿��Ͽ� �������� ����(���� -1�� �ؾ� ��)
		int startWeekDay = 0, endDay = 0;
		Calendar edate = Calendar.getInstance();	// ������
		edate.set(year, month, 1);		// �������� ������ 1��
		edate.add(Calendar.DATE, -1);	// ������ 1�Ͽ��� �Ϸ縦 �� ��¥(���ۿ��� ����)
		startWeekDay = sdate.get(Calendar.DAY_OF_WEEK); // �������� ���Ϲ�ȣ���� 1���� ���� ��ġ
		endDay = edate.get(Calendar.DATE); // ����

		System.out.println("      " + year + "��" + month + "��");
		System.out.println(" SU MO TU WE TH FR SA");
		for (int i = 1;i<startWeekDay ;i++ ){
			System.out.print("   "); 
		} // 1���� ������ġ�� ��� ���� for��
		for (int i = 1, n = startWeekDay;i<=endDay ;i++, n++ ){
			// i: ��¥�� ��(day)�κ��� ����� ����,  n: ���Ϲ�ȣ ������� �������� ������ ���� �ٷ� ������ ���� �뵵 
			System.out.print((i<10) ? "  " + i : " " + i);
			// ��(day)�� 10�̸��� ������ ��� �ڸ��� �� ĭ �� ���
			if (n%7 == 0){ System.out.println();}
			// �������� �������Ƿ� ���� �ٷ� ����
		}
	}
}
