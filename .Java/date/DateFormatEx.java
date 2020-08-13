import java.util.*;
import java.text.*;

class  DateFormatEx{
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		// Calendar객체의 인스턴스를 이용하여 Date객체 생성
		//Date today = new Date();  : Calendar 안쓰고 Date만 쓰면
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf5, sdf6, sdf7, sdf8, sdf9;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");					// 2020-08-13
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");			// '20년 8월 13일 목요일
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");		// 2020-08-13 11:59:55.126
		sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");		// 2020-08-13 11:59:55 오전
		sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");		// 오늘은 올 해의 226번째 날입니다.
		sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");		// 오늘은 올 해의 13번째 날입니다.
		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");		// 오늘은 올 해의 33번째 날입니다.
		sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");		// 오늘은 이 달의 3번째 날입니다.
		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");	// 오늘은 이 달의 2번째 목요일입니다.

		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println();
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
	}
}

/*
G : 연대(BC, AD)	/ y : 년도	/ M : 월		/ w : 년의 몇 째 주		/ W : 월의 몇 째 주
D : 년의 몇 째 일	/ d : 월의 몇 째 일		/ F : 월의 몇 째 요일(1~5)	/ E : 요일
a : 오전/오후		/ H : 시(0~23)	/ k : 시간(1~24)	/ h : 시(0~11)	/ m : 분(0~59)
s : 초(0~59)		/ S : 밀리초(0~999)		/ ' : 특수문자 표현
*/