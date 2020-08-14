import java.awt.*;
import javax.swing.*;

class  BorderLayoutManager{
	public static void main(String[] args) {
		JFrame frm = new JFrame("FlowLayout Test");
		frm.setBounds(120,120,300,200);
		frm.setLayout(new BorderLayout());

		frm.add(new JButton("EAST"), BorderLayout.EAST);
		frm.add(new JButton("WEST"), BorderLayout.WEST);
		frm.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		frm.add(new JButton("North"), BorderLayout.NORTH);
		frm.add(new JButton("CENTER"), BorderLayout.CENTER);

		// center를 제외하고 다른 영역을 채우지 않으면 주변의 다른 영역에서 그 자리를 채워줌
		// 단, center는 채워주지 않음

		frm.setVisible(true);
	}
}
