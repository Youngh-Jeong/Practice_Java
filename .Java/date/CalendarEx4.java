import java.util.*;
class  CalendarEx4{
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();

		date.set(2020, 7, 31);
		System.out.println(toString(date));	//2020��8��31��
		System.out.println("= 1�� �� =");
		date.add(Calendar.DATE, 1);
		// date�� ��¥�� ��(day)�� ���� 1�� ����
		System.out.println(toString(date)); //2020��9��1��

		System.out.println("= 6���� �� =");
		date.add(Calendar.MONTH, -6);
		// add()�޼ҵ��� �� ��° �Ű����� amount�� ���� ������ �Է��ϸ� ���� ��¥�� ����
		System.out.println(toString(date)); //2020��3��1��

		System.out.println("= 31�� ��(roll) = ");
		date.roll(Calendar.DATE, 31);
		// date�� ��¥�� ��(day)�� ���� 31�� ����
		// �ٸ� �ʵ�� �������� �ʰ�, ���� ���� �ʵ常 �����
		System.out.println(toString(date)); //2020��3��1��

		System.out.println("= 31�� ��(add) = ");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date)); //2020��4��1��
	}

	public static String toString(Calendar date){
		return date.get(Calendar.YEAR) + "��" + (date.get(Calendar.MONTH) + 1) + "��" + date.get(Calendar.DATE) + "��";
	}
}