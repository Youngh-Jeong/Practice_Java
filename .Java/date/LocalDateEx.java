import java.time.*;
import java.time.temporal.*;


class  LocalDateEx{
	public static void main(String[] args) {
		int year;
		int month;
		LocalDate bDate;

		if (args.length == 2){ // 년월 입력했으면
			bDate = LocalDate.of(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 1);
		} else { // 입력 안했으면
			bDate = LocalDate.now();
			bDate = bDate.withDayOfMonth(1);
		}
		year = bDate.getYear();	month = bDate.getMonthValue();


		int startWeekDay = 0, endDay = 0;
		startWeekDay = (((bDate.getDayOfWeek()).getValue())%7)+1; // LocalDate는 1~7(월~일), Calendar는 1~7(일~토)
		endDay = bDate.lengthOfMonth();// 말일

		System.out.println("      " + year + "년" + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		for (int i = 1;(i)<startWeekDay ;i++ ){
			System.out.print("   "); 
		} // 1일의 시작위치를 잡기 위한 for문
		for (int i = 1, n = startWeekDay;i<=endDay ;i++, n++ ){
			// i: 날짜의 일(day)부분을 담당할 변수,  n: 요일번호 담당으로 일주일이 지나면 다음 줄로 내리기 위한 용도 
			System.out.print((i<10) ? "  " + i : " " + i);
			// 일(day)이 10미만의 숫자일 경우 자리를 한 칸 더 띄움
			if ((n)%7 == 0){ System.out.println();}
			// 일주일이 지났으므로 다음 줄로 내림
		}
	}
}
