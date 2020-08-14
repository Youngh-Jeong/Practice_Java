/*
두 개의 버튼을 FlowLayout으로 배치하고 그 중 첫번째 버튼에 이벤트 리스너를 장착
첫번째 버튼을 클릭하면 콘솔창에 '버튼이 클릭되었습니다.' 라고 출력되게 작업
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  MouseEventHandler implements MouseListener{
		public void mouseClicked(MouseEvent e){
			JButton button = (JButton)e.getComponent();
			System.out.println("버튼이 클릭되었습니다.");
		}

		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		// MouseListener가 인터페이스이므로 MouseListener내의 모든 메소드들을 구현해야 함
		// 메소드내에서 할 작업이 없으면 빈 중괄호를 입력하여 구현해야 함
}


class JButtonMouseEvent{
	public static void main(String[] args) {
		JFrame frm = new JFrame("Mouse Event");
		frm.setBounds(120,120,400,100);
		frm.setLayout(new FlowLayout());


		MouseListener listener = new MouseEventHandler();
		JButton btn1 = new JButton("1st Button");
		btn1.addMouseListener(listener);
		JButton btn2 = new JButton("2nd Button");
		btn2.setEnabled(false);
		// 비활성화

		frm.add(btn1);	frm.add(btn2);

		frm.setVisible(true);
	}
}
