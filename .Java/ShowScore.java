import java.util.*;

class Student{
	private String id, name; //id : �й�, name : �̸�
	private int kor, his, math; // kor: ���� his: ���� math: ����
	public Student(String id, String name, int kor, int his, int math){
		this.id = id;	this.name = name;	this.kor = kor; this.his = his;	this.math = math;
	}
	public void showData(){ // ������ ���
		System.out.println("�й� : [" + id + "]");
		System.out.println("�̸� : [" + name + "]");
		System.out.println("���� ���� : " + kor + "��");
		System.out.println("���� ���� : " + his + "��");
		System.out.println("���� ���� : " + math + "��");
		System.out.println("��� : " + (kor + his + math)/3.0 + "��");
	}
	public String getId(){return id;} // getter���
	public String getName(){return name;}
	public int getKor(){return kor;}
	public int getHis(){return his;}
	public int getMath(){return math;}
}

class StudentHandler{
	private ArrayList<Student> students; //ArrayList���
	public StudentHandler(){ // ������
		students = new ArrayList<Student>();
	}

	public int stringToInt(String str){ // string�� int�� �ٲٴ� �޼ҵ�
		int num = 0;
		for (int i = 0 ; i < str.length() ;i++ ){
			if (str.charAt(i)<'0'||str.charAt(i)>'9'){
				return -1;
			}
			num += (str.charAt(str.length()-i-1)-'0')*Math.pow(10,i);
		}
		return num;
	}

	public boolean idCheck(String str){ // �Է°��� id�� �ߺ����� Ȯ���ϴ� �޼ҵ�
		boolean canUseId = true;
		for (int i = 0;i < students.size() ;i++ ){
			if (str.equals((students.get(i)).getId())){
				canUseId = false;
			}
		}
		return canUseId;
	}

	public void removeData(String str){ // �ش� id�� ������ ����� �޼ҵ�
		for (int i = 0;i < students.size() ;i++){
			if (str.equals((students.get(i)).getId())){
				students.remove(i);
			}
		}
	}

	private void addStudentInfo(Student std){ // ArrayList�� �Է�
		students.add(std);
	}

	public void addStudent(){ // �����Է��� �޴� �޼ҵ�
		String id, name;
		String flag;
		int kor, his, math;
		Scanner sc2 = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		System.out.print("�й� : "); id = sc2.nextLine();
		if (!idCheck(id)){ // �ߺ� ���̵� �����ϸ�
			System.out.println("�̹� �����ϴ� �й��Դϴ�. ������ ������ �����ϰڽ��ϱ�?");
			System.out.println("(Y/N) >>"); flag = sc2.nextLine();
			if (flag.equals("Y")){
				removeData(id); // List���� ����
				System.out.println("������ �Ϸ�Ǿ����ϴ�. ù ȭ������ ���ư��ϴ�.");
				return;
			} else {
				System.out.println("ù ȭ������ ���ư��ϴ�.");
				return;
			}
		}
		System.out.print("�̸� : "); name = sc2.nextLine();
		System.out.print("���� ���� : "); String korStr = sc2.nextLine();
		System.out.print("���� ���� : "); String hisStr = sc2.nextLine();
		System.out.print("���� ���� : "); String mathStr = sc2.nextLine();
		kor = stringToInt(korStr);	his = stringToInt(hisStr);	math = stringToInt(mathStr);
		if (kor<0||his<0||math<0){ // char�� ���ڰ� �ƴϸ� ���� ����
			System.out.println("�Է°��� ���ڰ� �ƴմϴ�. �Է¿� �����Ͽ����ϴ�.");
			return;
		}

		addStudentInfo(new Student(id, name, kor, his, math));
		System.out.println("�Է� �Ϸ�\n");
	}
	public void showAllData(){ // ��ü ������ ����ϴ� �޼ҵ�
		if (students.size()==0){
			System.out.println("�Էµ� ������ �����ϴ�.");
		}
		for (int i = 0;i<students.size() ;i++ ){
			(students.get(i)).showData();
			System.out.println();
		}
	}
	public void searchStudent(){ // ���� �˻��� �ϴ� �޼ҵ�
		String idInput;
		boolean isStudent = false;
		Scanner sc3 = new Scanner(System.in);
		System.out.print("�˻��� �й��� �Է��ϼ���."); idInput = sc3.nextLine();
		for (int i = 0;i < students.size() ;i++ ){ 
			if (idInput.equals((students.get(i)).getId())){
				(students.get(i)).showData();
				isStudent = true;
			}
		}
		if (!isStudent){
			System.out.println("�˻��� �����Ͽ����ϴ�.");
		}
	}
}



class ShowScore{
	public static void main(String[] args){
		StudentHandler handler = new StudentHandler();
		while (true){
			System.out.println("== �޴� ���� ==");
			System.out.println("1. �����Է�");
			System.out.println("2. �����˻�");
			System.out.println("3. ��ü����");
			System.out.println("4. ����");
			System.out.print("���� >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice)	{
			case 1:
				handler.addStudent();		break;
			case 2:
				handler.searchStudent();	break;
			case 3:
				handler.showAllData();		break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}

	}
}
