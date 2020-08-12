import java.util.*;

class  CalendarEx3{
	public static void main(String[] args){
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_NAME = {"시간 ", "분 ", "초 "};

		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();

		// time1은 10시 20분 30초, time2는 20시 30분 10초로 지정
		time1.set(time1.get(Calendar.YEAR), time1.get(Calendar.MONTH), time1.get(Calendar.DATE), 10, 20, 30); //방법 1
		time2.set(Calendar.HOUR_OF_DAY, 20);	time2.set(Calendar.MINUTE, 30);		time2.set(Calendar.SECOND, 10); // 방법 2

		System.out.println(("time1 : ") + time1.get(Calendar.HOUR_OF_DAY) + "시" + time1.get(Calendar.MINUTE) + "분" + time1.get(Calendar.SECOND) + "초");
		System.out.println(("time2 : ") + time2.get(Calendar.HOUR_OF_DAY) + "시" + time2.get(Calendar.MINUTE) + "분" + time2.get(Calendar.SECOND) + "초");
		
		long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
		System.out.println("time1과 time2의 시간 차는 " + (diff) + "초 입니다.");

		String tmp = "";
		for (int i = 0; i<TIME_UNIT.length;i++ ){
			tmp += diff / TIME_UNIT[i] + TIME_NAME[i];
			diff = diff % TIME_UNIT[i];
		}
		System.out.println("시분초로 환산하면 " + tmp);
	}
}
