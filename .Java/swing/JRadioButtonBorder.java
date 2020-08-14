import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

class CheckBoxHandler implements ItemListener{
	JRadioButton rdo1, rdo2, rdo3;
	public CheckBoxHandler(JRadioButton rdo1, JRadioButton rdo2, JRadioButton rdo3){
		this.rdo1 = rdo1;
		this.rdo2 = rdo2;
		this.rdo3 = rdo3;
	}
	public void itemStateChanged(ItemEvent e){
		if (e.getStateChange() == ItemEvent.SELECTED){
			rdo1.setEnabled(true);
			rdo2.setEnabled(true);
			rdo3.setEnabled(true);
		} else {
			rdo1.setEnabled(false);
			rdo2.setEnabled(false);
			rdo3.setEnabled(false);
		}
	}
}

class  JRadioButtonBorder{
	public static void main(String[] args){
		JFrame frm = new JFrame("Choice Component Border");
		frm.setBounds(120, 120, 200, 200);
		frm.setLayout(new FlowLayout());

		JCheckBox chk = new JCheckBox("Are you a programmer");
		JRadioButton rdo1 = new JRadioButton("I like C");
		JRadioButton rdo2 = new JRadioButton("I like C++");
		JRadioButton rdo3 = new JRadioButton("I like Java", true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdo1);	bg.add(rdo2);	bg.add(rdo3);
		
		Border rdoBorder = BorderFactory.createEtchedBorder();
		rdoBorder = BorderFactory.createTitledBorder(rdoBorder, "Language");

		JPanel rdoPanel = new JPanel();
		rdoPanel.setLayout(new GridLayout(0, 1));
		rdoPanel.setBorder(rdoBorder);

		rdoPanel.add(rdo1);
		rdoPanel.add(rdo2);
		rdoPanel.add(rdo3);

		chk.addItemListener(new CheckBoxHandler(rdo1, rdo2, rdo3));
		frm.add(chk);	frm.add(rdoPanel);
		rdo1.setEnabled(false);	rdo2.setEnabled(false);	rdo3.setEnabled(false);
		
		rdo1.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED){
					// 이벤트가 일어난 컴포넌트의 상태가 '선택'되어있는 상태라면
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
