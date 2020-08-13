import java.time.*;
import java.time.temporal.*;


class  TimeEx1{
	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		// ���� ��¥�� �̿��Ͽ� LocalDate ��ü ����
		LocalDate bDate = LocalDate.of(1999, 12, 31);
		// Ư�� ��¥(1999�� 12�� 31��)�� �̿��Ͽ� LocalDate ��ü ����

		System.out.println("today : " + today); // today : 2020-08-13
		System.out.println("bDate : " + bDate); // bdate : 1999-12-31

		System.out.println(bDate.withYear(2000)); // 2000-12-31
		// bDate.withYear(2000) : bDate�� ��¥���� �⵵�� 2000������ ����
		System.out.println(bDate.plusDays(1)); // 2000-01-01
		// bDate.plusDays(1): bDate�� ��¥�� 1���� ���϶�� �ǹ�
		System.out.println(bDate.plus(1, ChronoUnit.DAYS)); // 2000-01-01
		// bDate.plus(1, ChronoUnit.DAYS) : bDate�� ��¥�� ��(day)�� �ش��ϴ� ���� 1�� ���϶�� �ǹ�

		System.out.println(bDate.minusMonths(1)); // 1999-11-30
		// bDate.minusMOnths(1) : bDate�� ��¥�� 1���� ����� �ǹ�
		System.out.println(bDate.minusWeeks(1)); // 1999-12-24
		// bDate.minusWeeks(1) : bDate�� ��¥�� 1��(7��)�� ����� �ǹ�
		System.out.println(bDate.minus(10, ChronoUnit.DAYS)); // 1999-12-21
		// with()�� plus(), minus() ��� ��¥�� �����Ű���� ������ �ƴ� ���ο� ��ü�� �����ϴ� ���
	}
}
