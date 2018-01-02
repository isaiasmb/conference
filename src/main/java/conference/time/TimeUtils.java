package conference.time;

public class TimeUtils {
	
	public static String addZeroInTime(int time) {
		return (time < 10 ? "0" + time : "" + time);
	}
	
	public static Time addMinutesToTime(int hour, int minute, int addMinute) {
		if (addMinute >= 60) {
			hour++;
		} else {
			int totalMinutes = minute + addMinute;
			if (totalMinutes >= 60) {
				hour++;
				minute = (totalMinutes - 60);
			} else {
				minute += addMinute;
			}
		}
		return new Time(hour, minute);
	}

}
