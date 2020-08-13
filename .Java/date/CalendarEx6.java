import java.util.*;

class  CalendarEx6{
	public static void main(String[] args) {
		int year;
		int month;
		Calendar sdate = Calendar.getInstance();	// 시작일
		if (args.length == 2){ // 년월 입력했으면
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
		} else { // 입력 안했으면
			year = sdate.get(Calendar.YEAR);
			month = sdate.get(Calendar.MONTH) + 1;
		}
		sdate.set(year, month - 1, 1);
		// 입력받은 년도와 월을 이용하여 시작일을 지정(월은 -1을 해야 함)
		int startWeekDay = 0, endDay = 0;
		Calendar edate = Calendar.getInstance();	// 종료일
		edate.set(year, month, 1);		// 시작일의 다음달 1일
		edate.add(Calendar.DATE, -1);	// 다음달 1일에서 하루를 뺀 날짜(시작월의 말일)
		startWeekDay = sdate.get(Calendar.DAY_OF_WEEK); // 시작일의 요일번호이자 1일의 시작 위치
		endDay = edate.get(Calendar.DATE); // 말일

		System.out.println("      " + year + "년" + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		for (int i = 1;i<startWeekDay ;i++ ){
			System.out.print("   "); 
		} // 1일의 시작위치를 잡기 위한 for문
		for (int i = 1, n = startWeekDay;i<=endDay ;i++, n++ ){
			// i: 날짜의 일(day)부분을 담당할 변수,  n: 요일번호 담당으로 일주일이 지나면 다음 줄로 내리기 위한 용도 
			System.out.print((i<10) ? "  " + i : " " + i);
			// 일(day)이 10미만의 숫자일 경우 자리를 한 칸 더 띄움
			if (n%7 == 0){ System.out.println();}
			// 일주일이 지났으므로 다음 줄로 내림
		}
	}
}
