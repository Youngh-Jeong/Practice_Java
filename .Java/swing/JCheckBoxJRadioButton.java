import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CheckBoxHandler implements ItemListener{
	JRadioButton rdo1, rdo2, rdo3;
	public CheckBoxHandler(JRadioButton rdo1, JRadioButton rdo2, JRadioButton rdo3){
		this.rdo1 = rdo1;
		this.rdo2 = rdo2;
		this.rdo3 = rdo3;
	}
	public void itemStateChanged(ItemEvent e){
	// 선택 상태가 변할 때 호출되는 메소드
		if (e.getStateChange() == ItemEvent.SELECTED){
			// 이벤트를 일으킨 e의 변화된 상태가 '선택'되어 있는 상태이면
			rdo1.setEnabled(true);
			rdo2.setEnabled(true);
			rdo3.setEnabled(true);
			// 라디오 버튼들을 활성화함
		} else { // ItemEvent.DESELECTED
			// 이벤트를 일으킨 e의 변화된 상태가 '비선택'되어 있는 상태이면
			rdo1.setEnabled(false);
			rdo2.setEnabled(false);
			rdo3.setEnabled(false);
			// 라디오 버튼들을 비활성화함
		}
	}
}

class  JCheckBoxJRadioButton{
	public static void main(String[] args){
		JFrame frm = new JFrame("Choice Component");
		frm.setBounds(120, 120, 200, 200);
		frm.setLayout(new GridLayout(0,1));
		// GridLayout(0,1) : 0은 마음대로 입력해도 된다는 의미

		JCheckBox chk = new JCheckBox("Are you a programmer");
		JRadioButton rdo1 = new JRadioButton("I like C");
		JRadioButton rdo2 = new JRadioButton("I like C++");
		JRadioButton rdo3 = new JRadioButton("I like Java", true);
		// JRadioButton 생성시 true를 넣으면 미리 선택되어 있는 상태로 열림
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdo1);	bg.add(rdo2);	bg.add(rdo3);
		// 세 개의 라디오버튼 중 하나만 선택되게 함
		
		chk.addItemListener(new CheckBoxHandler(rdo1, rdo2, rdo3));
		frm.add(chk);	frm.add(rdo1);	frm.add(rdo2);	frm.add(rdo3);
		rdo1.setEnabled(false);	rdo2.setEnabled(false);	rdo3.setEnabled(false);
		
		rdo1.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("I like C too");
				}
			}
		} );

		rdo2.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("I like C++ too");
				}
			}
		} );

		rdo3.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("I like Java too");
				}
			}
		} );

		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
