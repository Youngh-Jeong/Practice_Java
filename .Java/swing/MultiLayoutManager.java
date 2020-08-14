import java.awt.*;
import javax.swing.*;

class  MultiLayoutManager{
	public static void main(String[] args){
		JFrame frm = new JFrame("Multi Layout Manager");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new BorderLayout());
		// 프레임에는 BorderLayout을 사용

		JButton btn0 = new JButton("B0");	JButton btn1 = new JButton("B1");	
		JButton btn2 = new JButton("B2");	JButton btn3 = new JButton("B3");	
		JButton btn4 = new JButton("B4");	JButton btn5 = new JButton("B5");
		JButton btn6 = new JButton("B6");	JButton btn7 = new JButton("B7");
		JButton btn8 = new JButton("B8");	JButton btn9 = new JButton("B9");
		
		JPanel pan1 = new JPanel();
		// 프레임과 별도로 레이아웃을 지정할 수 있는 기능
		pan1.setLayout(new FlowLayout());
		// pan1이라는 JPanel의 레이아웃을 FlowLayout으로 지정
		pan1.add(btn0);		pan1.add(btn1);
		pan1.add(btn2);		pan1.add(btn3);

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(2,3,2,2));
		// pan2라는 JPanel의 레이아웃을 GridLayout으로 지정 (2행 3열)
		pan2.add(btn4);		pan2.add(btn5);
		pan2.add(btn6);		pan2.add(btn7);
		pan2.add(btn8);		pan2.add(btn9);

		frm.add(pan1, BorderLayout.NORTH);
		frm.add(pan2, BorderLayout.CENTER);
		// 컴포넌트들이 배치된 JPanel을 프레임에 배치

		frm.setVisible(true);
	}
}
