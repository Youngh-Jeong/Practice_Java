import java.util.*;
import java.text.*;

class  DateFormatEx{
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		// Calendar��ü�� �ν��Ͻ��� �̿��Ͽ� Date��ü ����
		//Date today = new Date();  : Calendar �Ⱦ��� Date�� ����
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf5, sdf6, sdf7, sdf8, sdf9;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");					// 2020-08-13
		sdf2 = new SimpleDateFormat("''yy�� MMM dd�� E����");			// '20�� 8�� 13�� �����
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");		// 2020-08-13 11:59:55.126
		sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");		// 2020-08-13 11:59:55 ����
		sdf5 = new SimpleDateFormat("������ �� ���� D��° ���Դϴ�.");		// ������ �� ���� 226��° ���Դϴ�.
		sdf6 = new SimpleDateFormat("������ �� ���� d��° ���Դϴ�.");		// ������ �� ���� 13��° ���Դϴ�.
		sdf7 = new SimpleDateFormat("������ �� ���� w��° ���Դϴ�.");		// ������ �� ���� 33��° ���Դϴ�.
		sdf8 = new SimpleDateFormat("������ �� ���� W��° ���Դϴ�.");		// ������ �� ���� 3��° ���Դϴ�.
		sdf9 = new SimpleDateFormat("������ �� ���� F��° E�����Դϴ�.");	// ������ �� ���� 2��° ������Դϴ�.

		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println();
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
	}
}

/*
G : ����(BC, AD)	/ y : �⵵	/ M : ��		/ w : ���� �� ° ��		/ W : ���� �� ° ��
D : ���� �� ° ��	/ d : ���� �� ° ��		/ F : ���� �� ° ����(1~5)	/ E : ����
a : ����/����		/ H : ��(0~23)	/ k : �ð�(1~24)	/ h : ��(0~11)	/ m : ��(0~59)
s : ��(0~59)		/ S : �и���(0~999)		/ ' : Ư������ ǥ��
*/