import java.awt.*;
import javax.swing.*;

class  FirstAwt{
	public static void main(String[] args) {
		Frame frm = new Frame("First AWT");
		// �������� Ÿ��Ʋ�ٿ��� ������ ���ڿ��� �Ű������� �Ͽ� ������ ����

		frm.setBounds(120, 120, 400, 100);
		// setBounds() : �������� ��ġ�� ũ�⸦ �����ϴ� �޼ҵ�
		// (X��ǥ, Y��ǥ, ����, ����
		frm.setLayout(new FlowLayout());
		// ������ ������ ������Ʈ���� ��ġ�ϴ� ����� ����

		Button btn1 = new Button("1st Button");
		Button btn2 = new Button("2nd Button");
		Button btn3 = new Button("3rd Button");
		// ��ư�� ĸ�ǰ� �Բ� ����

		frm.add(btn1);	frm.add(btn2);	frm.add(btn3);
		// ������ ��ư���� ������(frm)�� �ø�
		frm.setVisible(true);
	}
}
