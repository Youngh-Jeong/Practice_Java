import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ActionEventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		// 컴포넌트별 기본 동작시 호출되는 메소드 (버튼은 클릭)
		System.out.println(e.getActionCommand());
	}
} 


class  JButtonActionEvent{
	public static void main(String[] args) {
		JFrame frm = new JFrame("Action Event");
		frm.setBounds(120,120,250,150);
		frm.setLayout(new FlowLayout());

		JButton btn1 = new JButton("btnOne");
		JButton btn2 = new JButton("btnTwo");
		
		ActionListener action = new ActionEventHandler();
		btn1.addActionListener(action);
		btn2.addActionListener(action);
		// 버튼에 ActionListener 장착
		
		frm.add(btn1);	frm.add(btn2);
		btn2.setEnabled(false);
		// btn2를 비활성화

		frm.setVisible(true);
	}
}
