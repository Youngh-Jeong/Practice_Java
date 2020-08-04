class BasicBox{
	public void basicWrap(){System.out.println("basic wrap");}
}

class PaperBox extends BasicBox{
	public void paperWrap(){System.out.println("paper wrap");}
}

class GoldBox extends PaperBox{
	public void goldWrap(){System.out.println("gold wrap");}
}

class InstanceOf{
	public static void main(String[] args){
		BasicBox box1 = new BasicBox();
		PaperBox box2 = new PaperBox();
		GoldBox box3 = new GoldBox();

		wrapBox(box1);	wrapBox(box2);	wrapBox(box3);
	}
	public static void wrapBox(BasicBox box){
		// 매개변수의 자료형을 상위클래스로 지정했으므로 하위클래스형 인스턴스들도 받을 수 있게 됨.
		// 단, 상위클래스형으로 받았기 때문에 매개변수는 모두 상위클래스형으로 인식되어 상위클래스의 메소드만 사용할 수 있음
		// 하위클래스의 메소드르 ㄹ사용하려면 매개변수로 받은 인스턴스를 하위클래스형으로 형변환해야 함
		if (box instanceof GoldBox){
			//box를 GoldBox로 형변환이 가능하다면(GoldBox인지 물어보는 것이 아님
			((GoldBox)box).goldWrap();
			// box를 GoldBox형으로 형변환 후 goldWrap()메소드를 호출
		} else if (box instanceof PaperBox){
			((PaperBox)box).paperWrap();
		} else {
			box.basicWrap();
		}
		//instanceof를 사용해서 형변환 후 작업을 하려면 반드시 최하위클래스 부터 조건을 줘야 함
	}
}
