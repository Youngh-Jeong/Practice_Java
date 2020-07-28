class IfSwitchExam {
	public static void main(String[] args) {
		// 점수(score)를 이용하여 학점을 출력
		// 70 이상 'C', 80 이상 'B', 90 이상 'A', 60이상 'D', 60미만 'F'
		// if문과 switch문을 각각 이용하여 출력
		int score = 88;
		char grade;
		if (score >= 90){
			grade = 'A';
		}
		else if (score >= 80){
			grade = 'B';
		}
		else if (score >=70){
			grade = 'C';
		}
		else if (score >=60){
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		System.out.println("Grade : " + grade);


		int ten;
		char grade2;
		ten = score/10;
		switch (ten){
			case 9: case 10:
				grade2='A';
				break;
			case 8:
				grade2='B';
				break;
			case 7:
				grade2='C';
				break;
			case 6:
				grade2='D';
				break;
			default:
				grade2='F';
		}
		System.out.println("grade : " + grade2);
		


	}
}
