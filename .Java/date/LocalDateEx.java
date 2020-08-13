import java.time.*;
import java.time.temporal.*;


class  LocalDateEx{
	public static void main(String[] args) {
		int year;
		int month;
		LocalDate bDate;

		if (args.length == 2){ // ��� �Է�������
			bDate = LocalDate.of(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 1);
		} else { // �Է� ��������
			bDate = LocalDate.now();
			bDate = bDate.withDayOfMonth(1);
		}
		year = bDate.getYear();	month = bDate.getMonthValue();


		int startWeekDay = 0, endDay = 0;
		startWeekDay = (((bDate.getDayOfWeek()).getValue())%7)+1; // LocalDate�� 1~7(��~��), Calendar�� 1~7(��~��)
		endDay = bDate.lengthOfMonth();// ����

		System.out.println("      " + year + "��" + month + "��");
		System.out.println(" SU MO TU WE TH FR SA");
		for (int i = 1;(i)<startWeekDay ;i++ ){
			System.out.print("   "); 
		} // 1���� ������ġ�� ��� ���� for��
		for (int i = 1, n = startWeekDay;i<=endDay ;i++, n++ ){
			// i: ��¥�� ��(day)�κ��� ����� ����,  n: ���Ϲ�ȣ ������� �������� ������ ���� �ٷ� ������ ���� �뵵 
			System.out.print((i<10) ? "  " + i : " " + i);
			// ��(day)�� 10�̸��� ������ ��� �ڸ��� �� ĭ �� ���
			if ((n)%7 == 0){ System.out.println();}
			// �������� �������Ƿ� ���� �ٷ� ����
		}
	}
}
