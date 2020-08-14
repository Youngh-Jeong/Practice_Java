import java.awt.*;
import javax.swing.*;

class  GridLayoutManager{
	public static void main(String[] args) {
		JFrame frm = new JFrame("FlowLayout Test");
		frm.setBounds(120,120,300,200);
		frm.setLayout(new GridLayout(3, 2));
		// GridLayout(3, 2) : 3행 2열의 표모양으로 레이아웃을 꾸밈
		// GridLayout(int rows, int cols, int hgap, int vgap)
		// rows: 행수 / cols : 열수 / hgap : 수평간격 / vgap : 수직간격
		// rows와 cols만으로 생성하기도 함

		frm.add(new JButton("One"));
		frm.add(new JButton("Two"));
		frm.add(new JButton("Three"));
		frm.add(new JButton("Four"));
		frm.add(new JButton("Five"));
		frm.add(new JButton("Six"));


		frm.setVisible(true);
	}
}
