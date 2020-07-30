/*
Ŭ������: TestInfo
 - �й�, ����, ����, ���� ������ ������ �� �ִ� Ŭ���� �ۼ�
 - �ν��Ͻ� ������ ���ÿ� �� ����������� ���� �ʱ�ȭ(��� int)
 - ����, ����, ����, ������ ������ �� �ִ� setter �ۼ�
 - �й�, ����, ����, ���� ������ ������ �� �ִ� getter �ۼ�
 - ��������� ���Ͽ� �����ϴ� �޼ҵ� �ۼ�
 - �� �й��� ��ü ���� �� ��������� �����ִ� �޼ҵ� �ۼ�
 - �л����� 
	�й� : 1517039, ���� : 88, ���� : 75, ���� : 77
	�й� : 1517025, ���� : 98, ���� : 70, ���� : 79
	�й� : 1517018, ���� : 85, ���� : 81, ���� : 80
*/
class TestEx{
	public static void main(String[] args) {
		TestInfo s1 = new TestInfo(1517039, 88, 75, 77);
		TestInfo s2 = new TestInfo(1517025, 98, 70, 79);
		TestInfo s3 = new TestInfo(1517018, 85, 81, 80);
		System.out.println(s1.getCode() + "�� ������� ��� �׽�Ʈ :" + s1.scoreAvg());
		s1.showScore();
		s2.showScore();
		s3.showScore();
	}
}
// �� �л��� ���������� �����ϴ� Ŭ����
class TestInfo{
	final int code;
	int kor;
	int eng;
	int math;


	public TestInfo(int c, int k, int e, int m){ // ����������� �ʱ�ȭ �۾�
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

	public double scoreAvg(){return (kor+eng+math)/3;} //������� ���� ����
	public void showScore(){ // ��ü ���� �� ������� ���
		System.out.println("�й� : "+ code + ", ���� : " + kor + ", ���� : " + eng + ", ���� : " + math + "������� : " +scoreAvg());
	}	
}