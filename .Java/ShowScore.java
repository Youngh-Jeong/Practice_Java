import java.util.*;

class Student{
	private String id, name; //id : 학번, name : 이름
	private int kor, his, math; // kor: 국어 his: 국사 math: 수학
	public Student(String id, String name, int kor, int his, int math){
		this.id = id;	this.name = name;	this.kor = kor; this.his = his;	this.math = math;
	}
	public void showData(){ // 정보를 출력
		System.out.println("학번 : [" + id + "]");
		System.out.println("이름 : [" + name + "]");
		System.out.println("국어 점수 : " + kor + "점");
		System.out.println("국사 점수 : " + his + "점");
		System.out.println("수학 점수 : " + math + "점");
		System.out.println("평균 : " + (kor + his + math)/3.0 + "점");
	}
	public String getId(){return id;} // getter사용
	public String getName(){return name;}
	public int getKor(){return kor;}
	public int getHis(){return his;}
	public int getMath(){return math;}
}

class StudentHandler{
	private ArrayList<Student> students; //ArrayList사용
	public StudentHandler(){ // 생성자
		students = new ArrayList<Student>();
	}

	public int stringToInt(String str){ // string을 int로 바꾸는 메소드
		int num = 0;
		for (int i = 0 ; i < str.length() ;i++ ){
			if (str.charAt(i)<'0'||str.charAt(i)>'9'){
				return -1;
			}
			num += (str.charAt(str.length()-i-1)-'0')*Math.pow(10,i);
		}
		return num;
	}

	public boolean idCheck(String str){ // 입력값의 id가 중복인지 확인하는 메소드
		boolean canUseId = true;
		for (int i = 0;i < students.size() ;i++ ){
			if (str.equals((students.get(i)).getId())){
				canUseId = false;
			}
		}
		return canUseId;
	}

	public void removeData(String str){ // 해당 id의 정보를 지우는 메소드
		for (int i = 0;i < students.size() ;i++){
			if (str.equals((students.get(i)).getId())){
				students.remove(i);
			}
		}
	}

	private void addStudentInfo(Student std){ // ArrayList에 입력
		students.add(std);
	}

	public void addStudent(){ // 정보입력을 받는 메소드
		String id, name;
		String flag;
		int kor, his, math;
		Scanner sc2 = new Scanner(System.in);
		System.out.println("정보를 입력하세요.");
		System.out.print("학번 : "); id = sc2.nextLine();
		if (!idCheck(id)){ // 중복 아이디가 존재하면
			System.out.println("이미 존재하는 학번입니다. 기존의 정보를 삭제하겠습니까?");
			System.out.println("(Y/N) >>"); flag = sc2.nextLine();
			if (flag.equals("Y")){
				removeData(id); // List에서 삭제
				System.out.println("삭제가 완료되었습니다. 첫 화면으로 돌아갑니다.");
				return;
			} else {
				System.out.println("첫 화면으로 돌아갑니다.");
				return;
			}
		}
		System.out.print("이름 : "); name = sc2.nextLine();
		System.out.print("국어 점수 : "); String korStr = sc2.nextLine();
		System.out.print("국사 점수 : "); String hisStr = sc2.nextLine();
		System.out.print("수학 점수 : "); String mathStr = sc2.nextLine();
		kor = stringToInt(korStr);	his = stringToInt(hisStr);	math = stringToInt(mathStr);
		if (kor<0||his<0||math<0){ // char가 숫자가 아니면 음수 리턴
			System.out.println("입력값이 숫자가 아닙니다. 입력에 실패하였습니다.");
			return;
		}

		addStudentInfo(new Student(id, name, kor, his, math));
		System.out.println("입력 완료\n");
	}
	public void showAllData(){ // 전체 정보를 출력하는 메소드
		if (students.size()==0){
			System.out.println("입력된 정보가 없습니다.");
		}
		for (int i = 0;i<students.size() ;i++ ){
			(students.get(i)).showData();
			System.out.println();
		}
	}
	public void searchStudent(){ // 정보 검색을 하는 메소드
		String idInput;
		boolean isStudent = false;
		Scanner sc3 = new Scanner(System.in);
		System.out.print("검색할 학번을 입력하세요."); idInput = sc3.nextLine();
		for (int i = 0;i < students.size() ;i++ ){ 
			if (idInput.equals((students.get(i)).getId())){
				(students.get(i)).showData();
				isStudent = true;
			}
		}
		if (!isStudent){
			System.out.println("검색에 실패하였습니다.");
		}
	}
}



class ShowScore{
	public static void main(String[] args){
		StudentHandler handler = new StudentHandler();
		while (true){
			System.out.println("== 메뉴 선택 ==");
			System.out.println("1. 정보입력");
			System.out.println("2. 정보검색");
			System.out.println("3. 전체정보");
			System.out.println("4. 종료");
			System.out.print("선택 >> ");

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
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}
}
