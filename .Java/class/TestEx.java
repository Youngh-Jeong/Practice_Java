/*
클래스명: TestInfo
 - 학번, 국어, 영어, 수학 점수를 저장할 수 있는 클래스 작성
 - 인스턴스 생성과 동시에 각 멤버변수들의 값을 초기화(모두 int)
 - 국어, 영어, 수학, 점수를 수정할 수 있는 setter 작성
 - 학번, 국어, 영어, 수학 점수를 추출할 수 있는 getter 작성
 - 평균점수를 구하여 리턴하는 메소드 작성
 - 각 학번별 전체 점수 및 평균점수를 보여주는 메소드 작성
 - 학생정보 
	학번 : 1517039, 국어 : 88, 영어 : 75, 수학 : 77
	학번 : 1517025, 국어 : 98, 영어 : 70, 수학 : 79
	학번 : 1517018, 국어 : 85, 영어 : 81, 수학 : 80
*/
class TestEx{
	public static void main(String[] args) {
		TestInfo s1 = new TestInfo(1517039, 88, 75, 77);
		TestInfo s2 = new TestInfo(1517025, 98, 70, 79);
		TestInfo s3 = new TestInfo(1517018, 85, 81, 80);
		System.out.println(s1.getCode() + "의 평균점수 출력 테스트 :" + s1.scoreAvg());
		s1.showScore();
		s2.showScore();
		s3.showScore();
	}
}
// 한 학생의 시험정보를 저장하는 클래스
class TestInfo{
	final int code;
	int kor;
	int eng;
	int math;


	public TestInfo(int c, int k, int e, int m){ // 멤버변수들의 초기화 작업
		kor = k;
		eng = e;
		math = m;
	}

	public void setKor(int k){kor = k;} //setter
	public void setEng(int e){eng = e;}
	public void setMath(int m){math = m;}
	public int getCode(){return code;} //getter
	public int getKor(){return kor;}
	public int getEng(){return eng;}
	public int getMath(){return math;}

	public double scoreAvg(){return (kor+eng+math)/3;} //평균점수 구해 리턴
	public void showScore(){ // 전체 점수 및 평균점수 출력
		System.out.println("학번 : "+ code + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math + "평균점수 : " +scoreAvg());
	}	
}