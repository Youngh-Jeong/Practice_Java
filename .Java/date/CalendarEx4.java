import java.util.*;
class  CalendarEx4{
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();

		date.set(2020, 7, 31);
		System.out.println(toString(date));	//2020년8월31일
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1);
		// date의 날짜에 일(day)의 값에 1을 더함
		System.out.println(toString(date)); //2020년9월1일

		System.out.println("= 6개월 전 =");
		date.add(Calendar.MONTH, -6);
		// add()메소드의 두 번째 매개변수 amount의 값을 음수로 입력하면 이전 날짜를 구함
		System.out.println(toString(date)); //2020년3월1일

		System.out.println("= 31일 후(roll) = ");
		date.roll(Calendar.DATE, 31);
		// date의 날짜에 일(day)의 값에 31을 더함
		// 다른 필드는 움직이지 않고, 값을 더한 필드만 변경됨
		System.out.println(toString(date)); //2020년3월1일

		System.out.println("= 31일 후(add) = ");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date)); //2020년4월1일
	}

	public static String toString(Calendar date){
		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH) + 1) + "월" + date.get(Calendar.DATE) + "일";
	}
}
