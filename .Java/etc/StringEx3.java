class StringEx3{
	public static void main(String[] args) {
		String file1 = "test.jpg";
		String file2 = "test.gif";
		String file3 = "test.zip";
		String file4 = "test.docx";

		isImg(file1); isImg(file2); isImg(file3); isImg(file4);
	}
	public static void isImg(String file){
		// �̹��� �������� ���θ� �˻��� �޼ҵ�
		/*
		�޾ƿ� ������ �̹�������(jpg, gif, png, jpeg)������ �˻�
		file + "�� �̹��� ������ �ƴմϴ�," or file + "�� �̹��� ������ �½��ϴ�." �� 1 ���
		*/
		int dot = file.indexOf('.');
		if (dot == -1){
			System.out.println(file + "�� �̹��� ������ �ƴմϴ�.");
			return;
		}
		String format = file.substring(dot+1);
	
		boolean jpg = format.equals("jpg");
		boolean gif = format.equals("gif");
		boolean png = format.equals("png");
		boolean jpeg = format.equals("jpeg");

		if (jpg||gif||png||jpeg){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
		} else {
			System.out.println(file + "�� �̹��� ������ �ƴմϴ�.");
		}
	/*
		if (format.equals("jpg")||format.equals("gif")||format.equals("png")||format.equals("jpeg") ){
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
		} else {
			System.out.println(file + "�� �̹��� ������ �ƴմϴ�.");
		}

*/
	}
}
