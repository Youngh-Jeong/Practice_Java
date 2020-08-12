import java.util.*;
class CalendarEx1{
	public static void main(String[] args){
		Calendar today = Calendar.getInstance();
		// static메소드인 getInstance()를 통해 날짜 및 시간 인스턴스 생성
		// Calendar 인스턴스는 생성되면 기본적으로 오늘 날짜 및 현재 시간이 지정됨

		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR)); // 2020
		System.out.println("월(0-11) : " + today.get(Calendar.MONTH)); // 7
		//월은 0이 1월이고, 12월은 11로 표현됨
		System.out.println("이 해의 몇 째 주 : " + today.get(Calendar.WEEK_OF_YEAR)); // 33
		System.out.println("이 달의 몇 째 주 : " + today.get(Calendar.WEEK_OF_MONTH)); // 3
		System.out.println("달의 몇 일 : " + today.get(Calendar.DATE)); // 12
		System.out.println("달의 몇 일 : " + today.get(Calendar.DAY_OF_MONTH)); // 12
		// Date와 DAY_OF_MONTH 는 동일한 값을 리턴
		System.out.println("해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR)); // 225
		System.out.println("요일(1-7, 1:일요일) : " + today.get(Calendar.DAY_OF_WEEK)); // 4
		System.out.println("달의 몇 째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // 2
		System.out.println("오전(0)_오후(1) : " + today.get(Calendar.AM_PM)); // 0
		System.out.println("시간(0-11) : " + today.get(Calendar.HOUR)); // 10
		System.out.println("시간(0-23) : " + today.get(Calendar.HOUR_OF_DAY)); // 10
		System.out.println("분(0-59) : " + today.get(Calendar.MINUTE)); // 12
		System.out.println("초(0-59) : " + today.get(Calendar.SECOND)); // 12
		System.out.println("밀리초(0-999) : " + today.get(Calendar.MILLISECOND)); // 394
		System.out.println("말일 : " + today.getActualMaximum(Calendar.DATE)); // 31
	}
}
