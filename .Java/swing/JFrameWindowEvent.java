import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class  WindowEventHandler implements WindowListener{
	String frameInfo;
	public WindowEventHandler(String info){
		frameInfo = info;
	}
	public void windowActivated(WindowEvent e){
	// 프레임이 활성화될 때 호출
		System.out.println(frameInfo + "windowActivated");
	}
	public void windowClosed(WindowEvent e){
	// 프레임 닫히고 난 후(windowClosing 이후)
		System.out.println(frameInfo + "windowClosed");
	}
	public void windowClosing(WindowEvent e){
	// 프레임이 닫힐 때
		JFrame frm = (JFrame)e.getWindow();
		frm.dispose();
		// 해당 프레임을 메모리에서 내려줌(프로그램 종료)
		System.out.println(frameInfo + "windowClosing");
	}
	public void windowDeactivated(WindowEvent e){
	// 프레임이 비활성화 될 때
		System.out.println(frameInfo + "windowDeactivated");
	}
	public void windowIconified(WindowEvent e){
	// 프레임이 최소화 될 때
		System.out.println(frameInfo + "windowIconified");
	}
	public void windowDeiconified(WindowEvent e){
	// 최소화된 프레임이 다시 올라올 때
		System.out.println(frameInfo + "windowDeiconified");
	}
	public void windowOpened(WindowEvent e){
	// 프레임이 열릴 때
		System.out.println(frameInfo + "windowOpened");
	}
}


class JFrameWindowEvent{
	public static void main(String[] args) {
		JFrame frmOne = new JFrame("Frame One");
		JFrame frmTwo = new JFrame("Frame Two");

		frmOne.setBounds(120,120,250,150);
		frmTwo.setBounds(380,120,250,150);

		frmOne.addWindowListener(new WindowEventHandler("Frame One"));
		frmTwo.addWindowListener(new WindowEventHandler("Frame Two"));

		frmOne.add(new JButton("button one"));
		frmTwo.add(new JButton("button two"));
		frmOne.setVisible(true);
		frmTwo.setVisible(true);
	}
}
