/*
ģ�� �ּҷ� ���α׷�
1. ���
 - ģ�� ��� : ����ģ���� ����ģ���� �����Ͽ� ���(�޴� �����͵� ���̰� ��)
    ģ�� ������ �޸𸮿� ����(�迭�� ����)
 - ���� ��� : ��ϵ� ģ������ ������ �����ֱ�

2. Ŭ����
 - Friend : ���� ģ������ ����� Ŭ���� : ������ �������� ������ �ʰ� ģ���� �������� �κ��� ������ Ŭ���� 
 - HighFriend : Friend Ŭ������ ��ӹ޾� �⺻������ ������ ����ģ�� ���� ������ ������ Ŭ����
 - UnivFriend : Friend Ŭ������ ��ӹ޾� �⺻������ ������ ����ģ�� ���� ������ ������ Ŭ����
 - FriendHandler : ģ�� ������ �̿��� �۾��� ó���ϴ� Ŭ����
 - FriendInfoBook : ���α׷��� ���۰� ���Ḧ ��� (main()�޼ҵ尡 �ִ� Ŭ����)

FriendŬ������ HighFriend�� UnivFriend�� ����Ŭ�����̹Ƿ� FriendŬ���������� �� Ŭ������ ���� �� ����
�� Ŭ������ ������ ������� ������ �� �ְ� ����
*/
import java.util.*;

class Friend{
	String name, phone, addr;
	public Friend(String name, String phone, String addr){
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showData(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
		System.out.println("�ּ� : " + addr);
	}
	public void showBasicInfo(){}
	// ����Ŭ�������� �������̵��ϱ� ���� ����� �޼ҵ�
	public String getName(){return name;}
}

class HighFriend extends Friend{
	//FriendŬ������ ��ӹ޾����Ƿ� �⺻������ FriendŬ�������� �����ϰ� HighFriend������ ����ģ�� ���� ������ �����ϸ� ��
	String work;	// ����ģ�� ���� ����
	public HighFriend(String name, String phone, String addr, String job){
		super(name, phone, addr);
		// �޾ƿ� ������ �� �⺻������ �ش��ϴ� �������� ����Ŭ������ Friend�� �ø�
		work = job;
	}
	public void showData(){
		super.showData();
		// showData()�޼ҵ�� �������̵��Ǿ� �ֱ� ������ ����Ŭ������ ���� �޼ҵ带 ȣ���Ϸ��� super�� �̿��Ͽ� ȣ���ϴ� ���
		System.out.println("���� : " + work);
	}
	public void showBasicInfo(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
	}
}

class UnivFriend extends Friend{
	//FriendŬ������ ��ӹ޾����Ƿ� �⺻������ FriendŬ�������� �����ϰ� UnivFriend������ ����ģ�� ���� ������ �����ϸ� ��
	String major;	// ����ģ�� ���� ����
	public UnivFriend(String name, String phone, String addr, String major){
		super(name, phone, addr);
		this.major = major;
	}
	public void showData(){
		super.showData();
		System.out.println("���� : " + major);
	}
	public void showBasicInfo(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
		System.out.println("���� : " + major);
	}
}

class FriendHandler{
	// ��������� Ŭ������(Friend, HighFriend, UnivFriend)�� �̿��Ͽ� ���� �۾��� �ϴ� Ŭ����
	private Friend[] friends;
	//Friend�� �迭 friends�� ���� : HighFriend�� UnivFriend ����� �ν��Ͻ��� �����ϱ� ����
	private int numOfFriends;
	// friends �迭�� �ε����� �迭�� ����ִ� �������� ������ ǥ���ϴ� ����
	public FriendHandler(int num) {
		// �迭�� ������ �޾ƿͼ� friends�迭�� ����
		friends = new Friend[num];
		numOfFriends = 0;
		//friends�迭�� �߰��� �����Ͱ� �� �ε��� ��ȣ���� ���� ����ִ� �������� ����
	}
	private void addFriendInfo(Friend fren){
	// ���� Ŭ���� ���ο����� ����ؾ� �ϴ� �޼ҵ��̹Ƿ� private���� �����
	// ģ�������� ���� �ν��Ͻ��� friends�迭�� �����ϴ� �޼ҵ�
	// �Ű������� �ڷ����� Friend�� �Ͽ� HighFriend�� UnivFriend ��� ���� �� �ְ� ��
		friends[numOfFriends] = fren;
		// friends�迭�� �޾ƿ� �����͸� ����
		numOfFriends++;
		// ������ ���� �������� �ε�����ȣ�� 1 ����
	}
	public void addFriend(int choice){
		// ������ ģ�������� ����ڿ��� �Է¹޴� �޼ҵ�
		String name, phone, addr, work, major;
		// �Է¹��� �������� ������ ������
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : "); name = sc.nextLine();
		System.out.print("��ȭ : "); phone = sc.nextLine();
		System.out.print("�ּ� : "); addr = sc.nextLine();
		// ģ�� �⺻�������� �Է� ����

		if (choice == 1){
			System.out.print("���� : "); work = sc.nextLine();
			addFriendInfo(new HighFriend(name, phone, addr, work));
			// �Է¹��� �����͸� �̿��Ͽ� HighFriend�� �ν��Ͻ��� ������ �� �� �ν��Ͻ��� �Ű������� �Ͽ� addFriendInfo()�޼ҵ带 ȣ��
		} else {
			System.out.print("���� : "); major = sc.nextLine();
			addFriendInfo(new HighFriend(name, phone, addr, major));
		}
		System.out.println("�Է� �Ϸ�\n");
	}
	public void showAllData() {
		for (int i = 0;i < numOfFriends ;i++ ){
			// �迭�� ���̰� �ƴ� ���� ����ִ� ������ ��ŭ�� ������ ��
			friends[i].showData();
			// friends�迭�� i �ε����� ����ִ� �ν��Ͻ��� showData()�޼ҵ� ����
			// friends�迭�� Friend���̹Ƿ� FriendŬ������ showData()�޼ҵ尡 ����Ǿ�� �ϳ� �������̵��Ǿ��ֱ� ������ ����Ŭ������ showData()�޼ҵ尡 �����
			System.out.println();
		}
	}
	public void showBasicData() {
		for (int i = 0;i < numOfFriends ;i++ ){
			friends[i].showBasicInfo();
			/*
			shoBasicInfo()�޼ҵ尡 �������̵��� �ƴ� ���
			if (friends[i] insatnceof HighFriend){
				((HighFriend)friends[i]).showBasicInfo();
			} else if (friends[i] insatnceof UnivFriend){
				((UnivFriend)friends[i]).showBasicInfo();
			}
			*/
			System.out.println();
		}
	}

