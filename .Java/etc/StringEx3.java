class StringEx3{
	public static void main(String[] args) {
		String file1 = "test.jpg";
		String file2 = "test.gif";
		String file3 = "test.zip";
		String file4 = "test.docx";

		isImg(file1); isImg(file2); isImg(file3); isImg(file4);
	}
	public static void isImg(String file){
		// 이미지 파일인지 여부르 검사할 메소드
		/*
		받아온 파일이 이미지파일(jpg, gif, png, jpeg)인지를 검사
		file + "는 이미지 파일이 아닙니다," or file + "은 이미지 파일이 맞습니다." 중 1 출력
		*/
		int dot = file.indexOf('.');
		if (dot == -1){
			System.out.println(file + "은 이미지 파일이 아닙니다.");
			return;
		}
		String format = file.substring(dot+1);
	
		boolean jpg = format.equals("jpg");
		boolean gif = format.equals("gif");
		boolean png = format.equals("png");
		boolean jpeg = format.equals("jpeg");

		if (jpg||gif||png||jpeg){
			System.out.println(file + "은 이미지 파일이 맞습니다.");
		} else {
			System.out.println(file + "은 이미지 파일이 아닙니다.");
		}
	/*
		if (format.equals("jpg")||format.equals("gif")||format.equals("png")||format.equals("jpeg") ){
			System.out.println(file + "은 이미지 파일이 맞습니다.");
		} else {
			System.out.println(file + "은 이미지 파일이 아닙니다.");
		}

*/
	}
}
