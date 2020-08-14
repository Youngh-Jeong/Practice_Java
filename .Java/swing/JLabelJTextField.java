import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LoginHandler implements ActionListener{
	JTextField id; // 한 줄의 문자열을 입력받는 컴포넌트
	JPasswordField pw; // JTextField의 하위클래스로 암호를 입력받기 위한 컴포넌트
	public LoginHandler(JTextField id, JPasswordField pw){
		this.id = id;
		this.pw = pw;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("ID : " + id.getText());
		// id내부에 입력된 문자열을 가져와서 출력
		System.out.println("Password : " + new String(pw.getPassword()));
		// getPassword() : PasswordField의 데이터를 char형 배열로 리턴
		// char형 배열을 바로 출력하기 위해 String인스턴스로 생성
		id.setText("");	pw.setText("");
		// id와 pw의 값을 지움
	}
}

class  JLabelJTextField{
	public static void main(String[] args){
		JFrame frm = new JFrame("JLabel & JTextField");
		frm.setBounds(120,120,180,80);
		frm.setLayout(new GridLayout(2,2));

		JLabel lblId = new JLabel("ID ", SwingConstants.RIGHT);
		// "ID "라는 문자열을 오른쪽 정렬시킴
		JTextField txtId = new JTextField(10);
		// 10자가 보일정도의 크기를 가진 텍스트필드 txtId생성

		JLabel lblPw = new JLabel("Password  ", SwingConstants.RIGHT);
		JPasswordField txtPw = new JPasswordField(10);
		txtPw.setEchoChar('*');
		// 입력된 글자 대신 보여줄 문자 지정

		txtPw.addActionListener(new LoginHandler(txtId, txtPw));
		// txtPw에 actionListener 장착

		frm.add(lblId); frm.add(txtId);
		frm.add(lblPw);	frm.add(txtPw);

		frm.setVisible(true);
		frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
