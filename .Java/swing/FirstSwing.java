import java.awt.*;
import javax.swing.*;

class  FirstSwing{
	public static void main(String[] args) {
		JFrame frm = new JFrame("First Swing");
		// 프레임의 타이틀바에서 보여줄 문자열을 매개변수로 하여 프레임 생성

		frm.setBounds(120, 120, 400, 100);
		// setBounds() : 프레임의 위치와 크기를 지정하는 메소드
		// (X좌표, Y좌표, 넓이, 높이
		frm.setLayout(new FlowLayout());
		// 프레임 내에서 컴포넌트들을 배치하는 방법을 지정

		JButton btn1 = new JButton("1st Button");
		JButton btn2 = new JButton("2nd Button");
		JButton btn3 = new JButton("3rd Button");
		// 버튼을 캡션과 함께 생성

		frm.add(btn1);	frm.add(btn2);	frm.add(btn3);
		// 생성한 버튼들을 프레임(frm)에 올림
		frm.setVisible(true);
	}
}
