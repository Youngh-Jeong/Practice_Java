import java.time.*;
import java.time.temporal.*;


class  TimeEx1{
	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		// 현재 날짜를 이용하여 LocalDate 객체 생성
		LocalDate bDate = LocalDate.of(1999, 12, 31);
		// 특정 날짜(1999년 12월 31일)를 이용하여 LocalDate 객체 생성

		System.out.println("today : " + today); // today : 2020-08-13
		System.out.println("bDate : " + bDate); // bdate : 1999-12-31

		System.out.println(bDate.withYear(2000)); // 2000-12-31
		// bDate.withYear(2000) : bDate의 날짜에서 년도를 2000년으로 변경
		System.out.println(bDate.plusDays(1)); // 2000-01-01
		// bDate.plusDays(1): bDate의 날짜에 1일을 더하라는 의미
		System.out.println(bDate.plus(1, ChronoUnit.DAYS)); // 2000-01-01
		// bDate.plus(1, ChronoUnit.DAYS) : bDate의 날짜에 일(day)에 해당하는 값에 1을 더하라는 의미

		System.out.println(bDate.minusMonths(1)); // 1999-11-30
		// bDate.minusMOnths(1) : bDate의 날짜에 1달을 빼라는 의미
		System.out.println(bDate.minusWeeks(1)); // 1999-12-24
		// bDate.minusWeeks(1) : bDate의 날짜에 1주(7일)를 빼라는 의미
		System.out.println(bDate.minus(10, ChronoUnit.DAYS)); // 1999-12-21
		// with()와 plus(), minus() 모두 날짜를 변경시키지만 원본이 아닌 새로운 객체를 생성하는 방법
	}
}
