import java.util.*;

// ���������� '�ڷΰ���'�� '�����ΰ���'�� Stack�� �̿��Ͽ� ������ ���α׷�
class StackEx{
	public static Stack back = new Stack(); // �ڷΰ��� �����丮�� ������ ����
	public static Stack forward = new Stack(); // ������ ���� �����丮�� ������ ����

	public static void main(String[] args) {
		goURL("1.����Ʈ");		goURL("2.����");
		goURL("3.���̹�");		goURL("4.����");
		// Ư�� �ּҷ� �̵���Ŵ - �ڷ� ���� �����丮���� ����
		printStatus();
		//back : [1.����Ʈ, 2.����, 3.���̹�, 4.����]
		//forward : []
		//���� ȭ���� '4.����' �Դϴ�.
		goBack();		
		System.out.println("= �ڷΰ��� ��ư�� ���� �� =");
		printStatus();
		//back : [1.����Ʈ, 2.����, 3.���̹�]
		//forward : [4.����]
		//���� ȭ���� '3.���̹�' �Դϴ�.
		goBack();		
		System.out.println("= �ڷΰ��� ��ư�� ���� �� =");
		printStatus();
		//back : [1.����Ʈ, 2.����]
		//forward : [4.����, 3.���̹�]
		//���� ȭ���� '2.����' �Դϴ�.

		goForward();		
		System.out.println("= �����ΰ��� ��ư�� ���� �� =");
		printStatus();
		//back : [1.����Ʈ, 2.����, 3.���̹�]
		//forward : [4.����]
		//���� ȭ���� '3.���̹�' �Դϴ�.

		goURL("google.com");
		System.out.println("= ���ο� �ּҷ� �̵� �� =");
		printStatus();
		//back : [1.����Ʈ, 2.����, 3.���̹�, google.com]
		//forward : []
		//���� ȭ���� 'google.com' �Դϴ�.
	}

	public static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("���� ȭ���� '" + back.peek() + "' �Դϴ�.");
		// peek() : Stack�� �� �� �����͸� ���� (������ �״��)
		System.out.println();
	}
	public static void goURL(String url){
		back.push(url);
		// �޾ƿ� url�� back�� ����
		if (!forward.empty()) forward.clear();
		// forward(�����ΰ��� �����丮)�� ������� ������ forward�� ���
	}
	public static void goForward() {
		if (!forward.empty()) back.push(forward.pop());
		// forward�� ������� ������ back�� forward�� �� �� �����͸� �̾Ƴ��� �����Ŵ
	}
	public static void goBack() {
		if (!back.empty()) forward.push(back.pop());
		// back�� ������� ������ forward�� back�� �� �� �����͸� �̾Ƴ��� �����Ŵ
	}
}