	public void searchName(){
		Scanner sc2 = new Scanner(System.in);
		System.out.print("�˻��� �̸� : "); String name = sc2.nextLine();
		boolean isNotFound = true;
		for (int i = 0; i<numOfFriends;i++ ){
			if (name.equals(friends[i].getName())){
				// �޾ƿ� perNum�� perArr�迭�� ����ִ� �ν��Ͻ��� number���� ������ ���Ͽ� ���ϴ� �̸��� ����
				friends[i].showData();
				isNotFound = false;
				System.out.println();
			}
		}
		if (isNotFound){System.out.print("�˻� ����� �����ϴ�.");}
	}
}


class FriendInfoBook2{
	public static void main(String[] args){
		FriendHandler handler = new FriendHandler(10);
		while (true){//���ѷ��� : �ݵ�� �������� ������ �־�� ��
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. ���� ģ�� ����");
			System.out.println("2. ���� ģ�� ����");
			System.out.println("3. ��ü ���� ���");
			System.out.println("4. �⺻ ���� ���");
			System.out.println("5. ģ������ �˻�");
			System.out.println("9. ���α׷� ����");
			System.out.print("���� >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1: case 2: //choice�� 1�̳� 2�̸�
				handler.addFriend(choice);	break;
			case 3:
				handler.showAllData();			break;
			case 4:
				handler.showBasicData();			break;
			case 5:
				handler.searchName();			break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
				//�޼ҵ� ���� ����� ����� main()�޼ҵ��̹Ƿ� ���α׷��� �����
			}
		}
	}
}