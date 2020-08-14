import java.awt.*;
import javax.swing.*;

class  FlowLayoutManager{
	public static void main(String[] args) {
		JFrame frm = new JFrame("FlowLayout Test");
		frm.setBounds(120,120,400,200);
		frm.setLayout(new FlowLayout());
		// 기본적으로 프레임의 중앙에 컴포넌트들을 배치하며, 프레임의 넓이가 좁을 경우 컴포넌트들이 아래로 내려감

		frm.add(new JButton("Hi!"));
		frm.add(new JButton("Swing"));
		frm.add(new JButton("Button"));

		frm.add(new JButton("Hi2!"));
		frm.add(new JButton("Swing2"));
		frm.add(new JButton("Button2"));
	
		frm.setVisible(true);
	}
}
