import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  MouseEventHandler implements MouseListener{
		public void mouseClicked(MouseEvent e){
			JButton button = (JButton)e.getComponent();
			button.setText("Clicked");
			System.out.println("Clicked Button" + e.getButton());
			System.out.println("마우스 버튼 눌렸다 풀림");
		}

		public void mouseEntered(MouseEvent e){
		// 마우스 커서가 지정된 컴포넌트 위로 진입할 경우 호출되는 메소드
			System.out.println("커서 버튼 위 진입");
		}
		public void mouseExited(MouseEvent e){
		// 마우스 커서가 지정된 컴포넌트 위에서 벗어날 경우 호출되는 메소드
			System.out.println("커서 버튼 위 탈출");
		}
		public void mousePressed(MouseEvent e){
		// 마우스 버튼을 누를 경우 호출되는 메소드
			System.out.println("마우스 버튼 눌림");
		}
		public void mouseReleased(MouseEvent e){
		// 마우스 버튼을 눌렀다가 뗄 경우 호출되는 메소드
			System.out.println("마우스 버튼 풀림");
		}
}

class MouseEventEx{
	public static void main(String[] args) {
		JFrame frm = new JFrame("Mouse Event");
		frm.setBounds(120,120,400,100);
		frm.setLayout(new FlowLayout());


		MouseListener listener = new MouseEventHandler();
		// MouseListener 가 인터페이스 이므로 MouseListener를 구현한 클래스인 MouseEventHandler를 이용하여 인스턴스를 생성
		// 단, 인스턴스가 MouseListener로 선언되었기 때문에 인스턴스는 MouseListener형으로 사용할 수 있음 
		JButton btn1 = new JButton("1st Button");
		btn1.addMouseListener(listener);
		// btn1에 listener를 달아서 마우스 관련 이벤트를 감시하게 함

		JButton btn2 = new JButton("2nd Button");
		btn2.addMouseListener(listener);

		JButton btn3 = new JButton("2nd Button");
		btn3.addMouseListener(listener);

		frm.add(btn1);	frm.add(btn2);	frm.add(btn3);
		// 버튼 배치
		frm.setVisible(true);
		// 프레임 보여줌
	}
}
