package 백준문제;

import java.time.*;

public class BOJ_16170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now(ZoneId.of("Europe/London"));
		
		System.out.println(now.getYear());
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
	}

}
